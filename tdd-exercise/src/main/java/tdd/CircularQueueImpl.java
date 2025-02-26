package tdd;


public class CircularQueueImpl implements CircularQueue {
    private static final int DEFAULT_CAPACITY = 3;
    private int[] queue;
    private int size;
    private int head;
    private int tail;
    public CircularQueueImpl() {
        queue = new int[DEFAULT_CAPACITY];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }
    @Override
    public void enqueue(int value) {
        if(isFull()){
            head = (head +1) % DEFAULT_CAPACITY;
        }else{
            size++;
        }
        queue[tail] = value;
        tail = (tail + 1) % DEFAULT_CAPACITY;
    }

    @Override
    public int dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        else {
            int value = queue[head];
            head = (head + 1) % DEFAULT_CAPACITY;
            size--;
            return value;
        }
    }

    @Override
    public int peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return queue[head];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isFull() {
        return size == DEFAULT_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

}
