import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.Random;

public class Peces {

    private ArrayList<Pez> peces=new ArrayList<>();
    private int total=50;
    private GImage imagen;
    private Random rand=new Random();

    public Peces(){

        int cantidad=0;

        while(cantidad<total){
            Pez pez=new Pez();
            if(cantidad<25){
                imagen = new GImage("imagenes/pezH.png");
                pez.setSexe("Hembra");
                int direccion=rand.nextInt(4)+1;
                if(direccion==3){
                    direccion=-1;
                }if(direccion==4){
                    direccion=-2;
                }
                pez.setDireccion(direccion);
                pez.setVelocidad(rand.nextInt(5)+1);
                pez.setImagen(imagen);
                imagen.setSize(80,60);
                peces.add(pez);
            }
            if(cantidad>=25){
                imagen = new GImage("imagenes/pezM.png");
                pez.setSexe("Macho");
                int direccion=rand.nextInt(4)+1;
                if(direccion==3){
                    direccion=-1;
                }if(direccion==4){
                    direccion=-2;
                }
                pez.setDireccion(direccion);
                pez.setVelocidad(rand.nextInt(5)+1);
                pez.setImagen(imagen);
                imagen.setSize(80,60);
                peces.add(pez);
            }
            cantidad++;
        }
    }

    public ArrayList<Pez> getPeces() {
        return peces;
    }


    /*public void MoverPeces (int x,int y){
        for(Pez pez:peces){ //vigilar
            pez.getImagen().move(x,y);
        }
    }*/

    public void MoverPeces(){
        for(Pez pez:peces){
            if(pez.getDireccion()==1){
                pez.getImagen().move(pez.getVelocidad(),0);
            }if(pez.getDireccion()==-1){
                pez.getImagen().move(-1*pez.getVelocidad(),0);
            }if(pez.getDireccion()==2){
                pez.getImagen().move(0,pez.getVelocidad());
            }if(pez.getDireccion()==-2){
                pez.getImagen().move(0,-1*pez.getVelocidad());
            }
        }

    }
}
