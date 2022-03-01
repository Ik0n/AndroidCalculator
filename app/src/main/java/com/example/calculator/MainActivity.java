package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonClear;
    private Button buttonBackspace;
    private Button buttonDivision;
    private Button buttonPercent;
    private Button buttonMultiplication;
    private Button buttonAddition;
    private Button buttonSubtraction;
    private Button buttonComma;
    private Button buttonEven;

    private EditText editTextAnswer;
    private EditText editTextOperation;

    private String action;

    private Calculator calculator = new Calculator();

    public static final String CALCULATOR = "CALCULATOR";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getExtras().getString("Theme").equals("dark_theme"))
            setTheme(R.style.Theme_Calculator_Dark);
        else if (getIntent().getExtras().getString("Theme").equals("light_theme"))
            setTheme(R.style.Theme_Calculator_Light);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            calculator = savedInstanceState.getParcelable(CALCULATOR);
        }

        editTextAnswer = findViewById(R.id.edit_answer);
        editTextOperation = findViewById(R.id.edit_operation);

        button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('1'));
                } else {
                    editTextOperation.setText("1");
                }
            }
        });

        button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('2'));
                } else {
                    editTextOperation.setText("2");
                }
            }
        });

        button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('3'));
                } else {
                    editTextOperation.setText("3");
                }
            }
        });

        button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('4'));
                } else {
                    editTextOperation.setText("4");
                }
            }
        });

        button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('5'));
                } else {
                    editTextOperation.setText("5");
                }
            }
        });

        button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('6'));
                } else {
                    editTextOperation.setText("6");
                }
            }
        });

        button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('7'));
                } else {
                    editTextOperation.setText("7");
                }
            }
        });

        button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('8'));
                } else {
                    editTextOperation.setText("8");
                }
            }
        });

        button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('9'));
                } else {
                    editTextOperation.setText("9");
                }
            }
        });

        button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null && !editTextOperation.getText().toString().equals("0")) {
                    editTextOperation.setText(editTextOperation.getText().append('0'));
                } else {
                    editTextOperation.setText("0");
                }
            }
        });

        buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null) {
                    editTextOperation.setText("");
                    editTextAnswer.setText("0");
                    calculator.setFirstOperand(0);
                    calculator.setSecondOperand(0);
                }
            }
        });

        buttonBackspace = findViewById(R.id.button_backspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder string = new StringBuilder(editTextOperation.getText().toString());
                if (editTextOperation.getText() != null && string.length() != 0) {

                    string.deleteCharAt(string.length() - 1);
                    editTextOperation.setText(string);

                }
            }
        });

        buttonDivision = findViewById(R.id.button_division);
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    if (calculator.getFirstOperand() == 0)
                        calculator.setFirstOperand(Double.parseDouble(string));


                    calculator.setAction("/");

                    editTextOperation.setText("0");
                }
            }
        });

        buttonPercent = findViewById(R.id.button_percent);
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    if (calculator.getFirstOperand() == 0)
                        calculator.setFirstOperand(Double.parseDouble(string));


                    calculator.setAction("%");

                    editTextOperation.setText("0");
                }
            }
        });
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    if (calculator.getFirstOperand() == 0)
                        calculator.setFirstOperand(Double.parseDouble(string));


                    calculator.setAction("*");

                    editTextOperation.setText("0");
                }
            }
        });
        buttonAddition = findViewById(R.id.button_addition);
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    if (calculator.getFirstOperand() == 0)
                        calculator.setFirstOperand(Double.parseDouble(string));


                    calculator.setAction("+");

                    editTextOperation.setText("0");
                }
            }
        });
        buttonSubtraction = findViewById(R.id.button_subtraction);
        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    if (calculator.getFirstOperand() == 0)
                        calculator.setFirstOperand(Double.parseDouble(string));


                    calculator.setAction("-");

                    editTextOperation.setText("0");
                }
            }
        });

        buttonComma = findViewById(R.id.button_comma);

        buttonEven = findViewById(R.id.button_even);
        buttonEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextOperation.getText() != null) {
                    String string = editTextOperation.getText().toString();
                    try {
                        calculator.setSecondOperand(Double.parseDouble(string));
                    } catch (NumberFormatException e) {

                    }

                    //editTextOperation.setText(calculator.getFirstOperand() + " " + calculator.getAction() + " " + calculator.getSecondOperand());
                    editTextOperation.setText(calculator.getFirstOperand() + "");
                    double answer = 0;

                    switch (calculator.getAction()) {
                        case "/":
                            answer = calculator.division();
                            break;
                        case "%":
                            answer = calculator.percent();
                            break;
                        case "*":
                            answer = calculator.multiplication();
                            break;
                        case "+":
                            answer = calculator.addition();
                            break;
                        case "-":
                            answer = calculator.subtraction();
                            break;
                        default:
                            answer = calculator.getFirstOperand();
                            break;
                    }

                    editTextAnswer.setText(String.valueOf(answer));

                    calculator.setFirstOperand(answer);
                    calculator.setSecondOperand(0);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CALCULATOR, calculator);
    }
}