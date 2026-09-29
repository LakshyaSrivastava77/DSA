class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] > 9){
                carry = digits[i] / 10;
                digits[i] %= 10;
            } else {
                carry = 0;
                break;
            }
        }
        if (carry == 0) return digits;

        int[] newArr = new int[digits.length+1];
        newArr[0] = carry;
        for (int i = 1; i < newArr.length; i++) {
            newArr[i] = digits[i-1];
        }
        return newArr;
    }
}