import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1112
 * @since 1.0
 */
public final class ImmutableUnmodifiableCollections {
  public static void main(String[] args) {
    List<String> original = new ArrayList<>();
    original.add("Java");
    List<String> unmodifiable = Collections.unmodifiableList(original);
    System.out.println("before add python " + unmodifiable);
    original.add("python");

    System.out.println(unmodifiable);

    System.out.println("-----------------------immutable--------------------------------");
    List<String> immutable = List.of("Rust", "C#");
    //immutable.add("go");///that is immutable that they cant modified

    List<String> immutable2 = List.of("asp.net", "katlin", "groovy");
    System.out.println("immutable list " + immutable2);

    Set<String> set = Set.of("A", "B", "C");
    System.out.println("set " + set);
    Map<Integer, String> map1 = Map.of(1, "one", 2, "two");
    System.out.println("map " + map1);


    Map<Integer, String> map2 = Map.ofEntries(
        Map.entry(1, "OneEnt"),
        Map.entry(2, "twoEnt"),
        Map.entry(3, "threeEnt")
        );


  }
}
