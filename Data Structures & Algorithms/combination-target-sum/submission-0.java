class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTracking(nums, target, current, 0);
        return res;
    }
    public void backTracking(int[] nums, int target, List<Integer> current, int i)
    {
        if(target == 0)
        {
            res.add(new ArrayList(current));
            return;
        }

        if(target < 0 || i >= nums.length )
        {
            return;
        }

        current.add(nums[i]);
        backTracking(nums, target - nums[i], current, i);
        current.remove(current.size() - 1);
        backTracking(nums, target, current, i + 1);
    }
}
