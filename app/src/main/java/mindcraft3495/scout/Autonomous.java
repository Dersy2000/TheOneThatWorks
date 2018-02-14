package mindcraft3495.scout;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    boolean boSwitch;
    boolean boScale;
    boolean auto;
    String team;
    String match;

    private int boxCounter = 0;


    DatabaseReference rootRef,demoRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);
        mAuth = FirebaseAuth.getInstance();

        rootRef = FirebaseDatabase.getInstance().getReference().child("Teams");
        demoRef = rootRef.child("Team").child("254").child("Auto");

        tvBox = (TextView)findViewById(R.id.tvBox);
        bMinus = (Button)findViewById(R.id.bMinus);
        bPlus = (Button)findViewById(R.id.bPlus);
        tv0 = (TextView)findViewById(R.id.tv0);
        bSwitch = (Button)findViewById(R.id.bSwitch);
        bScale = (Button)findViewById(R.id.bScale);
        bAuto = (Button)findViewById(R.id.bAuto);
        boSwitch = false;
        boSwitch = false;
        auto = false;
        team = preMatch.getTeam();
        match = preMatch.getMatch();





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
        bSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!boSwitch){
                    boSwitch = true;
                    bSwitch.setBackgroundColor(Color.GREEN);
                }else{
                    boSwitch = false;
                    bSwitch.setBackgroundColor(Color.RED);
                }
            }
        });
        bScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!boScale){
                    boScale = true;
                    bScale.setBackgroundColor(Color.GREEN);
                }else{
                    boScale = false;
                    bScale.setBackgroundColor(Color.RED);
                }
            }
        });
        bAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!auto){
                    auto = true;
                    bAuto.setBackgroundColor(Color.GREEN);
                }else{
                    auto = false;
                    bAuto.setBackgroundColor(Color.RED);
                }
            }
        });


    }
    private void saveAutoInfo(){
        String autoBox = tv0.getText().toString();

        String littleScale = Boolean.toString(boSwitch);
        String Switch = Boolean.toString(boScale);
        String Autoline = Boolean.toString(auto);
        AutoInfo autoInfo = new AutoInfo(autoBox, littleScale, Switch, Autoline);
        rootRef.child("Team "+team).child("Round "+match).child("Auto").setValue(autoInfo);

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
            saveAutoInfo();
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









