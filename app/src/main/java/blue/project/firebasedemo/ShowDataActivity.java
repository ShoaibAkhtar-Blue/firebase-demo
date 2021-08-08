package blue.project.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {
    private final String LOG_TAG = ShowDataActivity.class.getSimpleName();
    private RecyclerView userRecyclerView;
    private UserRecyclerViewAdapter mAdapter;
    private ArrayList<User> mList;

    // Firebase database connection
    private final FirebaseDatabase DATABASE = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = DATABASE.getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        setTitle("Data from Firebase Database");
        mList = new ArrayList<>();
        userRecyclerView = findViewById(R.id.usersRecyclerView);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new UserRecyclerViewAdapter(this, mList);
        userRecyclerView.setAdapter(mAdapter);

        // Get data from Firebase database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot :
                        snapshot.getChildren()) {
                    User user = dataSnapshot.getValue(User.class);

                    // Log information
                    Log.i(LOG_TAG, "User: " + user.getFullName());

                    mList.add(user);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}