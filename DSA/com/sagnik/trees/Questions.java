package com.sagnik.trees;

import java.util.*;

public class Questions {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    void dfsStack(TreeNode node) {
        // DFS using stack
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");
            if (removed.right != null) {
                stack.push(removed.right);
            }
            if (removed.left != null) {
                stack.push(removed.left);
            }
        }
    }

    boolean findPath(TreeNode node, int[] arr) {
        // Check whether path exists in Binary Tree from root to leaf
        if (node == null) {
            return arr.length == 0;
        }
        return helper(node, arr, 0);
    }

    boolean helper(TreeNode node, int[] arr, int index) {
        if (node == null) {
            return false;
        }
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        if (node.left == null && node.right == null && index == arr.length - 1) {
            return true;
        }
        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    /**
     * Finds the level-order successor of the given key in the binary tree.
     * @param root the root of the binary tree
     * @param key the value of the node whose successor is to be found
     * @return the successor TreeNode, or null if no successor exists
     */
    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }

        return queue.peek();
    }

    int countPaths(TreeNode node, int sum) {
        List<Integer> path = new LinkedList<>();
        return helper(node, sum, path);
    }

    int helper(TreeNode node, int sum, List<Integer> path) {
        if (node == null) {
            return 0;
        }
        path.add(node.val);
        int count = 0;
        int s = 0;
        // How many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();
            if (s == sum) {
                count++;
            }
        }
        count += helper(node.left, sum, path) + helper(node.right, sum, path);
        // Backtrack
        path.remove(path.size() - 1);
        return count;
    }

    public static void kdown(TreeNode root, int k, TreeNode blockNode, ArrayList<Integer> ans) {
        if (root == null || k < 0 || root == blockNode) {
            return;
        }
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        kdown(root.left, k - 1, blockNode, ans);
        kdown(root.right, k - 1, blockNode, ans);
    }

    public static int distanceK(TreeNode root, int target, int k, ArrayList<Integer> ans) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            kdown(root, k, null, ans);
            return 1;
        }
        int ld = distanceK(root.left, target, k, ans);
        if (ld != -1) {
            kdown(root, k - ld, root.left, ans);
            return ld + 1;
        }
        int rd = distanceK(root.right, target, k, ans);
        if (rd != -1) {
            kdown(root, k - rd, root.right, ans);
            return rd + 1;
        }
        return -1;
    }

    public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
        // All nodes at K distance
        ArrayList<Integer> ans = new ArrayList<>();
        distanceK(root, target, k, ans);
        return ans;
    }
}
