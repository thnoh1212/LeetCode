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
        
        Queue<Node> nextQue = new LinkedList<>();
        
        if(root != null){
            nextQue.add(root);
        }
        
        do{
            Queue<Node> currentQue = new LinkedList<>(nextQue);
            nextQue = new LinkedList<>();
            while(!currentQue.isEmpty()){
                Node currentNode = currentQue.poll();
                if(currentNode.left != null){
                    nextQue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    nextQue.add(currentNode.right);
                }
                
                if(!currentQue.isEmpty()){
                    currentNode.next = currentQue.peek();
                }
                else{
                    currentNode.next = null;
                }
            }
            
        }while(!nextQue.isEmpty());
        
        return root;
    }
}