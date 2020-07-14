package com.dou.tfx.prefect.algorithm;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/27 17:06
 */
public class BinarySearchTest {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
