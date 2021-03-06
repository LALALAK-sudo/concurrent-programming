package cn.itcast.n6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class  Test{
    static class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V> {        //定义缓存的容量
    private int capacity;        //带参数的构造器
    LRULinkedHashMap(int capacity){            //如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
        //如果accessOrder为flase的话，则按插入顺序来遍历
        super(16,0.75f,true);            //传入指定的缓存最大容量
        this.capacity=capacity;
    }        //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest){            return size()>capacity;
    }
}    //test
    public static void main(String[] args) {
        LRULinkedHashMap<String, Integer> testCache = new LRULinkedHashMap<>(3);
        testCache.put("A", 1);
        testCache.put("B", 2);
        testCache.put("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.put("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));
    }
}

