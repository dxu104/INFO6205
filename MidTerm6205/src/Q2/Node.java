package Q2;



public class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node<T> parent;

    public Node(T data){
        this.data = data;
    }

    private void traverse (Node node, Node parent){
        if(node ==null){
            return;
        }
        node.parent=parent;
        traverse(node.left,node);
        traverse(node.right,node);
    }

}
