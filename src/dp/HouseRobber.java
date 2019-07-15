package dp;

/**
 * House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * 本质：求数组不相邻元素最大和
 * 动态规划（背包问题）：设P[i]表示从0~i个房间抢劫的最大收益。
 */
public class HouseRobber {
    public static int maxPackage(int[] packageList) {
        int size = packageList.length;
        int[] result = new int[size];

        result[0] = packageList[0];
        result[1] = Math.max(packageList[0], packageList[1]);

        for (int i = 2; i < size; i++) {
            result[i] = Math.max(packageList[i] + result[i - 2], result[i - 1]);
        }

        return result[size - 1];
    }

    public static int rob(int[] packageList) {
        if (packageList == null || packageList.length == 0) {
            return 0;
        }

        int size = packageList.length;
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(left + packageList[i], right);
            left = right;
            right = max;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] packageList = new int[]{12, 23, 45, 24, 100, 22, 9};
        System.out.println(maxPackage(packageList));
        System.out.println(rob(packageList));
    }
}
