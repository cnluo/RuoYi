package com.ruoyi.common.config;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class EhCacheConfig {


    @Bean
    public CacheManager ehCacheManager() {

        Configuration config = new Configuration();

        config.setName("ruoyi");
        config.setUpdateCheck(false);

        config.diskStore(new DiskStoreConfiguration()//
                .path(System.getProperty("java.io.tmpdir"))//
        );

        // defaultCache
        config.addDefaultCache(new CacheConfiguration()//
                .maxEntriesLocalHeap(1000)//
                .eternal(false)//
                .timeToIdleSeconds(3600)//
                .timeToLiveSeconds(3600)//
                .overflowToDisk(false)//
                .statistics(false)//
        );

        addCache(config, "loginRecordCache", 2000, false, 600, 0, false);
        addCache(config, "sys-userCache", 10000, false, 0, 0, false);

        // sys-authCache (LRU)
        config.addCache(new CacheConfiguration("sys-authCache", 10000)//
                .eternal(false).timeToIdleSeconds(0)//
                .timeToLiveSeconds(0)//
                .overflowToDisk(false)//
                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU)//
                .statistics(false)//
        );

        // sys-cache / sys-config / sys-dict
        addEternalCache(config, "sys-cache", 1000);
        addEternalCache(config, "sys-config", 1000);
        addEternalCache(config, "sys-dict", 1000);

        addCache(config, "shiro-activeSessionCache", 10000, false, 0, 0, false);

        return CacheManager.newInstance(config);
    }

    private void addCache(Configuration config, String name, int maxEntries, boolean eternal, long tti, long ttl, boolean overflowToDisk) {

        config.addCache(new CacheConfiguration(name, maxEntries)//
                .eternal(eternal)//
                .timeToIdleSeconds(tti)//
                .timeToLiveSeconds(ttl)//
                .overflowToDisk(overflowToDisk)//
                .diskPersistent(false)//
                .statistics(false)//
        );
    }

    private void addEternalCache(Configuration config, String name, int maxEntries) {
        config.addCache(new CacheConfiguration(name, maxEntries)//
                .eternal(true)//
                .overflowToDisk(false) // ★ 2.6.11 下强烈建议 false
                .statistics(false)//
        );
    }
}
