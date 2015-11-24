import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Pecera {

    private ArrayList<Animal> AnimalesMarinos=new ArrayList<>();
    private ArrayList<Animal> Crias =new ArrayList<Animal>();
    private static int totalpeces=50;
    private static int totaltiburones=6;
    private GImage imagen;

    public Pecera(){
        crearPeces();
        crearTiburones();
    }


    public void posicion_inicial(){
        for(int i=0;i<getAnimalesMarinos().size();i++){
            Animal animal =getAnimalesMarinos().get(i);
            PosicionaAnimal(animal);
        }
    }
    public void Mover(){
        MoverAnimames();
    }
    public void choque(Animal ani1){

        Animal quecoliciona=AnimalQueColisiona(ani1);
        if(quecoliciona!=null){
            if(SonPeces(ani1, quecoliciona)==true || SonTiburones(ani1, quecoliciona)==true ){
                if (diferentesexo(ani1, quecoliciona)){
                    ani1.setEsteril(false);
                    quecoliciona.setEsteril(true);
                }if(SonDelMismoSexo(ani1, quecoliciona)==true) {
                    ani1.setEsMort(true);
                    quecoliciona.setEsMort(true);
                }
            }if(PezContraTiburon(ani1, quecoliciona)==true || TiburonContraPez(ani1, quecoliciona)==true){
                if(ani1.getClass()==Pez.class){
                    ani1.setEsMort(true);
                }if(quecoliciona.getClass()==Pez.class){
                    quecoliciona.setEsMort(true);
                }

            }

        }else{
            if(ani1.isEsteril()==false && ani1.getClass()==Pez.class){
                Pez pez3 = new Pez();
                GImage img=new GImage(ani1.getImagen().getImage());
                img.setSize(20,20);
                pez3.setImagen(img);
                pez3.setSexe(ani1.getSexe());
                pez3.setEsteril(false);
                pez3.setDireccion();
                pez3.setEsMort(false);
                pez3.setVelocidad();
                PosicionaAnimal(pez3);
                Crias.add(pez3);
                ani1.setEsteril(true);
                pez3.setEsteril(true);
            }if(ani1.isEsteril()==false && ani1.getClass()==Tiburon.class){
                Tiburon tibuBb = new Tiburon();
                GImage img=new GImage(ani1.getImagen().getImage());
                img.setSize(30,30);
                tibuBb.setImagen(img);
                tibuBb.setSexe(ani1.getSexe());
                tibuBb.setEsteril(false);
                tibuBb.setDireccion();
                tibuBb.setEsMort(false);
                tibuBb.setVelocidad();
                PosicionaAnimal(tibuBb);
                Crias.add(tibuBb);
                ani1.setEsteril(true);
                tibuBb.setEsteril(true);
            }
        }
    }
    public ArrayList<Animal> getAnimalesMarinos() {
        return AnimalesMarinos;
    }
    public ArrayList<Animal> getCrias() {
        return Crias;
    }


    private Animal AnimalQueColisiona(final Animal a) {
        for (Animal b : getAnimalesMarinos()) {
            if (b != a && a.getPosicion().intersects(b.getPosicion())) {
                return b;
            }
        }
        return null;
    }
    private double getAleatori(double min, double max){
        return Math.random() *(max-min+1)+min;
    }
    private boolean SonDelMismoSexo(Animal ani1,Animal ani2){
        if (ani1.getSexe() == "Macho" && ani2.getSexe() == "Macho" || ani1.getSexe() == "Hembra" && ani2.getSexe() == "Hembra") {
            return true;
        }
        return false;
    }
    private boolean diferentesexo(Animal ani1,Animal ani2){
        if (ani1.getSexe() == "Macho" && ani2.getSexe() == "Hembra" ||ani1.getSexe() == "Hembra" && ani2.getSexe() == "Macho") {
            return true;
        }
        return false;

    }
    private void crearPeces(){
        int cantidad=0;

        while(cantidad<totalpeces){
            Animal pez=new Pez();
            if(cantidad%2==0){
                //Nuevopez("Hembra",false);
                imagen = new GImage("imagenes/pezH.png");
                pez.setSexe("Hembra");
                pez.setDireccion();
                pez.setVelocidad();
                pez.setEsMort(false);
                pez.setImagen(imagen);
                imagen.setSize(20,20);
                AnimalesMarinos.add(pez);
            }
            if(cantidad%2==1){
                imagen = new GImage("imagenes/pezM.png");
                pez.setSexe("Macho");
                pez.setDireccion();
                pez.setVelocidad();
                pez.setEsMort(false);
                pez.setImagen(imagen);
                imagen.setSize(20,20);
                AnimalesMarinos.add(pez);
            }
            cantidad++;
        }
    }
    private void crearTiburones(){
        int cantidad=0;
        while(cantidad<totaltiburones){
            Tiburon tibu=new Tiburon();
            if(cantidad%2==0){
                imagen = new GImage("imagenes/tibuH.png");
                tibu.setSexe("Hembra");
                tibu.setDireccion();
                tibu.setVelocidad();
                tibu.setEsMort(false);
                tibu.setImagen(imagen);
                imagen.setSize(30,30);
                AnimalesMarinos.add(tibu);
            }if(cantidad%2==1){
                imagen = new GImage("imagenes/tibuM.png");
                tibu.setSexe("Macho");
                tibu.setDireccion();
                tibu.setVelocidad();
                tibu.setEsMort(false);
                tibu.setImagen(imagen);
                imagen.setSize(30,30);
                AnimalesMarinos.add(tibu);
            }
            cantidad++;
        }
    }
    private void PosicionaAnimal(Animal pez){
        pez.Posiconarar(getAleatori(1300 - pez.getImagen().getWidth(),0), getAleatori(0,600 - pez.getImagen().getHeight()));
    }
    private void MoverAnimames(){
        for(Animal animal:getAnimalesMarinos()){
            animal.Mover();
        }
    }
    private boolean SonTiburones(Animal ani1,Animal ani2){
        if(ani1.getClass()==Tiburon.class && ani2.getClass()==Tiburon.class){
            return true;
        }
        return false;
    }
    private boolean SonPeces(Animal ani1,Animal ani2){
        if(ani1.getClass()==Pez.class && ani2.getClass()==Pez.class){
            return true;
        }
        return false;
    }
    private boolean PezContraTiburon(Animal ani1,Animal ani2){
        if(ani1.getClass()==Pez.class && ani2.getClass()==Tiburon.class){
            return true;
        }
        return false;
    }
    private boolean TiburonContraPez(Animal ani1,Animal ani2){
        if(ani1.getClass()==Tiburon.class && ani2.getClass()==Pez.class){
            return true;
        }
        return false;
    }
}