class Solution {
    int result = -1;
    int cnt = 0;

    public int kthLargest(Node root, int k) {
        reverseInorder(root, k);
        return result;
    }

    public void reverseInorder(Node root, int k) {
        if (root == null || cnt >= k) return;

        reverseInorder(root.right, k);

        cnt++;
        if (cnt == k) {
            result = root.data;
            return;
        }

        reverseInorder(root.left, k);
    }
}