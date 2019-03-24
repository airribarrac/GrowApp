package loskaurosuwu.growapp;


/**
 * Created by Irri on 27-06-2018.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DBHelper {
    // Nombre de la base de datos, y tabla asociada
    private static final String DATABASE_NAME = "MiDB";
    private static final String DATABASE_TABLE = "plantas";
    private static final int DATABASE_VERSION = 4;
    // Las constantes que representan las columnas de la tabla
    private static final String FILAID = "_id";
    private static final String NOMBRE = "nombre";
    private static final String CNT = "nombre_cnt";
    private static final String IMG_F = "img_flor";
    private static final String BENCENO = "pur_ben";
    private static final String FORMAL = "pur_for";
    private static final String CLORET = "pur_clor";
    private static final String XILENO= "pur_xil";
    private static final String AMONIA = "pur_amo";
    private static final String REGADO = "regado";
    private static final String TEMP = "temp";
    private static final String LUZ = "luz";
    private static final String AMBI = "ambiente";
    private static final String PRECIO = "precio";

    private static final String TAG = "DBHelper";

    // Este String contiene el comando SQL para la creación de la base de datos
    private static final String DATABASE_CREATE = "create table " + DATABASE_TABLE +
            "(" + FILAID + " integer primary key , " + NOMBRE +
            " text not null, " + CNT + " text not null," + IMG_F + " text not null," +
            FORMAL + " text not null, " +
            CLORET + " text not null, " +
            XILENO + " text not null, " +
            AMONIA + " text not null, " +
            REGADO + " text not null, " +
            TEMP + " text not null, " +
            LUZ + " text not null, " +
            AMBI + " text not null, " +
            PRECIO + " integer not null," +
            BENCENO + " text not null );" ;
    private final Context contexto; // Contexto de la aplicacion
    private DatabaseHelper Helper; // Clase interna para acceso a base de datos SQL
    private SQLiteDatabase db; // La base de datos SQL
    public DBHelper(Context contexto) {
        Log.i("alo","olaola");
        this.contexto = contexto;
        Helper = new DatabaseHelper(contexto);
    }
    // Clase privada interna para acceso a base de datos SQL
    private static class DatabaseHelper extends SQLiteOpenHelper {
        private Context context;
        DatabaseHelper(Context contexto) {
            super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
            context = contexto;
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                Log.w(TAG, "Creando la base de datos");
                // Emite el comando SQL para crear la base de datos
                db.execSQL(DATABASE_CREATE);
                db.execSQL("create table usuarios(" +
                        "username text primary key , " +
                        "puntos integer default 0 not null );");
                InputStream is = context.getResources().openRawResource(R.raw.baseuwu);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                while ((line = br.readLine())!=null){
                    Log.i("alo","meto dato");
                    String[] partido = line.split(";");
                    if(partido.length<3){
                        break;
                    }
                    for(String x : partido){
                        Log.i("item",x);
                    }
                    ContentValues cv = new ContentValues();
                    Log.v("partido", String.valueOf(partido.length));

                    cv.put(FILAID,partido[0]);
                    cv.put(NOMBRE,partido[1]);
                    cv.put(CNT,partido[2]);
                    cv.put(IMG_F,partido[3]);
                    cv.put(BENCENO,partido[4]);
                    cv.put(FORMAL,partido[5]);
                    cv.put(CLORET,partido[6]);
                    cv.put(XILENO,partido[7]);
                    cv.put(AMONIA,partido[8]);
                    cv.put(REGADO,partido[9]);
                    cv.put(TEMP,partido[10]);
                    cv.put(LUZ,partido[11]);
                    cv.put(AMBI,partido[12]);
                    cv.put(PRECIO,partido[13]);
                    db.insert(DATABASE_TABLE, null, cv);
                }
                ContentValues val = new ContentValues();
                val.put("username","juanito");
                db.insert("usuarios",null,val);
            }
            catch(SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
            Log.w(TAG, "Actualizando la base de datos desde la versión " + versionAnterior +
                    " a la versión " + versionNueva);
            db.execSQL("DROP TABLE IF EXISTS contactos");
            onCreate(db);
        }
    }
    // Abre la base de datos para escritura
    public DBHelper abre() throws SQLException {
        // Abre la base de datos para escritura
        db = Helper.getWritableDatabase();
        return this;
    }
    // Cierra la base de datos
    public void cierra() {
        Helper.close();
    }


    public Cursor todasPlantas(){
        Log.i("busco","todas");
        return db.query(DATABASE_TABLE,new String[]{NOMBRE,BENCENO,FORMAL,CLORET,XILENO,AMONIA,
                        FILAID,PRECIO},
                null,null,null,null,
                FILAID);
    }
    public Cursor plantaPorID(int id){
        Log.i("busco","una "+id);
        return db.query(DATABASE_TABLE,new String[]{NOMBRE,CNT,IMG_F,REGADO,TEMP,LUZ,AMBI},
                FILAID+"= ?",new String[]{String.valueOf(id)},null,null,null);
    }
    public void agregarSaldo(String usuario,int cantidad){
        String consulta = "update usuarios set puntos = puntos + "+cantidad+" where username = ?;";
        db.execSQL(consulta,new String[]{usuario});
    }
    public boolean comprarPlanta(String usuario,int plantID){
        Cursor a = db.query("plantas",new String[]{PRECIO},
                FILAID+"= ?",new String[]{String.valueOf(plantID)},null,null,null);
        Cursor b = db.query("usuarios", new String[]{"puntos"},
                "username = ?",new String[]{usuario},null,null,null);
        a.moveToFirst();
        b.moveToFirst();
        if(a.getInt(0)>b.getInt(0)){
            return false;
        }else{
            String consulta = "update usuarios set puntos = puntos - ?  where username = ?;";
            db.execSQL(consulta,
                    new String[]{String.valueOf(a.getInt(0)),usuario});
            return true;
        }
    }
    public int getSaldo(String usuario){
        Cursor c = db.query("usuarios",new String[]{"puntos"},"username = ?",new String[]{usuario},
                null,null,null);
        c.moveToFirst();
        return c.getInt(0);
    }

/*
    public Cursor buscafecha(int dia, int mes) {
        Log.i("busco",DIA+"="+dia+" AND " + MES+"="+mes);
        // Realiza una consulta a la base de datos para recuperar efemerides x fecha
        return db.query(DATABASE_TABLE, new String[] {NOMBRE,DIA, MES,ANIO},
                DIA+" = ? AND " + MES+" = ?",
                new String[]{Integer.toString(dia),Integer.toString(mes)},null, null, null);
    }
*/
}

