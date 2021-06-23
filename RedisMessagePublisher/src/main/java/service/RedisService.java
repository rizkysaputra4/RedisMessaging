package service;

import config.RedisConfig;
import entity.SimpleMessage;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.codec.SerializationCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.Scanner;

public class RedisService {

    RedissonClient client;

    public RedisService(RedissonClient client) {
        this.client = client;
    }

    public void publishMessage() {
        RTopic publishTopic = client.getTopic("xxx", new SerializationCodec());
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Name: ");
            String u = s.nextLine();
            System.out.println("Enter Age: ");
            Integer a = s.nextInt();
            publishTopic.publish(new SimpleMessage(u, a));
            System.out.println("Message published.....");
        }
    }
}


