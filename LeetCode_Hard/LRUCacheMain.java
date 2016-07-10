package LeetCode_Hard;

import java.util.HashMap;

/**
 * Created by subhransumishra on 7/9/16.
 *
 * Problem: Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already
 * present. When the cache reached its capacity, it should invalidate the least recently used item before inserting
 * a new item.
 *
 * Example:
 * Solution:
 * Complexity:
 */

public class LRUCacheMain{
    public static void main(String[] args){
        LRUCache lru = new LRUCache(10);

        CachePage page1 = new CachePage();
        CachePage page2 = new CachePage();
        CachePage page3 = new CachePage();
        CachePage page4 = new CachePage();
        CachePage page5 = new CachePage();
        CachePage page6 = new CachePage();
        CachePage page7 = new CachePage();

        lru.set(page1, 12);
        lru.set(page2, 14);
        lru.set(page3, 54);
        lru.set(page4, 96);
        lru.set(page5, 75);
        lru.get(page3);
    }
}

class LRUCache {

    //A HashMap will be helpful to access the element in O(1).
    HashMap<CachePage, CacheQueueNode> LRUmap = new HashMap<>();
    CacheQueue Cache;

    public LRUCache(int size) {
        Cache = new CacheQueue(size);
    }

    //set(key, value) - Set or insert the value if the key is not already. present. When the cache reached its capacity,
    // it should invalidate the least recently used item before inserting
    public void set(CachePage page, int val) {
        CacheQueueNode cachenode = new CacheQueueNode(val);
        Cache.push(cachenode);
        LRUmap.put(page, cachenode);
    }

    //get(key) : Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    public int get(CachePage page) {
        if (!LRUmap.containsKey(page)) {
            return -1;
        } else {
            CacheQueueNode tempnode = LRUmap.get(page);
            Cache.update(tempnode);
            return LRUmap.get(page).val;
        }
    }

}


//Page class is just a representation of Page in Cache
class CachePage{
    double randval;
    CachePage(){
        this.randval = Math.random();
    }
}

class CacheQueueNode{
    CacheQueueNode next;
    CacheQueueNode prev;
    int val;

    CacheQueueNode(int val){
        this.val = val;
    }
}

class CacheQueue{
    CacheQueueNode head=null;
    CacheQueueNode tail=null;
    int size = 0;
    int current = 0;

    public CacheQueue(int val){
        this.size = val;
    }

    public void push(CacheQueueNode cachenode){
        if(head == null){
            head = cachenode;
            tail = cachenode;
            current++;
        }else{
            CacheQueueNode tempnode = head;
            head = cachenode;
            head.next = tempnode;
            tempnode.prev = head;
            current++;

            if(current == size){
                pop(tail);
            }
        }
    }

    public void pop(CacheQueueNode cachenode){
        tail = tail.prev;
        tail.next = null;
    }

    public void update(CacheQueueNode cachenode){
        CacheQueueNode tempnode = head;
        cachenode.prev.next = cachenode.next;
        cachenode.next.prev = cachenode.prev;

        head = cachenode;
        head.next = tempnode;
        tempnode.prev = head;
    }
}



