package cr.ac.itcr.ict_go.DBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by car_e on 4/9/2016.
 */
public class AnimalsDataSource {

    //Metainformación de la base de datos
    public static final String ANIMALS_TABLE_NAME = "Animals";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Animals
    public static class ColumnAnimal {
        public static final String ID_ANIMAL = BaseColumns._ID;
        public static final String NAME_ANIMAL = "name";
        public static final String SCIENTIFIC_NAME = "sname";
        public static final String DESCRIPTION = "description";
        public static final String ID_IMG = "img";
    }

    //Script de Creación de la tabla Animals
    public static final String CREATE_ANIMALS_SCRIPT =
            "create table "+ANIMALS_TABLE_NAME+"(" +
                    ColumnAnimal.ID_ANIMAL+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnAnimal.NAME_ANIMAL+" "+STRING_TYPE+" not null," +
                    ColumnAnimal.SCIENTIFIC_NAME+" "+STRING_TYPE+" not null," +
                    ColumnAnimal.DESCRIPTION+" "+STRING_TYPE+" not null," +
                    ColumnAnimal.ID_IMG+" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_ANIMALS_SCRIPT =
            "insert into "+ ANIMALS_TABLE_NAME +" values(" +
                    "null," +
                    "\"Tortuga\"," +
                    "\"STortuga\"," +
                    "\"Es una Tortuga\"," +
                    "\"1\")," +
                    "(null," +
                    "\"Jaguar\"," +
                    "\"SJaguar\"," +
                    "\"Es una Jaguar\"," +
                    "\"2\")";

}
