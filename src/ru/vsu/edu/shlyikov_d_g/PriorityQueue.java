package ru.vsu.edu.shlyikov_d_g;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Consumer;

public interface PriorityQueue<T extends Comparable<? super T>> extends Queue<T>  {

    T put(T t);

    @Override
    default boolean remove(Object o) {
        return false;
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    default boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    default boolean offer(T t) {
        return false;
    }

    /**
     * Возвращает элемент из головы очереди и удаляет его.
     *
     * @return Возвращает null, если очередь пуста.
     */
    T remove();

    @Override
    default T poll() {
        return null;
    }

    @Override
    default T element() {
        return null;
    }

    /**
     * Возвращает элемент из головы очереди.
     * Элемент не удаляется.
     *
     * @return Возвращает null, если очередь пуста.
     */
    T peek();

    /**
     * Очистка дерева (удаление всех элементов)
     */
    void clear();

    /**
     * Размер дерева
     *
     * @return Кол-во элементов в дереве
     */
    int size();

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    default boolean contains(Object o) {
        return false;
    }

    @Override
    default void forEach(Consumer<? super T> action) {
        Queue.super.forEach(action);
    }

    @Override
    default Object[] toArray() {
        return new Object[0];
    }

    @Override
    default <T1> T1[] toArray(T1[] a) {
        return null;
    }
}