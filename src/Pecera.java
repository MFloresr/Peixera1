import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Pecera {

    private ArrayList<Pez> peces=new ArrayList<>();
    private ArrayList<Pez> Crias =new ArrayList<Pez>();
    private ArrayList<Pez> Muertos =new ArrayList<Pez>();
    private static int total=10;
    private GImage imagen;
    //private Random rand=new Random();



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
                pez.setEsMort(false);
                pez.setImagen(imagen);
                imagen.setSize(20,20);
                peces.add(pez);
            }
            if(cantidad%2==1){
                imagen = new GImage("imagenes/pezM.png");
                pez.setSexe("Macho");
                pez.setDireccion();
                pez.setVelocidad();
                pez.setEsMort(false);
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
            Posiciona(pes);
        }

    }
    public void MoverPeces(){
        for(Pez pez:getPeces()){
            pez.Mover();
        }

    }
    public void choque(Pez pez1){

        Pez quecoliciona=pezQueColisiona(pez1);

        if(quecoliciona!=null){
            if (diferentesexo(pez1, quecoliciona)){
                pez1.setEsteril(false);
                quecoliciona.setEsteril(true);
            }if(SonDelMismoSexo(pez1, quecoliciona)==true) {
                pez1.setEsMort(true);
                quecoliciona.setEsMort(true);
            }
        }else{
            if(pez1.isEsteril()==false){
                Pez pez3 = new Pez();
                GImage img=new GImage(pez1.getImagen().getImage());
                img.setSize(20,20);
                pez3.setImagen(img);
                pez3.setSexe(pez1.getSexe());
                pez3.setEsteril(false);
                pez3.setDireccion();
                pez3.setEsMort(false);
                pez3.setVelocidad();
                Posiciona(pez3);
                Crias.add(pez3);
                pez1.setEsteril(true);
                pez3.setEsteril(true);
            }
        }
    }
    private Pez pezQueColisiona(final Pez a) {
        for (Pez b : getPeces()) {
            if (b != a && a.getPosicion().intersects(b.getPosicion())) {
                return b;
            }
        }
        return null;
    }
    public ArrayList<Pez> getPeces() {
        return peces;
    }
    public ArrayList<Pez> getCrias() {
        return Crias;
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
    private boolean diferentesexo(Pez pez1,Pez pez2){
        if (pez1.getSexe() == "Macho" && pez2.getSexe() == "Hembra" || pez1.getSexe() == "Hembra" && pez2.getSexe() == "Macho") {
            return true;
        }
        return false;

    }
    private void Posiciona(Pez pes){
        pes.PosiconararPez(getAleatori(1300 - pes.getImagen().getWidth(),0), getAleatori(0,600 - pes.getImagen().getHeight()));
    }

}
