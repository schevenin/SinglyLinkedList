package LinkedLists;

public interface List<E> {
    // ACCESS METHODS
    int size(); // Returns the current number of items stored in the data structure.
    int count(E target); // Returns the number of instances equal to the target value contained in the data structure. Valid return values: 0 -> size()
    boolean isEmpty(); // Returns true only if there is nothing in the list.
    E get(int index); // Returns the element stored at the specified list index (0=front, -1=rear)

    // UPDATE METHODS
    boolean add(E datum); // Appends the datum to the END of the list.
    boolean add(List<E> other); // Appends every datum, in order, in the other list to the rear of this list.
    boolean addFirst(E datum); // Appends the datum to the FRONT of the list.
    boolean addLast(E datum); // Appends the datum to the END of the list.
    E set(int index, E value); // Mutates the value stored at the specified list index. This function returns the previous value stored at that position.
    E remove(int index); // Removes the item stored at the specified index from the list. (0=front, -1=rear).
    void reverse(); // Reverses the list's direction. This changes the list.
    void sort(); // Places the list in its natural order. Java may cast to type Comparable. This changes the list.
    void clear(); // Resets the list to an empty state. It does not need to override the existing list contents.

    // HELPER METHODS
    void print(); // Prints out list
}