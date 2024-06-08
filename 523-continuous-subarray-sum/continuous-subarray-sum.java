class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
     HashMap<Integer,Integer> map = new HashMap <>();
     map.put(0,-1);
     int sum = 0;
     for(int i= 0 ; i<nums.length;i++){
        sum+=nums[i];
        if(map.containsKey(sum%k)){
            int index =map.get(sum%k);
            if(i-index>=2){
                return true;
            }
        }
        else{
            map.put(sum%k,i);//store first occurence 
        }
      
        
    }
      return false;
    }
}