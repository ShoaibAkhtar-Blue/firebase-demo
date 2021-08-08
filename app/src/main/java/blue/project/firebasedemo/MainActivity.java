package blue.project.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button saveBtn;
    private Button getDataBtn;

    // Firebase database connection
    private final FirebaseDatabase DATABASE = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = DATABASE.getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references of the views
        firstNameEditText = findViewById(R.id.editText_firstName);
        lastNameEditText = findViewById(R.id.editText_lastName);
        saveBtn = findViewById(R.id.button_save);
        getDataBtn = findViewById(R.id.button_getData);

        saveBtn.setOnClickListener(view -> {
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();

            // Perform data validation
            if (firstName != null && !firstName.equals("")) {
                if (lastName != null && !lastName.equals("")) {
                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("firstName", firstName);
                    userMap.put("lastName", lastName);

                    // Save data to Firebase database
                    myRef.push().setValue(userMap).addOnCompleteListener(task -> Toast.makeText(this, "User Name: " + firstName + " " + lastName, Toast.LENGTH_SHORT).show());
                } else {
                    Toast.makeText(this, "Enter last name", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Enter first name", Toast.LENGTH_SHORT).show();
            }
        });
    }
}