package org.example.tree.binary;

public interface BTreeActions {

    void add(int value);

    boolean containsNode(int value);

    void deleteNode(int value);

    void traverse();

    void traverseLevel();
}
