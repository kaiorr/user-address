package br.com.kaiorr.useraddress.repositories;

import br.com.kaiorr.useraddress.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
