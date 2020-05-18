package com.linkedlist;

/**
 * 每个 Node 代表一个节点，Node中包含data域（数据） next域（指向下一个节点）
 * @author god
 */
public class Node {

    /**
     * data域 ：id
     */
    private int id;

    /**
     * data域 ：name
     */
    private String name;


    /**
     * next域
     */
    private Node node;

    public Node() {
    }

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name+"'}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
