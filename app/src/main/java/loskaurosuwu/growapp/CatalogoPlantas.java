package loskaurosuwu.growapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogoPlantas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("aaa","ooooo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_plantas);
        DBHelper db = new DBHelper(this);
        db.abre();
        LinearLayout ll = findViewById(R.id.llayout);
        Cursor c = db.todasPlantas();
        if(c.moveToFirst()){
            do{
                String name =c.getString(0);
                String benceno = c.getString(1);
                String formal = c.getString(2);
                String cloret = c.getString(3);
                String xileno = c.getString(4);
                String amonia = c.getString(5);

                View child = getLayoutInflater().inflate(R.layout.plant_catalog_element,null);
                ((TextView)child.findViewById(R.id.plant_name_text)).setText(name);
                child.setOnClickListener(new plantClickListener(c.getInt(6)));
                if(benceno.equals("si")){
                    child.findViewById(R.id.bencbut).setEnabled(true);
                    ((RadioButton)child.findViewById(R.id.bencbut)).setChecked(true);
                    ((RadioButton)child.findViewById(R.id.bencbut)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getBaseContext(),"Esta planta elimina benceno",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                if(formal.equals("si")){
                    child.findViewById(R.id.formbut).setEnabled(true);
                    ((RadioButton)child.findViewById(R.id.formbut)).setChecked(true);
                    ((RadioButton)child.findViewById(R.id.formbut)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getBaseContext(),"Esta planta elimina formaldehido",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                if(cloret.equals("si")){
                    child.findViewById(R.id.cloretbut).setEnabled(true);
                    ((RadioButton)child.findViewById(R.id.cloretbut)).setChecked(true);
                    ((RadioButton)child.findViewById(R.id.cloretbut)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getBaseContext(),"Esta planta elimina cloretileno",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                if(xileno.equals("si")){
                    child.findViewById(R.id.xilbut).setEnabled(true);
                    ((RadioButton)child.findViewById(R.id.xilbut)).setChecked(true);
                    ((RadioButton)child.findViewById(R.id.xilbut)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getBaseContext(),"Esta planta elimina xileno tolueno",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                if(amonia.equals("si")){
                    child.findViewById(R.id.amonbut).setEnabled(true);
                    ((RadioButton)child.findViewById(R.id.amonbut)).setChecked(true);
                    ((RadioButton)child.findViewById(R.id.amonbut)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getBaseContext(),"Esta planta elimina amoniaco",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                ll.addView(child);
            }while(c.moveToNext());
        }
    }
    private class plantClickListener implements View.OnClickListener{
        private int id;
        public plantClickListener(int _id){
            id=_id;
        }
        @Override
        public void onClick(View view) {
            Intent i = new Intent(CatalogoPlantas.this,ShowPlant.class);
            i.putExtra("ID",id);
            startActivity(i);
        }
    }

}
