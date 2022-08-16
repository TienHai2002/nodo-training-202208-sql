package chuong10;

import java.util.ArrayList;
import java.util.List;

public class TreeNode <T>{
    private T value;

    private TreeNode<T> nextSibling;
    private TreeNode<T> firstChild;
    private TreeNode<T> parent;

    public TreeNode(T v){
        value=v;
    }

    public TreeNode() {

    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getNextSibling() {
        return nextSibling;
    }

    public TreeNode<T> getFirstChild() {
        return firstChild;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    TreeNode<T> addChild(T value) {
        TreeNode<T> node = new TreeNode<T>(value);
        addChild(node);
        return node;
    }

    public void addChild(TreeNode<T>child) {
        if (child == null) return;
        child.parent = parent;
        if (firstChild == null) {
            firstChild = child;
        } else {
            TreeNode<T> temp = firstChild;
            while (temp.nextSibling != null) {
                temp = temp.nextSibling;
            }
            temp.nextSibling = child;
        }
    }

    public List<T> chonloc(TreeNodeFilter<T>filter){
        List<T> list = new ArrayList<T>();
        TreeNodeUtils.visit(this,filter,list);
        return  list;
    }
}