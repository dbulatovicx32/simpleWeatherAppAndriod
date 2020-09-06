package android.singidunum.ac.prognozaprojekat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.singidunum.ac.prognozaprojekat.prefs.SharedPrefs;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //key pod kojim se storuje u SharedPrefs
    private final static String SHARED_PREFFERENCES_PASSWORD = "password";
    private final static String SHARED_PREFFERENCES_EMAIL = "email";

    private EditText inputPassword,inputEmail;
    private Button buttonRegister, buttonLogin;
    private TextView labelText;

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
        labelText = (TextView) findViewById(R.id.labelTekst);

        buttonRegister.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        sacuvajPodatke();
    }

    public void openLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonRegister:
                sacuvajPodatke();
                break;
            case R.id.buttonLogin:
                openLogin();
                break;
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