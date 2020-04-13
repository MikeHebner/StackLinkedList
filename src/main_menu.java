import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main_menu {
    private String input;
    LinkStack theStack = new LinkStack();
    ArrayList<String> operators = new ArrayList<>();

    public main_menu(){
        input = "2 4 6 * +";
        //ArrayList<String> operators = new ArrayList<>();
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
        input = getter.nextLine();
        System.out.print("YOU HAVE ENTERED: " +input+ "\n");
        stackIntegers();
    }

    public void stackIntegers(){
        var x = input.split(" ");
        for(var elm:x){
            //System.out.print(elm+"\n");
            if(elm.matches("[()=;{}[\\]+\\-*/&!%^|<>']]")){
                //operators=operators+elm;
                operators.add(elm);
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
        while(operators.size()>0){
            int x = (int) theStack.pop();
            int y = (int) theStack.pop();
            var q = operators.get(0);
            var result = 0;
            operators.remove(0);
            System.out.print(y+" "+ q +" "+ x +"\n");
            switch(q){
                case "+":
                    result = y+x;
                    break;
                case "-":
                    result = y-x;
                    break;
                case "*":
                    result = y*x;
                    break;
                case "/":
                    result = y/x;
                    break;
                default:
                    System.out.print("INVALID INPUT");
            }
            theStack.push(result);
            System.out.print("="+ result+"\n");

        }
        System.out.print("**POSTFIX EVALUATION RESULT**\n");
        theStack.displayStack();
        System.out.print("\n");
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
