package JavaFarmProject;

import JavaFarmProject.Model.PetCreator;
import JavaFarmProject.Model.PetRepository;

import java.text.ParseException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws ParseException {
        View view = new View(new Controller(new PetCreator(), new PetRepository(new ArrayList())), new Dialog(), new Counter());
        try {
            view.start();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
