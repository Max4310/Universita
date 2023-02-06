/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author STUDENTE
 */
import Facolta.*;
import universita.*;
import Persone.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        char risPannello, risDocente, risSegreteria, risdocente2, risStudente, risStudente2;

        
        ArrayList<Studente> studentiInAttesa = new ArrayList<>(); //lista di studenti che la segreteria deve ancora approvare
        ArrayList<Docente> docentiInAttesa = new ArrayList<>(); //lista di docenti che la segreteria deve ancora approvare
        ArrayList<Facolta_I> universita = new ArrayList<>(); //liste delle facolta

        universita.add(new Giurispudenza());
        universita.add(new Informatica());
        universita.add(new Matematica());

        /*Docente docente1 = new Docente("fdjs","dfiks","docente:0");
        docente1.setIndexFacolta(0);*/

        /*Docente docente2 = new Docente("fdjs","dfiks","docente:1");
        docente2.setIndexFacolta(0);
        Docente docente3 = new Docente("fdjs","dfiks","docente:2");
        docente3.setIndexFacolta(1);*/

        /*universita.get(0).addDocente(docente1);

        universita.get(docente1.getIndexFacolta()).setEsameAttivo(new EsameAttivo(universita.get(0).getNextEsame().getNomeEsame(), universita.get(0), docente1));*/


        /*Studente studente1 = new Studente("ma","fdsfd","studente:0");
        studente1.setIndexFacolta(0);

        studente1.setIscritto(true);
        universita.get(0).getEsameAttivo().addStudente(studente1);*/




        /*Studente studente2 = new Studente("fdsfd","dfsfsd","studente:1");
        studente2.setIndexFacolta(1);
        Studente studente3 = new Studente("dfusdfsd","m,add","studente:2");
        studente3.setIndexFacolta(1);*/

        //universita.get(0).addStudente(studente1);
        //universita.get(1).addStudente(studente2);
        //universita.get(1).addStudente(studente3);



        //universita.get(0).addDocente(docente2);
        //universita.get(1).addDocente(docente3);


        /*for(Facolta_I facolta : universita){
            System.out.println(facolta.toString());
        }*/

        /*studentiInAttesa.add(new Studente("max","4310",universita.get(1).getIdFacolta()));
        studentiInAttesa.add(new Studente("mafdsfdx","dfsfsdf",universita.get(2).getIdFacolta()));
        studentiInAttesa.add(new Studente("weeee","89023743",universita.get(1).getIdFacolta()));


        docentiInAttesa.add(new Docente("max","4310",universita.get(1).getIdFacolta()));
        docentiInAttesa.add(new Docente("mafdsfdx","dfsfsdf",universita.get(2).getIdFacolta()));
        docentiInAttesa.add(new Docente("weeee","89023743",universita.get(1).getIdFacolta()));*/







        do{
            System.out.println("cosa vuoi gestire?" +
                    "\na. Segreteria" +
                    "\nb. Docente" +
                    "\nc. Studente" +
                    "\nd. Esci");
            risPannello = stdin.readLine().toLowerCase().charAt(0);

            switch (risPannello){
                case 'a':
                    //segreteria
                    //menu della segreteria
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
                                for(Facolta_I facolta : universita){
                                    System.out.println(facolta.toString());
                                }
                                break;
                            case 'b':
                                int riss;
                                do{
                                    int i=0;
                                    for(Facolta_I facolta_i : universita){
                                        System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                                        i++;
                                    }

                                    riss = Integer.parseInt(stdin.readLine()) - 1;
                                }while(riss>=universita.size() || riss < 0 );

                                if(universita.get(riss).getStudenti().size()>0){
                                    int i=0;
                                    for(Studente studente : universita.get(riss).getStudenti()){
                                        System.out.println((i+1)+". "+studente.toString());
                                        i++;
                                    }
                                }
                                else{
                                    System.out.println("La Facolta di "+ universita.get(riss).getIdFacolta()+ " non ha studenti");
                                }
                                break;
                            case 'c':
                                int rissC;
                                do{
                                    int i=0;
                                    for(Facolta_I facolta_i : universita){
                                        System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                                        i++;
                                    }

                                    rissC = Integer.parseInt(stdin.readLine()) - 1;
                                }while(rissC>=universita.size());

                                if(universita.get(rissC).getStudenti().size()>0){
                                    int i=0;
                                    for(Docente docente : universita.get(rissC).getDocenti()){
                                        System.out.println((i+1)+". "+docente.toString());
                                        i++;
                                    }
                                }
                                else{
                                    System.out.println("La Facolta di "+ universita.get(rissC).getIdFacolta()+ " non ha docenti");
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
                                            for(Facolta_I facolta : universita){
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

                                        for(Facolta_I facolta : universita){

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
                                            for(Facolta_I facolta : universita){
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

                                        for(Facolta_I facolta : universita){

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

                    break;
                case 'b':
                    //docenti
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
                                    if(realId < universita.get(0).getLastDocente() && "docente".equals(splitId[0].toLowerCase())){

                                        Docente docente = null;
                                        for(Facolta_I facolta_i : universita){
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

                                            mettiEsame = universita.get(docente.getIndexFacolta()).getEsameAttivo() != null;



                                            if(mettiEsame){
                                                //lui è l'saminatore?
                                                isEsaminatore = universita.get(docente.getIndexFacolta()).getEsameAttivo().getEsaminatore().equals(docente);
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
                                                        Facolta_I facolta = universita.get(docente.getIndexFacolta());
                                                        facolta.setEsameAttivo(null);
                                                    }
                                                    else if(!mettiEsame){
                                                        //posta un esame
                                                        Facolta_I facolta = universita.get(docente.getIndexFacolta());
                                                        Esame nextEsame = facolta.getNextEsame();
                                                        if(nextEsame != null){
                                                            facolta.remoteEsame(); //rimuovo l'esame che mi sono apepna gettato
                                                            facolta.setEsameAttivo(new EsameAttivo(nextEsame.getNomeEsame(), facolta, docente));
                                                        }
                                                        else{
                                                            System.out.println("sono finiti gli esami per qeusta facolta");
                                                        }

                                                    }

                                                    break;
                                                case 'b':
                                                    int i=0;
                                                    for(Studente studente : universita.get(docente.getIndexFacolta()).getStudenti()){
                                                        System.out.println((i+1)+ ". " + studente);
                                                    }
                                                    break;
                                                case 'c':
                                                    if(mettiEsame){
                                                        Facolta_I facolta = universita.get(docente.getIndexFacolta());
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
                                    for(Facolta_I facolta_i : universita){
                                        System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                                        i++;
                                    }

                                    rissBDoc = Integer.parseInt(stdin.readLine()) - 1;


                                }while(rissBDoc >= universita.size() || rissBDoc < 0);



                                System.out.println("dimmi il tuo nome");
                                String none = stdin.readLine();
                                System.out.println("dimmi il tuo cognome");
                                String cognome = stdin.readLine();

                                docentiInAttesa.add(new Docente(none, cognome, universita.get(rissBDoc).getIdFacolta()));
                                
                                System.out.println("la tua richiesta è stata inviata con successo");
                                break;
                            default:

                                break;
                        }
                    }while(risDocente != 'c');


                    break;
                case 'c':
                    //studente
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

                                    if(realId < universita.get(0).getLastStudente() && "studente".equals(splitId[0].toLowerCase())){
                                        boolean iscrivitiNuoviEsami = true;  /*metti il cotnrollo sul se ci sta un nuovo esame da fare*/
                                        boolean faiNuovoEsame = true; /*metti il controllo sul se ci sono nuovi esami cheil tipo nn ha fatto!*/
                                        boolean giaFatto = false;

                                        Studente studente = null;
                                        for(Facolta_I facolta_i : universita){
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


                                            iscrivitiNuoviEsami = universita.get(studente.getIndexFacolta()).getEsameAttivo() != null;
                                            //se c'è un esame attivo da fare

                                            faiNuovoEsame = studente.isIscritto();
                                            /*metti il controllo sul se ci sono nuovi esami cheil tipo nn ha fatto!*/


                                            //System.out.println(faiNuovoEsame);
                                            if(iscrivitiNuoviEsami && !faiNuovoEsame){
                                                giaFatto = studente.isGiaFatto(universita.get(studente.getIndexFacolta()).getEsameAttivo());
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
                                                    System.out.println("Facolta: " + universita.get(studente.getIndexFacolta()).getIdFacolta());
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
                                                    System.out.println("Facolta: " + universita.get(studente.getIndexFacolta()));

                                                    int i=0;
                                                    for(Esame esame : universita.get(studente.getIndexFacolta()).getEsami()){
                                                        System.out.println((i+1)+". "+esame);
                                                        i++;
                                                    }
                                                    break;
                                                case 'c':
                                                    if(iscrivitiNuoviEsami && !faiNuovoEsame && !giaFatto){
                                                        //CASO IN CUI HA NUOVI ESAMI DA ISCRIVERSI
                                                        studente.setIscritto(true);

                                                        Facolta_I facolta = universita.get(studente.getIndexFacolta());
                                                        facolta.getEsameAttivo().addStudente(studente);
                                                    }
                                                    else if(faiNuovoEsame){
                                                        //CASO IN CUI DEVE FARE L'ESAME A CUI E' ISCRITTO
                                                        Facolta_I facolta = universita.get(studente.getIndexFacolta());
                                                        EsameAttivo esameAttivo = facolta.getEsameAttivo();

                                                        float voto = (float) Math.round(ThreadLocalRandom.current().nextDouble(5.0,30.0)*100)/100;;
                                                        EsameStudente esameStudente = new EsameStudente(esameAttivo.getNomeEsame(), esameAttivo.getFacolta(),voto ,esameAttivo.getEsaminatore());
                                                        facolta.getEsameAttivo().removeStudente(studente);

                                                        studente.addEsame(esameStudente);
                                                        studente.setIscritto(false);

                                                        System.out.println("hai completato l'esame il tuo voto e': "+ voto);
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
                                    for(Facolta_I facolta_i : universita){
                                        System.out.println((i+1)+". "+facolta_i.getIdFacolta());
                                        i++;
                                    }

                                    rissBStu = Integer.parseInt(stdin.readLine()) - 1;


                                }while(rissBStu >= universita.size() || rissBStu < 0);



                                System.out.println("dimmi il tuo nome");
                                String none = stdin.readLine();
                                System.out.println("dimmi il tuo cognome");
                                String cognome = stdin.readLine();
                                
                                studentiInAttesa.add(new Studente(none, cognome, universita.get(rissBStu).getIdFacolta()));
                                
                                System.out.println("la tua richiesta è stata inviata con successo");
                                

                                break;
                            default:

                                break;
                        }
                    }while(risStudente != 'c');

                    break;
                default:
                    break;
            }




        }while(risPannello != 'd');
        
    }
    
}
