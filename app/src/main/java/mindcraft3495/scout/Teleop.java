package mindcraft3495.scout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Teleop extends AppCompatActivity {
    private DatabaseReference dataBaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);

        dataBaseRef = FirebaseDatabase.getInstance().getReference();
    }
}
