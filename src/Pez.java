import acm.graphics.GImage;

/**
 * Created by Vipi on 02/11/2015.
 */
public class Pez {
    private String sexe;
    private GImage imagen;

    public Pez(String sexe,GImage imagen){
        this.sexe=sexe;
        this.imagen=imagen;
    }

    public Pez(){

    }

    public GImage getImagen() {
        return imagen;
    }

    public void setImagen(GImage imagen) {
        this.imagen = imagen;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
