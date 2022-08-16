package chuong10;

import java.util.List;

public class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<String>("0");
        TreeNode<String> node1 = new TreeNode<>("0");
        root.addChild(node1);
        root.addChild(new TreeNode<>("1.1"));
        root.addChild(new TreeNode<>("1.2"));
        root.addChild(new TreeNode<>("1.3"));


        TreeNode<String> node2 =node1.getNextSibling();
        node2.addChild("2.0.0");
        node2.addChild("2.1.0");
        node2.addChild("2.1.1");
//
        System.out.println("Next sibling of "+node1.getValue()+" is "+ node2.getValue().toString());

//        System.out.println("Check contains 2.1.1 ="+ chuong10.TreeNodeUtils.contains(root,"2.1.1"));

        List<String> list = root.chonloc(value -> {
            return value.contains(".0");
        });
        System.out.println("Co tong so "+list.size()+" chua '.0.'");
        list.forEach(value->
                System.out.println("phan tu loc =====>"+value));

    }
}