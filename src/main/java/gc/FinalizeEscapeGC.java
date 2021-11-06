package gc;

/**
 * @author: Ryan
 * @date: 2021/11/6
 * @description:
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;

    public void isLive(){
        System.out.println("yes,live");
    }

    //该方法只执行一次，在F-Queue里面被触发
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        //对象自我拯救
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isLive();
        }else {
            System.out.println("no dead");
        }
        //拯救失败
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isLive();
        }else {
            System.out.println("no dead");
        }
    }
}
