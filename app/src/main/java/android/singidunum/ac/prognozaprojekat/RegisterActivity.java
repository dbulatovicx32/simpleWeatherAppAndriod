package android.singidunum.ac.prognozaprojekat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.singidunum.ac.prognozaprojekat.prefs.SharedPrefs;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //key pod kojim se storuje u SharedPrefs
    private final static String SHARED_PREFFERENCES_PASSWORD = "password";
    private final static String SHARED_PREFFERENCES_EMAIL = "email";

    private EditText inputPassword,inputEmail;
    private Button buttonRegister, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initComponents();
    }

    private void initComponents(){
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openWeather(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonRegister:
                register();
                break;
            case R.id.buttonLogin:
                openLogin();
                //openWeather();
                break;
        }
    }

    private void register(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        if(email.trim().length() <= 4 && password.trim().length() <= 4){
            Toast.makeText(getApplicationContext(),
                    "Please enter valid username and password length.",
                    Toast.LENGTH_LONG).show();
        }
        if (email.matches(emailPattern)){
            sacuvajPodatke();
            openLogin();
            Toast.makeText(getApplicationContext(),
                    "Valid email address, please log in.",
                    Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(),
                    "Invalid email address",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void sacuvajPodatke(){
        String password = inputPassword.getText().toString();
        String email = inputEmail.getText().toString();

        SharedPreferences.Editor editor = SharedPrefs.getInstance(this).getPrefs().edit();
        editor.putString(SHARED_PREFFERENCES_PASSWORD, password);
        editor.putString(SHARED_PREFFERENCES_EMAIL, email);
        editor.apply();
    }

}