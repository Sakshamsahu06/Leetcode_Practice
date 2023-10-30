class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        int numDigitsInInterval = 9;

        while (n - numDigitsInInterval > 0) {
            n -= numDigitsInInterval;
            digit += 1;
            numDigitsInInterval = 9 * (int) Math.pow(10, digit - 1) * digit;
            
            if (numDigitsInInterval < 0) break;
        }

        int base = (int) Math.pow(10, digit - 1);
        int number = base + (n - 1) / digit;

        char digitInNumber = String.valueOf(number).charAt((n - 1) % digit);

        return digitInNumber - '0';
    }
}
