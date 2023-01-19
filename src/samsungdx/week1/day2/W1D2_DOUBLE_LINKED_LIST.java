package samsungdx.week1.day2;

class Node1 {
    public int data;
    public Node1 prev;
    public Node1 next;

    public Node1(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class W1D2_DOUBLE_LINKED_LIST {

    private final static int MAX_NODE = 10000;

    private Node1[] node1 = new Node1[MAX_NODE];
    private int nodeCnt = 0;
    private Node1 head;

    public Node1 getNode(int data) {
        node1[nodeCnt] = new Node1(data);
        return node1[nodeCnt++];
    }

    public void init() {
        this.head = null;
    }

    public void addNode2Head(int data) {
        if (findNode(data)>0) return;
        Node1 inputNode1 = getNode(data);
        if (head!=null) {
            inputNode1.next = head;
            head.prev = inputNode1;
        }
        head = inputNode1;
    }

    public void addNode2Tail(int data) {
        if (findNode(data)>0) return;
        if (head==null) addNode2Head(data);
        else {
            Node1 inputNode1 = getNode(data);
            Node1 curr = head;
            while (curr.next!=null) curr = curr.next;
            curr.next = inputNode1;
            inputNode1.prev = curr;
        }
    }

    public void addNode2Num(int data, int num) {
        if (findNode(data)>0) return;
        if (head==null) {
            head = getNode(data);
            return;
        }
        if (num == 1) {
            addNode2Head(data);
            return;
        }

        Node1 curr = head;
        int cnt = 1;
        while (cnt != num-1) {
            if (curr == null) {
                addNode2Tail(data);
                return;
            }
            curr = curr.next;
            cnt++;
        }
        if (curr.next==null) {
            addNode2Tail(data);
            return;
        }
        Node1 inputNode1 = getNode(data);
        inputNode1.prev = curr;
        inputNode1.next = curr.next;
        curr.next.prev = inputNode1;
        curr.next = inputNode1;
    }

    public int findNode(int data) {
        int count = 1;
        Node1 curr = head;
        if (head ==null) return 0;
        while (data != curr.data) {
            if (curr.next==null) return 0;
            curr = curr.next;
            count++;
        }
        return count;
    }

    public void removeNode(int data) {
        if (findNode(data)<0) return;
        Node1 curr = head;
        if (head.data == data) {
            head = curr.next;
            head.prev = null;
            return;
        }
        while (data != curr.data) {
            if (curr.next==null) return;
            curr = curr.next;
        }
        if (curr.next!=null) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        } else {
            curr.prev.next = null;
        }
    }

    public int getList(int[] output) {
        Node1 curr = head;
        if (curr == null) return 0;
        int count = 0;

        while (curr != null) {
            output[count] = curr.data;
            count++;
            curr = curr.next;
        }
        return count;
    }

    public int getReversedList(int[] output) {
        Node1 curr = head;
        if (curr == null) return 0;
        int result = getList(output);

        for (int i=result-1; i>=0; i--) {
            output[i] = curr.data;
            curr = curr.next;
        }
        return result;
    }
}