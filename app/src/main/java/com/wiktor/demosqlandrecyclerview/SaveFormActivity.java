package com.wiktor.demosqlandrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SaveFormActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonSave;

    EditText editTextShop;
    EditText editTextPrise;
    EditText editTextNotes;


    TextView textViewData;
    TextView textViewNum1;
    TextView textViewNum2;
    TextView textViewResult;

    int number1, number2, number3;

    private DBHelper helper;
    String myDataTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_form);

        buttonSave = findViewById(R.id.b_save2);
        editTextShop = findViewById(R.id.et_shop);
        editTextPrise = findViewById(R.id.et_prise);
        editTextNotes = findViewById(R.id.et_notes);


        textViewData = findViewById(R.id.tv_data);
        textViewNum1 = findViewById(R.id.tv_num1);
        textViewNum2 = findViewById(R.id.tv_num2);
        textViewResult = findViewById(R.id.tv_res);

        buttonSave.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            number1 = Integer.parseInt(bundle.getString(Constants.KEY_FIRST));
            number2 = Integer.parseInt(bundle.getString(Constants.KEY_SECOND));
            number3 = Integer.parseInt(bundle.getString(Constants.KEY_RESULT));
        }

        textViewNum1.setText("" + number1);
        textViewNum2.setText("" + number2);
        textViewResult.setText("" + number3);

        //Date dateTime = Calendar.getInstance().getTime();
        myDataTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        textViewData.setText(myDataTime);

        helper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {
        addRow();
        // todo Вегнуться обратно  на 1 страницу
        closeActivity();
    }

    // todo 1  наполнить данными
    private void addRow() {
        String time = myDataTime;
        String shop = editTextShop.getText().toString();
        int prise = Integer.parseInt(editTextPrise.getText().toString());
        String notes = editTextNotes.getText().toString();

        helper.createRow(time, number1, number2, number3, shop, prise, notes);
        Toast.makeText(this, "Запись сохранена", Toast.LENGTH_SHORT).show();



    }

    // todo 2 получить данные
    private void select() {
        helper.getData();
        goBack();

    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.close();
    }
    public void goBack(){

    }
    private void closeActivity(){
        finish();
    }

}
