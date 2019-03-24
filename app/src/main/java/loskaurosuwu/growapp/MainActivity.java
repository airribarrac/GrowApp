package loskaurosuwu.growapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

        Button kreciclo = findViewById(R.id.reciclajeOP);
        kreciclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                krecicloClick();
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

    public void krecicloClick(){
        Intent i = new Intent(this,Que_Reciclo.class);
        startActivity(i);
    }
}
