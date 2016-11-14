import java.util.Scanner;

/** class ExpressionTreeTest **/
public class ExpressionTreeTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        ExpressionTree expression = new ExpressionTree();

        System.out.print("Enter fully paranthesized infix equation: ");
        expression.buildTree(scan.nextLine());

        System.out.print("Infix: ");
        expression.infix();

        System.out.println();
        System.out.println("Evaluated Result: " + expression.evaluate());
    }
}