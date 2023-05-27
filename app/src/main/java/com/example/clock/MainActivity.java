package com.example.clock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView clockImageView;
    private TextView clockTextView;
    private Button checkButton;
    private EditText answerEditText;
    private Button exitButton;

    private String[] questions = {
            "What time is shown in the clock?",
            "Can you tell the time on the clock?",
            "What's the time displayed?"
            // Add more questions here
    };

    private String[] answers = {
            "5:45 pm",
            "5:45 pm",
            "10:30 am",
            "2:15 pm",
            "7:00 pm",
            "12:00 pm",
            "3:30 am",
            "9:20 am",
            "6:45 pm",
            "11:15 am",
            "8:00 pm",
            "4:30 am",
            "1:45 pm",
            "9:10 am",
            "7:30 pm",
            "2:00 am",
            "10:25 am",
            "5:55 pm",
            "12:40 pm",
            "8:15 am",
            "6:20 pm",
            "11:50 am",
            "3:05 pm",
            "10:10 pm",
            "1:30 am",
            "4:50 pm",
            "7:25 am",
            "2:35 pm",
            "9:55 pm",
            "6:10 am",
            "11:35 pm",
            "3:50 pm"
            // Add more answers here
    };

    private Random random;
    private int randomIndex; // Store the random index here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockImageView = findViewById(R.id.clockImageView);
        clockTextView = findViewById(R.id.clockTextView);
        checkButton = findViewById(R.id.checkButton);
        answerEditText = findViewById(R.id.answerEditText);
        exitButton = findViewById(R.id.exitButton);

        random = new Random();

        // Set the initial clock image and text
        setRandomClock();

        // Check the user's answer
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = answerEditText.getText().toString();
                if (checkAnswer(userAnswer)) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    setRandomClock();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong! Try again.", Toast.LENGTH_SHORT).show();
                }
                answerEditText.setText("");
            }
        });

        // Exit the app
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setRandomClock() {
        randomIndex = random.nextInt(questions.length);
        String question = questions[randomIndex];
        String answer = answers[randomIndex];

        // Set the clock image and text
        // Replace these lines with your own logic to set the appropriate clock image
        clockImageView.setImageResource(R.drawable.clock_image);
        clockTextView.setText(question);
    }

    private boolean checkAnswer(String userAnswer) {
        String correctAnswer = answers[randomIndex];
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
