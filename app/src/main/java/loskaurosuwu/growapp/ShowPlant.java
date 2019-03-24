package loskaurosuwu.growapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowPlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_plant);
        Intent i = getIntent();
        int id = i.getIntExtra("ID",-1);
        TextView name = findViewById(R.id.plantName);

        DBHelper db = new DBHelper(this);
        db.abre();
        Cursor c = db.plantaPorID(id);

        if(c.moveToFirst()){
            name.setText(c.getString(0));
        }else{
            Log.wtf("rip","esto no deberia pasar");
        }
        ImageView imageView=findViewById(R.id.plantimage);
        imageView.setImageResource(getResources().getIdentifier(c.getString(2),"drawable",getPackageName()));
        TextView cnt = findViewById(R.id.weirdName);
        cnt.setText(c.getString(1));
        TextView regado = findViewById(R.id.Regado);
        regado.setText("Regado "+c.getString(3)+".");
        TextView luz = findViewById(R.id.Luz);
        luz.setText("Luz: "+c.getString(5)+".");
        TextView temp = findViewById(R.id.Temperatura);
        temp.setText("Temperatura: "+c.getString(4)+"°C");
        TextView lugar = findViewById(R.id.Lugar);
        lugar.setText(c.getString(6));

    }
}
