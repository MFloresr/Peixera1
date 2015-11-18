import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Pecera {

    private ArrayList<Pez> peces=new ArrayList<>();
    private int total=10;
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

    public ArrayList<Pez> getPeces() {
        return peces;
    }

}
