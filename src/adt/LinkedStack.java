/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author wenzh
 * @param <T>
 */
public class LinkedStack<T> implements LinkedStackInterface<T> {

    private Node top;
    private int size;
    private Node bottom;

    public LinkedStack() {
        top = null;
        size = 0;
        bottom = null;
    }

    @Override
    public boolean push(T newItem) {
        if (size == 0) {
            top = new Node(newItem);
            size++;
            bottom = top;
            return true;
        } else {
            Node temp = new Node(newItem);
            temp.next = top;
            top = temp;
            size++;
            return true;
        }
    }

    @Override
    public boolean pushAll(T[] newItems) {
        //if current stack is empty
        if (size == 0) {
            //assign first element
            top = new Node(newItems[0]);
            size++;
            bottom = top;
            //then for loop start from 1
            for (int i = 1; i < newItems.length; i++) {
                Node temp = new Node(newItems[i]);
                temp.next = top;
                top = temp;
                size++;
            }
            return true;
        } //if current stack have somethings
        else {
            for (T newItem : newItems) {
                Node temp = new Node(newItem);
                temp.next = top;
                top = temp;
                size++;
            }
            return true;
        }

    }

    @Override
    public T pop() {
        if (size > 1) {
            T data = top.data;
            top = top.next;
            size--;
            return data;
        } else if (size == 1) {
            T data = top.data;
            top = top.next;
            bottom = top;
            size--;
            return data;
        }
        return null;
    }

    @Override
    public T getTop() {
        T data = top.data;
        return data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size != 0;
    }

    @Override
    public boolean clear() {
        top = null;
        bottom = null;
        size = 0;

        return true;
    }

    @Override
    public boolean contain(T anItem) {
        for (Node temp = top; temp != null; temp = temp.next) {
            if (temp.data.equals(anItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean combine(LinkedStackInterface secondStack) {
        LinkedStack stackB = (LinkedStack) secondStack;
        LinkedStack temp=new LinkedStack();
        
        temp.copy(stackB);
        temp.bottom.next=this.top;
        this.top=temp.top;
        this.size=this.size+temp.size;
        
        temp=null;
        return true;
       
    }

    @Override
    public String posOfElement(T anItem) {
        String str = "";
        int i = 1;
        for (Node temp = top; temp != null; temp = temp.next) {
            if (temp.data == anItem) {
                str += i + " ";
            }
            i++;
        }
        return str;
    }

    @Override
    public T elementAtPos(int position) {
        int i = 1;
        for (Node temp = top; temp != null; temp = temp.next) {
            if (i == position) {
                return temp.data;
            }
            i++;
        }
        return null;
    }

    @Override
    public boolean equals(LinkedStackInterface secondStack) {
        LinkedStack stackB = (LinkedStack) secondStack;
        Node tempA = this.top;
        Node tempB = stackB.top;

        if (this.size != stackB.size) {
            return false;
        }
        while (tempA != null) {
            if (!tempA.data.equals(tempB.data)) {
                
                return false;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return true;
    }

    @Override
    public boolean copy(LinkedStackInterface secondStack) {
        LinkedStack stackB = (LinkedStack) secondStack;
        clear();
        for (Node temp = stackB.top; temp != null; temp = temp.next) {
            push(temp.data);
        }
        this.reverse();
        return true;
    }

    @Override
    public boolean copyPart(LinkedStackInterface secondStack, int num) {
        LinkedStack stackB = (LinkedStack) secondStack;
        clear();
        int i = 0;
        for (Node temp = stackB.top; temp != null && i != num; temp = temp.next) {
            push(temp.data);
            i++;
        }
        this.reverse();
        return true;
    }

    
//    public T[] toArray() {
//        T[] itemArr = (T[]) new Object[size];
//        int i = 0;
//        for (Node temp = top; temp != null; temp = temp.next) {
//            itemArr[i] = temp.data;
//            i++;
//        }
//        return itemArr;
//    }
    @Override
    public boolean toArray(T[] array)
    {
        int length=array.length;
        array=(T[]) new Object[length];
        int i = 0;
        for (Node temp = top; temp != null; temp = temp.next) {
            array[i] = temp.data;
            i++;
        }
        return true;
    }
    @Override
    public String toString() {
        String str = "";
        for (Node temp = top; temp != null; temp = temp.next) {
            str += temp.data.toString() + " ";
        }
        return str;
    }

    private class Node {

        T data;
        Node next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
    
    @Override
     public boolean reverse() {
        LinkedStack reverseStack = new LinkedStack();
        for (Node temp = top; temp != null; temp = temp.next) {
            reverseStack.push(temp.data);
        }
        this.top = reverseStack.top;
        this.bottom= reverseStack.bottom;
        return true;
    }

}
