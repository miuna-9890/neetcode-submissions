class TimeMap {
    HashMap<String, List<Object[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Object[]> ls = new ArrayList<>();
        if (!map.containsKey(key)) {
            map.put(key, ls);
        } 
        map.get(key).add(new Object[]{value, timestamp});
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } 
        List<Object[]> ls = map.get(key);
        int l = 0;
        int r = ls.size() - 1;
        String result = "";
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int stamp = (int) ls.get(mid)[1];
            String val = (String) ls.get(mid)[0];
            if (stamp <= timestamp) {
                result = val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
