package com.dmitrijch.ListSorter;

import com.dmitrijch.ListSorter.collections.MyArrayList;

/**
 * Приложение для демонстрации использования MyArrayList.
 */
public class ListSorterApplication {
    /**
     * Точка входа в приложение. Создает экземпляр MyArrayList, добавляет элементы, сортирует их и выполняет другие операции.
     */
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(5);
        myArrayList.add(3);
        myArrayList.add(8);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(15);
        myArrayList.add(123);

//		MyArrayList<String> myArrayList = new MyArrayList<>();
//
//		myArrayList.add("5");
//		myArrayList.add("3");
//		myArrayList.add("8");
//		myArrayList.add("2");
//		myArrayList.add("1");
//		myArrayList.add("1");
//		myArrayList.add("15");
//		myArrayList.add("123");

        /*
         * Вводится список до сортировки элементов.
         */
        System.out.println("До сортировки:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }

        myArrayList.quickSort();

        /*
         * Вводится список после сортировки элементов.
         */
        System.out.println("\n\nПосле сортировки:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }

        /*
         * Вводится список после добавления элемента.
         */
        myArrayList.add(10);
//		myArrayList.add("10");
        System.out.println("\n\nСписок после добавления 10 элемента:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        /*
         * Вводится список после добавления элемента по индексу.
         */
        myArrayList.add(1, 10);
//		myArrayList.add("10");
        System.out.println("\nСписок после добавления 10 элемента по индексу 1:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        /*
         * Вводится элемент по указанному индексу.
         */
        System.out.println("\nЭлемент по индексу 2:" + myArrayList.get(2));

        /*
         * Вводится список после удаления элемента по индексу.
         */
        myArrayList.remove(2);
        System.out.println("\nЭлементы после удаления элемента по индексу 2:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        /*
         * Вводится пустой список после очистки коллекции.
         */
        myArrayList.clear();
        System.out.println("\nЭлементы после очистки коллекции:");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
