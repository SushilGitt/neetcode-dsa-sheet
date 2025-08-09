class Solution {
    public String simplifyPath(String path) {
        path += "/";
        String str = "";
        ArrayDeque <String> s = new ArrayDeque<>();

        for(char c : path.toCharArray()) {
            if(c == '/' && str.length() > 0) {
                if(str.equals("..")) {
                    if(!s.isEmpty()) {
                        s.poll();
                    }
                }
                else if(!str.equals(".")){
                    s.push(str);
                }
                str = "";
            }
            else {
                if(c != '/') {
                    str += c;
                }
            }
        }

        if(s.isEmpty()) { return "/"; }

        str = "";
        while(!s.isEmpty()) {
            str += "/" + s.pollLast();
        }

        String[] str1 = str.split("/");

        return String.join("/", str1);
    }
}

/*

TC: O(n²) worst case due to repeated string concatenation.
    Optimized (with StringBuilder): O(n).

SC: O(n)

*/