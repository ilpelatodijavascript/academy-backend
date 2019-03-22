package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Contenuto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Simone
 */
public interface ContenutoRepository extends JpaRepository<Contenuto, Long> {
}
