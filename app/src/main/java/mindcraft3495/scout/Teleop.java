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

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

import static java.lang.String.valueOf;

public class Teleop extends AppCompatActivity {
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
        TextView tvScale;
        Button bScalePlus;
        Button bScaleMinus;
        TextView tvScale0;
        TextView tvSwitch;
        Button bSwitchPlus;
        Button bSwitchMinus;
        TextView tvSwitch0;
        TextView tvExchange;
        Button bExchangePlus;
        Button bExchangeMinus;
        TextView tvExchange0;
        TextView tvFumbled;
        Button bFumbledPlus;
        Button bFumbledMinus;
        TextView tvFumbled0;
        Button bDisabled;
        Button bIncap;
        Button bClimbed;
        Button bRobot;
        Button bRobot2;
        String team;
        String match;

        private DatabaseReference mDataBase;

        private int mCounter = 0;
        private int scaleCounter = 0;
        private int exchangeCounter = 0;
        private int fumbledCounter = 0;

        private boolean incap = false;
        private boolean disabled = false;
        private boolean climbed = false;
        private boolean robot = false;
        private boolean robot2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);


        tvScale = (TextView)findViewById(R.id.tvScale);
        bScalePlus = (Button)findViewById(R.id.bScalePlus);
        bScaleMinus = (Button)findViewById(R.id.bScaleMinus);
        tvScale0 = (TextView)findViewById(R.id.tvScale0);
        tvSwitch = (TextView)findViewById(R.id.tvSwitch);
        bSwitchPlus = (Button)findViewById(R.id.bSwitchPlus);
        bSwitchMinus = (Button)findViewById(R.id.bSwitchMinus);
        tvSwitch0 = (TextView)findViewById(R.id.tvSwitch0);
        tvExchange = (TextView)findViewById(R.id.tvExchange);
        bExchangePlus = (Button)findViewById(R.id.bExchangePlus);
        bExchangeMinus = (Button)findViewById(R.id.bExchangeMinus);
        tvExchange0 = (TextView)findViewById(R.id.tvExchange0);
        tvFumbled = (TextView)findViewById(R.id.tvFumbled);
        bFumbledPlus = (Button)findViewById(R.id.bFumbledPlus);
        bFumbledMinus = (Button)findViewById(R.id.bFumbledMinus);
        tvFumbled0 = (TextView)findViewById(R.id.tvFumbled0);
        bDisabled = (Button)findViewById(R.id.bDisabled);
        bIncap = (Button)findViewById(R.id.bIncap);
        bClimbed = (Button)findViewById(R.id.bClimbed);
        bRobot= (Button)findViewById(R.id.bRobot);
        bRobot2 = (Button)findViewById(R.id.bRobot2);

        mDataBase = FirebaseDatabase.getInstance().getReference().child("Teams");


        bSwitchPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter++;
                tvSwitch0.setText(valueOf(mCounter));
            }
        });
        bSwitchMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter--;
                tvSwitch0.setText(valueOf(mCounter));
            }
        });
        bScaleMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleCounter--;
                tvScale0.setText(valueOf(scaleCounter));
            }
        });
        bScalePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleCounter++;
                tvScale0.setText(valueOf(scaleCounter));
            }
        });
        bExchangeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exchangeCounter--;
                tvExchange0.setText(valueOf(exchangeCounter));
            }
        });
        bExchangePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exchangeCounter++;
                tvExchange0.setText(valueOf(exchangeCounter));
            }
        });
        bFumbledPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fumbledCounter++;
                tvFumbled0.setText(valueOf(fumbledCounter));
            }
        });
        bFumbledMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fumbledCounter--;
                tvFumbled0.setText(valueOf(fumbledCounter));
            }
        });

        bDisabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!incap){
                    incap = true;
                    bDisabled.setBackgroundColor(Color.GREEN);
                }else{
                    incap = false;
                    bDisabled.setBackgroundColor(Color.RED);
                }
            }
        });
        bIncap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!disabled){
                    disabled = true;
                    bIncap.setBackgroundColor(Color.GREEN);
                }else{
                    disabled = false;
                    bIncap.setBackgroundColor(Color.RED);
                }
            }
        });
        bClimbed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!climbed){
                    if(!climbed){
                        climbed = true;
                        bClimbed.setBackgroundColor(Color.GREEN);
                    }else{
                        climbed = false;
                        bClimbed.setBackgroundColor(Color.RED);
                    }
                }
            }
        });
        bRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!robot){
                    robot = true;
                    bRobot.setBackgroundColor(Color.GREEN);
                }else{
                    robot = false;
                    bRobot.setBackgroundColor(Color.RED);
                }
            }
        });
        bRobot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!robot2){
                    robot2 = true;
                    bRobot2.setBackgroundColor(Color.GREEN);
                }else{
                    robot2 = false;
                    bRobot2.setBackgroundColor(Color.RED);
                }
            }
        });
    }







    private void saveTeleopInfo(){

        String switchBoxes = tvSwitch0.getText().toString();
        String scaleBoxes = tvScale0.getText().toString();
        String fumbledBoxes = tvFumbled0.getText().toString();
        String exchangeBoxes = tvExchange0.getText().toString();
        String Climbed = Boolean.toString(climbed);
        String Incap = Boolean.toString(incap);
        String Disabled = Boolean.toString(disabled);
        String Robot = Boolean.toString(robot);
        String Robot2 = Boolean.toString(robot2);
        TeleopActivity teleopActivity = new TeleopActivity(switchBoxes, scaleBoxes, fumbledBoxes, exchangeBoxes, Climbed, Incap, Disabled, Robot, Robot2);



        team = preMatch.getTeam();
        match = preMatch.getMatch();
        mDataBase.child("Team "+ team).child("Round "+match).child("Teleop").setValue(teleopActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menuLogout){
            logout();
            return true;
        }
        if(id == R.id.saveData){
            saveTeleopInfo();
            Intent intent = new Intent(Teleop.this, preMatch.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Teleop.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }




}


