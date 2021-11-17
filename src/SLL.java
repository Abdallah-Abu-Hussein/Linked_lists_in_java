public class SLL {
    public Node head;
    public Node tail;

    public SLL() {
        head = tail = null;
    }

    public void addTotail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addToHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("List is empty");
        } else {

            if (position == 1) {
                addToHead(data);
            }
            Node temp = head;
            int count = 1;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
    }


    // ascending_order
    public void insertInOrder(int data) {
        Node newNode = new Node(data);
        Node temp;
        if (head == null || newNode.data <= head.data) {
            addToHead(newNode.data);
        } else {
            temp = head;
            while (temp.next != null && temp.next.data < newNode.data)
                temp = temp.next;
            newNode.next = temp.next;
            temp.next = newNode;

        }

    }

    public void displayList() {
        Node temp = head;
        if (head == null) {
            System.out.println("The List is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println();
    }

    public int getLength() {
        int count = 0;
        Node temp = head;
        if (head == null) {
            System.out.println("The List is empty");
        }
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }


    public int existAT(int data) {
        int position = 1;
        Node temp = head;
        while (temp != null) {

            if (temp.data == data) {
                return position;
            }
            temp = temp.next;
            position++;
        }
        return -1;
    }


    public Node deleteFrom_Head() {
        Node del_Node = head;
        if (head == null) {
            head = tail = null;
        }
        if (head != null) {
            head = head.next;
            System.out.println(del_Node.data + " has been deleted");
            return del_Node;
        }
        return null;
    }

    public Node removeLastNode(Node head) {
        if (head == null)
            return null;

        if (head.next == null) {
            return null;
        }

        // Find the second last node
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        // Change next of second last
        second_last.next = null;

        return head;
    }

    public Node deleteFrom_Tail() {
        Node tempNode = head;
        if (head == tail) {
            tempNode = tail;
            head = tail = null;
            return tempNode;
        }

        while (tempNode.next != tail) {
            tempNode = tempNode.next;
        }
        tail = tempNode;
        tail.next = null;

        return tempNode;
    }

    //ms.lana method
    public Node deleteAt(int value) {
        if (head == null) {
            return null;
        }
        if (head.data == value) {
            return deleteFrom_Head();
        }
        if (tail.data == value) {
            deleteFrom_Tail();
        }
        Node temp = head.next;
        Node prev = head;

        while (temp != null) {
            if (temp.data == value) {
                prev.next = temp.next;
            }
            temp = temp.next;
            prev = prev.next;
        }

        return temp;
    }

    public void deleteNode(int key) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
    }

    public void appendList(SLL newList) {
        tail.next = newList.head;
        tail = newList.tail;
    }


    public Node reverseList_recursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node restoflist = reverseList_recursion(head.next);
        head.next.next = head;
        head.next = null;

        return restoflist;
    }

    public boolean contains(int data) {
        Node temp = head;
        while (temp != null) {

            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public Node reverseBetween(Node head, int left, int right) {

        Node leftNode = new Node(left);
        Node mid = null;
        Node rightNode = new Node(right);
        Node temp = head;
        Node temp2 = null;

        while (temp != null) {
            if (temp.data == left) {
                leftNode = temp;
                mid = leftNode.next;
                rightNode = mid.next;

                if (rightNode.data > leftNode.data) {
                    temp2 = leftNode;
                    int k = temp.data;
                    leftNode.data = rightNode.data;
                    rightNode.data = k;
                    break;
                }
            }
            temp = temp.next;
        }
        return head;
    }


    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}





