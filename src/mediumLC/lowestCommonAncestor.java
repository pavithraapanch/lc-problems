package mediumLC;

import java.util.Map;
import java.util.HashMap;

class lCATreeNode{
    int val;
    lCATreeNode left;
    lCATreeNode right;
    lCATreeNode parent;
    lCATreeNode() {}
    lCATreeNode(int val) { this.val = val; }
    lCATreeNode(int val, lCATreeNode left, lCATreeNode right, lCATreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

public class lowestCommonAncestor {
    /**
     * lCA1 -> Both p and q exists in the tree.
     * Solution---->
     * Case 1:
     * p and q in the same subtree
     * For any levels below in a node, the LCA will the be root.
     * Say root and a node in it's subtree is p and q. Then root will be the LCA.
     * Case 2:
     * p and q in different branches of tree, then root will be LCA.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode curr = root;
        // Checks if the current root (maybe root of subtree) is LCA.
        // Stop search
        // If Case 1: do not search deeper levels, since root will be the LCA, just return root.
        if (curr == p || curr == q || curr == null) return curr;

        TreeNode left = lowestCommonAncestor1(curr.left, p, q);
        TreeNode right = lowestCommonAncestor1(curr.right, p, q);

        if (left != null && right != null) return curr; //found p and q in left and right subcalls, so curr is LCA
        else if (left != null) return left;
        else if (right != null) return right;
        else return null; //couldn't find anything
    }
    /**
     * lCA2 -> p and q may not exists in the tree.
     * *** Extension from lCA1 ***
     * Problem with lCA1 ---->
     * The first solution had this fault;
     * If one node is found, then we do not check subtree for second node. Blindly return the found node, since that will be LCA.
     * If q does not exist in the subtree of p, we will never know.
     * Quote ----->
     * ''This means if we encounter p, we won't explore the subtree as we immediately return.
     * If q does not exist in the subtree of p, we will never know''
     * Solution---->
     * If p or q is the result of the lCA, then once again check if p is in q's subtree or q is in p's subtree.
     * Then compute and return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;

        TreeNode res = lowestCommonAncestor1(root, p, q);
        if(res == p){
            // Search q in the subtree of p; If found(q), then p = LCA, else null
            return lowestCommonAncestor1(p, q, q) != null ? res : null;
        } else if(res == q){
            // Search p in the subtree of q; If found(p), then p = LCA, else null
            return lowestCommonAncestor1(q, p, p) != null ? res : null;
        }
        return res;
    }

    /**
     * lCA2 -> p and q exists in the tree, with a parent pointer. No root is given.
     * *** Not an extension from the lCA1 or lCA2 ***
     * Solution---->
     * 2 Approaches:
     * 1. Use a HashMap
     * Traverse through the parent pointers and fill the hashmap for 'p'.
     * Now, check if the node is found while traversing 'q' and return.
     * TC - O(N), SC - O(N)
     * 2. Cyclic Approach
     * Since we know p and q exists for sure, we keep traversing through the nodes and change the pointer to the head of next to check a cycle.
     * TC - O(N), SC - O(1)
     */
    public lCATreeNode lowestCommonAncestor3_HashMap(lCATreeNode p, lCATreeNode q){
        Map<Integer, lCATreeNode> map = new HashMap<>();
        lCATreeNode p1 = p;
        while(p1 != null){
            map.put(p1.val, p1);
            p1 = p1.parent;
        }
        lCATreeNode p2 = q;
        while(p2 != null){
            if(map.containsKey(p2.val)) return p2;
            p2 = p2.parent;
        }
        return null;
    }

    public lCATreeNode lowestCommonAncestor3_Cyclic(lCATreeNode p, lCATreeNode q){
        lCATreeNode p1 = p;
        lCATreeNode p2 = q;
        while(p1 != p2){
            p1 = (p1 == null) ? q : p1.parent;
            p2 = (p2 == null) ? p : p2.parent;
        }
        return p1;
    }
}
