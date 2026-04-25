class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int Row = matrix.length, Col = matrix[0].length;
        int top = 0, bot = Row - 1;
        while(top <= bot)
        {
            int row = (top + bot) / 2;
            if(target < matrix[row][0])
            {
                bot = row - 1;
            }
            else if(matrix[row][Col - 1] < target)
            {
                top = row + 1;
            }
            else
            {
                break;
            }
        }

        if(!(top <= bot))
        {
            return false;
        }

        int row = (top + bot) / 2;
        int l = 0, r = Col - 1;
        while(l <= r)
        {
            int m = l + (r - l) / 2;
            if(matrix[row][m] < target){
                l = m + 1;
            }
            else if(target < matrix[row][m])
            {
                r = m - 1; 
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}
