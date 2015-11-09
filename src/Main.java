import acm.program.GraphicsProgram;
import java.util.List;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);


        Juego juego =new Juego();

        List<Pez> pecesH = juego.getPecesH();
        for(Pez pez:pecesH){
            add(pez.getImagen());
        }

        List<Pez> pecesM= juego.getPecesM();
        for(Pez pez:pecesM){
            add(pez.getImagen());
        }
        juego.posicion_inicial();

        for(int i =0;i<50;i++){
            juego.MoverPeces();
            pause(200);
        }

    }

}
