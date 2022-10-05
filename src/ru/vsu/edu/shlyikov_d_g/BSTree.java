package ru.vsu.edu.shlyikov_d_g;

/**
 * Интерфейс для двоичного дерева поиска (BinarySearchTree) с реализацией по
 * умолчанию многих типичных для таких деревьев методов
 *
 * @param <T>
 */
public interface BSTree<T extends Comparable<? super T>> extends BinaryTree<T> {

    /**
     * Поиск TreeNode по значению
     *
     * @param value Значение для поиска
     * @return Узел, содержащий искомый элемент
     */
    default TreeNode<T> getNode(T value) {
        return BSTreeAlgorithms.getNode(getRoot(), value);
    }

    /**
     * Поиск знаяения, равного значению (не обязательного того же самого)
     *
     * @param value Значение для поиска
     * @return Искомое значение
     */
    default T get(T value) {
        TreeNode<T> valueNode = getNode(value);
        return (valueNode == null) ? null : valueNode.getValue();
    }

    /**
     * Проверка, содержится ли значение value (или равное value) в дереве
     *
     * @param value Значение для поиска
     * @return true/false
     */
    default boolean contains(T value) {
        return getNode(value) != null;
    }

    /**
     * Добавление элемента в дерево (возвращать старое значение нажно для
     * эффективной реализации словаря Map из стандартной библиотеки)
     *
     * @param value Добавляемое значение
     * @return Старое значение, равное value, если было
     */
    T put(T value);

    /**
     * Удаление значения из дерева (возвращать старое значение нажно для
     * эффективной реализации словаря Map из стандартной библиотеки)
     *
     * @param value Удаляемое значение
     * @return Старое значение, равное value, если было
     */
    T remove(T value);

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

    /**
     * Поиск минимального TreeNode
     *
     * @return Узел, содержащий минимальный элемент
     */
    default TreeNode<T> getMinNode() {
        return BSTreeAlgorithms.getMinNode(getRoot());
    }

    /**
     * Поиск минимального значение
     *
     * @return Минимальное значение
     */
    default T getMin() {
        TreeNode<T> minNode = getMinNode();
        return (minNode == null) ? null : minNode.getValue();
    }

    /**
     * Поиск максимального TreeNode
     *
     * @return Узел, содержащий минимальный элемент
     */
    default TreeNode<T> getMaxNode() {
        return BSTreeAlgorithms.getMaxNode(getRoot());
    }

    /**
     * Поиск максимального значение
     *
     * @return Минимальное значение
     */
    default T getMax() {
        TreeNode<T> minNode = getMinNode();
        return (minNode == null) ? null : minNode.getValue();
    }

    /**
     * Поиск TreeNode с наибольшим значением, меньшим или равным value
     *
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default TreeNode<T> getFloorNode(T value) {
        return BSTreeAlgorithms.getFloorNode(getRoot(), value);
    }

    /**
     * Поиск наибольшего значения, меньшего или равного value
     *
     * @param value Параметр
     * @return Искомое значение
     */
    default T getFloor(T value) {
        TreeNode<T> floorNode = getFloorNode(value);
        return (floorNode == null) ? null : floorNode.getValue();
    }

    /**
     * Поиск TreeNode с наименьшим значением, большим или равным value
     *
     * @param value Параметр
     * @return Узел, содержащий искомый элемент
     */
    default TreeNode<T> getCeilingNode(T value) {
        return BSTreeAlgorithms.getCeilingNode(getRoot(), value);
    }

    /**
     * Поиск наименьшего значения, меньше или равного value
     *
     * @param value Параметр
     * @return Искомое значение
     */
    default T getCeiling(T value) {
        TreeNode<T> ceilingNode = getCeilingNode(value);
        return (ceilingNode == null) ? null : ceilingNode.getValue();
    }

    int getArrSize(T element);
}
