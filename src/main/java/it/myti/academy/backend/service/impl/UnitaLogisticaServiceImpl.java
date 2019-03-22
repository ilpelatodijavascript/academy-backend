/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.service.impl;

import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import it.myti.academy.backend.repository.ContenutoRepository;
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
    
    @Autowired
    private ContenutoRepository contenutoRepository;

    @Override
    public List<DettaglioUnitaLogistica> findAllDettaglioByUserId(Long id){
        List<DettaglioUnitaLogistica> returnValue = new ArrayList<>();
        List<Object[]> unitaLogistiche = (List<Object[]>) unitaLogisticaRepository.findAllDettaglioByUserId(id);
        
        unitaLogistiche.stream().filter((foo) -> (foo.length>0)).forEachOrdered((foo) -> {
            returnValue.add(new DettaglioUnitaLogistica(
                    longValue(foo[0]), //Id
                    stringValue(foo[1]), //Codice
                    stringValue(foo[2]), //Latitudine
                    stringValue(foo[3]), //Longitudine
                    statoUnitaLogisticaRepository.findById(longValue(foo[4])).get(), //Status
                    spedizioneRepository.findById(longValue(foo[5])).get(), //Spedizione
                    contenutoRepository.findById(longValue(foo[6])).get() //Contenuto
            ));
        });
        return returnValue;
    }
    
    @Override
    public DettaglioUnitaLogistica findDettaglioById(Long idUnitaLogistica, Long idUtente){
        List<DettaglioUnitaLogistica> returnValue = new ArrayList<>();
        List<Object[]> unitaLogistiche = (List<Object[]>) unitaLogisticaRepository.findAllDettaglioByUserId(idUnitaLogistica);
        
        for(Object[] foo : unitaLogistiche){
            if(foo.length>0){
                returnValue.add(new DettaglioUnitaLogistica(
                    longValue(foo[0]), //Id
                    stringValue(foo[1]), //Codice
                    stringValue(foo[2]), //Latitudine
                    stringValue(foo[3]), //Longitudine
                    statoUnitaLogisticaRepository.findById(longValue(foo[4])).get(), //Status
                    spedizioneRepository.findById(longValue(foo[5])).get(), //Spedizione
                    contenutoRepository.findById(longValue(foo[6])).get() //Contenuto
                ));
            }else{
                return null;
            }
        }
        return returnValue.get(0);
    }
    private Long longValue(Object o){
        return Long.valueOf(String.valueOf(o));
    }
    private String stringValue(Object o){
        return String.valueOf(o);
    }
}
