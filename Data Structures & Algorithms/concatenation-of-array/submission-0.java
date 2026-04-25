class Solution {
    public int[] getConcatenation(int[] nums) {  
        int []newNums =  new int[nums.length * 2];

        return duplicateContent(nums, newNums);
    }

    public int[] duplicateContent(int[] nums, int[] newNums)
    {
        if(nums.length == (newNums.length/2))
        {
            int i = 0;
            int n = i;
            do
            {
                newNums[i] = nums[n];
                if(n == ((newNums.length/2)-1))
                {
                    n = 0;
                    n--;
                }
                
                n++;
                i++;
            } while (i < newNums.length);
        }
        return newNums;

    }


}

