package JavaFarmProject.Model;

import java.util.List;

public class PetRepository {
    protected List<Pet> pets;

    public PetRepository(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public void deletePet(int id){
        pets.remove(id);
    }

    public List<Pet> getAllPet (){
        return pets;
    }
    
    public Pet getByIdPet(int id){
        return pets.get(id);
    } 
    
    public List<String> getCommands(int id){
        return pets.get(id).commands;
    }
}
