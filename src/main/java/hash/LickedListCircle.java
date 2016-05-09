package hash;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rtsy on 13.03.2016.
 * This is broken iterators with cycle
 */
public class LickedListCircle<T> {

    Node<T> root;
    Node<T> tail;

    int size;

    Iterator<T> iterator() {
        return new SingleElementStepIterator();
    }

    Iterator<T> doubleStepIterator() {
        return new DoubleElementStepIterator();
    }

    public boolean add(T value) {
        if (root == null) {
            root = new Node<T>(value);
            root.setPrev(null);
            tail = root;
            size++;
            return true;
        } else {
            Node<T> newNode = new Node<>(value);
            newNode.setPrev(tail);
            newNode.setNext(root);
            tail.setNext(newNode);
            tail = newNode;
            size++;
            return true;
        }
    }

    public T get(int index) {
        return getNodeValue(root, index);
    }

    public T getNodeValue(Node<T> node, int index) {
        if (index == 0) {
            return node.getValue();
        } else {
            return getNodeValue(node.getNext(),--index);
        }
    }

    public int size() {
        return size;
    }

    class SingleElementStepIterator implements Iterator<T>{
        Node<T> lastReturned;

        @Override
        public boolean hasNext() {
            return lastReturned.getNext() != null;
        }

        @Override
        public T next() {
            if (lastReturned == null) {
                lastReturned = root;
                return lastReturned.getValue();
            }
            if (hasNext()) {
                lastReturned = lastReturned.getNext();
                return lastReturned.getValue();
            } else {
                throw new NoSuchElementException();
            }
        }
    }


    class DoubleElementStepIterator extends SingleElementStepIterator{

        @Override
        public boolean hasNext() {
            Node node = lastReturned.getNext();
            return ((node != null) && (node.getNext() != null));
        }

        @Override
        public T next() {
            if (lastReturned == null) {
                lastReturned = root;
                return lastReturned.getValue();
            }
            if (hasNext()) {
                lastReturned = lastReturned.getNext().getNext();
                return lastReturned.getValue();
            } else {
                throw new NoSuchElementException();
            }
        }
    }
    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;



        public Node(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }
    }

    public static void main(String[] args) {
        LickedListCircle<Integer> list = new LickedListCircle<>();
        for (int i = 0; i < 231; i++) {
            list.add(i);
        }

        System.out.println(list.get(4));

        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> iterator2 = list.doubleStepIterator();
        iterator.next();
        iterator2.next();

        while (iterator.hasNext() && iterator2.hasNext()) {
            Integer val1 = iterator.next();
            Integer val2 = iterator2.next();
            System.out.println(val1 + " : " + val2);
            if (val1 == val2) {
                System.out.println("equals");
                System.exit(1);
            }
        }
    }
}