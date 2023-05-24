package org.example.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree implements BTreeActions {

    private Node root;

    public BinaryTree() {
    }

    private Node insertRecursive(Node curentNode, int value) {
        if (curentNode == null) {
            return new Node(value);
        }

        if (value < curentNode.getValue()) {
            curentNode.setLeftNode(insertRecursive(curentNode.getLeftNode(), value));
        } else if (value > curentNode.getValue()) {
            curentNode.setRightNode(insertRecursive(curentNode.getRightNode(), value));
        } else {
            return curentNode;
        }

        return curentNode;
    }

    @Override
    public void add(int value) {
        root = insertRecursive(root, value);
    }

    private boolean containsRecursive(Node curentNode, int value) {
        if (curentNode == null) {
            return false;
        }

        if (curentNode.getValue() == value) {
            return true;
        }

        boolean contains = false;
        if (value < curentNode.getValue()) {
            contains = containsRecursive(curentNode.getLeftNode(), value);
        } else if (value > curentNode.getValue()) {
            contains = containsRecursive(curentNode.getRightNode(), value);
        }

        return contains;
    }

    @Override
    public boolean containsNode(int value) {
        return containsRecursive(root, value);
    }

    private Node deleteRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (value == currentNode.getValue()) {
            if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                return null;
            }

            int smallestValue = findSmallestValue(currentNode.getRightNode());
            currentNode.setValue(smallestValue);
            currentNode.setRightNode(deleteRecursive(currentNode.getRightNode(), smallestValue));
        }
        if (value < currentNode.getValue()) {
            currentNode.setLeftNode(deleteRecursive(currentNode.getLeftNode(), value));
            return currentNode;
        }
        currentNode.setRightNode(deleteRecursive(currentNode.getRightNode(), value));

        return currentNode;

    }

    private int findSmallestValue(Node root) {
        return root.getLeftNode() == null ? root.getValue() : findSmallestValue(root.getLeftNode());
    }

    @Override
    public void deleteNode(int value) {
        deleteRecursive(root, value);
    }

    private void traverseRecursive(Node node) {
        if (node != null) {
            System.out.println("Value : " + node.getValue());
            traverseRecursive(node.getLeftNode());
            traverseRecursive(node.getRightNode());
        }
    }

    @Override
    public void traverse() {
        traverseRecursive(root);
    }

    @Override
    public void traverseLevel() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.println("Value : " + node.getValue());

            if (node.getLeftNode() != null) {
                nodes.add(node.getLeftNode());
            }

            if (node.getRightNode() != null) {
                nodes.add(node.getRightNode());
            }
        }
    }
}
