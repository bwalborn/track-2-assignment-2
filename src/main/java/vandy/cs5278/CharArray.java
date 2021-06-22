/* @author Vanderbilt University, copyright 2019 - All rights reserved */
package vandy.cs5278;

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Provides a wrapper facade around primitive char arrays, allowing
 * for dynamic resizing.
 */
public class CharArray implements Comparable<CharArray>,
        Iterable<Character>,
        Cloneable {
    /**
     * The underlying array.
     */
    // TODO - you fill in here
    private char[] CharArray; 
    // private ArrayList CharArray;

    /**
     * The current size of the array.
     */
    // TODO - you fill in here
    private int size;

    /**
     * Default value for elements in the array.
     */
    // TODO - you fill in here
    private char value;

    // private CharArray deepCopy;



    /**
     * Constructs an array of the given size.
     *
     * @param size Non-negative integer size of the desired array.
     * @throws NegativeArraySizeException if the specified size is
     *                                    negative.
     */
    public CharArray(int size) {
        // TODO - you fill in here
        // this.size = size;
        this.CharArray = new char[size];
        this.size = size;
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
        // TODO - you fill in here
        // this.value = defaultvalue;
        // this.size = size;
        this.CharArray = new char[size];
        this.value = defaultvalue;
        Arrays.fill(this.CharArray, defaultvalue);
    }

    /**
     * Copy constructor; creates a deep copy of the provided CharArray.
     *
     * @param s The CharArray to be copied.
     */
    public CharArray(CharArray s) {
        // TODO - you fill in here
        // this.CharArray = s.CharArray;  // shallow copy

        this.CharArray = new char[s.size];  // deep copy
        for (int i = 0; i < s.size; i++) {
            this.CharArray[i] = s.CharArray[i];
        }
    }

    /**
     * Creates a deep copy of this CharArray.  Implements the
     * Prototype pattern.
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO - you fill in here (replace return null with right implementation).

        return super.clone();
        // return null;
    }

    /**
     * @return The current size of the array.
     */
    public int size() {
        // TODO - you fill in here (replace return 0 with right implementation).
        // return 0;
        return size;
    }

    /**
     * @return The current maximum capacity of the array.
     */
    public int capacity() {
        // TODO - you fill in here (replace return 0 with right implementation).
        return CharArray.length;
        // return 0;
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
        // TODO - you fill in here
        if(size > this.size){
            // char[] temp = new char[size];
            int diff = size - this.size;
            char[] tempArray = new char[diff];

            Arrays.fill(tempArray, value);
            

            
            char[] result = new char[size];
            // Arrays.fill(temp, defaultvalue);
            // this.CharArray = new char[size];

            System.arraycopy(this.CharArray, 0, result, 0, this.size);
            System.arraycopy(tempArray, 0, result, this.size, size);


            this.CharArray = result;

            // char[] temp = Arrays.copyOf(this.CharArray, size);
            // this.CharArray = Stream.concat(Arrays.stream(temp2), Arrays.stream(temp)).toArray(char[]::new);



            this.size = size;
        }
        if(size < this.size){

            int diff = this.size - size;

            char[] tempArray = new char[diff];

            Arrays.fill(tempArray, value);
            
            char[] result = new char[size];
  
            System.arraycopy(this.CharArray, 0, result, 0, this.size);
            System.arraycopy(tempArray, 0, result, this.size, size);


            this.CharArray = result;

            this.size = size;
        }
    }

    /**
     * @param index Nonnegative index of the requested element.
     * @return the element at the requested index.
     * @throws ArrayIndexOutOfBoundsException If the requested index is outside the
     *                                        current bounds of the array.
     */
    public char get(int index) {
        try {
            return CharArray[index];
        } catch (Exception e) {
            throw e;
        }
        // return '\0';
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
        // TODO - you fill in here (replace return 0 with right implementation).
        // String str = new String(this.CharArray);
        // String str2 = new String(s);
        // str str2 = new StringBuilder();
        // String v = s.toString();

        // if(s.size > size()) return -1;

        // for(int i = 0; i<this.CharArray.length; i++){
        //     str2.append(s.get(i));
        // }

        // str2.toString();
        int compare = this.tString().compareTo(s.tString());

        // if(compare == 0) return 0;
        if(compare < 0){
            return -1;
        } 
        else if(compare > 0){
            return 1;
        } else {
            return 0;
        }



        // return 0;

        // if(Arrays.deepEquals(s, this)){
        //     return 0;
        // }

        // if(s.size < this.CharArray.length){
        //     return 1;
        // }
        // // if (s.CharArray.length > this.CharArray.length){
        // if (s.size > this.CharArray.length){
        //     return -1;
        // }
        // return 100;
        // else {
        //     for(int i = 0; i<this.CharArray.length; i++){
        //         if(Character.compare(s.CharArray[i], this.CharArray[i]) != 0){

        //         }
        //     }
        // }
        // return 0;
        // return size;
    }

    /**
     * Check whether the @a index is in bounds or not.
     *
     * @throws ArrayIndexOutOfBoundsException If the requested index
     *                                        is outside the current bounds of the array.
     */
    private void rangeCheck(int index) {
        // TODO - you fill in here
    }

    /**
     * Define an Iterator over the CharArray.
     */
    public class CharArrayIterator
            implements java.util.Iterator<Character> {
        /**
         * Keeps track of how far along the iterator has progressed.
         */
        // TODO - you fill in here
        int foo;

        /**
         * @return true if there are any remaining elements that
         * haven't been iterated through yet; else false.
         */
        @Override
        public boolean hasNext() {
            // TODO - you fill in here (replace return false with right implementation)
            return false;
        }

        /**
         * @return The next element in the iteration.
         */
        @Override
        public Character next() {
            // TODO - you fill in here (replace return '\0' with right implementation)
            return '\0';
        }
    }

    /**
     * Factory method that returns an Iterator.
     */
    public Iterator<Character> iterator() {
        // TODO - you fill in here (replace return null with right implementation)
        return null;
    }
}
