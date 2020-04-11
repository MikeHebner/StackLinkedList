import java.util.Arrays;
import java.util.Scanner;

public class main_menu {
    private String input;
    LinkStack theStack = new LinkStack();
    private String operators;

    public main_menu(){
        input = "2 4 6 * +";
        operators = "";
    }

    private void printMenu(){
        System.out.println("SELECT AN OPTION FROM THE FOLLOWING MENU:");
        System.out.println("    [1] Read an expression in postfix notation");
        System.out.println("    [2] Evaluate the postfix expression");
        System.out.println("    [0] EXIT");
    }

    public void readIn(){
        var getter = new Scanner(System.in);
        System.out.print("ENTER INFIX EXPRESSION\nONLY VALID OPERATORS: +,-,*,/\n" +
                "All OPERANDS MUST BE POSITIVE INTEGERS\n" +
                "SEPERATE EACH ELEMENT BY A SPACE\n" +
                "IE: 55 + 4 - 2\n");
        var infix = getter.nextLine();
        input = infix;
        System.out.print("YOU HAVE ENTERED: " +input+ "\n");
        stackIntegers();
    }

    public void stackIntegers(){
        var x = input.split(" ");
        for(var elm:x){
            //System.out.print(elm+"\n");
            if(elm.matches("[()=;{}[\\]+\\-*/&!%^|<>']]")){
                operators=operators+elm;
            }
            else{
                int i = Integer.parseInt(elm);
                theStack.push(i);
                theStack.displayStack();
            }
        }
        theStack.displayStack();
        System.out.print("\n"+ operators+"\n");
    }

    public void evalPostfix(){
        System.out.print("**POSTFIX EVALUATION RESULT**");
    }

    public void runMenu() {
        var getter = new Scanner(System.in);
        while(true){
            printMenu();
            var selection = getter.nextInt();
            getter.nextLine();
            switch(selection){
                case 1:
                    readIn();
                    break;
                case 2:
                    evalPostfix();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.print("INVALID INPUT");
            }
        }
    }
}
