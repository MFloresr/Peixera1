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
    private boolean EsMort;
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

    public boolean getEsMort() {
        return EsMort;
    }

    public void setEsMort(boolean esMort) {
        EsMort = esMort;
    }

    public void PosiconararPez(double x, double y){
        imagen.setLocation(x,y);
    }

    public GRectangle getPosicion(){
        return imagen.getBounds();
    }

    public void Mover(){
        if(direccion==1){
            imagen.move(velocidad,0);
            if(imagen.getLocation().getX()>1300){
                direccion=-1;
            }
        }if(direccion==-1){
            imagen.move(-1*velocidad,0);
            if(imagen.getLocation().getX()<0- imagen.getWidth()){
                direccion=1;
            }
        }if(direccion==2){
            imagen.move(0,velocidad);
            if(imagen.getLocation().getY()>600) {
                direccion = -2;
            }
        }if(direccion==-2){
            imagen.move(0, -1 * velocidad);
            if(imagen.getLocation().getY()<0-imagen.getHeight()) {
                direccion = 2;
            }
        }

    }
}
