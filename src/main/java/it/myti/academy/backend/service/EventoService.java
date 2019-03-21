/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.service;
import it.myti.academy.backend.model.Evento;
import java.util.List;
/**
 *
 * @author Simone
 */
public interface EventoService {
    public List<Evento> findAllEventiInViaggioByUserId(Long idUtente, Long idSpedizione, Long idUnitaLogistica);
}
