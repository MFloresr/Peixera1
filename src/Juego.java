import java.util.List;

public class Juego {
    private Peces pecesH;
    private Peces pecesM;

    public Juego(){
        pecesH = new Peces();
        pecesM = new Peces();
    }

    public List<Pez> getPecesH() {
        return pecesH.getPecesH();
    }

    public void posicion_inicial(){
        for(int i=0;i<getPecesH().size();i++){
            Pez pes =getPecesH().get(i);

            pes.PosiconararPez(getAleatori(1300 - pes.getImagen().getWidth(),0), getAleatori(0,600 - pes.getImagen().getHeight()));
        }
        for(int i=0;i<getPecesM().size();i++){
            Pez pes =getPecesM().get(i);

            pes.PosiconararPez(getAleatori(1300 - pes.getImagen().getWidth(),0), getAleatori(0,600 - pes.getImagen().getHeight()));
        }
    }

    public double getAleatori(double min, double max){
        return Math.random() *(max-min+1)+min;
    }

    public List<Pez> getPecesM() {
        return pecesM.getPecesM();
    }

    public void MoverPeces(){
        //pecesH.MoverPeces(-5,0);
        pecesM.MoverPeces(5,0);

    }

}
