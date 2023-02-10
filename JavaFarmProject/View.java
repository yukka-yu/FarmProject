package JavaFarmProject;

import JavaFarmProject.Model.Pet;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class View {
   private Controller controller ;
   private Dialog dialog;
   public View(Controller controller, Dialog dialog) {
       this.controller = controller;
       this.dialog = dialog;
   }

   public void printMenu(){
       System.out.println("""
               Choose an action:
               1 - View all animals
               2 - Add animal
               3 - View commands
               4 - Learn some new command
               0 - Exit""");
   }

    void printDialogList() {

        System.out.println("""
                Whom do you want to add?
                1 - Cat
                2 - Dog
                3 - Hamster
                0 - Change my mind""");
    }

    void printDialog(int index) throws ParseException {
            String [] arr = dialog.printDialog();
            controller.addPet(index, arr[0], new SimpleDateFormat("yyyy-MM-dd").parse(arr[1]),arr[2]);
            System.out.println("Added!");
    }

    private void viewAllPet(){
        for (Pet pet : controller.getAllPet()) {
            System.out.println(pet);
        }

   }
   private void viewCommands(int id){
       System.out.println(controller.getCommands(id));
   }

   private int chooseAction(){
       Scanner scan = new Scanner(System.in);
       int choice = scan.nextInt();
       //scan.close();
       return choice;
   }

   public void start() throws ParseException {
       boolean flag = true;
       while (flag) {
           printMenu();
           int choice = chooseAction();
           if ((choice >= 0) && (choice <= 4)) {
               switch (choice) {
                   case 1 -> viewAllPet();
                   case 2 -> {
                       printDialogList();
                       int choice1 = chooseAction();
                       if ((choice1 > 0) && (choice1 <=3)){
                           printDialog(choice1);
                       }
                       else if (choice1 == 0) System.out.println("Return to main menu");
                       else System.out.println("Unexpected value");

                       break;
                   }
                   case 3 -> {
                       viewAllPet();
                       System.out.println("Enter the number of animal whose commands you want to see");
                       int choice1 = chooseAction();
                       if ((choice1 >= 1) && (choice1 < controller.getAllPet().size()+1)) {
                           System.out.println("This animal know commands:");
                           viewCommands(choice1 - 1);
                       }
                       else System.out.println("Unexpected animal number");
                       break;
                   }

                   case 4 -> {
                       viewAllPet();
                       System.out.println("Enter the number of animal you want to train");
                       int choice1 = chooseAction();
                       if ((choice1 >= 1) && (choice1 < controller.getAllPet().size()+1)) {
                           controller.trainPet(choice1 - 1);
                       }
                       else System.out.println("Unexpected animal number");
                   }
                   case 0 -> flag = false;
               }
           }
           else System.out.println("Unexpected value. Try again!");

       }
   }
}
