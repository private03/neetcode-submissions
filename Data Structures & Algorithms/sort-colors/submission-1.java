class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int i : nums)
        {
            count[i] += 1;
        }

        int i = 0;
        for(int n = 0; n < count.length; n++)
        {
            for(int j = 0; j < count[n]; j++)
            {
                 nums[i++] = n;
            }
        }
    }
}