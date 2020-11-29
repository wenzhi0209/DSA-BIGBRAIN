/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author SheaJing
 * @param <T>
 */

public interface PriorityQueueInterface<T> { 
    
    /*get array[0] item*/
    public T peek();
    /*get and remove array[0] item*/
    public T poll();
    public boolean add(T element);
    public T remove(T element);
    public boolean contains(T element);
    public int getLength(); 
    public boolean isEmpty();
    public boolean isFull();
    public void clear();
    public String toString();
}
