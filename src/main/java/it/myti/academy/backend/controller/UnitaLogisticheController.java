/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.UnitaLogisticaService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Simone
 */

@RestController
@RequestMapping("/unitalogistica")
public class UnitaLogisticheController {
    @Autowired
    UnitaLogisticaService unitaLogisticaService;
    
    @Autowired
    UtenteRepository utenteRepository;
    
    @GetMapping("/utente/{id}")
    public String getAllDettaglioUnitaLogisticaStringByUserId(@PathVariable("id") long id){
        if(utenteRepository.findById(id) != null) {
            List<DettaglioUnitaLogistica> unitaLogistiche = (List<DettaglioUnitaLogistica>) unitaLogisticaService.findAllDettaglioByUserId(id);
            String returnValue = Arrays.toString(unitaLogistiche.toArray());
            return returnValue;
        }else{
            return null;
        }
    }
    
    @GetMapping("/{idUnitaLogistica}/utente/{idUtente}")
    public String getDettaglioUnitaLogisticaStringById(@PathVariable("idUnitaLogistica") long idUnitaLogistica, @PathVariable("idUtente") long idUtente){
        if(utenteRepository.findById(idUtente) != null) {
            DettaglioUnitaLogistica returnValue = (DettaglioUnitaLogistica) unitaLogisticaService.findDettaglioById(idUnitaLogistica, idUtente);
            return returnValue.toString();
        }else{
            return null;
        }
        
    }
}
