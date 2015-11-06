import acm.graphics.GImage;

import java.util.ArrayList;

/**
 * Created by mario on 06/11/2015.
 */
public class Peces {


    private ArrayList<Pez> Peces= new ArrayList<>();
    private int cantidad=25;
    private GImage imagen;

    public Peces(){
        for(int i=0;i<cantidad;i++ ){

        }

        Pez pez=new Pez();
        while(cantidad !=0){
            pez.setVelocidad();
            pez.setDireccion();
            String sexo = pez.setSexe();
            if(sexo=="Macho"){
                imagen =new GImage("imagenes/pezMH.png",200,300);
                imagen.setSize(80,60);
                pez.setSexe("Macho");
                pez.setImagen(imagen);

                int contadorH =0;
                if(contadorH<25){
                    Peces.add(pez);
                    contadorH ++;
                }
            }else if (sexo=="Hembra") {
                imagen =new GImage("imagenes/pezM.png",400,500);
                imagen.setSize(80,60);
                pez.setSexe("Hembra");
                pez.setImagen(imagen);
                int contadorM =0;
                if(contadorM<25){
                    Peces.add(pez);
                    contadorM ++;
                }
            }

        }
    }

    public ArrayList<Pez> getPeces() {
        return Peces;
    }
}
