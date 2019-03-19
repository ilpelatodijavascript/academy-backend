/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.service;
import it.myti.academy.backend.model.DettaglioUnitaLogistica;
import java.util.List;
/**
 *
 * @author Simone
 */
public interface UnitaLogisticaService {
    public List<DettaglioUnitaLogistica> findByUserId(Long id);
}
