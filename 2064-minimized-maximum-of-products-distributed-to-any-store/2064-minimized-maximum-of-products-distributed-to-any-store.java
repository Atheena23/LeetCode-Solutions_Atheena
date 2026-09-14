class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for(int quantity:quantities){
            high = Math.max(high,quantity);
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int stores = 0;
            for(int quantity:quantities){
                stores+=(quantity+mid-1)/mid;
                if(stores>n){
                    break;
                }
            }
            if(stores<=n){
                high = mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}