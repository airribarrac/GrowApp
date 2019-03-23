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
        Button reciclaje = findViewById(R.id.reciclajeOP);
        catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catalogButtonClick();
            }
        });
        reciclaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reciclajeButtonClick();
            }
        });

    }
    public void catalogButtonClick(){
        Log.v("presione","catalog");
        Intent i = new Intent(this,CatalogoPlantas.class);
        startActivity(i);
    }
    public void reciclajeButtonClick(){
        Log.v("presione","reciclaje");
        Intent i = new Intent(this,Reciclaje2.class);
        startActivity(i);
    }

}
