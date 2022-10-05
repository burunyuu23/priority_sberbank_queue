package ru.vsu.edu.shlyikov_d_g;

import java.awt.*;
import java.util.Iterator;

/**
 * Интерфейс для двоичного дерева с реализацияей по умолчанию различных обходов
 * дерева
 *
 * @param <T>
 */
public interface BinaryTree<T> extends Iterable<T> {

    /**
     * Интерфейс для описания узла двоичного дерева
     *
     * @param <T>
     */
    interface TreeNode<T> extends Iterable<T> {

        /**
         * @return Значение в узле дерева
         */
        T getValue();

        /**
         * @return Левое поддерево
         */
        default TreeNode<T> getLeft() {
            return null;
        }

        /**
         * @return Правое поддерево
         */
        default TreeNode<T> getRight() {
            return null;
        }

        /**
         * @return Цвет узла (для рисования и не только)
         */
        default Color getColor() {
            return Color.BLACK;
        }

        /**
         * Реализация Iterable&lt;T&gt;
         *
         * @return Итератор
         */
        @Override
        default Iterator<T> iterator() {
            return BinaryTreeAlgorithms.inOrderValues(this).iterator();
        }

        /**
         * Представление поддерева в виде строки в скобочной нотации
         *
         * @return дерево в виде строки
         */
        default String toBracketStr() {
            return BinaryTreeAlgorithms.toBracketStr(this);
        }
    }

    /**
     * @return Корень (вершина) дерева
     */
    TreeNode<T> getRoot();

    /**
     * Реализация Iterable&lt;T&gt;
     *
     * @return Итератор
     */
    @Override
    default Iterator<T> iterator() {
        return this.getRoot().iterator();
    }


    /**
     * Представление дерева в виде строки в скобочной нотации
     *
     * @return дерево в виде строки
     */
    default String toBracketStr() {
        return this.getRoot().toBracketStr();
    }
}
