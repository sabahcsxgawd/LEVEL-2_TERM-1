import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node {
    private int key;
    private Node left, right;

    public Node() {
        this.left = this.right = null;
    }

    public Node(int key) {
        this();
        this.key = key;
    }

    public Node(Node node) {
        this.key = node.key;
        this.left = node.left;
        this.right = node.right;
    }

    public int getKey() {
        return this.key;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class BST {

    private Node root;
    private boolean isDelete = false;

    public BST() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = this.insertHelp(this.root, key);
        System.out.println(this.printHelp(this.root));
    }

    private Node insertHelp(Node node, int key) {
        if (node == null) {
            node = new Node(key);
        } else {
            if (key < node.getKey()) {
                node.setLeft(insertHelp(node.getLeft(), key));
            } else {
                node.setRight(insertHelp(node.getRight(), key));
            }
        }
        return node;
    }

    public void find(int key) {
        if (this.findHelp(this.root, key)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private boolean findHelp(Node node, int key) {
        if (node == null) {
            return false;
        } else if (key == node.getKey()) {
            return true;
        } else if (key < node.getKey()) {
            return findHelp(node.getLeft(), key);
        } else {
            return findHelp(node.getRight(), key);
        }
    }

    private int findMax(Node node) {
        int maxValue = node.getKey();
        while (node.getRight() != null) {
            node = node.getRight();
            maxValue = node.getKey();
        }
        return maxValue;
    }

    private int findMin(Node node) {
        int minValue = node.getKey();
        while (node.getLeft() != null) {
            node = node.getLeft();
            minValue = node.getKey();
        }
        return minValue;
    }

    public void delete(int key) {
        this.isDelete = false;
        this.root = this.deleteHelp(this.root, key);
        if (this.isDelete) {
            System.out.println(this.printHelp(this.root));
        } else {
            System.out.println("Invalid Operation");
        }
    }

    private Node deleteHelp(Node node, int key) {
        if (node != null) {
            if (key < node.getKey()) {
                node.setLeft(deleteHelp(node.getLeft(), key));
            } else if (key > node.getKey()) {
                node.setRight(deleteHelp(node.getRight(), key));
            } else {
                this.isDelete = true;
                if (node.getLeft() == null || node.getRight() == null) {
                    Node temp = node.getLeft() == null ? node.getRight() : node.getLeft();
                    node = temp;
                } else {
                    int tempKey = findMax(node.getLeft());
                    node.setKey(tempKey);
                    node.setLeft(deleteHelp(node.getLeft(), tempKey));
                }
            }
        }
        return node;
    }

    private String printHelp(Node node) {
        if (node == null) {
            return "";
        } else if (node.getLeft() == null && node.getRight() == null) {
            return node.getKey() + "";
        } else {
            return node.getKey() + "(" + printHelp(node.getLeft()) + ")" + "(" + printHelp(node.getRight()) + ")";
        }
    }

    public void traverse(String string) {
        if (string.equalsIgnoreCase("pre")) {
            this.preOrder(this.root);
        } else if (string.equalsIgnoreCase("in")) {
            this.inOrder(this.root);
        } else if (string.equalsIgnoreCase("post")) {
            this.postOrder(this.root);
        } else {
            System.out.println("Invalid Traversal");
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            if (node.getLeft() != null) {
                preOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                preOrder(node.getRight());
            }
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            if (node.getLeft() != null) {
                inOrder(node.getLeft());
            }
            System.out.print(node.getKey() + " ");
            if (node.getRight() != null) {
                inOrder(node.getRight());
            }
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            if (node.getLeft() != null) {
                postOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                postOrder(node.getRight());
            }
            System.out.print(node.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            while (true) {
                String s = br.readLine();
                if (s == null) {
                    break;
                }
                String[] operation = s.split(" ");
                if (operation[0].equalsIgnoreCase("F")) {
                    try {
                        bst.find(Integer.parseInt(operation[1]));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid Parameter Passed");
                    }
                } else if (operation[0].equalsIgnoreCase("I")) {
                    try {
                        bst.insert(Integer.parseInt(operation[1]));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid Parameter Passed");
                    }
                } else if (operation[0].equalsIgnoreCase("D")) {
                    try {
                        bst.delete(Integer.parseInt(operation[1]));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid Parameter Passed");
                    }
                } else if (operation[0].equalsIgnoreCase("T")) {
                    bst.traverse(operation[1]);
                    System.out.println();
                } else {
                    System.out.println("Invalid Input");
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
