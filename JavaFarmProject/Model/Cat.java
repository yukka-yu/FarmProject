package JavaFarmProject.Model;

import java.util.Date;

public class Cat extends Pet {
    public Cat(String name, Date birthday, String color) {
        super(name, birthday, color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                ", commands=" + commands +
                '}';
    }
}
