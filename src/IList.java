package LinkedListv2;

/**
 * @author JM120897 @GitHub, @Jayem_97 @Twitter
 */
public interface IList<E> {
        
    public boolean addIndex(E e, int i) throws IndexOutOfBoundsException;                                          

    public boolean addEnd(E e);

    public boolean addFront(E e);
    
    public boolean add(E e);                                                    //Own implementation
    
    public E getElement(int i)throws IndexOutOfBoundsException;
    
    public boolean removeIndex(int i)throws IndexOutOfBoundsException;
    
    public boolean removeEnd();
    
    public boolean removeFront();
        
    /**public boolean remove(E e);                                                 //Own implementation**/

    public boolean isEmpty();
    
    public int size();
    
    public String toString();
    
}
