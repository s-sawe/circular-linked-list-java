package org.circularlinkedlist.adding;

import org.circularlinkedlist.implementation.CircularLinkedList;

public class InsertNodeBeginning {

    private ListNode last;
    private int length;

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }
    public InsertNodeBeginning(){
       last = null;
       length = 0;
    }

    public void insertFirst(int data){
        ListNode temp = new ListNode(data);
        if (last == null){
            last = temp;
        }else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }
    public static void main(String[] args) {
        InsertNodeBeginning circularLink = new InsertNodeBeginning();
        circularLink.last = new ListNode(10);
        ListNode first = new ListNode(20);
        ListNode second = new ListNode(30);
        ListNode third = new ListNode(40);

        //CHAINING THE ELEMENTS
        circularLink.last.next = first;
        first.next = second;
        second.next = third;
        third.next = circularLink.last;

        //OUTPUTS
        circularLink.display();
        circularLink.insertFirst(190);
        circularLink.display();
    }

    private void display() {
        ListNode temp = last.next;
        if (last == null){
            return;
        }while (temp != last){
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.println(temp.data+"-->");
    }
}
