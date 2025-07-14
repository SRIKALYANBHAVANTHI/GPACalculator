package com.example.gpacalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText course1Grade, course2Grade, course3Grade, course4Grade, course5Grade;
    Button computeButton;
    TextView gpaDisplay;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course1Grade = findViewById(R.id.course1Grade);
        course2Grade = findViewById(R.id.course2Grade);
        course3Grade = findViewById(R.id.course3Grade);
        course4Grade = findViewById(R.id.course4Grade);
        course5Grade = findViewById(R.id.course5Grade);
        computeButton = findViewById(R.id.computeButton);
        gpaDisplay = findViewById(R.id.gpaDisplay);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeGPA();
            }
        });

        // Set button text to "Compute GPA" initially
        computeButton.setText("Compute GPA");
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void computeGPA() {
        // Retrieve grades from EditText fields
        String grade1 = course1Grade.getText().toString();
        String grade2 = course2Grade.getText().toString();
        String grade3 = course3Grade.getText().toString();
        String grade4 = course4Grade.getText().toString();
        String grade5 = course5Grade.getText().toString();

        // Check for empty fields
        if (TextUtils.isEmpty(grade1) || TextUtils.isEmpty(grade2) || TextUtils.isEmpty(grade3)
                || TextUtils.isEmpty(grade4) || TextUtils.isEmpty(grade5)) {
            // Show error message if any field is empty
            gpaDisplay.setText("Please fill all fields");
            return;
        }

        // Convert grades to float
        float g1 = Float.parseFloat(grade1);
        float g2 = Float.parseFloat(grade2);
        float g3 = Float.parseFloat(grade3);
        float g4 = Float.parseFloat(grade4);
        float g5 = Float.parseFloat(grade5);

        // Calculate GPA
        float total = g1 + g2 + g3 + g4 + g5;
        float gpa = total / 5;

        // Display GPA
        gpaDisplay.setText(String.format("GPA: %.2f", gpa));

        // Change background color based on GPA range
        if (gpa < 60) {
            gpaDisplay.setBackgroundColor(Color.RED);
        } else if (gpa >= 60 && gpa <= 79) {
            gpaDisplay.setBackgroundColor(Color.YELLOW);
        } else {
            gpaDisplay.setBackgroundColor(Color.GREEN);
        }

        // Change button text to "Clear Form"
        computeButton.setText("Clear Form");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();

        // Reset button text to "Compute GPA" when resuming activity
        computeButton.setText("Compute GPA");
    }
}
