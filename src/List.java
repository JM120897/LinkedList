package LinkedListv2;

/**
 * @author JM120897 @GitHub Jayem_97 @Twitter
 */

public class List<E> implements IList<E> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public List(){
        head = null;
        tail = null;
        size = 0;
    }
    
    public boolean addIndex(E e, int i) throws IndexOutOfBoundsException{
        boolean added = false;
        
        if(i > this.size() || i <= 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(i == 1){
            added = this.addFront(e);
        }else if(i == this.size()){
            added = this.addEnd(e);
        }else{
            Node<E> n = new Node();
            n.setElement(e);
            Node<E> next = head;
            Node<E> previous = null;
            
            for(int c = 1; c < i; c++){
                previous = next;
                next = next.getNext();
            }
            n.setNext(previous.getNext());                                      //Given A->B we want to instert C between A and B
            previous.setNext(n);                                                //C->B && A->B
            added = true;
            this.size++;    
        }
        return added;
    }
    
    public boolean addFront(E e){                                               
        boolean added = false;
        if(e != null){
            Node<E> n = new Node();
            n.setElement(e);
            if(head != null){
                n.setNext(head);
                head = n;
            }else{
                head = n;
            }
            this.size++;
            added = true;
        }
        return added;
    }
    
    public boolean addEnd(E e){
        boolean added = false;
        if(e != null){
            Node<E> n = new Node();
            n.setElement(e);
            if(tail != null){
                tail.setNext(n);
                tail = n;
            }else{
                head = tail = n;
            }
            this.size++;
            added = true;
        }
        return added;
    }
    
    public boolean add(E e){                                                    //Own implementation. Just does what addEnd does.
        boolean added = false;
        if(e != null){
            Node<E> n = new Node();
            n.setElement(e);
            if(tail != null){
                tail.setNext(n);
                tail = n;
            }else{
                head = tail = n;
            }
            this.size++;
            added = true;
        }
        return added;
    }
    
    public E getElement(int i) throws IndexOutOfBoundsException{
        if(i > this.size() || i <= 0){
            throw new IndexOutOfBoundsException();
        }
        
        Node<E> next = head;   
        for(int c = 1; c < i; c++){      
            next = next.getNext();                                       
        }
        
        return next.getElement();
    }
    
    public boolean removeIndex(int i) throws IndexOutOfBoundsException{
        boolean removed = false;
        
        if(i > this.size() || i <= 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(i == 1){
            removed = this.removeFront();
        }else if(i == this.size()){
            removed = this.removeEnd();
        }else{
            Node<E> next = head;                                                                                                   
            Node<E> previous = null;
            
            for(int c = 0; c < i; c++){ 
                previous = next;
                next = next.getNext();                                       
            }           
            previous.setNext(next.getNext());                                   //Given: A->B->C where A = previous and B = next                                                  
            next.setNext(null);                                                 //A -> C, B(null), B -> Null
            next.setElement(null);
            removed = true;
            size--;
        }
        return removed;
    }
    
    public boolean removeFront(){
        boolean removed = false;
        
        if(!this.isEmpty()){
            Node<E> aux = head;                                                 //Given: A->B->C
            head = head.getNext();                                              //Now head makes reference to B
            aux.setNext(null);                                                  //A-/->B
            aux.setElement(null);                                               //COMPLETE removal of A     
            this.size--;                                                        //Mandatory size decrease
            removed = true;
        }
        return removed;
    }
    
    public boolean removeEnd(){
        boolean removed = false;
        
            if(!this.isEmpty()){
            Node<E> next = head;
            Node<E> previous = null;

            while(next.getNext() != null){                                      //Given: A->B->C->D->E, at the end: Previous = D, Next = E;
                previous = next;
                next = next.getNext();
            }
            
            next.setElement(null);                                              //Bye bye, element in tail.
            previous.setNext(null);                                             //Unlinking D-/->E and making D the tail as his next node is NULL;
            tail = previous;                                                    //Referencing HEAD to D;
            this.size--;  
            removed = true;
       }
        return removed;
    }
    
    /** DON'T USE IT IT'S BUGGED.
    public boolean remove(E e){                                                 //Own implementation.
        boolean removed = false;
        if(e != null){
            Node<E> next = head;
            Node<E> previous = null;
            boolean found = false;
            
            while(next.getNext() != null && !found){      
                if(next.getElement().equals(e)){                                //Loop to move through all the linked list.
                    found = true;
                }
                previous = next;
                next = next.getNext();                                       
            }
           
            if(found){                                                          //Given A->B->C (A = Previous, B = Next)
                previous.setNext(next.getNext());                               //Relinking: A->C 
                next.setNext(null);                                             //Unlinking B-/->C
                next.setElement(null);                                          
                removed = true;
            }     
            this.size--; 
        }
        return removed;
    }**/
    
    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }    
    
    public String toString(){
        String s = "{ ";
        Node<E> next = head;
        
        for(int i = 0; i < this.size(); i++){
            if(i < this.size() - 1){
                s += next.getElement().toString() +", ";
                next = next.getNext();
            }else{
                s += next.getElement().toString() + " }";
            }
        }
        return s;
    }
   
}
