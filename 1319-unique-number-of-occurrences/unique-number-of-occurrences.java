class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());

        return set.size() == map.size();
    }
}