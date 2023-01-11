package RepoInterface;

import ModelClass.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository < Order, Long > {
}