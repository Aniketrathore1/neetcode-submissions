/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int preIndex = 0;
    private HashMap<Integer , Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        return build(preorder , 0 , inorder.length-1);
    }

    private TreeNode build(int[] preorder , int left , int right){
        if(left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode newRoot = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        newRoot.left = build(preorder , left , mid-1);
        newRoot.right = build(preorder , mid+1 , right);

        return newRoot;
    }
}
