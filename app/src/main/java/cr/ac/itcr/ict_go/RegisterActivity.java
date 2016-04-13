package cr.ac.itcr.ict_go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cr.ac.itcr.ict_go.DBManager.DBDataSource;


public class RegisterActivity extends AppCompatActivity {

    private DBDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dataSource = new DBDataSource(getApplicationContext());

        final TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
        final TextView txtFullname = (TextView) findViewById(R.id.txtFullname);
        final TextView txtUsername = (TextView) findViewById(R.id.txtUsername);
        final TextView password = (TextView) findViewById(R.id.password);



        Button registerButton = (Button) findViewById(R.id.btnRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtEmail.getText().toString() != "" && txtFullname.getText().toString() != "" && txtUsername.getText().toString() != "" && password.getText().toString() != "") {
                    dataSource.insertRecord("People",txtFullname.getText().toString(), txtUsername.getText().toString(), txtEmail.getText().toString(), password.getText().toString());
                    Toast t=Toast.makeText(getApplicationContext(),"Your account has been created", Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    Toast t=Toast.makeText(getApplicationContext(),"All fields are required", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
    }
}
