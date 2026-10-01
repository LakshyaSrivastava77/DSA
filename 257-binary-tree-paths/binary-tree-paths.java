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
        StringBuilder sb = new StringBuilder();
        List<String> lst = new ArrayList<String>();

        pathFinder(lst, sb, root);
        return lst;
    }

    private void pathFinder (List<String> lst, StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }

        int n = sb.length();

        if (n== 0) sb.append(root.val);
        else sb.append("->" + root.val);

        if (root.left == null && root.right == null) {
            lst.add(sb.toString());
            sb.delete(n , sb.length());
            return;
        }

        if (root.left != null) {
            pathFinder(lst, sb, root.left);
        }
        if (root.right != null) {
            pathFinder(lst, sb, root.right);
        }
        sb.delete(n , sb.length());
    }
}