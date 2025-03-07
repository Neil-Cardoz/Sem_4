public class stack1 {

    // Private members
    private char[] myStack;
    private int top;

    //Constructor to innitialize the private members...
    public stack1(int size) {
        myStack = new char[size];
        top = 0;
    }

    //Return capacity
    public int capacity() {
        return myStack.length;
    }
    // Push characters onto the stack
    public void push(char c) {

            if (top == myStack.length) {
                System.out.println("Stack is full");
                return;
            }
            myStack[top] = c;
            top++;

    }

    // Pop a character in a stack
    public char pop() {

        if (top == 0) {
            System.out.println("Stack is empty");
            return ' ';

        }
        top--;
        return myStack[top];
    }


    public boolean isFull() {
        if (top == myStack.length) {
            return true;
        }
        return top == myStack.length - 1;
    }

    public static void main(String[] args) {
        stack1 stack = new stack1(5);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        stack.push('f');

        boolean isFull = stack.isFull();
        System.out.println("Stack is full? " + isFull);
        System.out.println("popped: " + stack.pop());
    }
}
