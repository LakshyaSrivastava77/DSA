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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(lst, root, 0);
        return lst;
    }

    private void helper(List<Integer> lst, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == lst.size()) lst.add(root.val);
        else lst.set(depth, root.val);

        helper(lst, root.left, depth+1);
        helper(lst, root.right, depth+1);
    }
}