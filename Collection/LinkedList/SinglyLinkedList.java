package com.aaachuan.collection;

import java.util.NoSuchElementException;

/**
 * 
 * @param <E>
 */
public class SinglyLinkedList<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    public void add(E element) {
        Node<E> oldLast = last;
        Node<E> newNode = new Node<>(element, null);
        last = newNode;
        if (oldLast == null)
            first = newNode;
        else
            oldLast.next = newNode;
        size++;
    }

    public E removeLast() {
        Node<E> lastNode = last;
        if (first == null && last == null)
            throw new NoSuchElementException("没有元素可以移除");
        if ((first == last) && (first != null)) {
            Node<E> oneNode = first;
            first = null;
            size--;
            return oneNode.value;
        }
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.next == last) {
                lastNode = x.next;
                x.next = null;
                last = x;
                size--;
            }
        }
        return lastNode.value;

    }


    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        if (size == 1)
            return "[" + (String) first.value + "]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node<E> x = first; x != null; x = x.next) {
              if (x == last) {
                sb.append(x.value).append("]");
            } else {
                sb.append(x.value).append(",");
            }
        }
        return sb.toString();
    }




    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}


