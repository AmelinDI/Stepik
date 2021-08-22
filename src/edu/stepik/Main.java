package edu.stepik;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Node resultHead;
        Node head1 = new Node();
        Node head2 = new Node();
        Node cn; // Current Node

        cn = head1;
        cn.setData(1);
        cn.setNext(new Node());

        cn = cn.getNext();
        cn.setData(3);

        cn = head2;
        cn.setData(2);
        cn.setNext(new Node());

        cn = cn.getNext();
        cn.setData(5);

        resultHead = merge(head1, head2);

        do {
            System.out.println(resultHead.getData());
            resultHead = resultHead.getNext();
        } while (resultHead != null);
    }

    static Node merge(Node head1, Node head2){
        Node result;
        Node next;
        Node nextHead1 = head1;
        Node nextHead2 = head2;

        if (nextHead1.getData() < nextHead2.getData()){
            result = nextHead1;
            nextHead1 = nextHead1.getNext();
        } else {
            result = nextHead2;
            nextHead2 = nextHead2.getNext();
        }

        next = result;

        while (nextHead1 != null && nextHead2 != null){
            if (nextHead1.getData() < nextHead2.getData()){
                next.setNext(nextHead1);
                next = nextHead1;
                nextHead1 = nextHead1.getNext();
            } else {
                next.setNext(nextHead2);
                next = nextHead2;
                nextHead2 = nextHead2.getNext();
            }
        }

        if (nextHead1 == null){
            next.setNext(nextHead2);
        } else {
            next.setNext(nextHead1);
        }

        return result;
    }


    static class Node  {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}


