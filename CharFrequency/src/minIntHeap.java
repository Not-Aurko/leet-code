import java.util.Arrays;

/**
 * @author Aurko
 * Coding excercise to help me better understand Heap implementation
 *
 */
public class minIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild (int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild (int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild(int index) { return items[getRightChildIndex(index)]; }
    private int parent(int index) { return items[getParentIndex(index)]; }

    private void swap( int indexOne, int indexTwo ) {
        int temp = items[indexOne];
        items[indexOne] = items [indexTwo];
        items[indexTwo] = temp;
    }

    /**
     * Basically An ArrayList's logic
     */
    private void ensureExtraCapacity() {
        if ( size == capacity ) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * If array is empty return an exception since nothing is there
     *
     * @return first element in the array(the most minimum element in the array)
     */
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    /**
     *  If the array is empty return an exception
     *  Extract minimum element and remove it from the array
     *      get the value of the minimum
     *      replace first element in array with the last element in array
     *      shrink size of array
     *      Find the correct position of the current root by heapifying it down the array
     * @return
     */
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        heapifyDown();
        return item;
    }

    /**
     * Add an element to the Heap
     *      ensure there is enough space in the array
     *      add Element to the last spot in the array
     *      increase the size
     *      heapify up to find correct spot
     * @param item
     */
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    /**
     * Start with the last element added
     *      parse up the heap so long as a parent exists and the parent is greater than child
     */
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index] ) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }

    }

    /**
     * Start at the root
     *      parse down the heap so long as the node has children
     *          set the smallerChildIndex to the smaller of the left and right child
     *          if there is a right child and it is smaller than the left child set that to the new right child
     *      if the node is the smallest of the two children then the node is in the correct spot
     *          otherwise, swap the node with the smallest child and set the new index and proceed with the loop.
     */
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }

    }
}
