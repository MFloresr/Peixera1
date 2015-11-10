import java.util.List;

public class Juego {
    private Peces peces;
    private Pez pez;

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

  /*  public void MoverPeces(){
        peces.MoverPeces(1,0);
    }*/

    public void MoverPeces(){
        for(Pez pez:getPeces()){
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
