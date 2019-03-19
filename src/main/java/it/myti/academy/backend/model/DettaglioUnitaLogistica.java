/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.myti.academy.backend.model;


/**
 *
 * @author Simone
 */

public class DettaglioUnitaLogistica {
    /*
    
    id			- Long
    nome 		- String
    status		- Obj
    latitudine		- String
    longitudine		- String
    temperatura 	- Double
    umidità		- Double
    spedizione		- Obj
    contenuto		- List<Obj>

    */
    
    private Long id;
    private String nome, latitudine, longitudine;
    private StatoUnitaLogistica status;
    private Spedizione spedizione;
    private Contenuto contenuto;
    /*
    public DettaglioUnitaLogistica(Long id, String nome, String latitudine, String longitudine, StatoUnitaLogistica status, Spedizione spedizione, Contenuto contenuto) {
        --this.id = id;
        --this.nome = nome;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
        --this.status = status;
        --this.spedizione = spedizione;
        this.contenuto = contenuto;
    }
    */
    
    public DettaglioUnitaLogistica(Long id, String nome, StatoUnitaLogistica status, Spedizione spedizione) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.spedizione = spedizione;
    }
    
    @Override
    public String toString(){
        return "{" + "id=" + id + ", nome=" + nome + ", " + status + ", " + spedizione + "}";
    }
}
