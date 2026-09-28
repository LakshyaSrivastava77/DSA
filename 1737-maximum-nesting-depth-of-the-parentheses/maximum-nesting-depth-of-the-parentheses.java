class Solution {
    public int maxDepth(String s) {
        int depth = 0, n = s.length(), maxDep = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') depth++;
            else if (ch == ')') depth--;

            maxDep = Math.max(depth, maxDep);
        }

        return maxDep;
    }
}