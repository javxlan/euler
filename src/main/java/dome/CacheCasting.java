package dome;

public class CacheCasting {
    public class Cache {
    }

    public class DiskCache extends Cache {
    }

    public class MemoryCache extends Cache {
    }

    public class OptimizedDiskCache extends DiskCache {
    }


    public static void main(String[] args) {
        new CacheCasting().test();
    }

    public void test() {

        /***

         OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
         Cache cache = (Cache) optimizedDiskCache;

        [x]
         MemoryCache memoryCache = new MemoryCache();
         Cache cache = (Cache) memoryCache;
         DiskCache diskCache = (DiskCache) cache;

         [x]
         DiskCache diskCache = new DiskCache();
         OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;

         OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
         DiskCache diskCache = (DiskCache) optimizedDiskCache;

         [x]
         Cache cache = new Cache();
         MemoryCache memoryCache = (MemoryCache) cache;

         OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
         Cache cache = (Cache) optimizedDiskCache;
         DiskCache diskCache = (DiskCache) cache;

         */
    }
}

