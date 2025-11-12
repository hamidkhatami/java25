import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1112
 * @since 1.0
 */
public final class ProfDemo {
  public static void main(String[] args) {
    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>();

    long t1 = System.nanoTime();
    System.out.println(t1);
    for (int i = 0; i < 1_000_000; i++) arrayList.add(i);
    long t2 = System.nanoTime();
    System.out.println(t2);
    System.out.println("ArrayList add: " + (t2 - t1));

    t1 = System.nanoTime();
    System.out.println(t1);
    for (int i = 0; i < 1_000_000; i++) linkedList.add(i);
    t2 = System.nanoTime();
    System.out.println(t2);
    System.out.println("LinkedList add: " + (t2 - t1));


  }
}
