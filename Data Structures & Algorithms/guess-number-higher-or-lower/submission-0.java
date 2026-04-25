/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return binarySearch(1, n);
        
    }

    public int binarySearch(int l, int r)
    {
        if(l > r)
        {
            return -1;
        }

        int m = l + (r - l) / 2;
        int res = guess(m);
        if(res > 0)
        {
            return binarySearch(m + 1, r);
        }
        else if (res < 0)
        {
            return binarySearch(l, m - 1);
        }
        else
        {
            return m;
        }
    }
}