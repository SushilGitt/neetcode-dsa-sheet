/*

Brute force: 

--> Use two nested loops to check all pairs.
--> TC: O(n²)
--> SC: O(1)

*/
public int[] twoSum(int[] nums, int target) {
    for(int i = 0; i < nums.length-1; i++) {
        for(int j = i+1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) {
                return new int[] {i, j};
            }
        }
    }

    return new int[] {0, 0};
}
// -----------------------------------------------------------------------------

/*

Better:

--> Store values with their indices in a separate array.
--> Sort the array based on values.
--> Use two pointers to find the target sum.

--> TC: O(n log n)
--> SC: O(n)
*/

// -----------------------------------------------------------------------------

/*

Optimal:

--> Use a HashMap to store numbers and their indices.
--> For each element, check if the complement (target - current) exists in the map.

--> TC: O(n) --> Array traversal
--> SC: O(n) --> Use of Map of n size

*/


public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if(numsMap.containsKey(rem) && numsMap.get(rem) != i) {
                return new int[] {numsMap.get(rem), i};
            }
            numsMap.put(nums[i], i);
        }
        
        return new int[] {0, 0};
}