/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.UnitaLogistica;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Simone
 */

@Repository
public interface UnitaLogisticaRepository extends CrudRepository<UnitaLogistica, Long>{
    @Query(value = "SELECT unita_logistiche.id AS id, unita_logistiche.codice AS nome, "
            + "stati_unita_logistiche.id AS statusId, "
            + "spedizioni.id AS spedizioniId "
            + "FROM unita_logistiche "
            + "INNER JOIN colli ON unita_logistiche.id = colli.unita_logistica_id "
            + "INNER JOIN stati_unita_logistiche ON stati_unita_logistiche.id = unita_logistiche.stato_id "
            + "INNER JOIN spedizioni ON spedizioni.id = colli.spedizione_id "
            + "WHERE colli.utente_id = ?1", nativeQuery = true)
    List<Object[]> findByUserId(Long id);
}
