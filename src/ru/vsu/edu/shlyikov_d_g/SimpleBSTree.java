package ru.vsu.edu.shlyikov_d_g;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Класс, реализующий простое (наивное) дерево поиска
 * @param <T>
 */
public class SimpleBSTree<T extends Comparable<? super T>> extends SimpleBinaryTree<T> implements BSTree<T> {

    private static class CheckBSTResult<T> {
        public boolean result;
        public int size;
        public T min;
        public T max;

        public CheckBSTResult(boolean result, int size, T min, T max) {
            this.result = result;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    int size = 0;

    public SimpleBSTree(Function<String, T> fromStrFunc, Function<T, String> toStrFunc) {
        super(fromStrFunc, toStrFunc);
    }

    public SimpleBSTree(Function<String, T> fromStrFunc) {
        super(fromStrFunc);
    }

    public SimpleBSTree() {
        super();
    }

    private static <T extends Comparable<? super T>> CheckBSTResult<T> isBSTInner(TreeNode<T> node) {
        if (node == null) {
            return null;
        }

        CheckBSTResult<T> leftResult = isBSTInner(node.getLeft());
        CheckBSTResult<T> rightResult = isBSTInner(node.getRight());
        CheckBSTResult<T> result = new CheckBSTResult<>(true, 1, node.getValue(), node.getValue());
        if (leftResult != null) {
            result.result &= leftResult.result;
            result.result &= leftResult.max.compareTo(node.getValue()) < 0;
            result.size += leftResult.size;
            result.min = leftResult.min;
        }
        if (rightResult != null) {
            result.result &= rightResult.result;
            result.size += rightResult.size;
            result.result &= rightResult.min.compareTo(node.getValue()) > 0;
            result.max = rightResult.max;
        }
        return result;
    }

    /**
     * Проверка, является ли поддерево деревом поиска
     * @param <T>
     * @param node Поддерево
     * @return treu/false
     */
    public static <T extends Comparable<? super T>> boolean isBST(BinaryTree.TreeNode<T> node) {
        return node == null ? true : isBSTInner(node).result;
    }

    /**
     * Загрузка дерева из скобочного представления
     * @param bracketStr
     * @throws Exception Если переаддное скобочное представление не является деревом поиска
     */
    @Override
    public void fromBracketNotation(String bracketStr) throws Exception {
        SimpleBinaryTree tempTree = new SimpleBSTree(this.fromStrFunc);
        tempTree.fromBracketNotation(bracketStr);
        CheckBSTResult<T> tempTreeResult = isBSTInner(tempTree.getRoot());
        if (!tempTreeResult.result) {
            throw new Exception("Заданное дерево не является деревом поиска!");
        }
        super.fromBracketNotation(bracketStr);
        this.size = tempTreeResult.size;
    }

    public int getArrSize(T value){
        return getArrSize(root, value);
    }

    private int getArrSize(SimpleTreeNode node, T value){
        int cmp = value.compareTo(node.value);
        if (cmp == 0) {
            return node.arr.size();
        } else {
            if (cmp < 0) {
                if (node.left == null) {
                    return node.arr.size();
                } else {
                    return getArrSize(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.arr.size();
                } else {
                    return getArrSize(node.right, value);
                }
            }
        }
    }

    /**
     * Рекурсивное добавление значения в поддерево node
     *
     * @param node Узел, в который (в него или его поддеревья) добавляем
     * значение value
     * @param value Добавляемое значение
     * @return Старое значение, равное value, если есть
     */
    private T put(SimpleTreeNode node, T value) {
        int cmp = value.compareTo(node.value);
        if (cmp == 0) {
            // в узле значение, равное value
            T oldValue = node.value;
            node.value = value;
            node.arr.add(value);
            size++;
            return oldValue;
        } else {
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new SimpleTreeNode(value);
                    size++;
                    return null;
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    node.right = new SimpleTreeNode(value);
                    size++;
                    return null;
                } else {
                    return put(node.right, value);
                }
            }
        }
    }

    /**
     * Рекурсивное удаления значения из поддерева node
     *
     * @param node
     * @param nodeParent Родитель узла
     * @param value
     * @return Старое значение, равное value, если есть
     */
    private T remove(SimpleTreeNode node, SimpleTreeNode nodeParent, T value)
    {
        if (node == null) {
            return null;
        }
        int cmp = value.compareTo(node.value);
        if (cmp == 0) {
            if (getArrSize(node.value) != 0) {
            size--;
            node.arr.remove(getArrSize(node.value) - 1);
            return node.value;
        }
            else {
                // в узле значение, равное value
                T oldValue = node.value;
                if (node.left != null && node.right != null) {
                    // если у node есть и левое и правое поддерево
                    SimpleTreeNode minParent = getMinNodeParent(node.right);
                    if (minParent == null) {
                        node.value = node.right.value;
                        node.right = node.right.right;
                    } else {
                        node.value = minParent.left.value;
                        minParent.left = minParent.left.right;
                    }
                } else {
                    SimpleTreeNode child = (node.left != null) ? node.left : node.right;
                    if (nodeParent == null) {
                        // возможно, если только node == root
                        root = child;
                    } else if (nodeParent.left == node) {
                        nodeParent.left = child;
                    } else {
                        nodeParent.right = child;
                    }
                }
                size--;
                return oldValue;
            }
        } else if (cmp < 0)
            return remove(node.left, node, value);
        else {
            return remove(node.right, node, value);
        }
    }

    /**
     * Поиск родителя минимально TreeNode в поддереве node
     *
     * @param node Поддерево в котором надо искать родителя минимального элемент
     * @return Узел, содержащий минимальный элемент
     */
    private SimpleTreeNode getMinNodeParent(SimpleTreeNode node) {
        if (node == null) {
            return null;
        }
        SimpleTreeNode parent = null;
        for (; node.left != null; node = node.left) {
            parent = node;
        }
        return parent;
    }

    // Реализация BSTree<T>

    @Override
    public T put(T value) {
        if (root == null) {
            root = new SimpleTreeNode(value);
            size++;
            return null;
        }
        return put(root, value);
    }

    @Override
    public T remove(T value) {
        return remove(root, null, value);
    }

    @Override
    public int size() {
        return size;
    }
}
