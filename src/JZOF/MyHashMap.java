package JZOF;

import java.util.Arrays;
import java.util.Map;

public class MyHashMap {
    /**
     * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
     * 实现 MyHashMap 类
     * MyHashMap() 用空映射初始化对象
     * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。
     * 如果 key 已经存在于映射中，则更新其对应的值 value 。
     * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
     * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
     */
    /** Initialize your data structure here. */
        int[] map;
    public MyHashMap() {
        map=new int[1000001];
        Arrays.fill(map,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key]=value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

