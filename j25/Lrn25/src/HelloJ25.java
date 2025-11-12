import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.concurrent.Executors;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1104
 * @since 1.0
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HelloJ25 {


  public static void main(String[] args) {
    System.out.println("Hello World");
    System.out.println("-------------------------------------------------------");
    System.out.println("---------------------Point object----------------------");

    Point p = new Point(1, 2);
    printShape(p);
    System.out.println("-------------------------------------------------------");
    System.out.println("---------------------------Circle----------------------");
    Point pCircle = new Point(30, 40);
    Circle c = new Circle(pCircle, 50);
    printShape(c);
    System.out.println("---------------------------Threads----------------------");
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 0; i <= 1_000; i++) {
        int task = i;
        executor.submit(() -> {System.out.println("Task" + task);});
      }
    }

    System.out.println("---------------------------SequencedMap----------------------");
    SequencedMap<String, Integer> map = new LinkedHashMap<>();
    map.put("A", 1);
    map.put("B", 2);
    System.out.println("First map: " + map.firstEntry());
    System.out.println("Last map: " + map.lastEntry());
    System.out.println("------------------------------Second sample of Sequences --------------------");

    List<String> names = new ArrayList<>(List.of("A", "B", "C"));
    SequencedCollection<String> seq = (SequencedCollection<String>) names;
    seq.addFirst("Start");
    seq.addLast("End");
    System.out.println("Names: " + names);
    System.out.println("Seq: " + seq);
    System.out.println("Start: " + seq.getFirst());
    System.out.println("End: " + seq.getLast());

    var reversed = seq.reversed();
    System.out.println("Reversed: " + reversed);

    System.out.println("------------------------------Third sample of Sequences --------------------");
    LinkedHashMap<Integer, String> map3 = new LinkedHashMap<>();
    map3.put(1, "One");
    map3.put(2, "Two");

    SequencedMap<Integer, String> seq3 = (SequencedMap<Integer, String>) map3;

    seq3.putFirst(0, "Zero");
    seq3.putLast(3, "Third");
    System.out.println("Seq 3: " + seq3);
    System.out.println("First map: " + map3.firstEntry());
    System.out.println("Last map: " + map3.lastEntry());
    System.out.println("reversed Linked HashMap: " + seq3.reversed());

  }

  static void printShape(Object shape) {
    switch (shape) {
      case Point(int x, int y) -> System.out.println("Point: " + x + ", " + y);
      case Circle(Point(int x, int y), int r) -> System.out.println("Circle at " + x + "," + y + " r=" + r);
      default -> System.out.println("Unknown");
    }
  }

  record Point(int x, int y) {}

  record Circle(Point center, int radius) {}
}