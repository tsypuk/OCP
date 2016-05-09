package hash;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rtsy on 13.03.2016.
 */
public class LinkedListCircle {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
//        list.size()
//        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(5, 0.75F, true);
//        for (int i = 0; i < 20; i++) {
//            map.put(i, "select * from " + i);
//            System.out.println(map);
//        }

        LRUCache<Integer, String> cache = new LRUCache<>(5);
        for (int i = 0; i < 20; i++) {
            cache.put(i, "select * from " + i);
            System.out.println(cache);
        }
    }
}
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75F, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}