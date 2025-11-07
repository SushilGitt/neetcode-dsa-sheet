public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> ans = new HashMap<>();

        for(String str:strs) {
            int[] chars = new int[26];
            for(char i:str.toCharArray()) {
                chars[i-'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i:chars) {
                key.append(i).append('#');
            }

            String k = key.toString();
            if(!ans.containsKey(k)) {
                ans.put(k, new ArrayList<>());
            }
            ans.get(k).add(str);
        }

        return new ArrayList<>(ans.values());
    }

/*

--> Create unique keys to find anagrams
--> Put those strings in associated list.

--> n is the number of strings in strs
--> l is the length of each string in strs

TC: O(n.l)
SC: O(n.l)

*/