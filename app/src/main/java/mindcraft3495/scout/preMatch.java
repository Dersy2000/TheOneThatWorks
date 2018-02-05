package mindcraft3495.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class preMatch extends AppCompatActivity {
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_match);
        mAuth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.menuLogout);


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.prematch, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menuLogout){
            logout();
            return true;
        }
        if(id == R.id.auto) {
            Intent auto = new Intent(preMatch.this, Autonomous.class);
            startActivity(auto);
        }
        return super.onOptionsItemSelected(item);
    }



    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(preMatch.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

