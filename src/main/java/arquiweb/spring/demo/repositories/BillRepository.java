package arquiweb.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arquiweb.spring.demo.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Object> {

}
