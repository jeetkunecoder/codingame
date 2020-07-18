
/**
 * Implementation of a classic stack of integers
 */

public class StackImplementation {

    private final int SIZE = 50;
    private int st[];
    private int top;

    public StackImplementation()
    {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int v)
    {
        st[++top] = v;
    }

    public int pop()
    {
        return st[top--];
    }

    public int peek()
    {
        return st[top];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}