/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.repository;

import it.myti.academy.backend.model.Evento;
import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Simone
 */

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long>{
    @Query(value = "SELECT eventi.id AS id FROM eventi "
            + "INNER JOIN colli ON colli.id = eventi.collo_id "
            + "INNER JOIN unita_logistiche ON unita_logistiche.id = colli.unita_logistica_id "
            + "INNER JOIN stati_unita_logistiche ON stati_unita_logistiche.id = unita_logistiche.stato_id "
            + "INNER JOIN spedizioni ON spedizioni.id = colli.spedizione_id "
            + "WHERE colli.utente_id = ?1 AND spedizioni.id = ?2 AND unita_logistiche.id = ?3 AND stati_unita_logistiche.id = 3 ", nativeQuery = true)
    List<BigInteger> findAllEventiInViaggioByUserId(Long idUtente, Long idSpedizione, Long idUnitaLogistica);
    
}
