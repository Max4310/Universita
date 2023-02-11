import universita.Università;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*class prova{
    private int c;

    prova(int c){
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public String toString(){
        //System.out.print("cmdo");
        return ""+this.c;
    }
}*/


public class Test {

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        char risPannello;
        Università università = new Università();


        /*ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);


        //objectMapper.writeValue(new File("dati.json"), università);
        università = objectMapper.readValue(new File("dati.json"), Università.class);*/


        do{
            System.out.println("vuoi ripristinare lo scenario da dove lo avevi lasciato l'ultima volta?  (y/n) ");
            risPannello = stdin.readLine().toLowerCase().charAt(0);
        }while (risPannello != 'y' && risPannello != 'n');

        if(risPannello == 'y'){
            System.out.println("scenario ricaricato");
            università.caricaScenario();
        }


        do{
            System.out.println("cosa vuoi gestire?" +
                    "\na. Segreteria" +
                    "\nb. Docente" +
                    "\nc. Studente" +
                    "\nd. Salva Scenario" +
                    "\ne. Esci");
            risPannello = stdin.readLine().toLowerCase().charAt(0);

            switch (risPannello){
                case 'a':
                    //segreteria
                    università.pannelloSegreteria();
                    break;
                case 'b':
                    //docenti
                    università.pannelloDocente();
                    break;
                case 'c':
                    //studente
                    università.pannelloStudente();
                    break;
                case 'd':
                    //salva lo scenario sul file json
                    università.salvaScenario();
                    break;
                default:
                    break;
            }
        }while(risPannello != 'e');
        
    }
    
}
