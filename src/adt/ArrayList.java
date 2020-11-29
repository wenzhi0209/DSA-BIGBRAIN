/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;
import client.Game;
import java.io.Serializable;


/**
 *
 * @author Winnie wong
 */
public class ArrayList<T> implements ListInterface<T>, Serializable{

  private T[] arr;
  private int length;
  private static final int DEFAULT_CAPACITY = 10;

  public ArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayList(int initialCapacity) {
    length = 0;
    arr = (T[]) new Object[initialCapacity];
  }

  @Override
  public boolean add(T newEntry) {
    if(isArrayFull()){
	doubleSize();
     }
     arr[length] = newEntry;
     length++;
     return true;
  }


  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        arr[newPosition - 1] = newEntry;
        length++;
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T remove(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = arr[givenPosition - 1];

      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    }

    return result;
  }

  public void clear() {
    length = 0;
  }

  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      arr[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      result = arr[givenPosition - 1];
    }

    return result;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(arr[index])) {
        found = true;
      }
    }

    return found;
  }

  public int getLength() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += arr[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return length == arr.length;
  }


  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      arr[index + 1] = arr[index];
    }
  }
  
  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      arr[index] = arr[index + 1];
    }
  }
  
  private void doubleSize(){
     T[] temp = (T[]) new Object[arr.length * 2];

	for(int i = 0; i < length; i++){
		temp[i] = arr[i];
     }
     arr = temp; 
}
  
 
}
