class Solution {
    public List<List<String>> partition(String s) {
        List<String> arr = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        partition(0, s, arr, ans);
        return ans;
    }

    private void partition(int index, String str, List<String> arr, List<List<String>> ans) {
        if(index == str.length()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = index; i < str.length(); i++) {
            String s = str.substring(index, i+1);
            if(isPalindrome(s)) {
                arr.add(s);
                partition(i + 1, str, arr, ans);
                arr.remove(arr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length()-1;

        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++; j--;
        }

        return true;
    }
}

// TC: O(N * 2^N)
// SC: O(N * 2^N)