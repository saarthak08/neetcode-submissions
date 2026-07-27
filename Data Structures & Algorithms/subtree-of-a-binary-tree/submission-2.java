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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (matchSubTree(root, subRoot)) {
                return true;
            }
        }
        boolean leftMatch = isSubtree(root.left, subRoot);
        boolean rightMatch = isSubtree(root.right, subRoot);
        return leftMatch || rightMatch;
    }

    public boolean matchSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                return matchSubTree(root.left, subRoot.left)
                    && matchSubTree(root.right, subRoot.right);
            }
            return false;
        }
        {
            return false;
        }
    }
}
