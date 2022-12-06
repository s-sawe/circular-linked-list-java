package org.circularlinkedlist.adding;

public class InsertNodeEnd {

    private ListNode last;
    private int length;

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
           this.data = data;
        }
    }

    public InsertNodeEnd(){
        last = null;
        length = 0;
    }
    /*..................BEGINNING OF CODE...............*/
    public void displayCircular(){
        ListNode current = last.next;
        if (last == null){
            return;
        }while(current != last){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println(current.data+"-->");
    }

    // TODO: 12/6/2022 INSERT NODE AT THE END OF A SINGLY LINKED LIST
    public void insertEnd(int data){
        ListNode newNode = new ListNode(100);
        if (last == null){
            last = newNode;
            last.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public static void main(String[] args) {
        InsertNodeEnd node = new InsertNodeEnd();
        node.last = new ListNode(1);
        ListNode newNode = new ListNode(2);
        ListNode anotherNode = new ListNode(3);

        //CHAINING THEM
        node.last.next = newNode;
        newNode.next = anotherNode;
        anotherNode.next = node.last;

        node.displayCircular();
        node.insertEnd(100);
        node.displayCircular();
    }
}
