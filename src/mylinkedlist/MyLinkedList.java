package mylinkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class Node {

    int number;
    Node next;

    public Node(int number) {
        this.number = number;
        this.next = next;
    }

}

public class MyLinkedList {

    Node first;
    
    int length=0;

    public MyLinkedList() {
        first = null;
        
    }

    public void addFirst(int x) {

        if (first == null) {
            first = new Node(x);
        } else {
            Node n = new Node(x);
            n.next = first;
            first = n;
        }
        length++;
    }

    //link-->next
    //p-->number
    public void addLast(int x) {

        Node n = new Node(x);
        Node p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = n;
        length++;

//        if (n == null) {
//            first = n;
//            last = n;
//        } else {
//            Node p = first;
//            while (p.next != null) {
//                p = p.next;
//            }
//            p.next = n;
//        }
    }

    public void insert(int x, int index) {
        Node n=new Node(x);
        Node p=first;
        for (int i = 0; i < index-1; i++) {
            p=p.next;
        }
        Node p2=p.next;
        p.next=n;
        n.next=p2;



//        Node temp = first;
//        while (temp.next != null) {
//            if (temp.number == index) {
//                n.next = temp.next;
//                temp.next = n;
//                break;
//            } else {
//                temp = temp.next;
//            }
//        }
//        if (temp == last && temp.number == index) {
//            last.next = n;
//            last = n;
//        }
    }

    public void removeFirst() {
        first = first.next;        
        length--;
    }

    public void removeLast() {
        Node temp = first;
        while (temp.next.next != null) {            
            temp = temp.next;
        }
        temp.next=null;
        length--;
    }

    public void removeAt(int index) {
        Node p=first;
        Node p2,p3;
        
        for (int i = 0; i < index-1; i++) {
            p=p.next;
        }
        p2=p;
        p3=p.next.next;
        p2.next=p3;
        length--;
    }

    public void clear() {
        first = null;
    }

    public int get(int index)  {
        if (index>=length) {
            System.err.println("Girilen index uzunluktan büyüktür.");
            //throw new Exception("Girilen index uzunluktan büyüktür.");
            return -1;
        }
        Node current = first;
        int cnt = 0;

        while (current != null) {
            if (cnt == index) {
                return current.number;
            }
            cnt++;
            current = current.next;
        }
        assert (false);
        return 0;
    }
    
    public int size(){
        return length;
    }

    public void print() {
        //Node current will point to head  
        Node current = first;
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        String s="";
        while (current != null) {
            //Print each node by incrementing pointer  
            s+=current.number + ",";
            current = current.next;
        }
        s=s.substring(0, s.length()-1);
        System.out.println(s);
    }

//    String listit(){
//        Node res=first;
//        String list="";
//        while(res!=null){
//            list=list+res.number+"-->";
//            res=res.next;
//        }
//        return list;
//    }
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addFirst(8);
        list.addFirst(9);
        list.addLast(1);
        list.insert(5, 1);
        list.addLast(2);        
        list.addFirst(50);
        list.removeFirst();
        list.removeLast();
        list.removeAt(2);
        list.clear();
//        Node x = new Node(4);
//        list.addFirst(x);
//        x = new Node(2);
//        list.addFirst(x);
//        x = new Node(5);
//        list.addFirst(x);
//        x = new Node(6);
//        list.addFirst(x);
//        x = new Node(1);
//        list.addFirst(x);
//        x = new Node(9);
//        list.insert(x, 0);
        //list.addFirst(x);
        //list.addLast(x);
        //list.removeFirst();
        System.out.println("Çıkış: ");
        list.print();        
        //System.out.println("istenilen indexteki sayı: " + list.get(6));
        
        
        

    }

}
