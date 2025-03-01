package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    //insert value in the queue
    void enqueue(int value);
    // remove value from the queue
    int dequeue();
    // head element of the queue
    int peek();
    // size of queue
    int size();
    // check if the queue is full
    boolean isFull();
    // check if the queue is full
    boolean isEmpty();
}