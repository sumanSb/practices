package org.selflearning.lru;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer,Integer> cache ;
    int count =0;
    public LRUCache(int capacity){
        cache = new HashMap<>(capacity);
    }
    public int get(int key){
     return cache.containsKey(key)? cache.get(key) : 0;
    }
    public void put(int key, int value){
       if(count>=cache.size()){
           int k = cache.keySet().stream().findFirst().get();
           cache.remove(k);
           count--;
       }
       cache.put(key,value);
       count++;
    }


}

