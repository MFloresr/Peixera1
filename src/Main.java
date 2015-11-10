import acm.program.GraphicsProgram;
import java.util.List;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);


        Juego juego =new Juego();

        List<Pez> peces = juego.getPeces();
        for(Pez pez:peces){
            add(pez.getImagen());
        }

        juego.posicion_inicial();

        for(int i =0;i<500;i++){

            pause(50);
        }

    }

}
