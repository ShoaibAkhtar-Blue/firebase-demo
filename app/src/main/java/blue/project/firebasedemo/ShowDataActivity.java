package blue.project.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShowDataActivity extends AppCompatActivity {
    private RecyclerView userRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        setTitle("Data from Firebase Database");

        userRecyclerView = findViewById(R.id.usersRecyclerView);
    }
}