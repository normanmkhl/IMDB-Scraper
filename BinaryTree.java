import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public ArrayList<Integer> BiggestToSmallest(){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.right;
            } else {
                temp = stack.pop();
                list.add(temp.data);
                temp = temp.left;
            }
        }
        return list;
    }

    public ArrayList<Integer> SmallestToBig(){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                list.add(temp.data);
                temp = temp.right;
            }
        }
        return list;
    }

    public void binarySearchTreeInsert(int value){
        root = binarySearchTreeInsert(root, value);
    }

    public TreeNode binarySearchTreeInsert(TreeNode root, int score){
        if(root == null){
            root = new TreeNode(score);
            return root;
        }
        if(score < root.data){
            root.left = binarySearchTreeInsert(root.left,score);
        }else{
            root.right = binarySearchTreeInsert(root.right,score);
        }
        return root;
    }

    public TreeNode SearchBST(int key){
        return SearchBST(root,key);
    }

    public TreeNode SearchBST(TreeNode root,int key){
        if(root == null || root.data == key){
            return root;
        }
        if(key < root.data){
            return SearchBST(root.left,key);
        }else{
            return SearchBST(root.right,key);
        }
    }

    public void BSTsmallest(){
        BSTsmallest(root);
    }

    public void BSTsmallest(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null){
            System.out.println(root.data);
        }
        BSTsmallest(root.left);
    }

    public void BSTbiggest(){
        BSTbiggest(root);
    }

    public void BSTbiggest(TreeNode root){
        if(root == null){
            return;
        }
        if(root.right == null){
            System.out.println(root.data);
        }
        BSTbiggest(root.right);
    }
}