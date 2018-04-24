package ella.lablo52;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by uca on 04-16-18.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    Context con;
    List<Planet> pLanetList;

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
        holder.tTxt.setText(pLanetList.get(position).getNombre());
        holder.dTxt.setText(pLanetList.get(position).getDesc());
        holder.btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pLanetList.get(position).setFav(true);
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
}
