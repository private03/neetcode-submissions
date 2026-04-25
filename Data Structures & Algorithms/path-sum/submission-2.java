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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        return sumHelper(root, targetSum, 0);
    }

    public boolean sumHelper(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }
        boolean result = false;
        currentSum += root.val;

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                return true;
            }
        } else {
            if (root.left != null) {
                if (sumHelper(root.left, targetSum, currentSum)) {
                    result = true;
                }
            }
            if (root.right != null && result != true) {
                if (sumHelper(root.right, targetSum, currentSum)) {
                    result = true;
                }
            }
        }

        return result;

    }
}