/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within. */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = new IntNode(5, null);
    }

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }


    /**
     * Creates an SLList with the given array of integers.
     */
    public SLList(int[] arr) {
        sentinel = new IntNode(63, null);
        size = 0;
        for (int i : arr) {
            addLast(i);
        }
    }
    /*
    public SLList(int[] x) {
        sentinel = new IntNode(63, null);
        size = x.length;
        IntNode p = sentinel;
        for (int value : x) {
            p.next = new IntNode(value, null);
            p = p.next;
        }
    }
     */

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /**
     * Delete the first item in the list.
     */
    public void deleteFirst() {
        if (sentinel.next != null) {
            sentinel.next = sentinel.next.next;
            size -= 1;
        }
    }


    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * every two same adjacent element will be added together to become one element
     */
    public void addAdjacent() {
        IntNode obj = sentinel.next;
        while(obj != null && obj.next != null){
            if (obj.item == obj.next.item) {
                obj.item += obj.next.item;
                obj.next = obj.next.next;
                size -= 1;
            } else {
                obj = obj.next;
            }
        }
    }

    /**
     * every time add a value and “square” the list.
     */
    public void sq(int x) {
        IntNode obj = sentinel.next;
        while(obj != null) {
            obj.next = new IntNode(obj.item * obj.item, obj.next);
            obj = obj.next.next;
            size ++;
        }
        addLast(x);
    }


public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addFirst(77);
        L.addLast(20);
        L.addFirst(5);
        L.addFirst(777);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        L.deleteFirst();
        System.out.println(L.size());
        System.out.println(L.getFirst());
        int[] intArray = {0, 1, 2, 3, 4, 5};
        SLList M = new SLList(intArray);
        System.out.println(M.size());
        M.deleteFirst();
        M.deleteFirst();
        System.out.println(M.getFirst());
        System.out.println(M.size());

        int[] a = {1,1,2,4,8,9};
        SLList A = new SLList(a);
        A.addAdjacent();
        System.out.println(A.getFirst());
        System.out.println(A.size());
        A.sq(20);
        System.out.println(A.size());
        A.deleteFirst();
        System.out.println(A.getFirst());
        A.deleteFirst();
        System.out.println(A.getFirst());
        A.deleteFirst();
        System.out.println(A.getFirst());
        A.deleteFirst();
        System.out.println(A.size());

    }


}