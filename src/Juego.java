import acm.graphics.GImage;

import java.util.ArrayList;

/**
 * Created by Vipi on 02/11/2015.
 */
public class Juego {
    private ArrayList<Pez> Peces= new ArrayList<>();
    private int cantidad=50;
    private GImage imagenH;
    private GImage imagenM;

    public void llenarpeces(){
        Pez pez=new Pez();
        while(cantidad !=0){
            pez.setSexe();
            pez.setVelocidad();
            if(pez.getSexe()=="Hombre"){
                imagenH =new GImage("imagenes/pezH.png");
                pez.setImagen(imagenH);
                int contadorH =0;
                if(contadorH<25){
                    Peces.add(pez);
                    contadorH ++;
                }
            }else if (pez.getSexe()=="Hembra") {
                imagenM =new GImage("imagenes/pezM.png");
                pez.setImagen(imagenM);
                int contadorM =0;
                if(contadorM<25){
                    Peces.add(pez);
                    contadorM ++;
                }
            }

        }
    }

    public final void MoverPeces(int x, int y){
        for(Pez pez: Peces){
            pez.getImagen().move(x,y);
        }
    }
    public final void girarpez(){


    }


}
