package loskaurosuwu.growapp;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Solicitud_reciclaje extends AppCompatActivity{

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Papel", "Las fibras de papel pueden ser recicladas cerca de 7 veces antes de que reduzcan su tamaño en tal magnitud que no pueden ser recicladas."));
        models.add(new Model(R.drawable.sticker, "Aluminio", "El aluminio se puede recuperar completamente, infinitas veces. La producción de una lata a partir de aluminio reciclado requiere 95% menos de energía que fabricarla con materia prima."));
        models.add(new Model(R.drawable.plastico, "Plasticos", "Todas las botellas desechables que corresponden a plástico PET, están identificadas con el número 1. Estas corresponden a envases de bebidas gaseosas, jugos, jarabes, aceites comestibles, bandejas, y algunos artículos de farmacia y medicamentos."));
        models.add(new Model(R.drawable.vidrio, "Vidrio", "El vidrio se obtiene a partir de arena de sílice (SiO2), carbonato de sodio (Na2CO3) y caliza (CaCO3) a unos 1500 °C. Es totalmente reciclable y puede ser recuperado infinitas veces."));
        models.add(new Model(R.drawable.pilas, "Pilas y Baterias", "El plomo y los plásticos de las baterías usadas se pueden reciclar. Si las baterías, al fin de su ciclo de vida, no son manejadas de manera adecuada, pueden liberar al medio ambiente su contenido contaminando el suelo y agua. "));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(0, 30, 0, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
