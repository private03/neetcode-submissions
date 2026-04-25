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
        return guessNumberHelper(0, n);
        
    }

    public int guessNumberHelper(int s, int e)
    {
        int m = s + (e - s) / 2;
        
        if(guess(m) > 0)
        {
            return guessNumberHelper(m + 1, e);
        }
        else if (guess(m) < 0)
        {
            return guessNumberHelper(s, m - 1);
        }
        else
        {
            return m;
        }
    }
}