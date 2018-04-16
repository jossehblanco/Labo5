package ella.lablo52;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Planet> planetList;
    RecyclerView recyclerView;
    PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Llenando lista
        planetList = fillList();
        //Recycler View
        recyclerView = findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PlanetAdapter(this, planetList);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Planet> fillList(){
        ArrayList<Planet> l = new ArrayList<>();
        String desc = "asdñlkasdñsalkñdsalkñdsalkdaslkjdjklaasdfsadsadasdasdasdasdsadas";

        l.add(new Planet(1, "Ella", desc));
        l.add(new Planet(1, "Ella Contraataca", desc));
        l.add(new Planet(1, "El Retorno de Ella", desc));
        return l;
    }
}
