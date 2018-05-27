package com.yzc;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mergeLen = len1 + len2;

        int[] merge = new int[mergeLen];
        
        int mergeEnd = merge.length - 1;
        int end1 = len1 - 1;
        int end2 = len2 - 1;

        if (len1 == 0) {
            merge = nums2;
        } else if (len2 == 0) {
            merge = nums1;
        } else {
            while (end1 >= 0 && end2 >= 0) {
                if (nums1[end1] < nums2[end2]) {
                    merge[mergeEnd] = nums2[end2];
                    end2--;
                    mergeEnd--;
                } else {
                    merge[mergeEnd] = nums1[end1];
                    end1--;
                    mergeEnd--;
                }
            }
            while (end1 >= 0) {
                merge[mergeEnd] = nums1[end1];
                end1--;
                mergeEnd--;
            }
            while (end2 >= 0) {
                merge[mergeEnd] = nums2[end2];
                end2--;
                mergeEnd--;
            }
        }
        if ((len1 + len2) % 2 == 1) {
            // 奇数
            return merge[mergeLen / 2];
        } else {
            // 偶数
            return (double) (merge[mergeLen / 2 - 1] + merge[mergeLen / 2]) / 2;
        }
    }
}