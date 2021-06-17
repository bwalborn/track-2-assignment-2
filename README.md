# CharArray

### Overview of the CharArray Assignment

The purpose of this assignment is to give you experience using your development environment to develop a simple Java CharArray class.  A CharArray is an abstract data type (ADT) with operations such as get(), set(), and size(). Your task
    is to implement an CharArray ADT in Java.  This array will be
    different from Java built-in arrays since it can be resized.
 
You are also going to have to implement the following capabilities on your class:  
* Implement the requirements of the <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html">Iterable</a> interface.

As much as possible, you should avoid using loops in this assignment.  In our solution, we only needed to use an explicit looping construct once.

The following resources may be helpful in completing this assignment:

* [java.utils.Arrays documentation](http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html)
* [The Oracle Java Tutorial](http://docs.oracle.com/javase/tutorial/)

### Skeleton Code

This repository contains all of the starter code you need to get going.  Look carefully over the provided, especially at the TODO comments.
Also look very closely at the automated tests that are executed against your class.  Your class must successfully pass of the provided tests without having to alter the tests. 

### Read the Tests

To correctly implement this assignment, you will need to run and understand the tests. There are many edge cases where the expected behavior is captured in the test and not in the comments. If you fail a test, look carefully at the test to understand why. If you run into trouble, post on the class discussion forum.

### Capacity vs. Size

An important concept in this application is capacity vs. size. The goal of this assignment is to create an array that can be dynamically resized as needed. The code below helps to explain what capacity and size are:

  - Size - this is the "logical" size that your CharArray has been set to. 
  - Capacity - this is the "actual" size of the underlying array
  
The CharArray contains an underlying Java primitive char[] array. The underlying char[] may be bigger than the "size" that the CharArray is currently set to. This concept is important when resizing the CharArray:

```java
CharArray arr = new CharArray(10);

System.out.println(arr.size()); // this will print 10
System.out.println(arr.capacity()); // this will print 10

arr.resize(5);

System.out.println(arr.size()); // this will print 5
System.out.println(arr.capacity()); // this will still print 10

arr.resize(15);

System.out.println(arr.size()); // this will print 15
System.out.println(arr.capacity()); // this will print 15

```

### Default Value

Whenever you change the size of the array, you need to fill in any newly initialized array elements with the default value. If you resize the array to be larger than the old size, the new array elements that are created by the resizing need to be set to the default value:

```java
CharArray arr = new CharArray(5,'j');
arr.resize(10);
System.out.println(arr.get("arr[9] = " + arr[9]); // Should print "arr[9] = j"

arr.set(9,'b');
System.out.println(arr.get("arr[9] = " + arr[9]); // Should print "arr[9] = b"

// Notice this case! If we resize the array to be smaller, the old elements beyond
// the original size need to be reset to the default value
arr.resize(5);
arr.resize(10);
System.out.println(arr.get("arr[9] = " + arr[9]); // Should print "arr[9] = j"
```

### Copy Constructor

When your copy constructor is called, it should ONLY copy the elements in the CharArray less than size. It should not copy the full, potentially unused, capacity of the underlying array. This example illustrates the expected behavior:

```java
CharArray arr = new CharArray(10,'j');
arr.resize(1);

CharArray theCopy = new CharArray(arr);

System.out.println(arr.size()); // Should print 1
System.out.println(arr.capacity()); // Should print 10
System.out.println(theCopy.size()); // Should print 1
System.out.println(theCopy.capacity()); // Should print 1
```

### Lexicographical Comparison

Here are the steps for lexicographical comparison:

1. Take two CharArrays, a1 and a2
2. For each position i that is valid in a1 and a2, if a1[i] != a2[i], then return a1[i] - a2[i]
3. If all valid positions match, then return a1.size - a2.size

A position is "valid" if it would pass the "rangeCheck" in a1 and a2. You should be able to compare CharArrays that aren't the same size without throwing an exception.

### Deep Copy

This is what is meant by a "deep copy" in this assignment. There are utility methods in Java that can do this for you, but you can also just write it out by hand.

```java

int[] a1 = ...; // some array
int[] deepCopy = new int[a1.length];

for(int i = 0; i < a1.length; i++){
  deepCopy = a1[i];
}

```

### Concluding Remarks

When you are confused, rather than struggling in silence, please post to the class discussion forum.

If you find it extremely hard to complete this assignment, please email the instructors ASAP to discuss.

### REMINDERS:

* Only alter project files that you are explicitly permitted to.

* For full credit, your program must compile and pass the tests successfully.
 
