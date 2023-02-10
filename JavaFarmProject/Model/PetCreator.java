package JavaFarmProject.Model;

import java.util.Date;

public class PetCreator {
    public Pet createPet(int petType, String name, Date birthday, String color) {
        switch (petType) {
            case 1 -> {
                return new Cat(name, birthday, color);
            }
            case 2 -> {
                return new Dog(name, birthday, color);
            }
            case 3 -> {
                return new Hamster(name, birthday, color);
            }

        }
        throw new IllegalStateException("Unexpected value" + petType);
        //return null;
    }
}
