package com.example.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler{
    private RecyclerView mRecyclerView;
    CoordinatorLayout mcoordinatorLayout;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Donnee> getDataSource() {
        ArrayList results = new ArrayList<Donnee>();
        for (int index = 0; index < 20; index++) {
            Donnee obj = new Donnee("Texte principal " + index,"Texte auxiliaire " + index,R.drawable.mouton);
            results.add(index, obj);
        }
        return results;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        /**mLayoutManager = new LinearLayoutManager(this);*/
        mLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        ((GridLayoutManager)mLayoutManager) .setSpanSizeLookup(
                new GridLayoutManager.SpanSizeLookup() {

                    @Override
                    public int getSpanSize(int arg0) {
                        return (arg0 % 3) == 0 ? 2 : 1;
                    }
                });
                        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        DividerItemDecoration itemDecoration =
                new DividerItemDecoration(this, R.drawable.divider);
        mRecyclerView.addItemDecoration(itemDecoration);


        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    public void clicSurRecyclerItem(int position, View v) {
       // Toast.makeText(getApplicationContext(), "Clic sur l'item "+position, Toast.LENGTH_LONG).show();
       // Toast.makeText(getApplicationContext(), "Clic sur l'item "+position, Toast.LENGTH_LONG).show();
        Snackbar.make(mcoordinatorLayout, " Clic sur l'item " + position, Snackbar.LENGTH_LONG).show();
    }




}