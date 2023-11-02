class Solution {
    public boolean squareIsWhite(String s) {
        int a = s.charAt(0);
        int b = s.charAt(1);

        if((a%2!=0 && b%2==0) || (a%2==0 && b%2!=0)) return true;
        else return false;
    }
}