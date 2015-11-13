import acm.graphics.GImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    private Peces peces;
    private ArrayList<Pez> Crias =new ArrayList<Pez>();

    public Juego(){
        peces = new Peces();
    }

    public List<Pez> getPeces() {
        return peces.getPeces();
    }

    public void posicion_inicial(){
        for(int i=0;i<getPeces().size();i++){
            Pez pes =getPeces().get(i);
            pes.PosiconararPez(getAleatori(1300 - pes.getImagen().getWidth(),0), getAleatori(0,600 - pes.getImagen().getHeight()));
        }

    }
    public double getAleatori(double min, double max){
        return Math.random() *(max-min+1)+min;
    }

    public void MoverPeces(){
        for(Pez pez:getPeces()){
            pez.Mover();
        }

    }
    public void EliminarPeces(Pez pez){
        getPeces().remove(pez);
    }


    public void choque(Pez pez1){

         GImage imagen;
         Random rand=new Random();
        for(Pez pez2:getPeces()){
            if(colisionan(pez1,pez2)){
                if(pez1.getSexe()=="Macho" && pez2.getSexe()=="Macho"|| pez1.getSexe()=="Hembra" && pez2.getSexe()=="Hembra"){
                    pez1.setEsMort(true);
                    pez2.setEsMort(true);
                }if(pez1.getSexe()=="Macho" && pez2.getSexe()=="Hembra" || pez1.getSexe()=="Hembra" && pez2.getSexe()=="Macho" ){

                    Pez pezhijo=new Pez();

                    int sexe= rand.nextInt(2)+1;
                    if (sexe==1){
                        imagen = new GImage("imagenes/pezH.png");
                        pezhijo.setSexe("Hembra");
                        int direccion=rand.nextInt(4)+1;
                        if(direccion==3){
                            direccion=-1;
                        }if(direccion==4){
                            direccion=-2;
                        }
                        pezhijo.setDireccion(direccion);
                        pezhijo.setVelocidad(rand.nextInt(10)+1);
                        pezhijo.setEsMort(false);
                        pezhijo.setImagen(imagen);
                        imagen.setSize(80,60);
                        Crias.add(pezhijo);
                    }if(sexe==2){
                        imagen = new GImage("imagenes/pezM.png");
                        pezhijo.setSexe("Macho");
                        int direccion=rand.nextInt(4)+1;
                        if(direccion==3){
                            direccion=-1;
                        }if(direccion==4){
                            direccion=-2;
                        }
                        pezhijo.setDireccion(direccion);
                        pezhijo.setVelocidad(rand.nextInt(10)+1);
                        pezhijo.setEsMort(false);
                        pezhijo.setImagen(imagen);
                        imagen.setSize(80,60);
                        Crias.add(pezhijo);
                    }
                }

            }
        }

    }

    public boolean colisionan(Pez pez1,Pez pez2){
        return (!pez1.getPosicion().equals(pez2.getPosicion()) && pez1.getPosicion().intersects(pez2.getPosicion()));
    }

}
