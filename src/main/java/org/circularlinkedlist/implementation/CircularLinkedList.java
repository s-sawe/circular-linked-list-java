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

    public void display(){
        ListNode current = last;
        if (last == null){
            return;
        }while (current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }

    //THE CORRECT IMPLEMENTATION OF DISPLAY METHOD
    public void circularDisplay(){
        if (last == null){
            return;
        }
        ListNode first = last.next;
        while(first != last){
            System.out.print(first.data+"-->");
            first = first.next;
        }
        System.out.println(first.data+"");
    }

    public void createCircularLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first; //the lastNode, fourth, points to firstNode

        //Assign the value of fourth to LastNode ie. last
        last = fourth;
    }

    // TODO: 12/5/2022 PRINT THE ELEMENTS IN THE CIRCULAR LINKED LIST 
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCircularLinkedList();
        //cll.display(); //THIS DISPLAYS IN A NEVER ENDING LOOP
        cll.circularDisplay(); //THIS DISPLAYS THE ELEMENTS ONLY WITHOUT LOOPING
    }
}
