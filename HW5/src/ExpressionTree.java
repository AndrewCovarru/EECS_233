class ExpressionTree
{
    class TreeNode
    {
        char data;
        TreeNode left, right;

        /** constructor **/
        public TreeNode(char data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class StackNode
    {
        TreeNode treeNode;
        StackNode next;

        public StackNode(TreeNode treeNode)
        {
            this.treeNode = treeNode;
            next = null;
        }
    }

    private static StackNode top;

    public ExpressionTree()
    {
        top = null;
    }

    public void clear()
    {
        top = null;
    }

    private void push(TreeNode pointer)
    {
        if (top == null)
            top = new StackNode(pointer);
        else
        {
            StackNode npointer = new StackNode(pointer);
            npointer.next = top;
            top = npointer;
        }
    }

    private TreeNode pop()
    {
        if (top == null)
            throw new RuntimeException("Underflow");
        else
        {
            TreeNode pointer = top.treeNode;
            top = top.next;
            return pointer;
        }
    }

    private TreeNode peek()
    {
        return top.treeNode;
    }

    private void insert(char val)
    {
        try
        {
            if (isDigit(val))
            {
                TreeNode npointer = new TreeNode(val);
                push(npointer);
            }
            else if (isOperator(val))
            {
                TreeNode npointer = new TreeNode(val);
                npointer.left = pop();
                npointer.right = pop();
                push(npointer);
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid Expression");
        }
    }

    private boolean isDigit(char ch)
    {
        return ch >= '0' && ch <= '9';
    }

    private boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int digitize(char ch)
    {
        return ch - '0';
    }

    public void buildTree(String eqn)
    {
        for (int i = eqn.length() - 1; i >= 0; i--)
            insert(eqn.charAt(i));
    }

    public double evaluate()
    {
        return evaluate(peek());
    }

    public double evaluate(TreeNode pointer)
    {
        if (pointer.left == null && pointer.right == null)
            return digitize(pointer.data);
        else
        {
            double result = 0.0;
            double left = evaluate(pointer.left);
            double right = evaluate(pointer.right);
            char operator = pointer.data;

            switch (operator)
            {
                case '+' :
                    result = left + right;
                    break;
                case '-' :
                    result = left - right;
                    break;
                case '*' :
                    result = left * right;
                    break;
                case '/' :
                    result = left / right;
                    break;
            }
            return result;
        }
    }

    public void infix()
    {
        inOrder(peek());
    }

    private void inOrder(TreeNode pointer)
    {
        if (pointer != null)
        {
            inOrder(pointer.left);
            System.out.print(pointer.data);
            inOrder(pointer.right);
        }
    }

}
