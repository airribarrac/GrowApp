package loskaurosuwu.growapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Quimicos extends AppCompatActivity {


    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<FlowerData> mFlowerList;
    FlowerData mFlowerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mToolbar = findViewById(R.id.toolbar);
        //mToolbar.setTitle("Sustancias químicas");
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(Quimicos.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mFlowerList = new ArrayList<>();
        mFlowerData = new FlowerData("Benceno", getString(R.string.description_flower_rose),
                R.drawable.benceno);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Formaldehído", getString(R.string.description_flower_carnation),
                R.drawable.formaldehido);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Cloroetileno", getString(R.string.description_flower_tulip),
                R.drawable.cloroetileno);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Xileno", getString(R.string.description_flower_daisy),
                R.drawable.xileno);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Tolueno", getString(R.string.description_flower_sunflower),
                R.drawable.tolueno);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Amoniaco", getString(R.string.description_flower_daffodil),
                R.drawable.amoniaco);
        mFlowerList.add(mFlowerData);

        MyAdapterQuimico myAdapter = new MyAdapterQuimico(Quimicos.this, mFlowerList);
        mRecyclerView.setAdapter(myAdapter);
    }

}
