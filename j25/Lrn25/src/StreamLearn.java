import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1112
 * @since 1.0
 */
public final class StreamLearn {
  public static void main(String[] args) {
    List<String> names = List.of("Ali", "Reza", "Soheil", "Peyman");
    names.stream()
        .filter(x -> x.startsWith("P"))
        .map(String::toUpperCase)
        .forEach(System.out::println);

    System.out.println("------------------------second example-----------------------");
    List<Integer> nums = List.of(1, 2, 3, 4);
    Stream<Integer> stream = nums.stream();
    Employee employee = new Employee();
    employee.setName("Khatami");
    employee.setName("Hamid");
    employee.setIdentification(1L);
    List<Employee> employees = new ArrayList<>();
    employees.add(employee);
    Employee employee2 = new Employee();
    employee2.setfName("Rostami");
    employee2.setName("Reza");
    employee2.setIdentification(2L);
    employees.add(employee2);

    List<String> names2 = employees.stream().map(Employee::getName).collect(Collectors.toList());
    System.out.println(names2);

    Stream.of("a,b,c", "d,e").<String>mapMulti((str, consumer) -> {
      for (String s : str.split(",")) consumer.accept(s);
    }).forEach(System.out::println);


    System.out.println("--------------------------flatmap-----------------------------------");

    List<List<Integer>> lists = List.of(
        List.of(1, 2),
        List.of(3, 4),
        List.of(5, 6)
                                       );

    lists.stream().flatMap(List::stream).forEach(System.out::println);

    System.out.println("----------------------------List<List<String> to List<String>-------------------------------");
    List<List<String>> groups = List.of(
        List.of("A", "B"),
        List.of("C", "D")
                                       );
    List<String> res = groups
        .stream().
        flatMap(List::stream).
        toList();
    System.out.println(res);

    System.out.println("----------------------------Splitting character -------------------------------");
    List<String> words = List.of("Java", "Stream");
    List<String> chars = words
        .stream()
        .flatMap(x -> Arrays.stream(x.split("")))
        .toList();
    chars.forEach(System.out::println);

    System.out.println("---------------------------Optional------------------------------------------");
    Optional<String> name = Optional.of("hamid");
    name
        .flatMap(x -> Optional.of(x.toUpperCase()))
        .ifPresent(System.out::println);

    System.out.println("---------------------------String to list of char ------------------------------------------");
    List<String> word1 = List.of("Hamid", "Soheil", "Reza");

    var chars1 = word1.stream()
        .flatMap(x -> x.chars().mapToObj(c -> (char) c))
        .toList();
    System.out.println(chars1);

//       Important part of stream
    System.out.println("-------------------------Read Files and Lines--------------------------------");
    List<Path> files = List.of(
        Paths.get(System.getProperty("user.dir") + "/a.txt"),
        Paths.get(System.getProperty("user.dir") + "/b.txt")
                              );
    var lines = files
        .stream()
        .flatMap(path -> {
          try {
            return Files.lines(path);
          } catch (Exception e) {
            System.err.println("Error reading file: " + path + " - " + e.getMessage());
            return Stream.empty();
          }
        }).toList();
    lines.forEach(System.out::println);

    System.out.println("-------------------------json process--------------------------------");
    List<User> users = List.of(
        new User("A", List.of("Admin", "AUDIT")),
        new User("B", List.of("USER"))
                              );
    List<String> allRoles = users.stream().flatMap(x -> x.roles.stream()).toList();
    System.out.println(allRoles);
    System.out.println("-------------------------flatten Map<String,List<Transaction>>--------------------------------");
    Map<String, List<Integer>> txtMap = Map.of(
        "today", List.of(100, 200),
        "yesterday", List.of(50, 50)
                                              );
    var txList = txtMap.values()
        .stream()
        .flatMap(List::stream)
        .toList();
    System.out.println(txList);

    Optional<String> name1 = Optional.of("aaa");
    var res1 = name1.flatMap(x -> Optional.of(x.toUpperCase()));
    System.out.println(res1);
    System.out.println("-------------------------Process Request--------------------------------");
    Optional<String> mbInput = Optional.of("1");

    Optional<Integer> mbOutput = mbInput.flatMap(
        i -> {
          try {
            return Optional.of(Integer.parseInt(i));
          } catch (Exception e) {
            System.err.println("Process Request: " + e.getMessage());
            return Optional.empty();
          }
        });
    System.out.println(mbOutput);
    System.out.println("-------------------------Join --------------------------------");
    List<Customer> customers = List.of(
        new Customer("HAMID", List.of(new Order("1"))),
        new Customer("SOHEIL", List.of(new Order("2")))
                                      );

    var allOrders = customers
        .stream()
        .flatMap(x -> x.orders.stream())
        .toList();


    allOrders.forEach(x -> System.out.println(x.goodsName));
    //    Important part of stream

    System.out.println("-------------------------Multi token --------------------------------");
    List<String> lines2 = List.of("a,b,c",
        "d,e,f");
    var tokens = lines2.stream()
        .flatMap(l -> Arrays.stream(l.split(",")))
        .toList();

    System.out.println(tokens);
    System.out.println("-------------------------Stream<Stream<T>>--------------------------------");
    Stream<Stream<Integer>> nested = Stream.of(
        Stream.of(100, 200),
        Stream.of(50, 50)
                                              );
    var flat = nested
        .flatMap(s -> s).toList();
    System.out.println(flat);

    System.out.println("--------------------------------String template-----------------------------");
    String nameStTmp = "Hamid";
    int age =30;
    String fulltext=STR."My name is {nameStTmp}, age {age}";
    System.out.println(fulltext);


  }
}
