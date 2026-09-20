class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0 , curr = 0 , n = s.length() , left = 0;

        HashSet<Character> set = new HashSet<>();

        for (int i = 0 ; i < n ; i++) {
            if (set.contains(s.charAt(i))) {
                while (left <= i) {
                    set.remove(s.charAt(left));
                    curr--;
                    if (s.charAt(left) == s.charAt(i)) {
                        left++;
                        break;
                    }
                    left++;
                }
                set.add(s.charAt(i));
                curr++;
                longest = Math.max(longest , curr);
                continue;
            }

            curr++;
            longest = Math.max(longest , curr);
            set.add(s.charAt(i));
        }

        return longest;
    }
}