class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> ls = new ArrayList<>();
        if (!map.containsKey(key)) {
            map.put(key, ls);
        } 
        map.get(key).add(new Pair<>(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } 
        List<Pair<Integer, String>> ls = map.get(key);
        int l = 0;
        int r = ls.size() - 1;
        String result = "";
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int stamp = (int) ls.get(mid).getKey();
            String val = (String) ls.get(mid).getValue();
            if (stamp <= timestamp) {
                result = val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V val) {
            this.key = key;
            this.value = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
