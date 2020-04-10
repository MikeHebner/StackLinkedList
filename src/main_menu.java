import java.util.Scanner;

public class main_menu {
    private String input;

    public main_menu(){
        input = "";
    }

    private void printMenu(){
        System.out.println("SELECT AN OPTION FROM THE FOLLOWING MENU:");
        System.out.println("    [1] Read an expression in postfix notation");
        System.out.println("    [2] Evaluate the postfix expression");
        System.out.println("    [0] EXIT");
    }

    public void runMenu() {
        var getter = new Scanner(System.in);
        while(true){
            printMenu();
            var selection = getter.nextInt();
            getter.nextLine();
            switch(selection){
                case 1:
                    //method
                    break;
                case 2:
                    //method
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.print("INVALID INPUT");
            }
        }
    }
}
