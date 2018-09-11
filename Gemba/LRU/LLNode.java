class LLNode {

    int data;
    LLNode next;

    private LLNode(int data) {
        this.data = data;
        next = null;
    }
    static LLNode createNode(int data) {
        return new LLNode(data);
    }

    static LLNode insertAtLast(LLNode headNode , LLNode node) {
        LLNode temp = headNode;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        temp = temp.next;
        temp.next = null;
        return headNode;
    }

    static LLNode deleteHead(LLNode headNode) {
        if(headNode!=null)
            headNode = headNode.next;
        return headNode;
    }

    static LLNode deleteNonHead(LLNode headNode, int dataToBeDeleted) {

        LLNode temp = headNode;
        if(headNode == null) return headNode;
        if(headNode.data == dataToBeDeleted) return deleteHead(headNode);
        while(temp != null && temp.next.data != dataToBeDeleted) {
            temp = temp.next;
        }
        if(temp.next != null)temp.next = temp.next.next;
        return headNode;
    }

    static void displayLL (LLNode head) {
        LLNode temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    static LLNode contains(LLNode headNode, int data) {
        LLNode temp = headNode;
        while(temp != null){
            if(temp.data == data) {
                return temp;
            }
            temp=temp.next;
        }
        return temp;
    }

    static int size (LLNode headNode) {
        int count = 0;
        LLNode temp = headNode;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        System.err.println("Size " + count);
        return count;
    }

}