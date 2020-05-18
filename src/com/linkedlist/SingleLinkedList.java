package com.linkedlist;

import java.util.Stack;

/**
 * 单链表
 * @author god
 */
public class SingleLinkedList {

    /**
     * 初始化头节点
     */
    private Node headNode = new Node(0);


    /**
     * 添加节点，无排序
     * @param node
     */
    public void add(Node node){

        // 头节点的栈地址不能改变，否则无法定位头部数据是什么，所以需要一个临时变量来替代头节点
        Node temp = this.headNode;

        while(true){
            if(temp.getNode() ==null){
                temp.setNode(node);
                break;
            }
            // 如果当前节点中的 next域不为空，临时变量的栈地址指向 next
            temp = temp.getNode();
        }

        // 退出循环后，temp的栈地址指向最后一个next域
        temp.setNode(node);
    }
    /**
     * 添加节点
     * @param node
     */
    public void addByOrder(Node node){

        // 头节点的栈地址不能改变，否则无法定位头部数据是什么，所以需要一个临时变量来替代头节点
        Node temp = this.headNode;

        boolean flag = false;

        while(true){
            if(temp.getNode() ==null){
                temp.setNode(node);
                break;
            }

            // 获取temp要插入的位置
            // 默认升序
            if(temp.getNode().getId() > node.getId()){
                // 先后顺序不能写反，否则会出现循环调用，导致栈溢出
                node.setNode(temp.getNode());
                temp.setNode(node);
                break;
            }else if(temp.getNode().getId() == node.getId()){
                System.out.println("数据已存在");
                break;
            }
            // 指向下一个node
            temp = temp.getNode();
        }
    }

    public void update(Node node){

        Node temp = this.headNode;

        while(true){
            // 链表为空或链表循环结束
            if(temp.getNode() == null){
                break;
            }
            // 修改值
            if(temp.getNode().getId()==node.getId()){
                temp.getNode().setName(node.getName());
                break;
            }
            temp = temp.getNode();
        }
    }

    public void delete(Node node){
        Node temp = this.headNode;
        while(true){
            // 链表为空或链表循环结束
            if(temp.getNode() == null){
                return;
            }
            // 删除节点
            if(temp.getNode().getId() == node.getId()){
                temp.setNode(temp.getNode().getNode());
                break;
            }
            temp = temp.getNode();
        }
    }

    /**
     * 打印链表
     */
    public void list(){

        Node temp = this.headNode.getNode();

        while(true){

            if(temp == null){
                break;
            }
            System.out.println(temp.toString());
            // 指向下一个节点
            temp = temp.getNode();
        }
    }


    public int size(){
        if(this.headNode.getNode() == null){
            return 0;
        }
        Node temp = headNode.getNode();
        int size = 1;
        while(true){

            if(temp.getNode() != null){
                size ++;
            }else{
                break;
            }
            temp = temp.getNode();
        }
        return size;
    }

    public Node lastIndexNode(int index){

        if(this.headNode.getNode() == null){
            System.out.println("链表为空");
            return null;
        }

        // 获取链表长度
        int size =  this.size();

        // 校验index的有效性
        if(index > size || index <1){
            System.out.println("长度越界");
            return null;
        }
        // 根据长度计算要遍历的位置
        // 链表总长度 - 下标 = 要循环的次数
        Node temp = this.headNode.getNode();
        for(int i = 0; i<size-index; i++){
            temp = temp.getNode();
        }
        return temp;
    }

    public void reverse(SingleLinkedList list){

        if(list.headNode.getNode() == null || list.headNode.getNode().getNode() == null){
            System.out.println("无需反转");
            return;
        }

        Node temp = list.headNode.getNode();
        Node next = null;
        Node newHeadNode = new Node(0);
        while(temp != null){
            // 指向下一个节点
            next = temp.getNode();
            // 将新链表的头部节点赋值给循环出的链表
            temp.setNode(newHeadNode.getNode());
            // 将temp放入新链表的最前端
            newHeadNode.setNode(temp);
            temp = next;
        }

        list.headNode = newHeadNode;
    }


    public void reversePrint(SingleLinkedList list){
        if(list.headNode.getNode() == null || list.headNode.getNode().getNode() == null){
            System.out.println("无需反转");
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = list.headNode.getNode();
        while(true){
            if(temp == null){
                break;
            }
            // 进栈
            stack.push(temp);
            temp = temp.getNode();
        }

        while(stack.size()>0){
            // 出栈
            System.out.println(stack.pop());
        }

    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        Node node = new Node(1,"a");
        Node node1 = new Node(2,"c");
        Node node2 = new Node(3,"b");
        Node node3 = new Node(4,"d");

        // 新增节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node);
        singleLinkedList.list();

        // 修改节点
        singleLinkedList.update(new Node(2,"aa"));
        singleLinkedList.list();

        // 删除节点
        singleLinkedList.delete(node2);
        singleLinkedList.list();

        // 链表长度
        System.out.println(singleLinkedList.size());

        // 获取链表中倒数第 n 个节点
        System.out.println(singleLinkedList.lastIndexNode(0));

        System.out.println("链表反转：");
        singleLinkedList.list();
        System.out.println("--------------------------------");
        // 链表反转
        singleLinkedList.reverse(singleLinkedList);
        singleLinkedList.list();

        System.out.println("逆序打印：");
        singleLinkedList.reversePrint(singleLinkedList);


    }


}
