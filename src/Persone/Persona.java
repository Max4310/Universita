/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persone;

/**
 *
 * @author STUDENTE
 */
public class Persona {
    protected String nome;
    protected String cognome;
    
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String toString(){
        return "{ " + this.nome + ", " + this.cognome + " }";
    }
    
    
    
}
