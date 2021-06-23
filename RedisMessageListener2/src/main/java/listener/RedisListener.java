package listener;

import entity12.SimpleMessage;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.redisson.codec.SerializationCodec;
import service.MailSender;

import javax.mail.MessagingException;

public class RedisListener {

    RedissonClient client;
    MailSender mailSender;

    public RedisListener(RedissonClient client, MailSender mailSender) {
        this.client = client;
        this.mailSender = mailSender;
    }

    public void listenMessage() throws MessagingException {
        RTopic subscribeTopic = client.getTopic("xxx", new SerializationCodec());
        subscribeTopic.addListener(SimpleMessage.class, new MessageListener<SimpleMessage>() {
            @Override
            public void onMessage(CharSequence charSequence, SimpleMessage simpleMessage) {
                try {
                    mailSender.Send(simpleMessage);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                System.out.println(charSequence);
                System.out.println(simpleMessage);
                System.out.println("Process Finished.....");
            }
        });
    }
}


