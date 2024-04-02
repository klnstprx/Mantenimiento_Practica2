package org.mps.deque;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        LinkedNode<T> newNode = new LinkedNode<>(value, null, first);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        }
        size++;
    }

    @Override
    public void append(T value) {
        LinkedNode<T> newNode = new LinkedNode<>(value, last, null);
        if (last == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first != null) {
            first = first.getNext();
            if (first == null) {
                last = null;
            } else {
                first.setPrevious(null);
            }
            size--;
        } else {
            throw new DoubleLinkedQueueException("The queue is empty");
        }
    }

    @Override
    public void deleteLast() {
        if (last != null) {
            last = last.getPrevious();
            if (last == null) {
                first = null;
            } else {
                last.setNext(null);
            }
            size--;
        } else {
            throw new DoubleLinkedQueueException("The queue is empty");
        }
    }

    @Override
    public T first() {
        return first == null ? null : first.getItem();
    }

    @Override
    public T last() {
        return last == null ? null : last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}