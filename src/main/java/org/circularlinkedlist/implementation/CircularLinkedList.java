package org.circularlinkedlist.implementation;

/*Similar to SinglyLinkedList...
* In CircularLinkedList, the LastNode points to the FirstNode and is not Null;
* Instead of head, we keep track of the last node;
* when the list is empty, LastNode points --> to null */


public class CircularLinkedList {

    private ListNode last;
    private int length;

    private static class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularLinkedList(){
        last = null;
        length = 0;
    }

    public int getLength(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first; //last node,,fourth, points to firstNode

        //Assign the value of fourth to LastNode ie. last
        last = fourth;
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
    }
}
