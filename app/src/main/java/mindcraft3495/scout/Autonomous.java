package mindcraft3495.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Autonomous extends AppCompatActivity {
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.auto, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menuLogout){
            logout();
            return true;
        }
        if(id == R.id.Teleop) {
            Intent teleop = new Intent(Autonomous.this, Teleop.class);
            startActivity(teleop);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Autonomous.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
