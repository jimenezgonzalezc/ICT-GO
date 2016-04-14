package cr.ac.itcr.ict_go.Animal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cr.ac.itcr.ict_go.DBManager.DBDataSource;
import cr.ac.itcr.ict_go.Entity.Animal;
import cr.ac.itcr.ict_go.R;

public class ManageAnimalActivity extends AppCompatActivity {

    private DBDataSource dataSource;

    TextView txtIdAnimal;
    TextView txtNameAnimal;
    TextView txtScientificName;
    TextView txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_animal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dataSource = new DBDataSource(getApplicationContext());
        txtIdAnimal = (TextView) findViewById(R.id.txtIdAnimal);
        txtNameAnimal = (TextView) findViewById(R.id.txtNameAnimal);
        txtScientificName = (TextView) findViewById(R.id.txtScientificName);
        txtDescription = (TextView) findViewById(R.id.txtDescription);

        loadData();
        Button deleteAnimalButton = (Button) findViewById(R.id.btnDeleteAnimal2);
        deleteAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(txtIdAnimal.getText().toString());
                dataSource.deleteAnimal(id);
                Toast t = Toast.makeText(getApplicationContext(), "This animal has been deleted", Toast.LENGTH_SHORT);
                t.show();
                Log.d("delete", "yes");
            }
        });

        Button updateAnimalButton = (Button) findViewById(R.id.btnUpdateAnimal2);
        updateAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateAnimal();
                Log.d("update", "yes");
                txtIdAnimal = (TextView) findViewById(R.id.txtIdAnimal);
                txtNameAnimal = (TextView) findViewById(R.id.txtNameAnimal);
                txtScientificName = (TextView) findViewById(R.id.txtScientificName);
                txtDescription = (TextView) findViewById(R.id.txtDescription);
                dataSource.updateAnimal(Integer.parseInt(txtIdAnimal.getText().toString()), txtNameAnimal.getText().toString(), txtScientificName.getText().toString(), txtDescription.getText().toString());
                Toast t = Toast.makeText(getApplicationContext(), "This animal has been modify", Toast.LENGTH_SHORT);
                t.show();

            }
        });

    }

    public void loadData(){
        Animal a = (Animal)getIntent().getSerializableExtra("object");
        txtIdAnimal.setText(String.valueOf(a.getId()));
        Log.d("Anim id>", String.valueOf(a.getId()));

        txtNameAnimal.setText(a.getName());
        Log.d("Anim nombre>", a.getName());

        txtScientificName.setText(a.getScientificName());
        Log.d("Anim nombre cientific", a.getScientificName());

        txtDescription.setText(a.getDescription());
        Log.d("Anim descripcion>", a.getDescription());

        Log.d("Anim imagen>", a.getIdImg());
    }

}
