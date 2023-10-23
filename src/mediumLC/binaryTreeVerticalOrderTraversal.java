package mediumLC;

import java.util.List;
import java.util.*;
import javafx.util.*;

public class binaryTreeVerticalOrderTraversal {
/*
TC - O(N), due to BFS
SC - O(N), since there can be n keys and n values for each node, when they are in different levels
So, a hashtable with N size to hold the results would be needed
* */
    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        Map<Integer, List<Integer>> nodesMap = new HashMap<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        int min = 0;
        int max = 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> nodePair = queue.poll();
            TreeNode node = nodePair.getKey();
            int col = nodePair.getValue();

            nodesMap.putIfAbsent(col, new LinkedList<>());
            nodesMap.get(col).add(node.val);

            if(node.left != null){
                queue.add(new Pair<>(node.left, col-1));
                min = Math.min(min, col-1);
            }

            if(node.right != null){
                queue.add(new Pair<>(node.right, col+1));
                max = Math.max(max, col+1);
            }
        }

        for(int i = min; i<= max; i++){
            result.add(nodesMap.get(i));
        }

        return result;
    }
}
