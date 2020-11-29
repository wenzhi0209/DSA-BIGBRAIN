/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.io.Serializable;

/**
 *
 * @author Chin Yew
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T>, Serializable {

    private T[] arrayScore;
    private int length;
    public static final int DEFAULT_CAPACITY = 100;

    public SortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayList(int initialCapacity) {
        length = 0;
        arrayScore = (T[]) new Comparable[initialCapacity];
    }

  

    public boolean add(T newEntry) {
        int i = 0;
        while (i < length && newEntry.compareTo(arrayScore[i]) < 0) { //newEntry is smaller
            i++;
        }
        makeRoom(i + 1);
        arrayScore[i] = newEntry;
        length++;
        return true;
    }

    public boolean remove(T anEntry) { //Remove player from score list
        int i = 0;
        if (!isEmpty() && contains(anEntry)) {
            while (i < length && !(arrayScore[i].equals(anEntry))) {
                i++;
            }
            removeGap(i + 1);
            length--;
            return true;

        }
        return false;

    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < length); index++) {
            if (anEntry.equals(arrayScore[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public int compareTo(T anEntry) { //Compare to Update Score
        int value = 0;
        for (int index = 0; index < length; index++) {
            if (arrayScore[index].equals(anEntry)) {
                if (anEntry.compareTo(arrayScore[index]) > 0) {
                    value = -1;
                }
            }
        }
        return value;
    }

    public void clear() {
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == arrayScore.length;
    }

    public String toString(int index) {
        String outputStr = "";

        outputStr += arrayScore[index];
        return outputStr;
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = length - 1;

        for (int i = lastIndex; i >= newIndex; i--) {
            arrayScore[i + 1] = arrayScore[i];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = length - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            arrayScore[index] = arrayScore[index + 1];
        }
    }

}
