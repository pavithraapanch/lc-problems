package mediumLC;


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
     * lCA2 -> Both p and q exists in the tree.
     * Solution---->
     *
     */

}
