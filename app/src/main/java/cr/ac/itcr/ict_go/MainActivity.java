package cr.ac.itcr.ict_go;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import cr.ac.itcr.ict_go.DBManager.DBDataSource;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Crear nuevo objeto AnimalsDataSource
        DBDataSource dataSource = new DBDataSource(getApplicationContext());
        //dataSource.insertRecord("People", "Manfred Gomez","man","man@gmail.com","12345");
        //dataSource.insertRecord("Animals", "Tucan","STucan","Tucan","3");
        dataSource.deleteAnimal(1);
        dataSource.updateAnimal(2,"pez","spez","es un pez");
        Cursor eg = dataSource.getAllRecords("Animals") ;

        while(eg.moveToNext()){
            String id = eg.getString(0);
            Log.d("Animal id", id);
            String body = eg.getString(1);
            Log.d("Animal nombre", body);
            body = eg.getString(2);
            Log.d("Animal nombre cientific", body);
            body = eg.getString(3);
            Log.d("Animal descripcion", body);
            body = eg.getString(4);
            Log.d("Animal imagen", body);
        }
        eg = dataSource.getAllRecords("People");

        while(eg.moveToNext()){
            String body = eg.getString(2);
            Log.d("Nombre", body);
        }
        boolean ega = dataSource.existPerson("user","car") ;
        if (ega == true)
            Log.d("existe", "existe");
        else
            Log.d("existe", "no existe");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
