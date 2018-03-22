package mindcraft3495.scout;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static mindcraft3495.scout.R.*;

<<<<<<< HEAD
public class RegisterActivity extends AppCompatActivity {
=======
public class RegisterActivity extends AppCompatActivity implements OnClickListener {
>>>>>>> 4333caf4bf59fa7e4719254097f88b8b07700190

    private EditText etEmail;
    private EditText etPassword;
    public Button bRegister;
    private TextView tvLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
<<<<<<< HEAD
        bRegister.setOnClickListener((OnClickListener) this);

=======
        bRegister = findViewById(id.bRegister);
>>>>>>> 4333caf4bf59fa7e4719254097f88b8b07700190

        mAuth = FirebaseAuth.getInstance();
        bRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    private void registerUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email Is Required");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please Enter A Valid Email.");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password Is Required");
            etPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            etPassword.setError("Minimum Password Length is 6 Characters.");
            etPassword.requestFocus();
            return;

        }

<<<<<<< HEAD
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "User Registration Successful", Toast.LENGTH_SHORT).show();

                    }
=======
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "User Registration Successful", Toast.LENGTH_SHORT).show();
>>>>>>> 4333caf4bf59fa7e4719254097f88b8b07700190
                }
            }
        });


<<<<<<< HEAD
    }



=======
        if (view == bRegister) {
            registerUser();
            finish();
            Intent register = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(register);


        }
        if(view == tvLogin){
            Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(login);
        }
>>>>>>> 4333caf4bf59fa7e4719254097f88b8b07700190
    }
}




