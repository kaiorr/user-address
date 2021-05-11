package br.com.kaiorr.useraddress.repositories;

import br.com.kaiorr.useraddress.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
