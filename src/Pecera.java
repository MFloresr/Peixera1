import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Pecera {

    private ArrayList<Pez> peces=new ArrayList<>();
    private ArrayList<Pez> Crias =new ArrayList<Pez>();
    private ArrayList<Tiburon> tiburones=new ArrayList<>();
    private ArrayList<Tiburon> CriasTiburones =new ArrayList<Tiburon>();
    private static int totalpeces=60;
    private static int totaltiburones=4;
    private GImage imagen;
    //private Random rand=new Random();



    public Pecera(){
        crearPeces();
        crearTiburones();
    }


    public void posicion_inicial(){
        for(int i=0;i<getPeces().size();i++){
            Pez pez =getPeces().get(i);
            PosicionaPez(pez);
        }
        for(int i=0;i<getTiburones().size();i++){
            Tiburon tiburon = getTiburones().get(i);
            PosicionaTiburon(tiburon);
        }

    }
    public void Mover(){
        MoverPeces();
        MoverTiburones();
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
                PosicionaPez(pez3);
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
    public ArrayList<Tiburon> getTiburones() {
        return tiburones;
    }
    public ArrayList<Tiburon> getCriasTiburones() {
        return CriasTiburones;
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
    private void crearPeces(){
        int cantidad=0;

        while(cantidad<totalpeces){
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
    private void crearTiburones(){
        int cantidad=0;
        while(cantidad<totaltiburones){
            Tiburon tibu=new Tiburon();
            if(cantidad%2==0){
                //Nuevopez("Hembra",false);
                imagen = new GImage("imagenes/tibuH.png");
                tibu.setSexe("Hembra");
                tibu.setDireccion();
                tibu.setVelocidad();
                tibu.setEsMort(false);
                tibu.setImagen(imagen);
                imagen.setSize(20,20);
                tiburones.add(tibu);
            }if(cantidad%2==1){
                imagen = new GImage("imagenes/tibuM.png");
                tibu.setSexe("Macho");
                tibu.setDireccion();
                tibu.setVelocidad();
                tibu.setEsMort(false);
                tibu.setImagen(imagen);
                imagen.setSize(20,20);
                tiburones.add(tibu);
            }
            cantidad++;
        }
    }
    private void PosicionaPez(Pez pez){
        pez.Posiconarar(getAleatori(1300 - pez.getImagen().getWidth(),0), getAleatori(0,600 - pez.getImagen().getHeight()));
    }
    private void PosicionaTiburon(Tiburon tibu){
        tibu.Posiconarar(getAleatori(1300 - tibu.getImagen().getWidth(),0), getAleatori(0,600 - tibu.getImagen().getHeight()));
    }
    private void MoverPeces(){
        for(Pez pez:getPeces()){
            pez.Mover();
        }
    }
    private void MoverTiburones(){
        for(Tiburon tibu:getTiburones()){
            tibu.Mover();
        }
    }

}
