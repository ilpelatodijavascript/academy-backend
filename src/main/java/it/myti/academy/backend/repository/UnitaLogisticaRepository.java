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
            + "eventi_particle.latitudine AS latitudine, eventi_particle.longitudine AS longitudine, "
            + "stati_unita_logistiche.id AS statusId, "
            + "spedizioni.id AS spedizioniId, "
            + "contenuti.id AS contenutoId "
            + "FROM unita_logistiche "
            + "INNER JOIN colli ON unita_logistiche.id = colli.unita_logistica_id "
            + "INNER JOIN stati_unita_logistiche ON stati_unita_logistiche.id = unita_logistiche.stato_id "
            + "INNER JOIN spedizioni ON spedizioni.id = colli.spedizione_id "
            + "INNER JOIN eventi ON eventi.collo_id = colli.id "
            + "INNER JOIN eventi_particle ON eventi_particle.id = eventi.id "
            + "INNER JOIN contenuti ON contenuti.collo_id = colli.id "
            + "WHERE eventi.ricevuto_il = (SELECT MAX(ricevuto_il) FROM eventi WHERE collo_id = colli.id) AND "
            + "colli.utente_id = ?1", nativeQuery = true)
    List<Object[]> findAllDettaglioByUserId(Long id);
    
    @Query(value = "SELECT unita_logistiche.id AS id, unita_logistiche.codice AS nome, "
            + "eventi_particle.latitudine AS latitudine, eventi_particle.longitudine AS longitudine, "
            + "stati_unita_logistiche.id AS statusId, "
            + "spedizioni.id AS spedizioniId, "
            + "contenuti.id AS contenutoId "
            + "FROM unita_logistiche "
            + "INNER JOIN colli ON unita_logistiche.id = colli.unita_logistica_id "
            + "INNER JOIN stati_unita_logistiche ON stati_unita_logistiche.id = unita_logistiche.stato_id "
            + "INNER JOIN spedizioni ON spedizioni.id = colli.spedizione_id "
            + "INNER JOIN eventi ON eventi.collo_id = colli.id "
            + "INNER JOIN eventi_particle ON eventi_particle.id = eventi.id "
            + "INNER JOIN contenuti ON contenuti.collo_id = colli.id "
            + "WHERE eventi.ricevuto_il = (SELECT MAX(ricevuto_il) FROM eventi WHERE collo_id = colli.id) AND "
            + "unita_logistiche.id = ?1 AND colli.utente_id = ?2", nativeQuery = true)
    List<Object[]> findDettaglioById(Long idUnitaLogistica, Long idUtente);
}
