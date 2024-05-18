package BST;

class TestForBst {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");
        System.out.println("Value for key 5: " + bst.get(5));
        bst.delete(3);
        System.out.println("After deleting key 3, size: " + bst.size());
        System.out.println("In-order traversal:");
        for (BinarySearchTree.Entry<Integer, String> entry : bst) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
