class TimeMap {

    HashMap <String, ArrayList <String>> mapStr;
    HashMap <String, ArrayList <Integer>> mapTime;

    public TimeMap() {
        mapStr = new HashMap<>();
        mapTime = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mapStr.putIfAbsent(key, new ArrayList<>());
        mapTime.putIfAbsent(key, new ArrayList<>());

        mapStr.get(key).add(value);
        mapTime.get(key).add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        if(!mapStr.containsKey(key)) {
            return "";
        }

        int index = getTimeIndex(mapTime.get(key), timestamp);
        return (index == -1) ? "" : mapStr.get(key).get(index);
    }

    private int getTimeIndex(ArrayList<Integer> list, int time) {
        int index = -1,
            min = 0,
            max = list.size() - 1;

            while(min <= max) {
                int mid = min + (max - min) / 2;
                if(list.get(mid) <= time) {
                    index = mid;
                    min = mid + 1;
                }
                else {
                    max = mid - 1;
                }
            }

            return index;
    }
}

// TC: O(log(m))
// SC: O(n)