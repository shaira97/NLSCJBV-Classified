package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mTextzid;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonSiup;
    UserDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new UserDatabaseHelper(this);


        mTextzid = findViewById(R.id.zid_input);
        mTextPassword = findViewById(R.id.pw_input);
        mButtonLogin = findViewById(R.id.login_btn);
        mButtonSiup = findViewById(R.id.reg_btn);
        mButtonSiup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, signupActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextzid.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUsers(user, pwd);
                if (res == true) {
                    Intent LoginScreen = new Intent(LoginActivity.this, HomepageActivity.class);
                    startActivity(LoginScreen);
                } else {
                    Toast.makeText(LoginActivity.this, "Error: Unable to log-in - could not find an existing user with that username and password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

