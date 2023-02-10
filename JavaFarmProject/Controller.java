package JavaFarmProject;

import JavaFarmProject.Model.Pet;
import JavaFarmProject.Model.PetCreator;
import JavaFarmProject.Model.PetRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private PetCreator petCreator = new PetCreator();
    private PetRepository petRepository = new PetRepository(new ArrayList<>());

    public Controller(PetCreator petCreator, PetRepository petRepository) {
        this.petCreator = petCreator;
        this.petRepository = petRepository;
    }

    public void addPet(int petType, String name, Date birthday, String color){
        petRepository.addPet(petCreator.createPet(petType, name, birthday, color));
    }
    public void trainPet(int id){
        petRepository.getAllPet().get(id).train(petRepository.getAllPet().get(id));
    }
    public List<Pet> getAllPet() {
        return petRepository.getAllPet();
    }
    public List<String> getCommands(int id){
        return petRepository.getByIdPet(id).getCommands();
    }
}
