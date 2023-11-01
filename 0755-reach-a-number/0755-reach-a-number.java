class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int start=1,end=target,mid,steps=0,pos=0;
        long sum=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            sum=(long)mid*(mid+1)/2;
            if(sum>=target)
                {
                    pos=(int)sum;
                    steps=mid;
                    end=mid-1;
                }
            else
                start=mid+1;
        }
        while((pos-target)%2!=0)
        {
            steps++;
            pos+=steps;
        }
        return steps;
    }
}