class Solution {
    public int removeElement(int[] nums, int val) {
        // get the current capacity
        int capacity = nums.length;
        // loop through the array
        for (int i = 0; i < capacity; ++i)
        {
            // see if the current value is the target
            if(isSame(val, nums[i]))
            {
                // if so do he remove middle function
                removeMiddle(nums, i, capacity);
                // if it is the capacity decreases
                --capacity;
                // sometimes the targeted values are side by side so dont go
                --i;
                
                
    
            }

        }
        return capacity;
    }
}

public boolean isSame(int target, int current)
{
    if(target == current)
    {
        return true;
    }
    return false;
}

public void removeMiddle(int[] nums, int target, int currentLength)
{
    for(int iter = target + 1; iter < currentLength; iter++)
    {
        nums[iter - 1] = nums[iter];

    }
}