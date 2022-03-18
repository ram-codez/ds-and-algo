package com.ramz.code.funda;
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorz(root.left, root.right);
    }

    public boolean isMirrorz(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val
                && isMirrorz(left.right, right.left)
                && isMirrorz(left.left, right.right);


    }
}