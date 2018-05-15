package ella.lablo52;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by uca on 04-16-18.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    Context con;
    List<Planet> pLanetList;
    List<Integer> updatedFavs;
    boolean isFavTab;

    public PlanetAdapter(Context con, List<Planet> pLanetList) {
        this.pLanetList = pLanetList;
        this.con = con;
    }

    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View v = inflater.inflate(R.layout.list_layout, null);

        return new PlanetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanetAdapter.PlanetViewHolder holder, final int position) {
        updatedFavs = new ArrayList<>();
        holder.tTxt.setText(pLanetList.get(position).getNombre());
        holder.dTxt.setText(pLanetList.get(position).getDesc());
        holder.btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(!pLanetList.get(position).isFav){
                    pLanetList.get(position).setFav(true);
                    if(isFavTab) updatedFavs.remove(pLanetList.get(position).getPlanetID());
                    Toast.makeText(con, "Se cambio el estado a verdadero.", Toast.LENGTH_LONG);
                }
                else{
                    pLanetList.get(position).setFav(false);
                    if(isFavTab){
                        updatedFavs.add(pLanetList.get(position).getPlanetID());
                    }
                    Toast.makeText(con, "Se cambio el estado a falso.", Toast.LENGTH_LONG);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return pLanetList.size();
    }

    protected class PlanetViewHolder extends ViewHolder {
        TextView tTxt, dTxt;
        ImageButton btn;

        public PlanetViewHolder(View itemView) {
            super(itemView);

            tTxt = itemView.findViewById(R.id.txt1);
            dTxt = itemView.findViewById(R.id.txt2);
            btn = itemView.findViewById(R.id.imageButton);
        }
    }

    public List<Planet> getpLanetList(){
        return pLanetList;
    }
    public void setIsFavTab(boolean x){
        this.isFavTab = x;
    }


    //para fragmento con todas las series
    public void updateFavState(List<Integer> id){
        for(int i = 0; i < id.size(); i++){
            for(Planet planet:pLanetList){
                if(planet.getPlanetID() == id.get(i))planet.setFav(false);
            }
        }

    }
    public List<Integer> getUpdatedFavs(){
        return updatedFavs;
    }
}
