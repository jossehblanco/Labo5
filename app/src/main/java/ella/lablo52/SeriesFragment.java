package ella.lablo52;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by UCA on 23/4/2018.
 */

public class SeriesFragment extends Fragment{
    View view;
    List<Planet> planetList, favList;
    RecyclerView recyclerView;
    PlanetAdapter adapter;
    boolean isFavTab;
    PlanetContainer p_container;
    LayoutInflater inflater;
    @Nullable ViewGroup container;
    @Nullable Bundle savedInstanceState;
    public SeriesFragment(){

    }
    @SuppressLint("ValidFragment")
    public SeriesFragment(Boolean isFavTab){
        this.isFavTab = isFavTab;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        view = inflater.inflate(R.layout.fragment_series, container, false);
        p_container = new PlanetContainer();
        planetList = fillList();
        //Recycler View
        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PlanetAdapter(getContext(), planetList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private ArrayList<Planet> fillList(){
        ArrayList<Planet> l = new ArrayList<>();
        if(!isFavTab) l = p_container.getPlanetList();
        if(!isFavTab){
            return p_container.getPlanetList();
        }
        else{
            for(int i = 0; i < p_container.getPlanetList().size(); i++){
                Planet paux = p_container.getPlanetList().get(i);
                if(paux.isFav){
                    l.add(paux);
                }
            }
        }


        return l;
    }

    public List<Planet> getPlanetList(){

        return adapter.getpLanetList();
    }

    public void updateFavourites(List<Planet> planetList2){
        adapter = new PlanetAdapter(getContext(), planetList2);
        adapter.setIsFavTab(true);
        recyclerView.setAdapter(adapter);
    }

    public PlanetAdapter getAdapater(){
        return adapter;
    }
}
