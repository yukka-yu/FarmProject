package JavaFarmProject.Model;

import java.util.Date;

public class Dog extends Pet {
    public Dog(String name, Date birthday, String color) {
        super(name, birthday, color);
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                ", commands=" + commands +
                '}';
    }
}