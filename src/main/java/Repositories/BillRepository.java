package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Bill;

interface BillRepository extends JpaRepository<Bill, Object> {

}
