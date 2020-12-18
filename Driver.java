package LinkedLists;

public class Driver {
    public static void main(String[] args) {
    	/* Timing tests: addFirst, addLast, removeFirst, and removeLast */
    	System.out.println("Timing Tests:");
        addFirst();
        addLast();
        removeFirst();
        removeLast();
        System.out.println();

        /* All other tests */
        System.out.println("Other Tests:");
       	addList(); // Does add(List) produce correct results? That is, is other at the end? Is the size correct?
       	remove(); // Prove the remove method works with negative indices.
       	clear(); // Use two different methods to prove that clear() works correctly. 
       	sort(); // Show that the sort method performs correctly
       	set(); // Show that the set method works correctly (use the count() method to do so).
       	reverse(); // Reverse an empty list.
    }

    // TIMED TESTS
    public static void addFirst() {
    	System.out.println("--> addFirst");
        List<Integer> integers = new SinglyLinkedList<>();
        List<String> strings = new SinglyLinkedList<>();
        long start, finish, elapsedTime;

        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.print();
        start = System.nanoTime();
        integers.addFirst(0);
        finish = System.nanoTime();
        integers.print();
        elapsedTime = finish-start;
        System.out.println("Elapsed time: " + elapsedTime + "ns");

        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.print();
        start = System.nanoTime();
        strings.addFirst("zzz");
        finish = System.nanoTime();
        strings.print();
        elapsedTime = finish-start;
        System.out.println("Elapsed time: " + elapsedTime + "ns");
    }
    public static void addLast() {
    	System.out.println("--> addLast");
        List<Integer> integers = new SinglyLinkedList<>();
        List<String> strings = new SinglyLinkedList<>();
        long start, finish, elapsedTime;

        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.print();
        start = System.nanoTime();
        integers.addLast(0);
        finish = System.nanoTime();
   		elapsedTime = finish-start;
        integers.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");
        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.print();
        start = System.nanoTime();
        strings.addLast("zzz");
        finish = System.nanoTime();
        elapsedTime = finish-start;
        strings.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");
    }
    public static void removeFirst() {
    	System.out.println("--> removeFirst");
        List<Integer> integers = new SinglyLinkedList<>();
        List<String> strings = new SinglyLinkedList<>();
        long start, finish, elapsedTime;

        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.print();
        start = System.nanoTime();
        integers.remove(0);
        finish = System.nanoTime();
       	elapsedTime = finish-start;
        integers.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");

        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.print();
        start = System.nanoTime();
        strings.remove(0);
        finish = System.nanoTime();
        elapsedTime = finish-start;
        strings.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");
    }
    public static void removeLast() {
    	System.out.println("--> removeLast");
        List<Integer> integers = new SinglyLinkedList<>();
        List<String> strings = new SinglyLinkedList<>();
        long start, finish, elapsedTime;

        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.print();
        start = System.nanoTime();
        integers.remove(-1);
        finish = System.nanoTime();
        elapsedTime = finish-start;
        integers.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");

        strings.add("abc");
        strings.add("def");
        strings.add("ghi");
        strings.print();
        start = System.nanoTime();
        strings.remove(-1);
        finish = System.nanoTime();
        elapsedTime = finish-start;
        strings.print();
        System.out.println("Elapsed time: " + elapsedTime + "ns");
    }

    // ALL OTHER TESTS
    public static void addList() {
    	// Testing: add(List<E>)
        System.out.println("Testing: add(List<E>)");
        List<Integer> first = new SinglyLinkedList<Integer>();
        List<Integer> second = new SinglyLinkedList<Integer>();

        first.add(1);
        second.add(2);
        second.add(3);
        System.out.print("First list: ");
        first.print();
        System.out.print("Second list: ");
        second.print();
        first.add(second);
        System.out.print("Combined list: ");
        first.print();
        System.out.println();
    }
    public static void remove() {
    	// Testing: remove with negative indices
        System.out.println("Testing: negative indices (-2)");
        List<Integer> list = new SinglyLinkedList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.print("Before: ");
        list.print();
        list.remove(-2);
        System.out.print("After: ");
        list.print();
        System.out.println();
    }
    public static void clear() {
    	// Testing: clear
        System.out.println("Testing: clear()");
        List<Integer> list2 = new SinglyLinkedList<Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        System.out.print("Before: ");
        list2.print();
        list2.clear();
        System.out.print("After: ");
        list2.print();
        System.out.println();
    }
    public static void sort() {
    	// Testing: sort
        System.out.println("Testing: sort()");
        List<Integer> list3 = new SinglyLinkedList<Integer>();
        list3.add(0);
        list3.add(11);
        list3.add(4);
        list3.add(2);
        list3.add(9);
        list3.add(1);
        System.out.print("Before: ");
        list3.print();
        list3.sort();
        System.out.print("After: ");
        list3.print();
        System.out.println();
    }
    public static void set() {
    	// Testing: set
        System.out.println("Testing: set(1, 4)");
        List<Integer> list4 = new SinglyLinkedList<Integer>();
        list4.add(0);
        list4.add(11);
        list4.add(4);
        list4.add(2);
        list4.add(9);
        list4.add(1);
        System.out.print("Before: ");
        list4.print();
        System.out.println("Count(11): " + list4.count(11));
        System.out.println("Count(4): " + list4.count(4));
        list4.set(1, 4);
        System.out.print("After: ");
        list4.print();
        System.out.println("Count(11): " + list4.count(11));
        System.out.println("Count(4): " + list4.count(4));
        System.out.println();
    }
    public static void reverse() {
    	// Testing: reverse()
        System.out.println("Testing: reverse()");
        List<Integer> list5 = new SinglyLinkedList<Integer>();
        list5.reverse();
    }
}