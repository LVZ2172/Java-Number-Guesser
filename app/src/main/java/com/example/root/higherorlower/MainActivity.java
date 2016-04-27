package com.example.root.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        int generatedNumber;

    public void clickGuess(View view) {

        System.out.println(generatedNumber);

        EditText guess = (EditText) findViewById(R.id.guess);
        String guessStr = guess.getText().toString();
        if (guessStr.length() == 0) {
            Toast.makeText(getApplicationContext(), "cannot be blank!", Toast.LENGTH_SHORT).show();
        } else {
            int guessInt = Integer.parseInt(guessStr);
            String message = "";

            if (guessInt == generatedNumber) {
                message = guessInt + " is the correct guess!";
                Random randGen = new Random();
                generatedNumber = randGen.nextInt(6);
            } else if (guessInt < generatedNumber) {
                message = guessInt + " is too low, try again";
            } else {
                message = guessInt + " is too high, try again";
            }
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randGen = new Random();
        generatedNumber = randGen.nextInt(6);
    }

}
