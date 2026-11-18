import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class DataStructures {
    public static void invokeDS() {
        arrayInit();
        stringInit();
        hashMapInit();
        hashSetInit();
        linkedListInit();
        stackInit();
        queueInit();
        heapInit();
        binarySearchInit();
        treeInit();
        graphInit();
        trieInit();
    }

    public static void arrayInit() {
        int[] numbers = {4, 7, 2, 9};
        numbers[1] = 8;
        int maximum = numbers[0];
        for (int number : numbers) {
            maximum = Math.max(maximum, number);
        }
        System.out.println("Array: " + Arrays.toString(numbers) + ", maximum: " + maximum);
    }

    public static void stringInit() {
        String word = "leetcode";
        System.out.println("String: " + word + ", first character: " + word.charAt(0));
    }

    public static void hashMapInit() {
        Map<String, Integer> counts = new HashMap<>();
        counts.put("apple", 2);
        System.out.println("HashMap: apple count = " + counts.get("apple"));
    }

    public static void hashSetInit() {
        Set<Integer> seen = new HashSet<>();
        seen.add(4);
        seen.add(4);
        System.out.println("HashSet: contains 4 = " + seen.contains(4) + ", size = " + seen.size());
    }

    public static void linkedListInit() {
        LinkedList<Integer> values = new LinkedList<>();
        values.add(10);
        values.add(20);
        System.out.println("LinkedList: " + values);
    }

    public static void stackInit() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack: top = " + stack.peek() + ", popped = " + stack.pop());
    }

    public static void queueInit() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        System.out.println("Queue: front = " + queue.peek() + ", removed = " + queue.remove());
    }

    public static void heapInit() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(9);
        minHeap.add(2);
        minHeap.add(7);
        System.out.println("Min heap: smallest = " + minHeap.peek());
    }

    public static void binarySearchInit() {
        int[] sorted = {2, 4, 7, 9};
        System.out.println("Binary search: index of 7 = " + Arrays.binarySearch(sorted, 7));
    }

    public static void treeInit() {
        // Each node has up to two children. This tree has root 5.
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        StringBuilder preorder = new StringBuilder();
        visitPreorder(root, preorder);
        System.out.println("Binary tree preorder: " + preorder.toString().trim());
    }

    private static void visitPreorder(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        result.append(node.value).append(' ');
        visitPreorder(node.left, result);
        visitPreorder(node.right, result);
    }

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void graphInit() {
        // An adjacency list records each vertex's neighbors.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(2));

        // Breadth-first search visits nearby vertices first.
        Queue<Integer> toVisit = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        toVisit.add(1);
        visited.add(1);
        StringBuilder order = new StringBuilder();
        while (!toVisit.isEmpty()) {
            int vertex = toVisit.remove();
            order.append(vertex).append(' ');
            for (int neighbor : graph.get(vertex)) {
                if (visited.add(neighbor)) {
                    toVisit.add(neighbor);
                }
            }
        }
        System.out.println("Graph BFS: " + order.toString().trim());
    }

    public static void trieInit() {
        TrieNode root = new TrieNode();
        insertWord(root, "cat");
        insertWord(root, "car");
        System.out.println("Trie: contains cat = " + containsWord(root, "cat")
                + ", contains cap = " + containsWord(root, "cap"));
    }

    private static void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            node = node.children.computeIfAbsent(letter, ignored -> new TrieNode());
        }
        node.isWord = true;
    }

    private static boolean containsWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char letter : word.toCharArray()) {
            node = node.children.get(letter);
            if (node == null) {
                return false;
            }
        }
        return node.isWord;
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}
