package dp;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 斐波那契数列的典型应用。
 *
 * 0级台阶：0
 * 1级台阶：1
 * 2级台阶：2
 * 3级台阶：1+2=3
 * 4级台阶：2+3=5
 * ……
 * n级台阶：f(n-2)+f(n-1)=f(n)
 * 注意
 * 不要使用递归，否则遇到大数时，递归太深，容易溢出，同时效率低
 * 最好的方法是定义三个变量（不用建立数组），循环
 */
public class ClimeStair {
    public static int countDifferentPlans(int numOfStairs) {
        int step1 = 1;
        int step2 = 2;
        int step3 = 0;

        if (numOfStairs <= 0) {
            return 0;
        }

        if (numOfStairs == 1) {
            return step1;
        } else if (numOfStairs == 2) {
            return step2;
        } else {
            int cycleCnt = 0;
            while (cycleCnt++ < numOfStairs - 2) {
                step3 = step1 + step2;
                step1 = step2;
                step2 = step3;
            }
        }
        return step3;
    }

    public static void main(String[] args) {
        System.out.println(countDifferentPlans(3));
    }
}
