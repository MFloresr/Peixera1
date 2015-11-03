import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);
        Juego juego =new Juego();
        juego.llenarpeces();
        juego.MoverPeces(10,0); // canviar


    }
}
