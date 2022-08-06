/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Queue<Node> que = new LinkedList<>();
        if(root != null){
            que.add(root);
        }
        Node nextDepthFlag = (root == null || root.left == null) ? null : root.left;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.left != null){
                que.add(node.left);
            }
            if(node.right != null){
                que.add(node.right);
            }
                
            if(!que.isEmpty()){
               if(nextDepthFlag != null && que.peek() == nextDepthFlag){
                   node.next = null;
                   nextDepthFlag = que.peek().left != null ? que.peek().left : null;
               }
                else{
                    node.next = que.peek();
                }
            }
            else{
                node.next = null;
            }
        }
       
        return root;
    }
}