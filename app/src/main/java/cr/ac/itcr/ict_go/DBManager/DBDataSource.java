package cr.ac.itcr.ict_go.DBManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

import static java.lang.String.format;

/**
 * Created by car_e on 4/9/2016.
 */
public class DBDataSource implements Serializable{

    private DBHelper openHelper;
    private SQLiteDatabase database;

    public DBDataSource(Context context) {
        openHelper = new DBHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public Cursor getAllRecords (String TABLE_NAME){
        return database.rawQuery( "select * from " + TABLE_NAME, null );
    }

    public void insertRecord(String table, String var1, String var2, String var3, String var4){

        String query = format("insert into "+ table +" values(" + "null," + "\"%s\"," + "\"%s\"," + "\"%s\"," + "\"%s\")",
                var1, var2, var3, var4);
        database.execSQL(query);
    }

    /// If person exist serch by column
    public boolean existPerson (String column, String value){
        String query = format("select * from People WHERE "+ column + "=\"%s\"", value);

        Cursor exist = database.rawQuery(query, null);
        if (exist.getCount() == 0)
            return false; // Person doesn't exist
        else
            return true; // Person exist
    }

    public void deleteAnimal (int id){
        String query = format("delete from Animals WHERE _id=%d", id);

        database.execSQL(query);
    }

    public void updateAnimal (int id, String var1, String var2, String var3){
        String query = format("update Animals set name=" + "\"%s\"," +"sname=" + "\"%s\"," + "description=" + "\"%s\"" + " WHERE _id=%d", var1, var2, var3, id);

        database.execSQL(query);
    }

    public boolean login (String username, String password){
        String query = format("select * from People WHERE user=\"%s\" and pass=\"%s\"", username, password);

        Cursor exist = database.rawQuery(query, null);
        if (exist.getCount() == 1)
            return true; // Login success
        else
            return false; // Error
    }
}
