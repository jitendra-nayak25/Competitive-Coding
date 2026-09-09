public class DequeOperations {

    static int[] deque = new int[5];
    static int front = -1;
    static int rear = -1;

    // Insert at front
    static void insertFront(int value) {
        if (front == 0) {
            System.out.println("Deque Overflow");
        } else if (front == -1) {
            front = rear = 0;
            deque[front] = value;
        } else {
            front--;
            deque[front] = value;
        }
    }

    // Insert at rear
    static void insertRear(int value) {
        if (rear == deque.length - 1) {
            System.out.println("Deque Overflow");
        } else if (front == -1) {
            front = rear = 0;
            deque[rear] = value;
        } else {
            rear++;
            deque[rear] = value;
        }
    }

    // Delete from front
    static void deleteFront() {
        if (front == -1 || front > rear) {
            System.out.println("Deque Underflow");
        } else {
            System.out.println(deque[front] + " deleted from front");
            front++;

            if (front > rear) {
                front = rear = -1;
            }
        }
    }

    // Delete from rear
    static void deleteRear() {
        if (front == -1 || front > rear) {
            System.out.println("Deque Underflow");
        } else {
            System.out.println(deque[rear] + " deleted from rear");
            rear--;

            if (front > rear) {
                front = rear = -1;
            }
        }
    }

    // Display
    static void display() {
        if (front == -1) {
            System.out.println("Deque is empty");
        } else {
            System.out.print("Deque: ");

            for (int i = front; i <= rear; i++) {
                System.out.print(deque[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        insertRear(10);
        insertRear(20);
        insertRear(30);

        display();

        insertFront(5);

        display();

        deleteFront();

        display();

        deleteRear();

        display();
    }
}