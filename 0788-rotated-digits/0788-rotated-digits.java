class Solution {
    int[] available = new int[]{0,1,2,5,6,8,9};
    int[] swaps = new int[]{2,5,6,9};
    public int rotatedDigits(int n) {
        List<Integer> arr = new ArrayList();
        int a = n;
        while(a > 0){
            arr.add(a % 10);
            a/=10;
        }
        int[] nums = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            nums[i] = arr.get(arr.size() - 1 - i);
        }
        return g(nums,0, false);
    }
    int g(int[] A, int index, boolean allowed){
        int ans = 0;
        if(index == A.length - 1){
            for(int i = 0; i <  available.length && available[i] <= A[index]; i++){
                if(swapsToDifferent(available[i]) || allowed) {
                    ans++;
                }
            }
        }else{
            for(int i = 0; i <  available.length && available[i] <= A[index]; i++){
                if(available[i] == A[index]){
                    int res = g(A, index + 1, allowed || swapsToDifferent(A[index]));
                    ans += res;
                }else{
                    int res = f(A.length - index - 1, allowed || swapsToDifferent(available[i]));
                    ans += res;
                }
            }
        }
        return ans;
    }
    boolean swapsToDifferent(int number){
        for(int i : swaps){
            if(number == i) return true;
        }
        return false;
    }
    int f(int digits, boolean swapsToDifferent){
        if(digits == 0) return 0;
        if(digits == 1 && !swapsToDifferent) return 4;
        if(digits == 1 && swapsToDifferent) return 7;
        if(digits == 2 && !swapsToDifferent) return 40;
        if(digits == 2 && swapsToDifferent) return 49;
        if(digits == 3 && !swapsToDifferent) return 316;
        if(digits == 3 && swapsToDifferent) return 343;
        return -1;
    }
}