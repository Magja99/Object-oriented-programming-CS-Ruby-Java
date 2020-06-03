using System;
using System.Collections.Generic;

namespace Lista {

    public class Lista<T> {
       
        Node first;
        Node last;
        int size = 0;
        public bool Empty() {
            if(size == 0) 
                return true;
            else 
                return false;
        }
        public T Last() { 
            if(size == 0) 
                Console.WriteLine("Lista jest Pusta!");
            return last.val;

        } 
        public T First() { 
            if(size == 0) 
                Console.WriteLine("Lista jest Pusta!");
            return first.val;
        } 

        public void Push_Front(T value) {
            Node NewFirst = new Node(value, null, first);
            first = NewFirst;
            size ++;
            
            if(size == 1)
                last = first;
            else
                first.next.prev = first;
        }

         public void Push_Back(T value) {
            Node NewLast = new Node(value, last, null);
            last = NewLast;
            size ++;
            
            if(size == 1)
                first = last;
            else
                last.prev.next = last;
        }

        public Node PopBack() {
            if(size == 0) Console.WriteLine("Lista jest Pusta!");

            Node temp = last;
            last = last.prev;
            size--;
            if(size > 0)
                last.next = null;
            return temp;
        }

        public Node PopFront() {
            if(size == 0) Console.WriteLine("Lista jest Pusta!");

            Node temp = first;
            first = first.next;
            size--;
            if(size > 0)
                first.prev = null;
            return temp;
        }
        public class Node {

            public T val;
            public Node prev;
            public Node next;

            public Node(T value, Node p, Node n) {
                this.val = value;
                this.prev = p;
                this.next = n;
            }
        }
    }
}