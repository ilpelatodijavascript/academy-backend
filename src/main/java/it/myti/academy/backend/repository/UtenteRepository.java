package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Simone
 */
public interface UtenteRepository extends JpaRepository<Utente, Long> {
}

