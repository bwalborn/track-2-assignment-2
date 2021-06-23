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


    /**
     * Constructs an array of the given size.
     *
     * @param size Non-negative integer size of the desired array.
     * @throws NegativeArraySizeException if the specified size is
     *                                    negative.
     */
    public CharArray(int size) {
        this.CharArray = new char[size];
        this.size = size;
        this.capacity = size;
    }


    /**
     * Constructs an array of the given size, filled with the provided
     * default value.
     *
     * @param size         Nonnegative integer size of the desired array.
     * @param defaultvalue A default value for the array.
     * @throws NegativeArraySizeException if the specified size is
     *                                    negative.
     */
    public CharArray(int size, char defaultvalue) {
        this.CharArray = new char[size];
        this.value = defaultvalue;
        Arrays.fill(this.CharArray, defaultvalue);
        this.size = size;
        this.capacity = size;
    }


    /**
     * Copy constructor; creates a deep copy of the provided CharArray.
     *
     * @param s The CharArray to be copied.
     */
    public CharArray(CharArray s) {

        this.CharArray = new char[s.size];  // deep copy
        for (int i = 0; i < s.size; i++) {
            this.CharArray[i] = s.CharArray[i];
        }
        this.size = s.size;
        this.capacity = s.size;
        this.value = s.value;
    }

    /**
     * Creates a deep copy of this CharArray.  Implements the
     * Prototype pattern.
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() {
        try {
            CharArray t = (CharArray)super.clone();
            t.capacity = 0;
            return t;
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            return e;
        }
    }

    /**
     * @return The current size of the array.
     */
    public int size() {
        return this.size;
    }

    /**
     * @return The current maximum capacity of the array.
     */
    public int capacity() {
        return this.capacity;
    }

    /**
     * Resizes the array to the requested size.
     * <p>
     * Changes the capacity of this array to hold the requested number of elements.
     * Note the following optimizations/implementation details:
     * <ul>
     *   <li> If the requests size is smaller than the current maximum capacity, new memory
     *   is not allocated.
     *   <li> If the array was constructed with a default value, it is used to populate
     *   uninitialized fields in the array.
     * </ul>
     *
     * @param size Nonnegative requested new size.
     */
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

    /**
     * @param index Nonnegative index of the requested element.
     * @return the element at the requested index.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the
     *                                        current bounds of the array.
     */
    public char get(int index) {
        if(index > this.CharArray.length){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return this.CharArray[index];
        }
    }

    /**
     * Sets the element at the requested index with a provided value.
     *
     * @param index Nonnegative index of the requested element.
     * @param value A provided value.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the
     *                                        current bounds of the array.
     */
    public void set(int index, char value) {
        this.CharArray[index] = value;
    }


  
    public String tString() {
        StringBuilder str = new StringBuilder();
        for(char c: this.CharArray)
            str.append(c);
        
        return str.toString();
    }




    /**
     * Compares this array with another array.
     * <p>
     * This is a requirement of the Comparable interface.  It is used to provide
     * an ordering for CharArray elements.
     *
     * @return a negative value if the provided array is "greater than" this array,
     * zero if the arrays are identical, and a positive value if the
     * provided array is "less than" this array. These arrays should be compred
     * lexicographically.
     */
    @Override
    public int compareTo(CharArray s) {
        int compare = this.tString().compareTo(s.tString());
        if(compare < 0) return -1;
        else if(compare > 0) return 1;
        else return 0;
    }

    /**
     * Check whether the @a index is in bounds or not.
     *
     * @throws ArrayIndexOutOfBoundsException If the requested index
     *                                        is outside the current bounds of the array.
     */
    private void rangeCheck(int index) {

        int min = 0;
        int max = this.size;

        if(!(index > min && index < max)){
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public class CharArrayIterator implements java.util.Iterator<Character> {
        /**
         * Keeps track of how far along the iterator has progressed.
         */
 
        private int currentIndex = 0;

        /**
         * @return true if there are any remaining elements that
         * haven't been iterated through yet; else false.
         */
        @Override
        public boolean hasNext() {
            if(currentIndex < CharArray.this.CharArray.length) return true;

            return false;
        }

        /**
         * @return The next element in the iteration.
         */
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