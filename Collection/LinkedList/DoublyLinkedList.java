package com.aaachuan.collection;

public class DoublyLinkedList<E> {
    //链表长度
    private int size;
    //头节点
    private Node first;
    //尾节点
    private Node last;

    /**
     * 节点定义(内部类)——单链表包含节点值与上一节点、下一节点地址
     * @param <E>
     */
    private static class Node<E> {
        E value;
        Node<E> pre;
        Node<E> next;
        Node(E value, Node<E> pre, Node<E> next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
    }


    /**
     * 指定索引返回对应元素
     * @param index
     * @return
     */
    public E get(int index) {
        indexCheck(index);
        return node(index).value;
    }


    /**
     * 指定索引节点修改元素
     * @param index
     * @param value
     * @return
     */
    public E set(int index, E value) {
        indexCheck(index);
        Node<E> oldNode =  node(index);
        E oldValue = oldNode.value;
        oldNode.value = value;
        return oldValue;
    }

    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x.pre = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 索引越界检查
     * index应满足(index >= 0 && index < size)
     * @param index
     */
    private void indexCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引值越界: index:" + index + ",size:" + size);
    }

    /**
     * 通过索引定位元素(其他方法使用场景多而抽取)
     * 利用pre的特征索引定位时可从后序到前序以节省查找遍历的节点过程
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        Node<E> x = first;
        if (index > (size >> 1)) {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        } else {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder().append("[");
        for (Node<E> x = first; x != null; x = x.next) {
            sb.append(x.value);
            if (x.next == null)
                return sb.append("]").toString();
            sb.append(",");
        }
        return sb.toString();
    }
}
