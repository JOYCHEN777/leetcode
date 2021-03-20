package JZOF;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 */
public class MyHashSet {
    /**
     * Initialize your data structure here.
     */
    byte[] map;

    public MyHashSet() {
        map = new byte[1000001 / 8 + 1];

    }

    public void add(int key) {
        int index = key >> 3;
        int position = key % 8;
        map[index] |= (1 << position);

    }

    public void remove(int key) {
        int index = key >> 3;
        int position = key % 8;
        map[index] &= (~(1 << position));

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key >> 3;
        int position = key % 8;
        return (map[index] & (1 << position))!=0;

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
