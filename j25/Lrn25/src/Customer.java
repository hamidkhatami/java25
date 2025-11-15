import java.util.List;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1115
 * @since 1.0
 */
public class Customer {
  String name;
  List<Order> orders;

  public Customer(String name, List<Order> orders) {
    this.name = name;
    this.orders = orders;
  }
}
