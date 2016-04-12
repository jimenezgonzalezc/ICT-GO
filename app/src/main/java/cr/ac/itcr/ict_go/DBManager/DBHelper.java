package cr.ac.itcr.ict_go.DBManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by car_e on 4/9/2016.
 */
public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "ICT-GO.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear las tablas ANIMALS Y PEOPLE
        db.execSQL(AnimalsDataSource.CREATE_ANIMALS_SCRIPT);
        db.execSQL(PeopleDataSource.CREATE_PEOPLE_SCRIPT);

        //Insertar registros iniciales
        db.execSQL(AnimalsDataSource.INSERT_ANIMALS_SCRIPT);
        db.execSQL(PeopleDataSource.INSERT_PEOPLE_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
