package com.example.teamcevn_operatorid_2022;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        clickLogin();
        clickSignup();
        clickReset();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    private void updateUI(FirebaseUser user) {
        if(user != null) {
            reload(user);
        }
    }

    private void reload(FirebaseUser user) {
        // Whatever happens after login/signup
    }


    // SIGN UP

    private void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();

                        Toast.makeText(Login.this, "Signed up as " + email + ".\nDon't forget to verify your email",
                                Toast.LENGTH_SHORT).show();

                        sendVerificationEmail(user);

                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(Login.this, "Sign up failed",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    private void clickSignup() {
        final Button button = findViewById(R.id.signup);
        button.setOnClickListener(v -> {
            try {
                final String email = ((EditText) findViewById(R.id.email)).getText().toString();
                final String password = ((EditText) findViewById(R.id.password)).getText().toString();
                signUp(email, password);
            } catch (IllegalArgumentException ex) {
                Toast.makeText(Login.this, "Sign up failed: email or password empty", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // LOG IN

    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();

                        Toast.makeText(Login.this,
                                "Logged in as " + email + (!user.isEmailVerified() ? ".\nDon't forget to verify your email." : "."),
                                Toast.LENGTH_SHORT).show();

                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(Login.this, "Login failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    private void clickLogin() {
        final Button button = findViewById(R.id.login);
        button.setOnClickListener(v -> {
            try {
                final String email = ((EditText) findViewById(R.id.email)).getText().toString();
                final String password = ((EditText) findViewById(R.id.password)).getText().toString();
                signIn(email, password);
            } catch (IllegalArgumentException ex) {
                Toast.makeText(Login.this, "Log in failed: email or password empty", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // EMAIL VERIFICATION

    private void sendVerificationEmail(FirebaseUser user) {
        user.sendEmailVerification();
    }


    // PASSWORD RESET

    private void resetPassword(String email) {
        mAuth.sendPasswordResetEmail(email);

        Toast.makeText(Login.this, "Please check your email", Toast.LENGTH_SHORT).show();
    }

    private void clickReset() {
        Button button = findViewById(R.id.forgot_password);
        button.setOnClickListener(v -> {
            try {
                String email = ((EditText)findViewById(R.id.email)).getText().toString();
                resetPassword(email);
            } catch (IllegalArgumentException ex) {
                Toast.makeText(Login.this, "Please enter the email you used to sign up", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void profile(View view){
        startActivity(new Intent(this, UserList.class));
    }

    public void map(View view){
        // TODO Needs map class
//        startActivity(new Intent(this, ));
    }

    public void settings(View view){
        startActivity(new Intent(this, MachineSettings.class));
    }
}