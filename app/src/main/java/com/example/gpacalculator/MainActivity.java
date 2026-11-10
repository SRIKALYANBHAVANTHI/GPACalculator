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

        computeButton.setText("Compute GPA");
        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Clear Form".contentEquals(computeButton.getText())) {
                    clearForm();
                } else {
                    computeGPA();
                }
            }
        });
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void computeGPA() {
        String[] gradeValues = {
                course1Grade.getText().toString().trim(),
                course2Grade.getText().toString().trim(),
                course3Grade.getText().toString().trim(),
                course4Grade.getText().toString().trim(),
                course5Grade.getText().toString().trim()
        };

        for (String grade : gradeValues) {
            if (TextUtils.isEmpty(grade)) {
                gpaDisplay.setText("Please fill all fields");
                return;
            }
        }

        try {
            float total = 0f;
            for (String gradeValue : gradeValues) {
                float grade = Float.parseFloat(gradeValue);
                if (Float.isNaN(grade) || Float.isInfinite(grade) || grade < 0f || grade > 100f) {
                    gpaDisplay.setText("Enter grades between 0 and 100");
                    return;
                }
                total += grade;
            }

            float gpa = total / gradeValues.length;
            gpaDisplay.setText(String.format("GPA: %.2f", gpa));

            if (gpa < 60) {
                gpaDisplay.setBackgroundColor(Color.RED);
            } else if (gpa <= 79) {
                gpaDisplay.setBackgroundColor(Color.YELLOW);
            } else {
                gpaDisplay.setBackgroundColor(Color.GREEN);
            }

            computeButton.setText("Clear Form");
        } catch (NumberFormatException e) {
            gpaDisplay.setText("Please enter valid numeric grades");
        }
    }

    private void clearForm() {
        course1Grade.setText("");
        course2Grade.setText("");
        course3Grade.setText("");
        course4Grade.setText("");
        course5Grade.setText("");
        gpaDisplay.setText("");
        gpaDisplay.setBackgroundColor(Color.TRANSPARENT);
        computeButton.setText("Compute GPA");
    }
}
