/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import it.myti.academy.backend.repository.SpedizioneRepository;
import it.myti.academy.backend.repository.StatoUnitaLogisticaRepository;
import it.myti.academy.backend.repository.UnitaLogisticaRepository;
import it.myti.academy.backend.service.UnitaLogisticaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simone
 */
@Service
public class UnitaLogisticaServiceImpl implements UnitaLogisticaService{
    @Autowired
    private UnitaLogisticaRepository unitaLogisticaRepository;
    
    @Autowired
    private StatoUnitaLogisticaRepository statoUnitaLogisticaRepository;
    
    @Autowired
    private SpedizioneRepository spedizioneRepository;

    @Override
    public List<DettaglioUnitaLogistica> findByUserId(Long id){
        List<DettaglioUnitaLogistica> returnValue = new ArrayList<>();
        List<Object[]> unitaLogistiche = (List<Object[]>) unitaLogisticaRepository.findByUserId(id);
        
        for(Object[] foo : unitaLogistiche){
            if(foo.length>0){
                returnValue.add(new DettaglioUnitaLogistica(
                    toLong(foo[0]),
                    toString(foo[1]),
                    statoUnitaLogisticaRepository.findById(toLong(foo[2])).get(),
                    spedizioneRepository.findById(toLong(foo[3])).get()
                ));
            }
        }
        return returnValue;
    }
    
    private Long toLong(Object o){
        return Long.valueOf(String.valueOf(o));
    }
    private String toString(Object o){
        return String.valueOf(o);
    }
}
