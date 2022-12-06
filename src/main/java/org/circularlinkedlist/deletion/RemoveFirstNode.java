package org.circularlinkedlist.deletion;

import java.util.NoSuchElementException;

public class RemoveFirstNode {

    private ListNode last;
    int length;

    private static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public RemoveFirstNode(){
        length = 0;
        last = null;
    }

    /*-----DISPLAY----*/
    public void displayCLL(){
        ListNode node = last.next;
        if (last == null){
            return;
        }while (node != last){
            System.out.print(node.data+"-->");
            node = node.next;
        }
        System.out.println(node.data+"-->");
    }

    // TODO: 12/6/2022 REMOVE NODE AT THE BEGINNING OF THE CIRCULAR LINKED LIST
    public ListNode removeNode(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (last.next == last){
            last = null;
        }else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public static void main(String[] args) {
        RemoveFirstNode removeNode = new RemoveFirstNode();
        removeNode.last = new ListNode(100);
        ListNode secondLast = new ListNode(101);
        ListNode remove = new ListNode(102);

        //CHAINING
        removeNode.last.next = secondLast;
        secondLast.next = remove;
        remove.next = removeNode.last;

        removeNode.displayCLL();
        removeNode.removeNode();
        removeNode.displayCLL();
    }
}
