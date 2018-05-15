package ella.lablo52;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.ViewPagerOnTabSelectedListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ella.lablo52.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    Bundle args;
    SeriesFragment s1;
    SeriesFragment s2;
    TabLayout tabLayout;
    public ViewPager viewPager;
    static ViewPagerAdapter vpadapter;
    private String[] tabTitles = {"Series", "Favs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         viewPager = findViewById(R.id.viewPager);
        loadViewPager(viewPager);
        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(tabTitles[0]);
        tabLayout.getTabAt(1).setText(tabTitles[1]);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                if(position == 1){
                    List<Planet> listaDeFavoritos = new ArrayList<>();

                    for(Planet planeta:s1.getPlanetList()){
                        listaDeFavoritos.add(planeta);
                    }

                    Iterator<Planet> iter = listaDeFavoritos.iterator();
                    while(iter.hasNext()){
                        Planet planet = iter.next();
                        if(!planet.isFav){
                            iter.remove();
                        }
                    }
                    s2.updateFavourites(listaDeFavoritos);
                }else if(position == 2){
                    s1.getAdapater().updateFavState(s2.getAdapater().getUpdatedFavs());
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    public void loadViewPager(ViewPager viewPager){
        vpadapter = new ViewPagerAdapter(getSupportFragmentManager());
        s1 = new SeriesFragment(false);
        vpadapter.addFragment(s1);

        s2 = new SeriesFragment(true);
        vpadapter.addFragment(s2);

        viewPager.setAdapter(vpadapter);

    }

}
