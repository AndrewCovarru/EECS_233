import java.util.Scanner;

public class StackListTester
{
    public static void main( String [ ] args ) {
        Scanner input = new Scanner(System.in);
        System.out.print("Part 1, 2, or 3?: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice){

            //Part 1: Balance
            case 1:
                System.out.print("Enter expression: ");
                String balanceString = input.nextLine();
                StackList<Integer> balanceTracker = new StackList<>();
                String status;
                for(int i =0; i < balanceString.length(); i++){
                    if(balanceString.charAt(i) == '(')
                        balanceTracker.push(i);

                    if(balanceString.charAt(i) == ')') {
                        if(balanceTracker.isEmpty())
                            balanceTracker.push(0);
                        else
                        balanceTracker.popB();
                    }
                }
                if(balanceTracker.isEmpty())
                    status = "balanced.";
                else
                    status = "NOT balanced.";
                System.out.println("Your equation is " + status);
                break;

            //Part 2: Fully parenthesized infix
            case 2:
                System.out.print("Enter expression: ");
                String paraString = input.nextLine();
                StackList<Double> numLL = new StackList<>();
                StackList<Character> operandLL = new StackList<>();

                for(int j = 0; j<paraString.length(); j++) {
                    if (paraString.charAt(j) == '0' || paraString.charAt(j) == '1' || paraString.charAt(j) == '2' || paraString.charAt(j) == '3' || paraString.charAt(j) == '4' || paraString.charAt(j) == '5' || paraString.charAt(j) == '6' || paraString.charAt(j) == '7' || paraString.charAt(j) == '8' || paraString.charAt(j) == '9')
                        numLL.push((double) Character.getNumericValue(paraString.charAt(j)));
                    if (paraString.charAt(j) == '+' || paraString.charAt(j) == '-' || paraString.charAt(j) == '*' || paraString.charAt(j) == '/')
                        operandLL.push(paraString.charAt(j));

                    for (int k = 0; k < operandLL.size(); k++) {
                        if (paraString.charAt(j) == ')') {
                            switch (operandLL.get(0)) {
                                case '+':
                                    numLL.push(numLL.pop() + numLL.pop());
                                    operandLL.popB();
                                    break;
                                case '-':
                                    numLL.push(numLL.pop() - numLL.pop());
                                    operandLL.popB();
                                    break;
                                case '*':
                                    numLL.push(numLL.pop() * numLL.pop());
                                    operandLL.popB();
                                    break;
                                case '/':
                                    numLL.push(numLL.pop() / numLL.pop());
                                    operandLL.popB();
                                    break;
                            }
                        }
                    }
                }

               System.out.println(numLL);
                break;

            //Part 3: Postfix
            case 3:
                System.out.print("Enter expression: ");
                String postString = input.nextLine();
                StackList<Double> doubleLL = new StackList<>();
                StackList<Character> operatorLL = new StackList<>();

                for(int j = 0; j<postString.length(); j++){

                    if(postString.charAt(j) == '0' || postString.charAt(j) == '1' || postString.charAt(j) == '2' || postString.charAt(j) == '3' || postString.charAt(j) == '4' || postString.charAt(j) == '5' || postString.charAt(j) == '6' || postString.charAt(j) == '7' || postString.charAt(j) == '8' || postString.charAt(j) == '9')
                        doubleLL.push((double)Character.getNumericValue(postString.charAt(j)));

                    if(postString.charAt(j) == '+' || postString.charAt(j) == '-' || postString.charAt(j) == '*' ||postString.charAt(j) == '/'){
                        operatorLL.push(postString.charAt(j));
                        for (int k = 0; k< operatorLL.size(); k++){
                            switch (operatorLL.get(0)){
                                case '+':
                                    doubleLL.push(doubleLL.pop() + doubleLL.pop());
                                    operatorLL.popB();
                                    break;
                                case '-':
                                    doubleLL.push(doubleLL.pop() - doubleLL.pop());
                                    operatorLL.popB();
                                    break;
                                case '*':
                                    doubleLL.push(doubleLL.pop() * doubleLL.pop());
                                    operatorLL.popB();
                                    break;
                                case '/':
                                    doubleLL.push(doubleLL.pop() / doubleLL.pop());
                                    operatorLL.popB();
                                    break;
                            }
                        }
                    }
                }
                    System.out.print(doubleLL);
                break;
        }
    }
    }