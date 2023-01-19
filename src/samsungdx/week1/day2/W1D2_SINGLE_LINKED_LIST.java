package samsungdx.week1.day2;

public class W1D2_SINGLE_LINKED_LIST {

    private final static int MAX_NODE = 10000;

    private Node1[] node = new Node1[MAX_NODE];
    private int nodeCnt = 0;
    private Node1 head;

    public Node1 getNode(int data) {
        node[nodeCnt] = new Node1(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = null;
    }

    public void addNode2Head(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node1 nHead = getNode(data);
        nHead.next = head;
        head = nHead;
    }

    public void addNode2Tail(int data) {
        if (head == null) {
            head = getNode(data);
            return;
        }

        Node1 curNode = head; // head 찾아서 tail 찾아야함
        while (curNode.next != null) { // 현재 node next가 null인 지점 찾기
            curNode = curNode.next; // null이 아니라면 다음 next node가 cur
        }

        Node1 nTail = getNode(data); // 새로운 tail 생성
        curNode.next = nTail;
    }

    public void addNode2Num(int data, int num) {
        if (head == null) {
            head = getNode(data);
            return;
        }
        if (num == 1) { // 맨앞에 넣을 경우
            addNode2Head(data);
            return;
        }

        Node1 curNode = head;
        Node1 preNode = null;
        int cnt = 1;
        while (true) {
            if (cnt == num - 1) {
                if (curNode == null) { // 연결 노드 개수보다 큰 경우 마지막에 삽입
                    addNode2Tail(data);
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
                break;
            }
            curNode = curNode.next;
            cnt++;
        }

        Node1 nNode = getNode(data);
        preNode.next = nNode;
        nNode.next = curNode;

    }

    public void removeNode(int data) {
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node1 curNode = head;
        Node1 preNode = null;
        Node1 nextNode = null;
        while (true) {
            if (curNode == null)
                return;

            if (curNode.data == data) {
                nextNode = curNode.next;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }

        preNode.next = nextNode;

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
}
