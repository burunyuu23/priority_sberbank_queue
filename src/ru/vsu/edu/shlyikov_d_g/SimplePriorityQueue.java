package ru.vsu.edu.shlyikov_d_g;

import java.util.*;
import java.util.function.Supplier;

public class SimplePriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    BSTree<T> tree = null;

    public SimplePriorityQueue(Supplier<BSTree> treeCreator) {
        tree = treeCreator.get();
    }

    public SimplePriorityQueue(SimplePriorityQueue<T> s) {
        tree = s.tree;
    }

    public SimplePriorityQueue() {
        this(SimpleBSTree::new);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (tree.getRoot() == null){
            sb.append("Queue is empty!");
        }
        else {
            sb.append("{");
            int j = 0;
            for (T element : this) {
                for (int i = 0; i <= tree.getArrSize(element); i++){
                    sb.append(element);
                    if (i != tree.getArrSize(element)) {
                        sb.append(", ");
                        j++;
                    }
                }
                j++;
                if (j != tree.size()) {
                    sb.append(", ");
                }
            }
            sb.append("}");
        }
        return sb.toString();
    }

    @Override
    public T put(T t) {
        tree.put(t);
        return t;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : this) {
            if (o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return tree.iterator();
    }

    @Override
    public boolean add(T t) {
        put(t);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        for (T e : this) {
            if (!c.contains(e)){
                if (tree.getArrSize(e) == 0){
                    tree.remove(e);
                }
                for (int i = 0; i <= tree.getArrSize(e); i++) {
                    tree.remove(e);
                }
                if (!flag){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public T remove(){
        return remove(tree.getRoot());
    }

    /**
     * Рекурсивное удаления значения из поддерева node
     *
     * @param node
     * @return Старое значение, равное value, если есть
     */
    private T remove(BinaryTree.TreeNode<T> node)
    {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null){
            return remove(node.getLeft());
        }
        else{
            tree.remove(node.getValue());
            return node.getValue();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = false;
        for (T e : this) {
            if (c.contains(e)){
                for (int i = 0; i <= tree.getArrSize(e); i++) {
                    tree.remove(e);
                }
                if (!flag){
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    public T peek() {
        return peek(tree.getRoot());
    }

    private T peek(BinaryTree.TreeNode<T> node)
    {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null){
            return peek(node.getLeft());
        }
        else{
            return node.getValue();
        }
    }

    @Override
    public void clear() {
        while(tree.getRoot() != null){
            remove();
        }
    }

    @Override
    public int size() {
        return tree.size();
    }

    // getTree возвращается дерево
    // Наследуется от очереди

}