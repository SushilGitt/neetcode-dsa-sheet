/*

Brute force: find if two elements are same?

--> Using two nested loops

--> TC: O(n²)
--> SC: O(1)

 */

public boolean containsDuplicate(int[] nums) {
    for(int i = 0; i < nums.length-1; i++) {
        for(int j = i+1; j < nums.length; j++) {
            if(nums[i] == nums[j]) {
                return true;
            }
        }
    }

    return false;
}
// -----------------------------------------------------------------------------
/*

Better: Sorting 

--> Sort the array and check if two adjacent are same.

--> TC: O(n log n)
--> SC: O(1)

*/
public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);

    for(int i = 0; i < nums.length-1; i++) {
        if(nums[i] == nums[i+1]) {
            return true;
        }
    }
    return false;
}
// -----------------------------------------------------------------------------

/*

Optimal: Using Set and HashMap
--> Set: Put one by one elements into set and check set contains this number.
--> HashMap: Count frequency of numbers.

--> TC: O(n)
--> SC: O(n)

 */

public boolean containsDuplicate(int[] nums) {
    Set<Integer> numSet = new HashSet<>();

    for(int i : nums) {
        if(numSet.contains(i)) {
                return true;
        }
        numSet.add(i);
    }

    return false;
}