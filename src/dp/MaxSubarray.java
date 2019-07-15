package dp;

public class MaxSubarray {



    public static int maxSubarrSum(int[] arr) {
        int curSum = 0, maxSum = 0;

        curSum = arr[0];
        maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curSum = curSum + arr[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }

            if (curSum < 0) {
                curSum = arr[i];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,-7,5,2,-1,2,-4,3};
        System.out.println(maxSubarrSum(arr));
    }
}
