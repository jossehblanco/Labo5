package ella.lablo52;

/**
 * Created by uca on 04-16-18.
 */

public class Planet {
    int planetID;
    String nombre;
    String desc;

    public Planet(int planetID, String nombre, String desc){
        this.planetID = planetID;
        this.nombre = nombre;
        this.desc = desc;
    }
    public int getPlanetID() {
        return planetID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDesc() {
        return desc;
    }

    public void setPlanetID(int planetID) {
        this.planetID = planetID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}