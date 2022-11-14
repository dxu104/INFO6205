package Q4;

// Java Program to insert in a sorted list
class LinkedList {
    Node head; // head of list

    /* Linked list Node*/
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }


   public void sortedInsert(Node insertedNode)
    {
        Node curr=null;


        if (head == null || head.data
                >= insertedNode.data) {
            insertedNode.next = head;
            head = insertedNode;
        }
        else {

            curr = head;

            while (curr.next != null
                    && curr.next.data < insertedNode.data){
                curr = curr.next;}

            insertedNode.next = curr.next;
            curr.next = insertedNode;
        }
    }


    /* Function to create a node */
   public Node newNode(int data)
    {
        Node x = new Node(data);
        return x;
    }

   public void printList()
    {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[])
    {
        LinkedList linkedList = new LinkedList();
        Node newNode;
        newNode = linkedList.newNode(2);
        linkedList.sortedInsert(newNode);
        newNode = linkedList.newNode(1);
        linkedList.sortedInsert(newNode);
        newNode = linkedList.newNode(5);
        linkedList.sortedInsert(newNode);
        newNode = linkedList.newNode(8);
        linkedList.sortedInsert(newNode);
        newNode = linkedList.newNode(0);
        linkedList.sortedInsert(newNode);
        newNode = linkedList.newNode(-1);
        System.out.println("The value of insert node is "+ newNode.data);

        System.out.println("Created Linked List is");
        linkedList.sortedInsert(newNode);

        linkedList.printList();
    }
}

