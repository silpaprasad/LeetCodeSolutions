class Solution {
    public  int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> resultHash = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if (resultHash.containsKey(complement)){
                return new int[] { resultHash.get(complement), i}; // prints the value of complement which is the index and i is the index of current element
            }
            resultHash.put(nums[i], i);
        }
        //return empty array if there is no solution
        return new int[] {};
    }


}
