public class CombinedDynamicArray {
    public static void main(String[] args) {
        DynamicArray<String> words = new DynamicArray<>();
        words.add("Alpha");
        words.add("Bravo");
        words.add("Charlie");

        System.out.println("Size after adds: " + words.size());
        System.out.println("Get index 1: " + words.get(1));
        System.out.println("Removed: " + words.remove(1));
        System.out.println("Size after remove: " + words.size());
        System.out.println("Now at index 1: " + words.get(1));

        DynamicArray<Integer> nums = new DynamicArray<>();
        for (int i = 1; i <= 25; i++) {
            nums.add(i);
        }
        System.out.println("\nIntegers size: " + nums.size());
        System.out.print("First 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(nums.get(i) + (i < 9 ? ", " : "\n"));
        }

        int removed = nums.remove(5);
        System.out.println("Removed at index 5: " + removed);
        System.out.println("New value at index 5: " + nums.get(5));

        try {
            nums.get(100);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("\nException caught as expected: " + ex.getMessage());
        }
    }
}

class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public DynamicArray() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            resize();
        }
        data[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = data[index];
        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(data, index + 1, data, index, elementsToMove);
        }
        data[--size] = null;
        return removed;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = (data.length == 0) ? INITIAL_CAPACITY : data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size
            );
        }
    }
}
