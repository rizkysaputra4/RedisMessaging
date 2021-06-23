import config.MailConfig;
import config.RedisConfig;
import listener.RedisListener;
import service.MailSender;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) throws MessagingException {

        MailConfig mailConfig = new MailConfig();
        RedisConfig redisConfig = new RedisConfig();

        RedisListener redisListener = new RedisListener(
                redisConfig.initRedisConfig(),
                new MailSender(mailConfig.getSession()));
        redisListener.listenMessage();
    }
}
