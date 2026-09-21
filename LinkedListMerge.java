

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}


public class LinkedListMerge{

    static void Display(Node head){
        while(head != null){
            System.out.println(head.data + "->");
            head = head.next;
        }
        System.out.println("Empty");
    }

        static Node merge(Node head1, Node head2){
            if (head1 == null)
                return head2;

        Node temp = head1;
            while(temp.data != null){
                temp = temp.next;
            }

            temp.next = head2;
        }
        return head1;
    } 

    
    public static void main(String[] args) {

        Node head1 =new Node(25);
        head1.next = new Node(20);
        head1.next.next = new Node(15);    


        Node head2 =new Node(30);
        head2.next = new Node(25);
        head2.next.next = new Node(20);

        LinkedListMerge list = new LinkedListMerge();
        System.out.println("First Linked List");
        list.Display(head1);

        System.out.println("Second Linked List");
        list.Display(head2);
    }

}