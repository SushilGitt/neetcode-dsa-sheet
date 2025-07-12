/*

Brute force: 

--> Use hashmap to keep track of frequency of each element
--> And return element(frequency) > n/3 times

--> TC: O(n)
--> SC: O(n)

*/
// -----------------------------------------------------------------------------

/*

Optimal:

--> Use Boyer-moore algorithm 
--> TC: O(n)
--> SC: O(1)

*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int freq1 = 0, freq2 = 0, num1 = 0, num2 = 0;

        for(int num:nums) {
            if(num == num1) {
                freq1++;
            }
            else if(num == num2) {
                freq2++;
            }
            else if(freq1 == 0) {
                num1 = num;
                freq1++;
            }
            else if(freq2 == 0) {
                num2 = num;
                freq2++;
            }
            else {
                freq1--;
                freq2--;
            } 
        }

        return isMajorityValid(nums, num1, num2);
    }

    private List<Integer> isMajorityValid(int[] nums, int num1, int num2) {

        List<Integer> ans = new ArrayList<>();
        int freq1 = 0, freq2 = 0;

        for(int num:nums) {
            if(num == num1) {
                freq1++;
            }
            else if(num == num2) {
                freq2++;
            }
        }

        if(freq1 > nums.length / 3) {
            ans.add(num1);
        }

        if(freq2 > nums.length / 3 && num1 != num2) {
            ans.add(num2);
        }
        
        return ans;
    }
}