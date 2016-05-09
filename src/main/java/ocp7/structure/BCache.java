package ocp7.structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by rtsy on 17.10.2015.
 */
public class BCache {
    public static final int SIZE = 500_000_000;
    public static final int DELAY = 5;
    Map<CacheKey, Object> _cache = new HashMap<>();

    public void put(CacheKey key, Object value) {
        Object old = _cache.put(key, value);
        System.out.println("PUT " + _cache.size());
        if (old != null) {
            System.out.println("hits");
        }
    }

    public Object get(CacheKey key) {
        Object result = _cache.get(key);
        if (result == null) {
            System.out.println("miss");
        }
        return result;
    }

    public static void main(String[] args)
            throws InterruptedException {
        BCache bCache = new BCache();
        Random random = new Random();
        while (true) {
            Thread.sleep(DELAY);
            int r = random.nextInt(SIZE);
            bCache.put(new CacheKey("select", null, r), "This is firts result set " + r);
            r = random.nextInt(SIZE);
            System.out.printf("Reply: %s %d \n", bCache.get(new CacheKey("select", null, r)), r);
        }
    }

}

class CacheKey {
    String _sql;
    List params;
    int limit;
    int _hashcode;

    public CacheKey(String sql, List params, int limit) {
        _sql = sql;
        this.params = params;
        this.limit = limit;
        _hashcode = hash();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CacheKey)) {
            return false;
        }

        CacheKey cacheKey = (CacheKey) o;

        if (limit != cacheKey.limit) {
            return false;
        }
        if (!_sql.equals(cacheKey._sql)) {
            return false;
        }
        return !(params != null ? !params.equals(cacheKey.params) : cacheKey.params != null);
    }

    @Override
    public int hashCode() {
        return this._hashcode;
    }

    public int hash() {
        int result = _sql.hashCode();
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + limit;
        return result;
    }
}