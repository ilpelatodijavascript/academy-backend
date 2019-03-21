/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.repository.EventoRepository;
import it.myti.academy.backend.repository.StatoUnitaLogisticaRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.EventoService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simone
 */
@Service
public class EventoServiceImpl implements EventoService{
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAllEventiInViaggioByUserId(Long idUtente, Long idSpedizione, Long idUnitaLogistica){
        List<Evento> returnValue = new ArrayList<>();
        List<BigInteger> eventi = (List<BigInteger>) eventoRepository.findAllEventiInViaggioByUserId(idUtente, idSpedizione, idUnitaLogistica);
        eventi.forEach((foo) -> {
            returnValue.add(eventoRepository.findById(foo.longValue()).get());
        });
        
        return returnValue;
    }
}
