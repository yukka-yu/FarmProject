package JavaFarmProject.Model;

import java.util.*;

public class Pet {
    protected String name;
    protected Date birthday;
    protected String color;
    protected List<String> commands;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }



    public Pet(String name, Date birthday, String color){
        this.name = name;
        this.birthday = birthday;
        this.color = color;
        this.commands = generateCommands();
    }

    public List<String> generateCommands() {

        List commandsList = new ArrayList<>();
        Collections.addAll(commandsList,"сидеть", "лежать", "умри", "ешь", "голос", "стоять", "прячься", "место", "лапу", "рядом");



        Random random = new Random();
        int choice = random.nextInt(0, 10);

        for (int i = 0; i < choice; i++)
        {
            commandsList.remove(9 - i);
        }
        return commandsList;
    }

    public void train(Pet pet){
        List allCommandsList = new ArrayList<String>();
        Collections.addAll(allCommandsList,"сидеть", "лежать", "умри", "ешь", "голос", "стоять", "прячься", "место", "лапу", "рядом");
        if (pet.getCommands().size() < 10){
            pet.commands.add((String) allCommandsList.get(pet.getCommands().size()));
            System.out.println("Научили чему-то новенькому!");
        }
        else {
            System.out.println("Всё умеет!");
        }

    }

}
