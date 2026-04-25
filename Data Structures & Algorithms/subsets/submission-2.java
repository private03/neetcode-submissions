class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList res = new ArrayList<>();
        ArrayList subset = new ArrayList<>();
        dfs(res, subset, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int n)
    {
        if(n >= nums.length)
        {
            List<Integer> copy = new ArrayList<>(subset);
            res.add(copy);
            return;

        }
        subset.add(nums[n]);
        dfs(res, subset, nums, n + 1);
        subset.remove(subset.size() - 1);
        dfs(res, subset, nums, n + 1);
    }
}
