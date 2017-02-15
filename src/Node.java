package LinkedListv2;

/**
 * @author JM120897 @GitHub Jayem_97 @Twitter
 */
public class Node<E> {
    
    private E e;
    private Node n;
    
    public Node(){                                                              
        this(null, null);
    }
    
    public Node(E e, Node n){
        setElement(e);
        setNext(n);
    }
    
    public void setElement(E e){
        this.e = e;
    }
    
    public E getElement(){
        return e;
    }
    
    public void setNext(Node n){
        this.n = n;
    }
    
    public Node getNext(){
        return n;
    }
}
