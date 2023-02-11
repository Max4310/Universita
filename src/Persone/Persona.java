package Persone;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Persona {
    protected String nome;
    protected String cognome;

    public Persona(){

    }
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String toString(){
        return "{ " + this.nome + ", " + this.cognome + " }";
    }

    @JsonGetter
    public String getNome() {
        return nome;
    }

    @JsonGetter
    public String getCognome() {
        return cognome;
    }
}
