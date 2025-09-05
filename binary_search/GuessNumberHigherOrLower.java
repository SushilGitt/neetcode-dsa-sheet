public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int num = guess(mid);

            if(num == -1) {
                high = mid - 1;
            }
            else if(num == 1) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return n;
    }
}

// TC: O(log n)
// SC: O(1)