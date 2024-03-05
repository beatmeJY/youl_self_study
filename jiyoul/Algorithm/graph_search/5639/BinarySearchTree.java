import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearchTree {

    static Node rootNode;

    public static void main(String[] args) {
        inputValue();
        rootNode.reversePrintSearch();
    }

    private static void insert(int scanValue) {
        if (rootNode == null) {
            rootNode = new Node(scanValue);
            return;
        }
        rootNode.insert(scanValue);
    }

    private static class Node {
        int number;
        Node leftNode;
        Node rightNode;

        Node(int number) {
            this.number = number;
        }

        void insert(int newNumber) {
            if (newNumber < number) {
                if (leftNode != null) {
                    leftNode.insert(newNumber);
                    return;
                }
                leftNode = new Node(newNumber);
            }
            if (newNumber > number) {
                if (rightNode != null){
                    rightNode.insert(newNumber);
                    return;
                }
                rightNode = new Node(newNumber);
            }
        }

        void reversePrintSearch() {
            if (this.leftNode != null) {
                this.leftNode.reversePrintSearch();
            }
            if (this.rightNode != null) {
                this.rightNode.reversePrintSearch();
            }
            System.out.println(number);
        }
    }

    private static void inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] tokens = line.split("\\s");
                insert(Integer.parseInt(tokens[0]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
