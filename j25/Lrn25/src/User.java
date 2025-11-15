import javax.management.relation.Role;
import java.util.List;

/**
 * @author Hamid Khatami(khatami@caspco.ir)
 * @version 1.0 2025.1115
 * @since 1.0
 */
public class User {
  String name;
  List<String> roles;

  public User(String name, List<String> roles) {
    this.name = name;
    this.roles = roles;
  }
}
