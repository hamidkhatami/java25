import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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






  }
}
