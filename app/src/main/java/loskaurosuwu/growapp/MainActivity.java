package loskaurosuwu.growapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



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
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mFlowerList = new ArrayList<>();
        mFlowerData = new FlowerData("Benceno", getString(R.string.description_flower_rose),
                R.drawable.plantas);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Formaldehído", getString(R.string.description_flower_carnation),
                R.drawable.hogar);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Cloroetileno", getString(R.string.description_flower_tulip),
                R.drawable.reci);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Xileno", getString(R.string.description_flower_daisy),
                R.drawable.solicita);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Tolueno", getString(R.string.description_flower_sunflower),
                R.drawable.quimicos);
        mFlowerList.add(mFlowerData);
        mFlowerData = new FlowerData("Amoniaco", getString(R.string.description_flower_daffodil),
                R.drawable.puntos);
        mFlowerList.add(mFlowerData);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, mFlowerList);
        mRecyclerView.setAdapter(myAdapter);
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("esto es una prueba","ola ola");
            setContentView(R.layout.activity_main);
        Button catalogo = findViewById(R.id.catalogbutton);
        catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catalogButtonClick();
            }
        });

        Button houseform = findViewById(R.id.houseformbutton);
        houseform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                houseFormClick();
            }
        });

        Button request = findViewById(R.id.reciclajeOP);
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catalogClick();
            }
        });

    }
    public void catalogButtonClick(){
        Log.v("presione","catalog");
        Intent i = new Intent(this,CatalogoPlantas.class);
        startActivity(i);
    }

    public void houseFormClick(){
        Intent i = new Intent(this,HouseForm2.class);
        startActivity(i);
    }

    public void catalogClick(){
        Intent i = new Intent(this,Reciclaje2.class);
        startActivity(i);
    }
    */
}
