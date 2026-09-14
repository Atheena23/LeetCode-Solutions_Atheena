class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        int minRank = Integer.MAX_VALUE;
        for(int rank:ranks){
            minRank = Math.min(minRank,rank);
        }
        long high = (long)minRank*cars*cars;
        while(low<high){
            long mid = low+(high-low)/2;
            long required = 0;
            for(int rank:ranks){
                required+=(long)Math.sqrt((double)mid/rank);
                if(required>=cars){
                    break;
                }
            }
            if(required>=cars){
                high =mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}