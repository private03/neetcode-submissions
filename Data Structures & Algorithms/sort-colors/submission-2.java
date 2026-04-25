class Solution {
    public void sortColors(int[] nums) {

        int[] count = {0, 0, 0};

        for(int i : nums)
        {
            count[i] += 1;
        }
        
        int index = 0;
        for(int n = 0; n < count.length; n++)
        {
            for(int j = 0; j < count[n]; j++)
            {
                nums[index] = n; 
                index++;
            }
        }
    }
}