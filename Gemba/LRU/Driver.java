import java.util.Scanner;
class Driver {

    //Cache size = 3;
    static final int CACHE_SIZE = 3;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of operations");
        int numberOfOperations = scanner.nextInt();
        LLNode head = null;
        LLNode last = null;
        LLNode newNode = null;
        while(numberOfOperations-- > 0) {
             int newTask = scanner.nextInt();
            LLNode tempNode = LLNode.contains(head, newTask);
            if( tempNode != null) {
                head = LLNode.deleteNonHead(head, newTask);
                head = LLNode.insertAtLast(head, tempNode);
            } else {
                if(LLNode.size(head) < CACHE_SIZE) {
                    if(head == null) {
                        head = LLNode.createNode(newTask);
                        last = head;
                        last.next = null;
                    } else {
                        newNode = LLNode.createNode(newTask);
                        last = LLNode.insertAtLast(last, newNode);
                    }
                } else {
                    head = LLNode.deleteHead(head);
                    head = LLNode.insertAtLast(head, tempNode);
                }
            }

            LLNode.displayLL(head);



            // if(head == null) {
            //     head = LLNode.createNode(newTask);
            //     last = head;
            // } else {
                
            //     newNode = LLNode.createNode(newTask);
            //     last = LLNode.insertAtLast(last, newNode);
                
            // }
            // LLNode.displayLL(head);

            
            // if(LLNode.contains(head, 2) != null){
            //     LLNode.deleteNonHead(head, 2);
            // }
            // System.out.print("\n");
            // LLNode.displayLL(head);
            //else System.out.println("Not Found");
        }

    }
} 