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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        return inorderHelper(root, array);
    }

    public List<Integer> inorderHelper(TreeNode root, List<Integer> array)
    {
        if(root == null)
        {
            return array;
        }

        inorderHelper(root.left, array);
        array.add(root.val);
        inorderHelper(root.right, array);

        return array;
    }
}