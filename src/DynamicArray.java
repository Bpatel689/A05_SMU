
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Bhavya Patel (A00488907)
 * @param <T>
 */
public class DynamicArray<T> implements DynamicCollection<T> {

    private T[] underLyingArray;
    private int size;

    public DynamicArray() {
        this.underLyingArray = (T[]) new Object[8];
        this.size = 0;

    }

    /**
     * adds a new element to the collection
     *
     * @param data: the new element to add
     */
    @Override
    public void add(T data) {
        if (size >= underLyingArray.length) {
            underLyingArray = Arrays.copyOf(underLyingArray,
                    underLyingArray.length * 2);
        }
        underLyingArray[size++] = data;
    }

    /**
     * deletes an element from the collection at the given index
     *
     * @return the deleted element of the collection
     * @param index: index of the element to delete
     */
    @Override
    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T remove = underLyingArray[index];
        for (int i = index; i < size; i++) {
            underLyingArray[i] = underLyingArray[i + 1];
        }
        underLyingArray[size--] = null;
        return remove;
    }

    /**
     * gets an element from the collection at the given index
     *
     * @return the requested element of the collection at the given index
     * @param index: index of the element to get
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return underLyingArray[index];
    }

    /**
     * updates a collection element at the given index
     *
     * @param index: index of the element to update
     * @param value: value to set
     */
    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        underLyingArray[index] = value;
    }

    /**
     * gets the last element of the collection
     *
     * @return the last element of the collection
     *
     */
    @Override
    public T getLast() {
        return underLyingArray[size - 1];
    }

    /**
     * gets a random element from the collection (w/uniform distribution, e.g.,
     * Random.nextInt)
     *
     * @return a random element of the collection
     *
     */
    @Override
    public T getRandom() {
        Random r = new Random();
        int randomIndex = r.nextInt(size);
        return underLyingArray[randomIndex];
    }

    /**
     *
     * @return a number of elements in the collection
     *
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * checks to see if the dynamic array is empty
     *
     * @return true if empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return elements of the collection as a Java array of Objects
     *
     */
    @Override
    public Object[] toJavaArray() {
        return Arrays.copyOf(underLyingArray, size);
    }

    /**
     *
     * @return a copy of the underlying array (for testing purposes)
     *
     */
    @Override
    public Object[] getUnderlyingArrayCopy() {
        return Arrays.copyOf(underLyingArray,
                underLyingArray.length);
    }

    /**
     * 
     * @return returns the String rep. of the toJavaArray 
     */
    @Override
    public String toString() {
        return Arrays.toString(this.toJavaArray());
    }

}
