public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j <  nums.length; j++){
                if(i == j){
                    continue;
                }
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
                else {
                    return new int[]{-1, -1};
                }
            }
        }
    }
    
    public static void main (String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
