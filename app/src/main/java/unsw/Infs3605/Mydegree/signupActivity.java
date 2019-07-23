package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConfPassword;
    Button mButtonRegister;
    UserDatabaseHelper db;
    Button mButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        setTitle("Create Your Account");


        db = new UserDatabaseHelper(this);
        mTextUsername = findViewById(R.id.rusername);
        mTextPassword = findViewById(R.id.rpw);
        mTextConfPassword = findViewById(R.id.rpwconf);
        mButtonRegister = findViewById(R.id.create_btn);
        mButtonBack = findViewById(R.id.back_btn);
        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(signupActivity.this, LoginActivity.class);
                startActivity(LoginIntent);

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String psw = mTextPassword.getText().toString().trim();
                String cfpsw = mTextConfPassword.getText().toString().trim();

                if (psw.equals(cfpsw)) {
                    long val = db.addStudent(user, psw);
                    if (val >=1) {
                        Toast.makeText(signupActivity.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                        Intent movetologin = new Intent(signupActivity.this, LoginActivity.class);
                        startActivity(movetologin);
                    } else {
                        Toast.makeText(signupActivity.this, "Error: Registration unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(signupActivity.this, "Error: Password does not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

