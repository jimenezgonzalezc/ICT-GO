package cr.ac.itcr.ict_go.DBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by car_e on 4/9/2016.
 */
public class PeopleDataSource {

    //Metainformación de la base de datos
    public static final String TABLE_NAME = "People";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla People
    public static class ColumnPerson {
        public static final String ID_PERSON = BaseColumns._ID;
        public static final String NAME_PERSON = "name";
        public static final String USERNAME = "user";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "pass";
    }

    //Script de Creación de la tabla People
    public static final String CREATE_PEOPLE_SCRIPT =
            "create table "+ TABLE_NAME +"(" +
                    ColumnPerson.ID_PERSON +" "+INT_TYPE+" primary key autoincrement," +
                    ColumnPerson.NAME_PERSON +" "+STRING_TYPE+" not null," +
                    ColumnPerson.USERNAME +" "+STRING_TYPE+" not null," +
                    ColumnPerson.EMAIL +" "+STRING_TYPE+" not null," +
                    ColumnPerson.PASSWORD +" "+STRING_TYPE+" not null)";

    //Scripts de inserción por defecto
    public static final String INSERT_PEOPLE_SCRIPT =
            "insert into "+ TABLE_NAME +" values(" +
                    "null," +
                    "\"Carlos Jimenez\"," +
                    "\"car\"," +
                    "\"car@gmail.com\"," +
                    "\"12345\")";
}
