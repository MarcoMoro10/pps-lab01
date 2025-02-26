package tdd;

import java.util.Stack;

public class MinMaxStackImpl implements MinMaxStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;
    public MinMaxStackImpl() {
        stack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
        if(maxStack.isEmpty() || value >= maxStack.peek()){
            maxStack.push(value);
        }
    }

    @Override
    public int pop() {
        if(stack.isEmpty() || minStack.isEmpty() || maxStack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        else{
            int valueToPop = stack.pop();
            if(valueToPop == minStack.peek()){
                minStack.pop();
            }
            if(valueToPop == maxStack.peek()){
                maxStack.pop();
            }
            return valueToPop;
        }


    }

    public int peek(){
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    @Override
    public int getMin() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    @Override
    public int getMax() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
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
