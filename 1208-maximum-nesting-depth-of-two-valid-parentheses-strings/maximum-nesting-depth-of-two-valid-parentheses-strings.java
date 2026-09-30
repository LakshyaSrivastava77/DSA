class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int count = 0, n = seq.length();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == ')') {
                count--;
                arr[i] = count % 2;
            } else {
                arr[i] = count % 2;
                count++;
            }
        }
        return arr;
    }
}