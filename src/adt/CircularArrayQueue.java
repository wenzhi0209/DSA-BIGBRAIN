
package adt;

public class CircularArrayQueue<T> implements QueueInterface<T> {

  private T[] arr; 
  private int front; //front index
  private int back; //back index
  private int size; //size of circular array
  private static final int DEFAULT_CAPACITY = 1;

  public CircularArrayQueue() {
    this(DEFAULT_CAPACITY);
  }
  
  public CircularArrayQueue(ArrayList<T> player) {
    this(DEFAULT_CAPACITY);
    for(int i=1; i<=player.getLength(); i++){
        enqueue(player.getEntry(i)); 
    }
  }
  
  public CircularArrayQueue(int customCapacity) { 
    arr = (T[]) new Object[customCapacity];      
    front = 0;                           
    back = 0;
    size = 0;
  }

  @Override
  public void enqueue(T newEntry) {
      if(size == arr.length){
          doubleArray();
      }
      arr[back] = newEntry;
      back = (back + 1)%arr.length;
      size++;
  }

  @Override
  public T getFront() {
      
      T temp = null;  
      
      if(size == 0){
          System.out.println("Queue is empty");
      }
      else {
      temp = arr[front];
      }
     
      return temp;
  }

  @Override
  public T dequeue() {
      
      T temp = null;  
      
      if(size == 0){
          System.out.println("Queue is empty");
      }
      else {
      temp = arr[front];
      arr[front] = null;
      front = (front + 1) % arr.length;          
      size--;
      
      }
     
      return temp;
  }

  @Override
  public boolean isEmpty() {
      return size == 0;
  }

  @Override
  public void clear() {
      if(!isEmpty()){
        for(int i = 0; i < size; i++){
            arr[(i+front)%arr.length] = null;
        }
        front = 0;
        back = 0;
        size = 0;
        System.out.println("Queue is cleared!");
      }
      
      
  }

    @Override
    public void displayQueue() {
        if(size==0){
            System.out.println("Queue is empty");
        }
        else
        {
            System.out.println("Diplaying Queue:");
            for(int i = 0; i < size; i++) {
                System.out.print(arr[(i+front)%arr.length] + " ");
            }
        }
        System.out.println("");
    }

    @Override
    public boolean isFull() {
        return size == arr.length;
    }

    public void doubleArray() {
        T[] oldArr = arr;
        arr = (T[]) new Object[2 * oldArr.length];
        for(int i = 0; i < oldArr.length; i++){
            arr[i] = oldArr[(front + i) % oldArr.length];
        }
        
        front = 0;
        back = size;
    }
    
    public int getSize(){
        return size;
    }
}