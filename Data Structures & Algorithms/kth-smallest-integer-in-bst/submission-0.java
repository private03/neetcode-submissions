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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> array = new ArrayList<>();
        array = inorderArray(root, array);
        return array.get(k - 1);

    }

    public List<Integer> inorderArray(TreeNode root, List<Integer> array)
    {
        if(root == null)
        {
            return array;
        }

        inorderArray(root.left, array);
        array.add(root.val);
        inorderArray(root.right, array);

        return array;
    }

}
