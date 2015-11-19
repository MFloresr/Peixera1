import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Pecera {

    private ArrayList<Pez> peces=new ArrayList<>();
    private ArrayList<Pez> Crias =new ArrayList<Pez>();
    private ArrayList<Pez> Muertos =new ArrayList<Pez>();
    private static int total=10;
    private GImage imagen;
    private Random rand=new Random();



    public Pecera(){

        int cantidad=0;

        while(cantidad<total){
            Pez pez=new Pez();
            if(cantidad%2==0){
                //Nuevopez("Hembra",false);
                imagen = new GImage("imagenes/pezH.png");
                pez.setSexe("Hembra");
                pez.setDireccion();
                pez.setVelocidad();
                pez.setSeReproduce(false);
                pez.setImagen(imagen);
                imagen.setSize(20,20);
                peces.add(pez);
            }
            if(cantidad%2==1){
                imagen = new GImage("imagenes/pezM.png");
                pez.setSexe("Macho");
                pez.setDireccion();
                pez.setVelocidad();
                pez.setSeReproduce(false);
                pez.setImagen(imagen);
                imagen.setSize(20,20);
                peces.add(pez);
            }
            cantidad++;
        }
    }

    public void posicion_inicial(){
        for(int i=0;i<getPeces().size();i++){
            Pez pes =getPeces().get(i);
            pes.PosiconararPez(getAleatori(1300 - pes.getImagen().getWidth(),0), getAleatori(0,600 - pes.getImagen().getHeight()));
        }

    }

    public void MoverPeces(){
        for(Pez pez:getPeces()){
            pez.Mover();
        }

    }

    public void choque(Pez pez1){

        for(Pez pez2:getPeces()) {
            if (colisionan(pez1, pez2)) {
                if(SonDelMismoSexo(pez1, pez2)==true){
                    pez1.setEsMort(true);
                    pez2.setEsMort(true);

                }if (SepuedeReproducir(pez1, pez2)==true) {
                    pez1.setSeReproduce(true);
                    pez2.setSeReproduce(true);
                    Pez pez3 = new Pez();
                    pez3.setImagen(pez1.getImagen());
                    pez3.setSexe(pez1.getSexe());
                    pez3.setSeReproduce(false);
                    pez3.setDireccion();
                    pez3.setEsMort(false);
                    pez3.setVelocidad();
                    Crias.add(pez3);
                }
            }

        }

        //add crias
        for(Pez pezBB:Crias){
            peces.add(pezBB);
        }
        // quitamos los peces muertos
        for (Pez m : Muertos) {
            peces.remove(m);
        }
    }

    public boolean colisionan(Pez pez1,Pez pez2){
        return (!pez1.getPosicion().equals(pez2.getPosicion()) && pez1.getPosicion().intersects(pez2.getPosicion()));
    }





    public ArrayList<Pez> getPeces() {
        return peces;
    }
    public ArrayList<Pez> getCrias() {
        return Crias;
    }
    public ArrayList<Pez> getMuertos() {
        return Muertos;
    }

    private double getAleatori(double min, double max){
        return Math.random() *(max-min+1)+min;
    }
    private boolean SonDelMismoSexo(Pez pez1,Pez pez2){
        if (pez1.getSexe() == "Macho" && pez2.getSexe() == "Macho" || pez1.getSexe() == "Hembra" && pez2.getSexe() == "Hembra") {
            return true;
        }
        return false;
    }
    private boolean SepuedeReproducir(Pez pez1,Pez pez2){
        if (pez1.getSexe() == "Macho" && pez2.getSexe() == "Hembra" || pez1.getSexe() == "Hembra" && pez2.getSexe() == "Macho") {
            return true;
        }
        return false;

    }

}
