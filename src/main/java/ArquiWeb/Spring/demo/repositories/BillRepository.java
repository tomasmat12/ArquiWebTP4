package ArquiWeb.Spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ArquiWeb.Spring.demo.entities.Bill;

interface BillRepository extends JpaRepository<Bill, Object> {

}
