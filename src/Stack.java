import java.util.NoSuchElementException;

public class Stack {
    SLL Stack = new SLL();
    Node top;

    public Stack() {
        top = null;
    }

    public boolean is_empty() {
        return top == null;
    }

    public void push(int value) {
        Stack.addTotail(value);
        top = Stack.tail;
    }


    public int pop() {
       Node out = Stack.deleteFrom_Tail();
       top = Stack.tail;
       return out.data;

   }

  public void display_Stack() {
        Stack.displayList();
    }
}