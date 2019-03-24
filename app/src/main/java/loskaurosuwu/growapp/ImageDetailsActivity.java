package loskaurosuwu.growapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView texto;
    private String[] textResource = new String[]{"Se reciclan botellas de bebidas, aguas y jugos, a excepción de aquellas que contengan vinagre o aceite.\n Considere aplastarlas para que ocupen menos espacio.",
    "Considere no eliminarlas con el resto de residuos. Estos materiales deben ser manejados como residuos peligrosos.\nEvite manipularlas si presentan daños del blindaje externo.",
    "Se reciclan diarios, revistas, cartones, cartulinas, papel blanco y otros. \nNO se reciclan servilletas ni papel higiénico.\nConsidere aplanar cajas y remover elementos como clips, corchetes,etc.",
    "Se reciclan botellas de bebidas, vinos y licores; frascos; perfumes.\n NO se reciclan Parabrisas, espejos, ampolletas, tubos fluorescentes, loza, pírex, cristales, vidrio templado y ventanas.",
    "Se reciclan latas de bebida y cerveza, láminas de aluminio. \nNO se reciclan tarros de pintura o contaminados con productos tóxicos, latas de aerosol."};
    private static final String DRAWABLE_RESOURE = "resource";
    private static final String Extra_RESOURE = "res";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_image);

        imageView = (ImageView)findViewById(R.id.img);
        texto = (TextView) findViewById(R.id.descripcion);

        int drawbleResource = getIntent().getIntExtra(DRAWABLE_RESOURE, 0);
        int posResource = getIntent().getIntExtra(Extra_RESOURE,0);

        imageView.setImageResource(drawbleResource);
        texto.setText(textResource[posResource]);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
