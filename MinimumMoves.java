
public class MinimumMovesInArray {

    public static int minMoves(int[] nums) {
        if(nums.length < 2) { return 0; }

        long sum = 0;
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            min = Math.min(min, nums[i]);
        }

        return (int) (sum - (nums.length * min));
    }
}
