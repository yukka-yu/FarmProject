package JavaFarmProject.Model;

import java.util.Date;

public class Hamster extends Pet {

    public Hamster(String name, Date birthday, String color) {
        super(name, birthday, color);
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", color='" + color + '\'' +
                ", commands=" + commands +
                '}';
    }
}
