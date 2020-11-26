package com.example.e_commerceadmin.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerceadmin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login_Admin extends AppCompatActivity {

    EditText inputUser, inputPass;
    Button btnLogin;
    protected FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
    Intent intent;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__admin);
        setControl();
        intent = getIntent();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setEvent();
    }

    private void setEvent() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, Nhan!");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = inputUser.getText().toString().trim();
                    String password = inputPass.getText().toString().trim();
                    if (TextUtils.isEmpty(email)) {
                        inputUser.setError("Vui lòng nhập Email");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        inputPass.setError("Vui lòng nhập mật khẩu");
                        return;
                    }
                    if (password.length() < 6) {
                        inputPass.setError("Mật khẩu phải từ 6 kí tự trở lên");
                    }
                mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login_Admin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Trangchu_Admin.class));
                            }
                            else {
                                Toast.makeText(Login_Admin.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
        });
    }

    private void setControl() {
        inputUser = findViewById(R.id.inputPhone);
        inputPass = findViewById(R.id.inputPass);
        btnLogin = findViewById(R.id.btnLogin);
    }
}