import java.util.ArrayList;
import java.util.Scanner;

public class main_menu {
    private String input;
    LinkStack theStack = new LinkStack();
    ArrayList<String> operators = new ArrayList<>();

    public main_menu(){
        //initialize input as empty string
        input = "";
    }

    private void printMenu(){
        System.out.println("SELECT AN OPTION FROM THE FOLLOWING MENU:");
        System.out.println("    [1] Read in expression in postfix notation");
        System.out.println("    [2] Evaluate the postfix expression");
        System.out.println("    [3] CLEAR");
        System.out.println("    [4] CHECK CLEAR");
        System.out.println("    [0] EXIT");
    }

    public void readIn(){
        var getter = new Scanner(System.in);
        System.out.print("ENTER INFIX EXPRESSION\nONLY VALID OPERATORS: +,-,*,/ \n" +
                "All OPERANDS MUST BE POSITIVE INTEGERS\n" +
                "SEPERATE EACH ELEMENT BY A SPACE\n" +
                "IE: 55 + 4 - 2\n");
        input = getter.nextLine();
        System.out.print("YOU HAVE ENTERED: " +input+ "\n");
        stackIntegers();
    }

    public void stackIntegers(){
        //splits elements by space and stores them as variable x
        var x = input.split(" ");
        for(var elm:x){
            //this looks for any operator
            //I could only get it to work by using this regex
            //Only using the four allowed operators did not work
            //If an operator is found, it's stored in the arraylist of operators
            if(elm.matches("[()=;{}[]+\\-*/&!%^|<>']]")){
                operators.add(elm);
            }
            else{
                int i = Integer.parseInt(elm);
                theStack.push(i);
                theStack.displayStack();
            }
        }
        theStack.displayStack();
        System.out.print("Operators, listed in order:"+operators+"\n");

    }

    public void evalPostfix(){
        //loop will cycle as long as there is operators left to perform work with
        while(operators.size()>0){
            int x = (int) theStack.pop();
            int y = (int) theStack.pop();
            var q = operators.get(0);
            //result variable is used to temporarily store the outcome from the arithmetic
            var result = 0;
            //operator can now be removed from array list since it is temporarily stored as variable q
            operators.remove(0);
            System.out.print(y+" "+ q +" "+ x +"\n");
            //Switch statement is used to decode operator that is currently stored as a string
            //and to preform the math
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
            //result is then pushed back onto the stack
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
                case 3:
                    //I implemented this clear option to ensure the stack is emptied before an other run
                    while (!theStack.isEmpty()){
                        theStack.pop();
                    }
                    break;
                case 4:
                    //This is to visually confirm the stack has been cleared after clearing
                    theStack.displayStack();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.print("INVALID INPUT");
            }
        }
    }
}
