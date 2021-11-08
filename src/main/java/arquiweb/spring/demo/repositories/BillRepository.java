package arquiweb.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import arquiweb.spring.demo.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Object> {
	
	@Query(value="SELECT date, SUM(total) as total FROM Bill b GROUP BY date")
	public void salesReport();
	

}
