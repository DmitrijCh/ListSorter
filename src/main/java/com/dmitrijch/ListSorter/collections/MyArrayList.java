package com.dmitrijch.ListSorter.collections;

/**
 * MyArrayList - простая реализация динамического массива с возможностью сортировки.
 * Поддерживает операции добавления, получения, удаления, сортировки и другие.
 *
 * @param <T> Тип элементов, реализующих интерфейс Comparable.
 */
public class MyArrayList<T extends Comparable<? super T>> {

    /**
     * Капацитет массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Массив для хранения элементов списка.
     */
    private Object[] array;

    /**
     * Реальный размер списка (количество добавленных элементов).
     */
    private int size;

    /**
     * Конструктор по умолчанию. Инициализирует массив и размер.
     */
    public MyArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления.
     */
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    /**
     * Добавляет элемент в указанную позицию списка.
     *
     * @param index   Индекс для добавления элемента.
     * @param element Элемент для добавления.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы размера списка.
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        ensureCapacity();

        shiftElementsToRight(index);
        array[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по заданному индексу.
     *
     * @param index Индекс для получения элемента.
     * @return Элемент списка.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы размера списка.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }

    /**
     * Удаляет элемент по заданному индексу из списка.
     *
     * @param index Индекс для удаления элемента.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы размера списка.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }

        shiftElementsToLeft(index);
        array[--size] = null;
    }

    /**
     * Очищает весь список, устанавливая размер в ноль и обнуляя все элементы.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Возвращает текущий размер списка.
     *
     * @return Размер списка.
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет и увеличивает емкость списка, если текущий размер достиг капацитета.
     */
    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    /**
     * Сдвигает элементы вправо, начиная с указанного индекса.
     *
     * @param index Индекс, с которого начинается сдвиг.
     */
    private void shiftElementsToRight(int index) {
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    /**
     * Сдвигает элементы влево, начиная с указанного индекса.
     *
     * @param index Индекс, с которого начинается сдвиг.
     */
    private void shiftElementsToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    /**
     * Выполняет сортировку списка с использованием алгоритма быстрой сортировки (quickSort).
     */
    public void quickSort() {
        quickSort(0, size - 1);
    }


    /**
     * Внутренний метод для рекурсивной реализации алгоритма быстрой сортировки.
     *
     * @param low  Нижний индекс.
     * @param high Верхний индекс.
     */
    void quickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSort(low, partitionIndex - 1);
            quickSort(partitionIndex + 1, high);
        }
    }

    /**
     * Выполняет разделение элементов для алгоритма быстрой сортировки.
     *
     * @param low  Нижний индекс.
     * @param high Верхний индекс.
     * @return Индекс разделения.
     */
    private int partition(int low, int high) {
        T pivot = (T) get(high);

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Обменивает значения двух элементов списка.
     *
     * @param i Индекс первого элемента.
     * @param j Индекс второго элемента.
     */
    private void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    /**
     * Сравнивает два элемента списка.
     *
     * @param a Первый элемент для сравнения.
     * @param b Второй элемент для сравнения.
     * @return Результат сравнения.
     * @throws NullPointerException Если один из элементов равен null.
     */
    private int compare(T a, T b) {
        if (a == null || b == null) {
            throw new NullPointerException("Невозможно сравнить пустые элементы");
        }
        return a.compareTo(b);
    }

    /**
     * Устанавливает значение элемента по указанному индексу.
     *
     * @param index   Индекс элемента.
     * @param element Новое значение элемента.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы размера списка.
     */
    private void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        array[index] = element;
    }
}
