package serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * author yg
 * description 基于ByteBuffer的通用二进制编解码比传统jdk序列化码流要小很多
 * date 2020/2/3
 */
public class Normal {
    public static final String GLOBAL_NAME = "andy";
    public static final int GLOBAL_ID = 1234555;

    public static void main(String[] args) {
        byte[] bytes0 = byteBufCodec();
        decode(bytes0);
        byte[] bytes1 = jdkCodec();
        System.err.println("byteBufCodec length:" + bytes0.length + " jdkCodec length:" + bytes1.length);
    }

    private static byte[] jdkCodec() {
        Person person = new Normal.Person();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;
    }

    //解码练习
    private static void decode(byte[] bytes) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(bytes);
        allocate.flip();
        int length = allocate.getInt();
        byte[] name = new byte[length];
        allocate.get(name);
        int id = allocate.getInt();
        String s = new String(name);
        System.err.println("name:" + s + " id:" + id);
    }

    private static byte[] byteBufCodec() {
        String andy = GLOBAL_NAME;
        int id = GLOBAL_ID;
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        byte[] bytes = andy.getBytes();
        int length = bytes.length;
        byteBuf.putInt(length);
        byteBuf.put(bytes);
        byteBuf.putInt(id);
        byteBuf.flip();
        byte[] result = new byte[byteBuf.remaining()];
        byteBuf.get(result);
        return result;
    }

    static class Person implements Serializable {
        private static final long serialVersionUID = -5220024838718407594L;

        private String name = Normal.GLOBAL_NAME;
        private int id = GLOBAL_ID;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
