package universita;

import Esame.Esame;
import Esame.EsameAttivo;
import Esame.EsameStudente;
import Facolta.Facolta_I;
import Facolta.Giurispudenza;
import Facolta.Informatica;
import Facolta.Matematica;
import Persone.Docente;
import Persone.Studente;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//questa è la classe principale dove vengono gestiti i panelli...

//questa classe quando si va salvare si andrà a salvare sul file "dati.json" nella cartella del progetto
//ingora nel salvataggio il path poiche è final e quindi sempre lo stesso...
//inoltre per via di un problema sulle istanze gli attributi statici non possono essere salvati.. verranno ricalcolati ogni volta grazie all'utilizzo
//delle somme delle dimenzioni dei vari arrayList (studenti, docenti) sono ovviamente in tutte le facolta

public class Università {
    //@JsonIgnore
    private ArrayList<Studente> studentiInAttesa;
    //@JsonIgnore
    private ArrayList<Docente> docentiInAttesa;
    //@JsonIgnore
    private ArrayList<Facolta_I> facolts;

    @JsonIgnore
    private final String pathSalvataggio = "dati.json";
    
    public Università(){
        studentiInAttesa = new ArrayList<>();
        docentiInAttesa = new ArrayList<>();
        facolts = new ArrayList<>();
        
        
        //carico le facolta
        facolts.add(new Giurispudenza());
        facolts.add(new Matematica());
        facolts.add(new Informatica());

        //this.pathSalvataggio = "dati.json";

        /*Docente x1 = new Docente("cvia", "dfks","dfsk");
        facolts.get(0).addDocente(x1);

        x1.postaEsame(facolts.get(0), facolts.get(0).getNextEsame());

        Studente x = new Studente("fkdjs", "fids", "fikdjs");
        facolts.get(0).addStudente(x);

        this.docentiInAttesa.add(new Docente("dfks", "fids", "dfis"));
        this.studentiInAttesa.add(new Studente("dfs", "sdfsfds", "rtge"));*/
        //this.studentiInAttesa.add()*/
    }

    //il metodo include inputs e output
    public void pannelloSegreteria() throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        char risPannello, risDocente, risSegreteria, risdocente2, risStudente, risStudente2;
        do{
            System.out.println("cosa vuoi fare? " +
                    "\na. Visualizzare tutte le facolta" +
                    "\nb. Visualizzare tutte i studenti in un falcolta" +
                    "\nc. Visualizzare tutte i docenti in una falcolta"+
                    "\nd. Visualizza i studenti in attesa"+ 
                    "\ne. Visualizza i docenti in attesa" +
                    "\nf. esci");
            risSegreteria = stdin.readLine().toLowerCase().charAt(0);


            switch (risSegreteria){
                case 'a':
                    for(Facolta_I facolta : facolts){
                        System.out.println(facolta.toString());
                    }
                    break;
                case 'b':
                    int riss;
                    do{
                        int i=0;
                        for(Facolta_I facolta_i : facolts){
                            System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                            i++;
                        }

                        riss = Integer.parseInt(stdin.readLine()) - 1;
                    }while(riss>=facolts.size() || riss < 0 );

                    if(facolts.get(riss).getStudenti().size()>0){
                        int i=0;
                        for(Studente studente : facolts.get(riss).getStudenti()){
                            System.out.println((i+1)+". "+studente.toString());
                            i++;
                        }
                    }
                    else{
                        System.out.println("La Facolta di "+ facolts.get(riss).getIdFacolta()+ " non ha studenti");
                    }
                    break;
                case 'c':
                    int rissC;
                    do{
                        int i=0;
                        for(Facolta_I facolta_i : facolts){
                            System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                            i++;
                        }

                        rissC = Integer.parseInt(stdin.readLine()) - 1;
                    }while(rissC>=facolts.size());

                    if(facolts.get(rissC).getStudenti().size()>0){
                        int i=0;
                        for(Docente docente : facolts.get(rissC).getDocenti()){
                            System.out.println((i+1)+". "+docente.toString());
                            i++;
                        }
                    }
                    else{
                        System.out.println("La Facolta di "+ facolts.get(rissC).getIdFacolta()+ " non ha docenti");
                    }

                    break;
                case 'd':
                    //gestici i studeti in attesa
                    if(studentiInAttesa.size() > 0){
                        int ris;
                        do{
                            int i=0;
                            for(Studente studente : studentiInAttesa){
                                System.out.println((i+1) + ". " + studente.toString());
                                i++;
                            }

                            System.out.println(
                                    (studentiInAttesa.size()+1) + ". Assumi tutti\n" + (studentiInAttesa.size()+2) + ". Rifiuta tutti"
                            );

                            ris = Integer.parseInt(stdin.readLine())-1;
                        }while (ris > studentiInAttesa.size()+1 || ris < 0);


                        if(ris == studentiInAttesa.size()){
                            //assumi tutti
                            for(Studente studente : studentiInAttesa){
                                int i=0;
                                for(Facolta_I facolta : facolts){
                                    if(studente.getId().equals(facolta.getIdFacolta())){
                                        studente.setIndexFacolta(i);
                                        studente.setIdStudente("studente:"+facolta.getLastStudente());
                                        facolta.addStudente(studente);
                                    }
                                    i++;
                                }
                            }

                            studentiInAttesa = new ArrayList<>();
                        }
                        else if(ris == studentiInAttesa.size()+1){
                            //nn assumere nessuno
                            studentiInAttesa = new ArrayList<>();
                        }
                        else if(ris < studentiInAttesa.size()){
                            //assumi quello che dice lui

                            for(Facolta_I facolta : facolts){

                                if(studentiInAttesa.get(ris).getId().equals(facolta.getIdFacolta())){
                                    Studente x = studentiInAttesa.get(ris);
                                    x.setIndexFacolta(ris);
                                    x.setIdStudente("studente:"+facolta.getLastStudente());
                                    facolta.addStudente(x);
                                }

                            }

                            studentiInAttesa.remove(ris);

                        }
                        else{
                            System.out.println("valore non valido");
                        }
                    }
                    else{
                        System.out.println("non ci sono studenti da assumere");
                    }
                    
                    break;
                case 'e':
                    //Gesti i docenti in attesa

                    if(docentiInAttesa.size() > 0){
                        int risD;
                        do{
                            int i=0;
                            for(Docente docente : docentiInAttesa){
                                System.out.println((i+1) + ". " + docente.toString());
                                i++;
                            }

                            System.out.println(
                                    (docentiInAttesa.size()+1) + ". Assumi tutti\n" + (docentiInAttesa.size()+2) + ". Rifiuta tutti"
                            );

                            risD = Integer.parseInt(stdin.readLine())-1;
                        }while (risD > docentiInAttesa.size()+1 || risD < 0);


                        if(risD == docentiInAttesa.size()){
                            //assumi tutti
                            for(Docente docente : docentiInAttesa){
                                int i=0;
                                for(Facolta_I facolta : facolts){
                                    if(docente.getId().equals(facolta.getIdFacolta())){
                                        docente.setIndexFacolta(i);
                                        docente.setId("docente:"+facolta.getLastDocente());
                                        facolta.addDocente(docente);
                                    }
                                    i++;
                                }
                            }

                            docentiInAttesa = new ArrayList<>();
                        }
                        else if(risD == docentiInAttesa.size()+1){
                            //nn assumere nessuno
                            docentiInAttesa = new ArrayList<>();
                        }
                        else if(risD < docentiInAttesa.size()){
                            //assumi quello che dice lui

                            for(Facolta_I facolta : facolts){

                                if(docentiInAttesa.get(risD).getId().equals(facolta.getIdFacolta())){
                                    Docente x = docentiInAttesa.get(risD);
                                    x.setId("docente:"+facolta.getLastDocente());
                                    x.setIndexFacolta(risD);
                                    facolta.addDocente(x);
                                }

                            }

                            docentiInAttesa.remove(risD);

                        }
                        else{
                            System.out.println("valore non valido");
                        }
                    }
                    else{
                        System.out.println("non ci sono studenti da assumere");
                    }

                    break;
                default:
                    break;
            }

        }while(risSegreteria != 'f');
    }
    
    //il metodo include inputs e output
    public void pannelloStudente() throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        char risPannello, risDocente, risSegreteria, risdocente2, risStudente, risStudente2;
        do{
            System.out.println("benvenuto! nel pannello per i studenti" +
                    "\na. log in" +
                    "\nb. registrati" +
                    "\nc. esci");
            risStudente  = stdin.readLine().toLowerCase().charAt(0);

            switch (risStudente){
                case 'a':
                    System.out.println("dimmi il tuo id studente");
                    String idStudente = stdin.readLine();

                    try{
                        String[] splitId = idStudente.split(":");
                        int realId = Integer.parseInt(splitId[1]);

                        //chiaramenteo "last studente" è uguale per tutte le facolta quindi è inutile fare il ciclo... ne prendo una a caso
                        //ovviametne devo anche controllare che lui prima dei : abbiamo scritto "docente"

                        if(realId < facolts.get(0).getLastStudente() && "studente".equals(splitId[0].toLowerCase())){
                            boolean iscrivitiNuoviEsami = true;  /*metti il cotnrollo sul se ci sta un nuovo esame da fare*/
                            boolean faiNuovoEsame = true; /*metti il controllo sul se ci sono nuovi esami cheil tipo nn ha fatto!*/
                            boolean giaFatto = false;

                            Studente studente = null;
                            for(Facolta_I facolta_i : facolts){
                                if(facolta_i.getStudente(idStudente.toLowerCase()) != null){
                                    studente = facolta_i.getStudente(idStudente.toLowerCase());
                                }
                            }

                            if(studente == null){
                                System.out.println("id non valido"); //se stampa questa cosa è un problema...
                                break;
                            }



                            do{
                                /**
                                 * visualizzare gli esami
                                 * iscriversi agli esami
                                 * fare l'esame
                                 * */

                                String o = "a. visualizza esami fatti" +
                                        "\nb. visualizza tutti gli esami del corso" +
                                        "\nc. esci";


                                iscrivitiNuoviEsami = facolts.get(studente.getIndexFacolta()).getEsameAttivo() != null;
                                //se c'è un esame attivo da fare

                                faiNuovoEsame = studente.isIscritto();
                                /*metti il controllo sul se ci sono nuovi esami cheil tipo nn ha fatto!*/


                                //System.out.println(faiNuovoEsame);
                                if(iscrivitiNuoviEsami && !faiNuovoEsame){
                                    giaFatto = studente.isGiaFatto(facolts.get(studente.getIndexFacolta()).getEsameAttivo());
                                    if(!giaFatto){
                                        o = o.replace("c. esci", "" +
                                                "c. Iscriviti Ad un nuovo Esame" +
                                                "\nd. esci");

                                    }
                                }
                                else if(faiNuovoEsame){
                                    o = o.replace("c. esci", ""+
                                            "c. fai l'esame a cui sei iscritto" +
                                            "\nd. esci");
                                }
                                System.out.println(o);
                                risStudente2 = stdin.readLine().toLowerCase().charAt(0);


                                switch (risStudente2){
                                    case 'a':
                                        System.out.println("Facolta: " + facolts.get(studente.getIndexFacolta()).getIdFacolta());
                                        if(studente.getEsamiFatti().isEmpty()) {
                                            System.out.println("non hai fatto nessun esame");
                                            break;
                                        }

                                        int iii = 0;
                                        for(EsameStudente esameStudente : studente.getEsamiFatti()){
                                            System.out.println((iii+1)+". "+esameStudente);
                                            iii++;
                                        }

                                        break;
                                    case 'b':
                                        System.out.println("Facolta: " + facolts.get(studente.getIndexFacolta()));

                                        int i=0;
                                        for(Esame esame : facolts.get(studente.getIndexFacolta()).getEsami()){
                                            System.out.println((i+1)+". "+esame);
                                            i++;
                                        }
                                        break;
                                    case 'c':
                                        if(iscrivitiNuoviEsami && !faiNuovoEsame && !giaFatto){
                                            //CASO IN CUI HA NUOVI ESAMI DA ISCRIVERSI
                                            Facolta_I facolta = facolts.get(studente.getIndexFacolta());
                                            studente.iscrivitiEsame(facolta.getEsameAttivo());
                                        }
                                        else if(faiNuovoEsame){
                                            //CASO IN CUI DEVE FARE L'ESAME A CUI E' ISCRITTO
                                            Facolta_I facolta = facolts.get(studente.getIndexFacolta());
                                            EsameAttivo esameAttivo = facolta.getEsameAttivo();

                                            System.out.println("hai completato l'esame il tuo voto e': "+ studente.faiEsame(esameAttivo));
                                        }
                                        break;
                                    default:
                                        break;
                                }

                                if(iscrivitiNuoviEsami || faiNuovoEsame){
                                    if(risStudente2 == 'c'){
                                        risStudente2 = 'd';
                                    }
                                    else if(risStudente2 == 'd'){
                                        risStudente2 = 'c';
                                    }
                                }

                            } while(risStudente2 != 'c');


                        }
                        else{
                            System.out.println("non sono riuscito a trovare il tuo id sei sicuro di averlo messo bene?");
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("sintassi id errata (studente= \"studente:[id]\") ");
                    }




                    break;
                case 'b':
                    //registrati come studente

                    int rissBStu;
                    do{
                        int i=0;
                        for(Facolta_I facolta_i : facolts){
                            System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                            i++;
                        }

                        rissBStu = Integer.parseInt(stdin.readLine()) - 1;


                    }while(rissBStu >= facolts.size() || rissBStu < 0);



                    System.out.println("dimmi il tuo nome");
                    String none = stdin.readLine();
                    System.out.println("dimmi il tuo cognome");
                    String cognome = stdin.readLine();

                    studentiInAttesa.add(new Studente(none, cognome, facolts.get(rissBStu).getIdFacolta()));

                    System.out.println("la tua richiesta è stata inviata con successo");


                    break;
                default:

                    break;
            }
        }while(risStudente != 'c');

    }
    
    //il metodo include inputs e output
    public void pannelloDocente() throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        char risPannello, risDocente, risSegreteria, risdocente2, risStudente, risStudente2;
        
        do{
            System.out.println("benvenuto! nel pannello per i docenti" +
                    "\na. log in" +
                    "\nb. registrati" +
                    "\nc. esci");
            risDocente = stdin.readLine().toLowerCase().charAt(0);

            switch (risDocente){
                case 'a':
                    System.out.println("dimmi il tuo id docente");
                    String idDocente = stdin.readLine();

                    try{
                        String[] splitId = idDocente.split(":");
                        int realId = Integer.parseInt(splitId[1]);

                        //chiaramenteo "last studente" è uguale per tutte le facolta quindi è inutile fare il ciclo... ne prendo una a caso
                        //ovviametne devo anche controllare che lui prima dei : abbiamo scritto "docente"
                        if(realId < facolts.get(0).getLastDocente() && "docente".equals(splitId[0].toLowerCase())){

                            Docente docente = null;
                            for(Facolta_I facolta_i : facolts){
                                if(facolta_i.getDocente(idDocente.toLowerCase()) != null){
                                    docente = facolta_i.getDocente(idDocente.toLowerCase());
                                }
                            }

                            if(docente == null){
                                System.out.println("id non valido"); //se stampa questa cosa è un problema...
                                break;
                            }

                            boolean mettiEsame ;
                            boolean isEsaminatore = false;

                            do{

                                String oo = "bentornato!" +
                                        "\na. posta un nuovo esame" +
                                        "\nb. vedi gli alunni iscritti alla tua facolta" +
                                        "\nc. esci";

                                mettiEsame = facolts.get(docente.getIndexFacolta()).getEsameAttivo() != null;



                                if(mettiEsame){
                                    //lui è l'saminatore?
                                    isEsaminatore = facolts.get(docente.getIndexFacolta()).getEsameAttivo().getEsaminatore().equals(docente);
                                    if(isEsaminatore){
                                        oo = oo.replace("a. posta un nuovo esame","a. chiudi esame postato");
                                    }
                                    else{
                                        oo = oo.replace("a. posta un nuovo esame","");
                                    }

                                    oo = oo.replace("c. esci", "c. Visualizza studenti iscritti all'esame\nd. esci");
                                }

                                System.out.println(oo);
                                risdocente2 = stdin.readLine().toLowerCase().charAt(0);

                                switch (risdocente2){
                                    case 'a':
                                        if(isEsaminatore && mettiEsame){
                                            //annulla esame
                                            Facolta_I facolta = facolts.get(docente.getIndexFacolta());
                                            docente.chiudiEsame(facolta);
                                            System.out.println("esame chiuso");
                                        }
                                        else if(!mettiEsame){
                                            //posta un esame
                                            Facolta_I facolta = facolts.get(docente.getIndexFacolta());
                                            Esame nextEsame = facolta.getNextEsame();
                                            if(nextEsame != null){
                                                docente.postaEsame(facolta, nextEsame);
                                                System.out.println("esame aperto");
                                            }
                                            else{
                                                System.out.println("sono finiti gli esami per qeusta facolta");
                                            }

                                        }
                                        break;
                                    case 'b':
                                        int i=0;
                                        for(Studente studente : facolts.get(docente.getIndexFacolta()).getStudenti()){
                                            System.out.println((i+1)+ ". " + studente);
                                        }
                                        break;
                                    case 'c':
                                        if(mettiEsame){
                                            Facolta_I facolta = facolts.get(docente.getIndexFacolta());
                                            int ii=0;
                                            System.out.println("facolta: "+ facolta.getIdFacolta() + " nome esame: " + facolta.getEsameAttivo().getNomeEsame());
                                            if(facolta.getEsameAttivo().getStudentiIscritti().isEmpty()){
                                                System.out.println("non ci sono iscritti per questo esame");
                                                break;
                                            }

                                            for(Studente  studente : facolta.getEsameAttivo().getStudentiIscritti()){
                                                System.out.println((ii+1)+". "+studente.toString());
                                            }
                                        }

                                        break;
                                    default:
                                        break;
                                }


                                if(mettiEsame){
                                    if(risdocente2 == 'd'){
                                        risdocente2 = 'c';
                                    }
                                    else if(risdocente2 == 'c'){
                                        risdocente2 = 'd';
                                    }
                                }



                            }while (risdocente2 != 'c');

                        }
                        else{
                            System.out.println("non sono riuscito a trovare il tuo id sei sicuro di averlo messo bene?");
                        }
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("sintassi id errata (sintassi= \"docente:[id]\") ");
                    }

                    break;
                case 'b':
                    //assumi docente
                    int rissBDoc;
                    do{
                        int i=0;
                        for(Facolta_I facolta_i : facolts){
                            System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                            i++;
                        }

                        rissBDoc = Integer.parseInt(stdin.readLine()) - 1;


                    }while(rissBDoc >= facolts.size() || rissBDoc < 0);



                    System.out.println("dimmi il tuo nome");
                    String none = stdin.readLine();
                    System.out.println("dimmi il tuo cognome");
                    String cognome = stdin.readLine();

                    docentiInAttesa.add(new Docente(none, cognome, facolts.get(rissBDoc).getIdFacolta()));
                    
                    System.out.println("la tua richiesta è stata inviata con successo");
                    break;
                default:

                    break;
            }


        }while(risDocente != 'c');
    }

    @JsonIgnore
    public String getPathSalvataggio() {
        return pathSalvataggio;
    }

    @JsonGetter
    public ArrayList<Studente> getStudentiInAttesa() {
        return studentiInAttesa;
    }

    @JsonGetter
    public ArrayList<Docente> getDocentiInAttesa() {
        return docentiInAttesa;
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Giurispudenza.class, name = "giurisprudenza"),
            @JsonSubTypes.Type(value = Matematica.class, name = "matematica"),
            @JsonSubTypes.Type(value = Informatica.class, name = "informatica")
    })
    public ArrayList<Facolta_I> getFacolts() {
        return facolts;
    }

    public void caricaScenario() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Università uni = objectMapper.readValue(new File("dati.json"), Università.class);

        this.studentiInAttesa = uni.studentiInAttesa;
        this.docentiInAttesa = uni.docentiInAttesa;
        this.facolts = uni.facolts;

        int docenti=0,studenti=0;
        for(Facolta_I facolta_i : this.facolts){
            studenti += facolta_i.getStudenti().size();
            docenti += facolta_i.getDocenti().size();
        }

        this.facolts.get(0).setLastDocente(docenti);
        this.facolts.get(0).setLastStudente(studenti);
    }

    public void salvaScenario() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        objectMapper.writeValue(new File(this.pathSalvataggio), this);
    }
}
