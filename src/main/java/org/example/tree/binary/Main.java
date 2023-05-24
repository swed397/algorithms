package org.example.tree.binary;

public class Main {

    public static void main(String[] args) {
        BTreeActions bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        bt.deleteNode(6);

        System.out.println(bt.containsNode(6));

        bt.traverse();
        bt.traverseLevel();
    }
}
