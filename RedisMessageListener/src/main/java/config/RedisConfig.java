package config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisConfig {

    RedissonClient client = Redisson.create();
    Config config = new Config();

    static Logger LOG = LoggerFactory.getLogger(RedisConfig.class);

    public RedissonClient initRedisConfig() {
        LOG.info("");
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
