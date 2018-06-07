package com.yzc;

// https://blog.csdn.net/ljiabin/article/details/40620579
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++ ) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            find(nums, i + 1, nums.length - 1, nums[i]);
        }

        return res;
    }

    private void find(int[] nums, int l, int r, int num) {
        while (l < r) {
            if (nums[l] + nums[r] + num == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(list);

                while (l < r && nums[l] == nums[l+1]) l++;
                while (l < r && nums[r] == nums[r-1]) r--;

                l++;
                r--;
            } else if (nums[l] + nums[r] + num < 0) {
                l++;
            } else if (nums[l] + nums[r] + num > 0) {
                r--;
            }

        }
    }
}