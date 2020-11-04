import data.BinaryTreeNode;

// https://www.interviewcake.com/question/java/second-largest-item-in-bst
public class SecondLargestInTree {

    public static BinaryTreeNode findSecondLargest(BinaryTreeNode root) {

        if (root == null) {
            throw new RuntimeException("root must not be null");
        }

        if (root.getLeft() == null && root.getRight() == null) {
            throw new RuntimeException("need at least 2 nodes");
        }

        final LargestResult result = findLargest(null, root);
        final BinaryTreeNode largest = result.getLargest();

        if (largest.getLeft() != null) {
            return findLargest(largest, largest.getLeft()).getLargest();
        } else {
            return result.getParent();
        }

    }

    private static LargestResult findLargest(BinaryTreeNode parent, BinaryTreeNode node) {
        if (node.getRight() != null) {
            return findLargest(node, node.getRight());
        }
        return new LargestResult(node, parent);
    }

    private static class LargestResult {
        private final BinaryTreeNode largest;
        private final BinaryTreeNode parent;

        private LargestResult(BinaryTreeNode largest, BinaryTreeNode parent) {
            this.largest = largest;
            this.parent = parent;
        }

        public BinaryTreeNode getLargest() {
            return largest;
        }

        public BinaryTreeNode getParent() {
            return parent;
        }
    }

}
