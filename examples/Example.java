package LinkedListv2;

/**
 * @author JM120897 @GitHub Jayem_97 @Twitter
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IList<Integer> a = new List();
        
        System.out.println("Adding 5, 3 to empty list, then adding 1 to front and 9 to end.");
        a.add(5);
        a.add(3);
        a.addFront(1);
        a.addEnd(9);
        System.out.println(a);
        System.out.println("Adding 4 @ index 1");
        a.addIndex(4, 1);
        System.out.println(a);
        System.out.println("Removing what was introduced @ index 1");
        a.removeIndex(1);
        System.out.println(a);
        System.out.println("Getting element @ index 3");
        System.out.println(a.getElement(3));
        System.out.println("Size: " + a.size());
        System.out.println("Adding element @ index 3");
        a.addIndex(4112016, 2);
        System.out.println(a);
        System.out.println("Adding element @ index = size");
        a.addIndex(1010101, a.size());
        System.out.println(a);
        System.out.println("Getting th element @ index = size");
        System.out.println(a.getElement(a.size()));
        System.out.println("Works flawlessly, feelsgoodman");
        
        
    }
    
}
