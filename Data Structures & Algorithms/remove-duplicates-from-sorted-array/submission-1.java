class Solution {
    public int removeDuplicates(int[] nums) {
        // remember the max space capacity for the array designated in the Ram.
        int maxCapacity = nums.length;
        //cycle through each index in the current size of the array.
        for(int i = 0; i < maxCapacity - 1; i++)
        {
            // if it is equal perform the remove middle operations
           if(isEqual(nums[i], nums[i+1]))
           {
            removeMiddle(nums, i, maxCapacity);
            maxCapacity--;
            i--;
           }

        }
        return maxCapacity;    
    }
    // check if the two are the same
    public boolean isEqual(int current, int next)
    {
       if(current == next)
       {
        return true;
       }
       return false;
    }

    public void removeMiddle(int[] nums, int i, int length)
    {
        for (int iter = i + 1; iter < length; iter++)
        {
            nums[iter-1] = nums[iter];
            
            
        }

    }


}