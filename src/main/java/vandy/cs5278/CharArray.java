/* @author Vanderbilt University, copyright 2019 - All rights reserved */
package vandy.cs5278;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Provides a wrapper facade around primitive char arrays, allowing
 * for dynamic resizing.
 */
public class CharArray implements Comparable<CharArray>,
        Iterable<Character>,
        Cloneable {

    private char[] CharArray; 
    private int size;
    private char value;
    private int capacity;


    public CharArray(int size) {
        this.CharArray = new char[size];
        this.size = size;
        this.capacity = size;
    }


    public CharArray(int size, char defaultvalue) {
        this.CharArray = new char[size];
        this.value = defaultvalue;
        Arrays.fill(this.CharArray, defaultvalue);
        this.size = size;
        this.capacity = size;
    }


    public CharArray(CharArray s) {
        this.CharArray = new char[s.size];  // deep copy
        for (int i = 0; i < s.size; i++) 
            this.CharArray[i] = s.CharArray[i];
        this.size = s.size;
        this.capacity = s.size;
        this.value = s.value;
    }

    
    @Override
    public Object clone() {
        try {
            CharArray t = (CharArray)super.clone();
            t.capacity = 0;
            return t;
        } catch (CloneNotSupportedException e) {
            return e;
        }
    }

    
    public int size() {
        return this.size;
    }

  
    public int capacity() {
        return this.capacity;
    }

    public void resize(int size) {
        if(size > this.size){
            char[] newArray = Arrays.copyOf(this.CharArray, size);

            for(int i = this.CharArray.length; i<size; i++) 
                newArray[i] = value;

            this.CharArray = newArray;

        } else {
            this.CharArray = Arrays.copyOf(this.CharArray, size);
        }
        this.size = size;
    }


    public char get(int index) {
        if(index > this.CharArray.length)
            throw new ArrayIndexOutOfBoundsException();
        else 
            return this.CharArray[index];
    }


    public void set(int index, char value) {
        this.CharArray[index] = value;
    }


    public String tString() {
        StringBuilder str = new StringBuilder();
        for(char c: this.CharArray)
            str.append(c);
        
        return str.toString();
    }


    @Override
    public int compareTo(CharArray s) {
        int compare = this.tString().compareTo(s.tString());
        if(compare < 0) return -1;
        else if(compare > 0) return 1;
        else return 0;
    }


    private void rangeCheck(int index) {
        int min = 0;
        int max = this.size;

        if(!(index > min && index < max))
            throw new ArrayIndexOutOfBoundsException();
    }


    public class CharArrayIterator implements java.util.Iterator<Character> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if(currentIndex < CharArray.this.CharArray.length) return true;

            return false;
        }

        @Override
        public Character next() {
            if(!hasNext()){
                throw new ArrayIndexOutOfBoundsException();
            } 
            return CharArray[currentIndex++];
        }
    }


    public Iterator<Character> iterator() {
        return new CharArrayIterator();
    }
}