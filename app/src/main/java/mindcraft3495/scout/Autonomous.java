package mindcraft3495.scout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import static java.lang.String.valueOf;

import com.google.firebase.database.DatabaseReference;

public class Autonomous extends AppCompatActivity {
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    TextView tvBox;
    Button bMinus;
    Button bPlus;
    TextView tv0;
    Button bSwitch;
    Button bScale;
    Button bAuto;

    private int boxCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);
        mAuth = FirebaseAuth.getInstance();

        tvBox = (TextView)findViewById(R.id.tvBox);
        bMinus = (Button)findViewById(R.id.bMinus);
        bPlus = (Button)findViewById(R.id.bPlus);
        tv0 = (TextView)findViewById(R.id.tv0);
        bSwitch = (Button)findViewById(R.id.bSwitch);
        bScale = (Button)findViewById(R.id.bScale);
        bAuto = (Button)findViewById(R.id.bAuto);

        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxCounter--;
                tv0.setText(valueOf(boxCounter));
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxCounter++;
                tv0.setText(valueOf(boxCounter));
            }
        });
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