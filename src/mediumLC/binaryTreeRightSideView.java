package mediumLC;

import java.util.*;

public class binaryTreeRightSideView {

    public static List<Integer> binaryTreeRightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i<size; i++) {
                TreeNode curr = q.remove();
                if(i == size-1)
                    result.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}
