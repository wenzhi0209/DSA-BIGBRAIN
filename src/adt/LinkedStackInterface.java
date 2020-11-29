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
public interface LinkedStackInterface<T> {
    //BASIC FUNCTION
    boolean push(T newItem);
    boolean pushAll(T[] newItems);
    T pop();
    T getTop();
    int size();
    boolean isEmpty();
    boolean clear();
    
    //ADVANCED FUNCTION
    boolean contain(T anItem);
    String posOfElement(T anItem);
    T elementAtPos(int position);
    boolean combine(LinkedStackInterface secondStack);
    boolean equals(LinkedStackInterface secondStack);
    boolean copy(LinkedStackInterface secondStack);
    boolean copyPart(LinkedStackInterface secondStack,int num);
    boolean reverse();
    boolean toArray(T[] array);
    
    
    
    
    
    
    
}
