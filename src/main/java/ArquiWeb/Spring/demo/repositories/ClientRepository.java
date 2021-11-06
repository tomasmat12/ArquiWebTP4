package ArquiWeb.Spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ArquiWeb.Spring.demo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Object> {
	@Modifying
	@Query(value="UPDATE Client SET dni = :new_dni, name = :name, lastname = :lastname, address = :address WHERE dni = :dni", nativeQuery = true)
	public void updateClient(@Param("dni") int new_dni, @Param("name") String name, @Param("lastname") String lastname,@Param("address") String address, @Param("dni") int dni);
}
