package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        PostOrderTraversal obj = new PostOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> list = obj.postorderOneStackIterativeTraversal(root);
        for(int x : list)
            System.out.println(x);
    }

    public List<Integer> postorderRecursiveTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null)
                list.addAll(postorderRecursiveTraversal(root.left));
            if (root.right != null)
                list.addAll(postorderRecursiveTraversal(root.right));
            list.add(root.val);
        }
        return list;
    }
//    1
//   4 3
//  2
    public List<Integer> postorderTwoStackIterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
           Stack<TreeNode> st = new Stack();
           Stack<TreeNode> reverseResult = new Stack();
           st.push(root);
           while (!st.isEmpty()) {
               TreeNode temp = st.pop();
               reverseResult.push(temp);
               if (temp.left != null)
                   st.push(temp.left);
               if (temp.right != null)
                  st.push(temp.right);
           }
           while(!reverseResult.isEmpty())
              result.add(reverseResult.pop().val);
       }
      return result;
    }

    public List<Integer> postorderOneStackIterativeTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> st = new Stack();
            do {
                while (root != null) {
                    if(root.right != null)
                        st.push(root.right);
                    st.push(root);
                    root = root.left;
                }
                root = st.pop();
                if (!st.isEmpty() && root.right != null && root.right == st.peek()) {
                    st.pop();
                    st.push(root);
                    root = root.right;
                } else {
                    result.add(root.val);
                    root = null;
                }
            } while (!st.isEmpty());
        }
        return result;
    }
}
