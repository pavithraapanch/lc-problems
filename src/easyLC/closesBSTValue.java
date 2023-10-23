package easyLC;

import mediumLC.TreeNode;

public class closesBSTValue {

    public int closestBinarySearchTreeValue(TreeNode root, double target){
        int val, closest = root.val;
        while(root != null){
            val = root.val;
            double currDiff = Math.abs(val - target);
            double prevDiff = Math.abs(closest - target);
            if(currDiff <= prevDiff){
                if(currDiff == prevDiff){
                    closest = Math.min(closest, val);
                }else{
                    closest = val;
                }
            }
            if(val > target){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return closest;
    }
}
