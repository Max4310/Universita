/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package universita;

import Facolta.Facolta_I;

/**
 *
 * @author STUDENTE
 */
public class Esame {
    private String nomeEsame;
    private Facolta_I facolta;

    public Esame(String nomeEsame, Facolta_I facolta) {
        this.nomeEsame = nomeEsame;
        this.facolta = facolta;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }

    public Facolta_I getFacolta() {
        return facolta;
    }

    public String toString(){
        return "{ nome esame: "+this.nomeEsame+", Facolta: " + this.facolta.toString()+" }";
    }
}
