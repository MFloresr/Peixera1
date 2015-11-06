import acm.graphics.GImage;
import acm.graphics.GRectangle;

import java.util.Random;

/**
 * Created by Vipi on 02/11/2015.
 */
public class Pez {
    private String sexe;
    private GImage imagen;
    private int velocidad;
    private int direccion_x;
    private int direccion_y;
    private Random rand=new Random();

    public Pez(String sexe,GImage imagen,int direcion_x,int direcion_y){
        this.sexe=sexe;
        this.imagen = imagen;
        velocidad = rand.nextInt(20)+2;
        this.direccion_x = direcion_x;
        this.direccion_y = direcion_y;
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

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getDireccion_x() {
        return direccion_x;
    }

    public int setDireccion_x() {
        int direccion = rand.nextInt(2);
        if (direccion==0){
            direccion= -1;
        }
        return direccion;
    }

    public void PosiconararPez(double x, double y){
        imagen.setLocation(x,y);
    }

    public int getDireccio_y() {
        return direccion_y;
    }

    public int setDireccion_y() {
        int direccion = rand.nextInt(2);
        if (direccion==0){
            direccion= -1;
        }
        return direccion;
    }

    public GRectangle getPosicion(){
        return imagen.getBounds();
    }
}
