class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int half = (nums1.length + nums2.length + 1) / 2;
        int l = 0;
        int r = nums1.length;
        while (l <= r) {
            int m1 = l + (r - l) / 2;
            int m2 = half - m1;
            int l1 = m1 > 0 ? nums1[m1 - 1] : Integer.MIN_VALUE;
            int l2 = m2 > 0 ? nums2[m2 - 1] : Integer.MIN_VALUE;

            int r1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
            int r2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }
        return -1;
    }
}
