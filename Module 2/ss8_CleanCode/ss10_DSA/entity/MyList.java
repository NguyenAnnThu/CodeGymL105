package ss10_DSA.entity;

import static com.sun.tools.javac.util.ArrayUtils.ensureCapacity;

public class MyList<E> {
    private int size =0;
    private static final int DEFAULT_CAPACITY =10;
    private Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void add(int index, E element){
        if(index < 0 || index >size){
            throw new IndexOutOfBoundsException("Index: "+index+", size: "+size);
        }
        ensureCapacity(size + 1);
        for(int i=size;i>index; i--){
            elements[i]=elements[i-1];
        }
        elements[index]=element;
        size++;

    }
    public boolean add(E e){
        ensureCapacity(size+1);
        elements[size++]=e;
        return true;
    }


    @SuppressWarnings("unchecked")
    public E remove(int index){
        if(index <0 || index >= size){
            throw  new IndexOutOfBoundsException("Index: "+ index+", size: "+ size);
        }
        E oldValue = (E) elements[index];
        for(int i = index; i<size -1; i++){
            elements[i]=elements[i+1];
        }
        elements[--size]=null;
        return oldValue;
    }
    public int size(){
        return size;
    }
    @SuppressWarnings("unchecked")
    public E get (int i){
        if(i<0 || i>= size){
            throw new IndexOutOfBoundsException("Index: "+ i+", Size: "+size);
        }
        return (E) elements[i];
    }
    public boolean contains(E o){
        return indexOf(o)>=0;
    }

    public int indexOf(E o) {
        if(o == null){
            for(int i=0; i<size;i++){
                if(elements[i]==null)
                    return i;
            }
        }else{
            for(int i=0;i<size;i++){
                if(o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int i) {
        if(i>elements.length){
            int newCapacity = Math.max(i,elements.length*2);
            Object[] newElements= new Object[newCapacity];
            System.arraycopy(elements,0,newElements,0,size);
            elements=newElements;
        }
    }
    @SuppressWarnings("unchecked")
    public MyList<E> clone(){
        MyList<E> newList= new MyList<>(elements.length);
        for (int i=0;i<size;i++){
            newList.add((E) elements[i]);
        }
        return newList;
    }
    public void clear(){
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size=0;
    }

}
