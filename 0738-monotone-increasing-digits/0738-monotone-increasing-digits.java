class Solution {
    public int monotoneIncreasingDigits(int n) {
        int[] digits = new int[10];
        int num = n;
        int index = 0;

        while(n > 0){
            digits[index++] = n % 10;
            n /= 10;
        }
        int start = 0, len = index;
        int end = len - 1;
        while(start < end){
            int d = digits[start];
            digits[start++] = digits[end];
            digits[end--] = d;
        }
        int i = 1;
        for(;i < len;i++){
            if(digits[i - 1] > digits[i]) break;
        }
        if(i == len) return num;
        i--;
        while(i > 0 && digits[i - 1] == digits[i]){
            i--;
        }
        digits[i++]--;
        while(i < len) digits[i++] = 9;
        int ans = 0;
        for( i = 0;i < len;i++) ans = ans * 10 + digits[i];
        return ans;
    }
}