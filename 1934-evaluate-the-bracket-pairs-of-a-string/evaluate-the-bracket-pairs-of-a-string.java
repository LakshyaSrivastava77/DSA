class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder str = new StringBuilder();
        String key = "";
        int left = 0, right = 0;
        boolean hasLeft = false;

        HashMap<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> pairs : knowledge) {
            map.put(pairs.get(0), pairs.get(1));
        }

        if (s.charAt(0) != '(') str.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i-1), curr = s.charAt(i);
            if (prev == '(') {
                left = i;
                hasLeft = true;
            }

            if (curr == ')' && hasLeft == true) {
                right = i;
                key = s.substring(left, right);
                str.append(map.getOrDefault(key, "?"));
                hasLeft = false;
                continue;
            }

            if (curr != '(' && !hasLeft) {
                str.append(curr);
            }
        }

        return str.toString();
    }
}