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
    private boolean Esteril=true;
    private Random rand=new Random();


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
        velocidad=rand.nextInt(10)+1;
        return velocidad;
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

    public int setDireccion() {
        direccion = rand.nextInt(4)+1;
        if(direccion==3){
            direccion=-1;
        }if (direccion==4){
            direccion=-2;
        }
        return direccion;
    }

    public boolean isEsteril() {
        return Esteril;
    }

    public void setEsteril(boolean Esteril) {
        this.Esteril = Esteril;
        /*if(Esteril==true){
            controlachoque =(int)imagen.getBounds().getWidth();
        }*/
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
