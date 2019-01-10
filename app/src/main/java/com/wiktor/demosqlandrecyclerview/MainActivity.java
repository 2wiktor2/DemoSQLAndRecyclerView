package com.wiktor.demosqlandrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNumber1;
    EditText editTextNumber2;

    TextView textViewResult;

    Button buttonCalculate;
    Button buttonSave;
    Button history;

    private int num1, num2, sum;

    private DBHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.et_number_1);
        editTextNumber2 = findViewById(R.id.et_number_2);
        textViewResult = findViewById(R.id.tv_result2);

        buttonCalculate = findViewById(R.id.b_calculate);
        buttonSave = findViewById(R.id.b_save);
        history = findViewById(R.id.b_saved_history);
        buttonCalculate.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        history.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_calculate:
              if (!editTextNumber1.getText().toString().equals("") && !editTextNumber2.getText().toString().equals("")) {
                  num1 = Integer.parseInt(editTextNumber1.getText().toString());
                  num2 = Integer.parseInt(editTextNumber2.getText().toString());
                  sum = num1+num2;
                  textViewResult.setText(""+sum);
              } else {
                  Toast.makeText(this, "введите числа", Toast.LENGTH_LONG).show();
              }


                break;
                case R.id.b_save:
                    Intent intent = new Intent(this, SaveFormActivity.class );
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.KEY_FIRST, editTextNumber1.getText().toString());
                    bundle.putString(Constants.KEY_SECOND, editTextNumber2.getText().toString());
                    bundle.putString(Constants.KEY_RESULT, textViewResult.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                break;
            case R.id.b_saved_history:
                helper = new DBHelper(this);
                helper.getData();
                break;
        }


    }
}
