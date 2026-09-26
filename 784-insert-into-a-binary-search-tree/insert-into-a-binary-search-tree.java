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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode newNode = new TreeNode(val);
        TreeNode curr = root, parCurr = null;

        while (curr != null) {
            parCurr = curr;
            if (curr.val > val) curr = curr.left;
            else curr = curr.right;
        }

        if (parCurr.val > val) parCurr.left = newNode;
        else parCurr.right = newNode;

        return root;
    }
}