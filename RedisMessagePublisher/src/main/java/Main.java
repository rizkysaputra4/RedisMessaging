import config.RedisConfig;
import service.RedisService;

public class Main {

    public static void main(String[] args) {

        RedisConfig redisConfig = new RedisConfig();

        RedisService redisService = new RedisService(redisConfig.initRedisConfig());
        redisService.publishMessage();
    }
}
