class Solution {
    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long target = ((long) mid*(mid+1))/2;
            if (target == n) return mid;
            else if (target > n) end = mid - 1;
            else start = mid +1;
        }
        return end;   
    }
}