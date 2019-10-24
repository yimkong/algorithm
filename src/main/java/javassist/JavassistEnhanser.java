package javassist;

import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * author yg
 * description
 * date 2019/10/16
 */
public class JavassistEnhanser<T> {
    /**
     * 增强类后缀
     */
    String CLASS_SUFFIX = "$ENHANCED";
    private static final ClassPool classPool = ClassPool.getDefault();
    private TestService testService;

    JavassistEnhanser(TestService testService) {
        this.testService = testService;
    }

    public T transform(T obj) throws Exception {
        Class aClass = obj.getClass();
        Class current = createEnhanceClass(aClass);
        Constructor<T> constructor = current.getConstructor(TestService.class);
        T t = constructor.newInstance(testService);
        return t;
    }

    private Class createEnhanceClass(final Class aClass) throws Exception {
        final CtClass enhancedClz = buildCtClass(aClass);
        buildFields(enhancedClz);
        buildConstructor(enhancedClz);
        buildEnhancedMethod(enhancedClz);
        enhancedClz.writeFile();
        return enhancedClz.toClass();
    }

    private void buildEnhancedMethod(CtClass enhancedClz) throws Exception {
        // 创建方法描述对象
        CtClass returnType = classPool.get(Void.class.getName());
        String mname = "go";
        CtClass[] parameters = new CtClass[]{classPool.get(Event.class.getName())};
        ConstPool cp = enhancedClz.getClassFile2().getConstPool();
        String desc = Descriptor.ofMethod(CtClass.voidType, parameters);
        MethodInfo methodInfo = new MethodInfo(cp, mname, desc);
        //增加注解
//        AnnotationsAttribute annoAttr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
//        javassist.bytecode.annotation.Annotation annot = new javassist.bytecode.annotation.Annotation(JsonIgnore.class.getName(), cp);
//        annoAttr.addAnnotation(annot);
//        methodInfo.addAttribute(annoAttr);
        // 创建方法对象
        CtMethod method = CtMethod.make(methodInfo, enhancedClz);
        method.setBody("{" + //
                "System.err.println($1.getClass());"+
                "this." + "service.go(" + "$1" + ");" + //
                "}");
        method.setModifiers(Modifier.PUBLIC);
        enhancedClz.addMethod(method);
    }

    private void buildConstructor(CtClass enhancedClz) throws Exception {
        CtConstructor constructor = new CtConstructor(
                toCtClassArray(TestService.class), enhancedClz);
        constructor.setBody("{ " + //
                "this." + "service" + " = $1; " +
                "}");
        constructor.setModifiers(Modifier.PUBLIC);
        enhancedClz.addConstructor(constructor);
    }

    private CtClass[] toCtClassArray(Class<?>... classes) throws NotFoundException {
        if (classes == null || classes.length == 0) {
            return new CtClass[0];
        }
        CtClass[] result = new CtClass[classes.length];
        for (int i = 0; i < classes.length; i++) {
            result[i] = classPool.get(classes[i].getName());
        }
        return result;
    }

    private void buildFields(CtClass enhancedClz) throws Exception {
        CtField ctField = new CtField(classPool.get(TestService.class.getName()), "service", enhancedClz);
        ctField.setModifiers(Modifier.PRIVATE + Modifier.FINAL);
        enhancedClz.addField(ctField);
    }

    private CtClass buildCtClass(final Class aClass) throws Exception {
        CtClass superClz = classPool.get(AbstractService.class.getName());
        CtClass result = classPool.makeClass(aClass.getCanonicalName() + CLASS_SUFFIX);
        result.setSuperclass(superClz);
        return result;
    }
}
