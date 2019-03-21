/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.controller;

import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import it.myti.academy.backend.model.Evento;
import it.myti.academy.backend.model.Utente;
import it.myti.academy.backend.repository.UtenteRepository;
import it.myti.academy.backend.service.EventoService;
import it.myti.academy.backend.service.UnitaLogisticaService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Simone
 */

@RestController
@RequestMapping("/eventi")
public class EventiController {
    @Autowired
    EventoService eventoService;
    
    @Autowired
    UtenteRepository utenteRepository;
    
    @GetMapping("/utente/{id}")
    public String getAllEventiInViaggioStringByUserId(@PathVariable("id") long idUtente, @RequestParam Map<String, String> param){
        if(param.size()==2 && utenteRepository.findById(idUtente) != null){
            Long idSpedizione = Long.parseLong(param.get("idSpedizione"));
            Long idUnitaLogistica = Long.parseLong(param.get("idUnitaLogistica"));
            List<Evento> eventiInViaggio = (List<Evento>) eventoService.findAllEventiInViaggioByUserId(idUtente, idSpedizione, idUnitaLogistica);
            String returnValue = Arrays.toString(eventiInViaggio.toArray());
            return returnValue;
        }else{
            return null;
        }
    }
}
