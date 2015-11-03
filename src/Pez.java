import acm.graphics.GImage;

import java.util.Random;

/**
 * Created by Vipi on 02/11/2015.
 */
public class Pez {
    private String sexe;
    private GImage imagen;
    private int velocidad;
    private Random rand=new Random();

    public Pez(String sexe,GImage imagen){
        this.sexe=sexe;
        this.imagen=imagen;
        velocidad = rand.nextInt(20)+2;
    }

    public Pez(){

    }

    public GImage getImagen() {
        return imagen;
    }

    public void setImagen(GImage imagen) {
        this.imagen = imagen;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int setVelocidad() {
        int velocitat = rand.nextInt(20)+2;
        return velocitat;
    }

    public String getSexe() {
        return sexe;
    }

    public String setSexe() {
        int alaeatori=rand.nextInt(2);
        if(alaeatori==0){
            String sexe="Macho";
        }else if(alaeatori==1){
            String sexe="Hembra";
        }
        return sexe;
    }
}
