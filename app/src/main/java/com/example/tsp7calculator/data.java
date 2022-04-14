package com.example.tsp7calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class data extends AppCompatActivity {
    //Button to move to calculator screen
    private Button move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        //Setting the button to the move button
        move=findViewById(R.id.Move2);
        //Creating on click listener
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Moving view to the calculator view
                Intent intent = new Intent(data.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}