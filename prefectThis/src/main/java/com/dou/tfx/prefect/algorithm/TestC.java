package com.dou.tfx.prefect.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2023/2/17 18:07
 */
public class TestC {
    public static void main(String[] args) {
        TestC testC = new TestC();
        //ZipUtil.zip("d:/aaa");
        //testC.climbStairs(35);
        //int aaa = testC.fib(20);
        //System.out.println(aaa);
        //int bbb = testC.fib1(20);
        //System.out.println(bbb);
        //System.out.println(5/2);
        int[] arr = {4, -3, -7, 0,-10};
        int[] arr2 = {10};
        testC.findTheDistanceValue(arr,arr2,69);

    }

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap();
        double b;
        double k = Double.parseDouble(String.valueOf(n));
        for (int a = 0; a <= n; a++) {
            double l = Double.parseDouble(String.valueOf(a));
            b = (k - l) / 2;
            if (Math.round(b) == b) {
                map.put(a, Integer.valueOf(String.valueOf(Math.round(b))));
            }
        }
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            if (entry.getKey() == 0 || entry.getValue() == 0) {
                c = c + 1;
            } else {
                c = c + combination(entry.getKey(), entry.getKey() + entry.getValue());
            }

        }
        System.out.println(c);
        return c;

    }

    public int factorial(int n) {
        int sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    public int arrangement(int m, int n) {
        return m <= n ? factorial(n) / factorial(n - m) : 0;

    }

    public int combination(int m, int n) {
        return m < n ? factorial(n) / (factorial(n - m) * factorial(m)) : 0;
    }

    public int titleToNumber(String columnTitle) {
        int zz = 0;
        for (int i = 1; i < columnTitle.length(); i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            zz = zz * 26 + num;
        }
        return zz;

    }

    //给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
    //
    //下述是从好到坏你可能持有的 手牌类型 ：
    //
    //"Flush"：同花，五张相同花色的扑克牌。
    //"Three of a Kind"：三条，有 3 张大小相同的扑克牌。
    //"Pair"：对子，两张大小一样的扑克牌。
    //"High Card"：高牌，五张大小互不相同的扑克牌。
    //请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
    //
    //注意：返回的字符串 大小写 需与题目描述相同。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/best-poker-hand
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public String bestHand(int[] ranks, char[] suits) {
        int a = 0;
        for (int i = 0; i < suits.length - 1; i++) {
            if (suits[i] == suits[i + 1]) {
                a = a + 1;
            }
        }
        if (a == suits.length - 1) {
            return "Flush";
        }
        int b = 0;
        int c = 0;
        for (int j = 0; j < ranks.length; j++) {
            int jj = 0;
            for (int k = 0; k < ranks.length; k++) {
                if (j == k) {
                    continue;
                }
                if (ranks[j] == ranks[k]) {
                    jj = jj + 1;
                }
            }
            if (jj >= 3) {
                b = b + 1;
            }
            if (jj >= 2) {
                c = c + 1;
            }

        }
        if (b > 0) {
            return "Three of a Kind";
        }
        if (c > 0) {
            return "Pair";
        }
        return "High Card";
    }

    public int search(int[] nums, int target) {
        int md = nums.length / 2;
        if (nums[md] > target) {
            if (nums[0] < target) {
                return -1;
            }
            ArrayList<Integer> newNums = new ArrayList<>();
            for (int i = 0; i < md; i++) {
                newNums.add(nums[i]);
            }
            return search(newNums.stream().mapToInt(Integer::valueOf).toArray(), target);
        }
        if (nums[md] < target) {
            if (nums[nums.length - 1] > target) {
                return -1;
            }
            ArrayList<Integer> newNums = new ArrayList<>();
            for (int i = md; i < nums.length; i++) {
                newNums.add(nums[i]);
            }
            return search(newNums.stream().mapToInt(Integer::valueOf).toArray(), target);
        }
        if (nums[md] == target) {
            return md;
        }
        return -1;
    }

    /**
     * splitAry方法<br>
     *
     * @param ary     要分割的数组
     * @param subSize 分割的块大小
     * @return
     */
    public Object[] splitAry(int[] ary, int subSize) {
        int count = ary.length % subSize == 0 ? ary.length / subSize : ary.length / subSize + 1;//要拆分出的数组的个数

        List<List<Integer>> subAryList = new ArrayList<List<Integer>>();

        for (int i = 0; i < count; i++) {//要拆分几个数组就遍历几次
            int index = i * subSize;
            List<Integer> list = new ArrayList<Integer>();
            int j = 0;
            while (j < subSize && index < ary.length) {
                list.add(ary[index++]);
                j++;
            }
            subAryList.add(list);
        }

        Object[] subAry = new Object[subAryList.size()];

        for (int i = 0; i < subAryList.size(); i++) {
            List<Integer> subList = subAryList.get(i);
            int[] subAryItem = new int[subList.size()];
            for (int j = 0; j < subList.size(); j++) {
                subAryItem[j] = subList.get(j).intValue();
            }
            subAry[i] = subAryItem;
        }

        return subAry;
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    public int peakIndexInMountainArray(int[] arr) {
        // 程序走到这里一定有 nums[len - 1] >= target，插入位置在区间 [0..len - 1]
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                left = mid;
                break;
            } else if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                right = mid;
            } else if (arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                left = mid;
            }
        }
        return left;
    }


    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        boolean flag = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long aaa = (long) mid * mid;
            if (aaa > num) {
                right = mid - 1;
            } else if (aaa < num) {
                left = mid + 1;
            } else {
                flag = true;
                break;
            }


        }
        return flag;
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (left - right) / 2;
            long aaa = (long) mid * mid;
            if (aaa < x) {
                ans = mid;
                left = mid + 1;
            } else if (aaa > x) {
                right = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    //你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
    //
    //给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode.cn/problems/arranging-coins
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //抹0法
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            //防止内存溢出写法 抹0法
            int mid = left + (right - left) / 2;
        }
        return 1;
    }

    public int fib(int n) {
        HashMap<Integer, Integer> aaa = new HashMap<>();
        return help(aaa, n);
    }

    public int help(HashMap<Integer, Integer> map, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        map.put(n, help(map, n - 1) + help(map, n - 2));
        return map.get(n);
    }

    public int fib1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        return help(dp, n);
    }

    public int help(int[] dp, int n) {
        if (n == 0) {
            return dp[0];
        }
        if (n == 1) {
            return dp[1];
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = help(dp, n - 1) + help(dp, n - 2);
        return dp[n];
    }

    public void aaa(int[] arr2) {
        //排序
        for (int i = 1; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length - i; j++) {
                if (arr2[j + 1] < arr2[j]) {
                    int temp = 0;
                    temp = arr2[j + 1];
                    arr2[j + 1] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        for (int n = 0; n < arr2.length; n++) {
            System.out.println(arr2[n]);
        }
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //冒泡排序
        for (int i = 1; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length - i; j++) {
                if (arr2[j + 1] < arr2[j]) {
                    int temp = 0;
                    temp = arr2[j + 1];
                    arr2[j + 1] = arr2[j];
                    arr2[j] = temp;
                }
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < arr1.length; k++) {
            int target = arr1[k];
            int index = helpFindTheDistanceValue(arr2, target);
            if (index == 0) {
                int bbb = 1;
                if(arr2.length ==1 ){
                    bbb = 0;
                }

                if (Math.abs(target - arr2[bbb]) > d) {
                    list.add(index);
                }
            } else if (index >= arr2.length - 1) {
                if (Math.abs(target - arr2[arr2.length - 1]) > d) {
                    list.add(index);
                }

            } else if (index > 0 && index < arr2.length - 1) {
                if (Math.abs(target - arr2[index]) > d && Math.abs(target - arr2[index + 1]) > d) {
                    list.add(index);
                }
            }


        }
        return list.size();
    }

    public int helpFindTheDistanceValue(int[] arr2, int target) {
        //有序 二分 寻找数组1在数组2中的插入位置
        int left = 0;
        int right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr2[mid] > target) {
                right = mid - 1;
            } else if (arr2[mid] < target) {
                left = mid + 1;
            } else if (arr2[mid] == target) {
                //不返回锁定左边界
                right = mid - 1;
            }
        }
        ////最后检查left越界情况
        //if (left >= arr2.length || arr2[left] != target) {
        //    return -1;
        //}
        return left;
    }
}
