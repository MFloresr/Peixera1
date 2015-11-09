import acm.graphics.GImage;
import java.util.ArrayList;
import java.util.List;

public class Peces {

    private ArrayList<Pez> PecesH= new ArrayList<>();  //hembras
    private ArrayList<Pez> PecesM= new ArrayList<>(); //machos
    private int cantidad=5;
    private GImage imagen;

    public Peces(){
        LlenarListas(PecesH,"Hembra","imagenes/pezH.png");
        LlenarListas(PecesH,"Macho","imagenes/pezM.png");
    }

    private void LlenarListas(List<Pez> peces,String sexe,String imagenf){
        for(int i=0;i<cantidad;i++){
            Pez pez=new Pez();
            imagen = new GImage(imagenf);
            pez.setSexe(sexe);
            pez.setDireccion();
            pez.setVelocidad();
            pez.setImagen(imagen);
            imagen.setSize(80,60);
            peces.add(pez);
        }
    }

    public ArrayList<Pez> getPecesH() {
        return PecesH;
    }

    public ArrayList<Pez> getPecesM() {
        return PecesM;
    }
    public void MoverPeces (int x,int y){
        for(Pez pez:PecesH){ //vigilar
            pez.getImagen().move(x,y);
        }
        for(Pez pez:PecesM){  //vigilar
            pez.getImagen().move(x,y);
        }

    }

}
