/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();

        if (root.left == null && root.right == null) {
            lst.add(""+root.val);
            return lst;
        }

        if (root.left != null) pathFinder(root.left, lst, ""+root.val);
        if (root.right != null) pathFinder(root.right, lst, ""+root.val);
        return lst;
    }

    private void pathFinder(TreeNode root, List<String> lst, String str) {
        str = str + "->" + root.val;
        if (root.left == null && root.right == null) {
            lst.add(str);
            return;
        }
        
        if (root.right != null) {
            pathFinder(root.right, lst, str);
        }
        
        if (root.left != null) {
            pathFinder(root.left, lst, str);
        }
    }
}