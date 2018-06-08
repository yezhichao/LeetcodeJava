package com.yzc;

// https://blog.csdn.net/ljiabin/article/details/40622607
class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);

        int closestDist = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum < target) {
                    if (target - sum < closestDist) {
                        closestDist = target - sum;
                        res = sum;
                    }
                    l++;
                } else if (sum > target) {
                    if (sum - target < closestDist) {
                        closestDist = sum - target;
                        res = sum;
                    }
                    r--;
                } else {
                    return sum;
                }
            }
        }

        return res;
    }
}