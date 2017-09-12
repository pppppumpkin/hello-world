package com.qunar.fresh.lru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liyingsong on 16-5-23.
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<Integer, String>(3, 0.75f, true);
        cache.put(1, "first");
        cache.put(2, "second");
        logger.info("cache contains:{}", cache);
        cache.put(3, "third");
        logger.info("cache contains:{}", cache);
        cache.put(4, "fourth");
        logger.info("cache contains:{}", cache);
        cache.put(5, "fifth");
        logger.info("cache contains:{}", cache);
        cache.put(3, "third");
        logger.info("cache contains:{}", cache);
        cache.put(6, "sixth");
        logger.info("cache contains:{}", cache);
    }
}
