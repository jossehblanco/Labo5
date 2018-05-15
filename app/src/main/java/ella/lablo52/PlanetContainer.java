package ella.lablo52;

import java.util.ArrayList;

/**
 * Created by UCA on 23/4/2018.
 */

public class PlanetContainer {
    ArrayList<Planet> planetList;

    public PlanetContainer(){
        planetList = new ArrayList<>();
        String desc1 = "La conoces a ella, y no te quiere.";
        String desc2 = "Ella contraataca, pero aun no te quiere.";
        String desc3 = "Ella regresó, pero jamás te va a querer.";
        planetList.add(new Planet(1, "Ella", desc1));
        planetList.add(new Planet(2, "Ella Contraataca", desc2));
        planetList.add(new Planet(3, "El Retorno de Ella", desc3));
    }
    public ArrayList<Planet> getPlanetList(){
        return planetList;
    }
}
