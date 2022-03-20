package com.example.tsp7calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;

    EditText editText;

    float mValueOne, mValueTwo;

    boolean add, sub, mult, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button41);
        button1 = (Button) findViewById(R.id.button35);
        button2 = (Button) findViewById(R.id.button34);
        button3 = (Button) findViewById(R.id.button33);
        button4 = (Button) findViewById(R.id.button31);
        button5 = (Button) findViewById(R.id.button30);
        button6 = (Button) findViewById(R.id.button29);
        button7 = (Button) findViewById(R.id.button27);
        button8 = (Button) findViewById(R.id.button26);
        button9 = (Button) findViewById(R.id.button25);
        button10 = (Button) findViewById(R.id.button22);
        buttonAdd = (Button) findViewById(R.id.button32);
        buttonSub = (Button) findViewById(R.id.button28);
        buttonMul = (Button) findViewById(R.id.button24);
        buttonDivision = (Button) findViewById(R.id.button39);
        buttonC = (Button) findViewById(R.id.button40);
        buttonEqual = (Button) findViewById(R.id.button21);
        editText = (EditText) findViewById(R.id.editTextTextPersonName);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "1");
            }
        } );

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "2");
            }
        } );

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "3");
            }
        } );

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "4");
            }
        } );

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "5");
            }
        } );

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "6");
            }
        } );

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "7");
            }
        } );

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "8");
            }
        } );

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "9");
            }
        } );

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + "0");
            }
        } );

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null) {
                    editText.setText("");
                } else {
                    mValueOne = Float.parseFloat(editText.getText() + "");
                    add = true;
                    editText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editText.getText() + "");
                sub = true;
                editText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editText.getText() + "");
                mult = true;
                editText.setText(null);
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(editText.getText() + "");
                div = true;
                editText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                mValueTwo = Float.parseFloat(editText.getText() + "");

                if (add) {
                    editText.setText((mValueOne + mValueTwo + ""));
                    add = false;
                }

                if (sub) {
                    editText.setText(mValueOne - mValueTwo + "");
                    sub = false;
                }

                if (mult) {
                    editText.setText(mValueOne * mValueTwo + "");
                    mult = false;
                }

                if (div) {
                    editText.setText(mValueOne / mValueTwo + "");
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText() + ".");
            }
        });
    }
}