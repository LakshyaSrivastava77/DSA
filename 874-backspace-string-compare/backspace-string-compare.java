class Solution {
    public boolean backspaceCompare(String s, String t) {
        int idxS = s.length()-1, idxT = t.length()-1;
        int backS = 0, backT = 0;
        boolean isSEmp = false, isTEmp = false;

        while (idxS >= 0 && idxT >= 0) {
            char charS = s.charAt(idxS), charT = t.charAt(idxT);

            if (charS == '#') {backS++; idxS--; continue;}
            if (charT == '#') {backT++; idxT--; continue;}

            if (backS > 0) {idxS--; backS--; continue;}
            if (backT > 0) {idxT--; backT--; continue;}

            if (charS == charT) {
                idxS--;
                idxT--;
                continue;
            } else {
                return false;
            }
        }

        while (idxS >= 0) {
            char charS = s.charAt(idxS);
            if (charS == '#') {
                backS++;
                idxS--;
                continue;
            }
            if (backS > 0) {
                backS--;
                idxS--;
                continue;
            }
            return false;
        }

        while (idxT >= 0) {
            char charT = t.charAt(idxT);
            if (charT == '#') {
                backT++;
                idxT--;
                continue;
            }
            if (backT > 0) {
                backT--;
                idxT--;
                continue;
            }
            return false;
        }
        
        return true;
    }
}