class Solution {
    public boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        char[] arr = new char[s.length()];
        if(sArr[0] == ']' || sArr[0] == '}' || sArr[0] == ')') return false;

        int idx = 0;
        for (int i = 0 ; i < sArr.length ; i++){
            if(sArr[i] == '(' || sArr[i] == '{' || sArr[i] == '['){
                arr[idx++] = sArr[i];
            } else if (sArr[i] == ')' && idx > 0 && arr[idx-1] == '('){
                idx--;
            } else if (sArr[i] == '}' && idx > 0 && arr[idx-1] == '{'){
                idx--;
            } else if (sArr[i] == ']' && idx > 0 && arr[idx-1] == '['){
                idx--;
            } else {
                return false;
            }
        }
        return (idx == 0);
    }
}