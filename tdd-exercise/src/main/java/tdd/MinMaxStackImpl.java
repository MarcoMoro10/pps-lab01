package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private Stack<Integer> stack;
    public MinMaxStackImpl() {
        stack = new Stack<>();
    }
    public void push(int value) {
        stack.push(value);
    }

    @Override
    public int pop() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        else
            return stack.pop();
    }

    public int peek(){
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        }
        else
            return false;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
