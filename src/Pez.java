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
    private int direccion;
    private Random rand=new Random();

    public Pez(String sexe,GImage imagen,int direcion){
        this.sexe=sexe;
        this.imagen = imagen;
        velocidad = rand.nextInt(20)+2;
        this.direccion = direcion;

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

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getSexe() {
        return sexe;
    }



    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void PosiconararPez(double x, double y){
        imagen.setLocation(x,y);
    }


    public GRectangle getPosicion(){
        return imagen.getBounds();
    }
}
