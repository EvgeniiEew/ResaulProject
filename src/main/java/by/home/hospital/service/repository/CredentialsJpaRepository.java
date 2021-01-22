package by.home.hospital.service.repository;

import by.home.hospital.domain.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CredentialsJpaRepository extends JpaRepository<Credential, Integer> {
    Optional<Credential> findByEmail(String credentialLogin);

    List<Credential> findAll();

    void deleteById(Integer id);

}
