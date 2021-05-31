//package cn.itcast.pattern;
//
//import java.util.Hashtable;
//import java.util.Map;
//
//public class Exercise {
//
//}
//
//class Mailboxes {
//    private static Map<Integer, GuardedObject> boxes = new Hashtable<>();
//
//    private  static int id = 1;
//    // 产生唯一ID
//    private static synchronized int generateId() {
//        return id++;
//    }
//
//    public static GuardedObject createGuardedObject() {
//        GuardedObject go = new GuardedObject(generateId());
//        boxes.put(go.getId(), go);
//        return go;
//    }
//}
//
//class GuardedObject {
//
//    // 标识 Guarded Object
//    private int id;
//
//    public GuardedObject(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    // 结果
//    private Object response;
//
//    // 获取结果
//    // timeout 表示要等待多久 2000
//    public Object get(long timeout) {
//        synchronized (this) {
//            // 开始时间 15:00:00
//            long begin = System.currentTimeMillis();
//            // 经历的时间
//            long passedTime = 0;
//            while (response == null) {
//                // 这一轮循环应该等待的时间
//                long waitTime = timeout - passedTime;
//                // 经历的时间超过了最大等待时间时，退出循环
//                if (timeout - passedTime <= 0) {
//                    break;
//                }
//                try {
//                    this.wait(waitTime); // 虚假唤醒 15:00:01
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                // 求得经历时间
//                passedTime = System.currentTimeMillis() - begin; // 15:00:02  1s
//            }
//            return response;
//        }
//    }
//
//    // 产生结果
//    public void complete(Object response) {
//        synchronized (this) {
//            // 给结果成员变量赋值
//            this.response = response;
//            this.notifyAll();
//        }
//    }
//}