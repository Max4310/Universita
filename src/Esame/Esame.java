/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Esame;

/**
 *
 * @author STUDENTE
 */
public class Esame {
    private String nomeEsame;

    public Esame(){

    }

    public Esame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }


    public String toString(){
        return "{ nome esame: "+this.nomeEsame+" }";
    }
}
