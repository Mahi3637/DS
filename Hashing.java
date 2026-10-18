import java.util.HashSet;
import java.util.Iterator;
public class Hashing{
    public static void main(String [] args){

        // The creation of the Hashset

        HashSet <Integer> set = new HashSet<>();

        set.add(1); set.add(2); set.add(3); set.add(4);set.add(1);

        if(set.contains(1)){
            System.out.println("skdjfheu");
        }

        System.out.print(set + "");

        set.remove(1);
         System.out.print(set + "");

         Iterator it = set.iterator();

         while(it.hasNext()){
           System.out.print(it.next());
         }
    }
}