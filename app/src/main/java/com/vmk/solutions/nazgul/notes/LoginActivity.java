package com.vmk.solutions.nazgul.notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vmk.solutions.nazgul.notes.notes.NotesActivity;
import com.vmk.solutions.nazgul.notes.util.Constants;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etusername = findViewById(R.id.etusername);
        final EditText etpassword = findViewById(R.id.etpassword);
        Button btlogin = findViewById(R.id.btlogin);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                if (username.equals("aaa") && password.equals("123")){
                    prefs.setPref(Constants.prefs_user, true);
                    Intent intent = new Intent(LoginActivity.this, NotesActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "Ingreso Incorrecto", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
