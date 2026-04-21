class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // brute force
        // create a result array int[][]
        // nested loop
        // outer loop -> itearte through array of string
        // fix one string , i, create a result array.add(strs(i))
        // inner loop, i + 1 = j,
        // for every string j, if strs[i].sort = strs.[j].sort
        // result array.add(strs(i))
        // final result.add(result array)
        // O(n^2), O(n)

        // Another solution
        // initalize hashmap (strs[i].sort, {strs[i]})
        // iterate through the array, i
        // if key exists, append strs[i] to the map.get(strs[i].sort)
        // if key does not exist, i just create (strs[i].sort, strs[i]
        // initialize a result array, iterate through map.values()
        // append value to result array, return

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] strsToChar = strs[i].toCharArray();
            Arrays.sort(strsToChar);
            String sorted = new String(strsToChar);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
