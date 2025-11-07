class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);

        while(i <= j) {
            int capacity = people[i] + people[j];
            if(capacity <= limit) {
                boat++;
                i++; j--;
            }
            else {
                boat++; j--;
            }
        }
        
        return boat;
    }
}
/*

TC: O(n log n)
SC: O(1)

*/