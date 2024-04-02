package org.mps.deque;

import java.util.Comparator;

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

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new DoubleLinkedQueueException("Index out of bounds");
        }

        LinkedNode<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getItem();
    }

    @Override
    public boolean contains(T value) {
        LinkedNode<T> current = first;

        while (current != null) {
            if (current.getItem().equals(value)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public void remove(T value) {
        LinkedNode<T> current = first;

        while (current != null) {
            if (current.getItem().equals(value)) {
                if (current == first) {
                    first = current.getNext();
                    if (first == null) {
                        last = null;
                    } else {
                        first.setPrevious(null);
                    }
                } else if (current == last) {
                    last = current.getPrevious();
                    if (last == null) {
                        first = null;
                    } else {
                        last.setNext(null);
                    }
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                size--;
                return;
            }

            current = current.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size < 2) {
            return;
        }

        LinkedNode<T> current = first;
        while (current != null) {
            LinkedNode<T> next = current.getNext();
            while (next != null) {
                if (comparator.compare(current.getItem(), next.getItem()) > 0) {
                    T temp = current.getItem();
                    current.setItem(next.getItem());
                    next.setItem(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }
}