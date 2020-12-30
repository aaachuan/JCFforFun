package com.aaachuan.collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        if(size == 0)
            return false;
        for (Node<E> x = first; x != null; x = x.next) {
            if ((x.value).equals(element))
                return true;
        }
        return false;
    }

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

    public E get(int index) {
        indexCheck(index);
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.value;
    }

    public E set(int index, E element) {
        indexCheck(index);
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        E oldValue = x.value;
        x.value = element;
        return oldValue;
    }

    public void add(int index, E element) {
        indexCheck(index);
        
    }

    public E remove(int index) {
        return null;
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

    public int index(E element) {
        return 0;
    }

    public void clear() {
        
    }

    private void indexCheck(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("索引值越界");
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


