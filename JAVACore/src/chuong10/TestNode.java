package chuong10;

public class TestNode {
    private static void test(NodeEx<?> nodeEx) {
        while (nodeEx != null) {
            System.out.println("value is : " + nodeEx.getValue() + "");
            nodeEx = nodeEx.next;
        }
    }

    public static void main(String[] args) {
        NodeEx<String> root = new NodeEx<>("Step 1");
        NodeEx<String> node1 = new NodeEx<>("Step 2");
        root.next = node1;
        test(root);
        NodeEx<Integer> root2;
        root2 = new NodeEx<Integer>(99, new NodeEx<Integer>(11));
        test(root2);
    }
}
