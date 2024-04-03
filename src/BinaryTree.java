package src;
public class BinaryTree<E extends Comparable<E>> {
    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(E data) {
        root = insertHelper(root, data);
    }

    private Node<E> insertHelper(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertHelper(node.right, data);
        }

        return node;
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node<E> node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node.data + " ");
            inOrderHelper(node.right);
        }
    }

    public E search(E key) {
        return searchHelper(root, key);
    }

    private E searchHelper(Node<E> node, E key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.data) == 0) {
            return node.data;
        } else if (key.compareTo(node.data) < 0) {
            return searchHelper(node.left, key);
        } else {
            return searchHelper(node.right, key);
        }
    }
}
