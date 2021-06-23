package entity;

import java.io.Serializable;

public class SimpleMessage implements Serializable {
    public String name;
    public Integer age;

    public SimpleMessage(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
