package com.example.bai1_mycurrency;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener
{
    private boolean equalClicked = false;
    private String lastExpression = "";
    private String inputString ="";
    private String ans ="";
    private CurrencyEntity[] currencyEntities = CurrencyEntityUtils.getCurrency();
    private float compare = 1;

    private final static int EXCEPTION = -1;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;

    Button buttonNumber0;
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;

    Button buttonClear;
    Button buttonClearAll;
    Button buttonPercent;
    Button buttonDot;

    TextView textViewInputNumbers;
    TextView textViewAns;
    TextView textViewCompare;

    Spinner inputSpinner;
    Spinner ansSpinner;

    String[] currencies = {"VND","USD","Yên", "Yuan", "Bảng", "Euro", };

    CurrencyEntity inputCurrencyEntity = currencyEntities[0];
    CurrencyEntity ansCurrencyEntity = currencyEntities[0];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViewVariables();

        setupSpinnerAdapter();
        setOnClickListeners();
        setOnTouchListener();
    }

    private void initializeViewVariables()
    {
        buttonNumber0 = (Button) findViewById(R.id.button_zero);
        buttonNumber1 = (Button) findViewById(R.id.button_one);
        buttonNumber2 = (Button) findViewById(R.id.button_two);
        buttonNumber3 = (Button) findViewById(R.id.button_three);
        buttonNumber4 = (Button) findViewById(R.id.button_four);
        buttonNumber5 = (Button) findViewById(R.id.button_five);
        buttonNumber6 = (Button) findViewById(R.id.button_six);
        buttonNumber7 = (Button) findViewById(R.id.button_seven);
        buttonNumber8 = (Button) findViewById(R.id.button_eight);
        buttonNumber9 = (Button) findViewById(R.id.button_nine);

        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonClearAll = (Button) findViewById(R.id.button_clear_all);
        buttonPercent = (Button) findViewById(R.id.button_bs);
        buttonDot = (Button) findViewById(R.id.button_dot);
        textViewInputNumbers = (TextView) findViewById(R.id.input_textview);
        textViewAns = (TextView) findViewById(R.id.result_text_view);
        textViewCompare = (TextView) findViewById(R.id.compare_text_view);

        inputSpinner = (Spinner) findViewById(R.id.input_spinner);
        ansSpinner = (Spinner) findViewById(R.id.ans_spinner);

        reloadAllText();
    }

    private void reloadAllText() {
        compare = getCompare(inputCurrencyEntity, ansCurrencyEntity);
        textViewInputNumbers.setText(inputCurrencyEntity.getSymbol());
        textViewAns.setText(ansCurrencyEntity.getSymbol());
        textViewCompare.setText(1 + " " + inputCurrencyEntity.getName() + " = " + compare + " " + ansCurrencyEntity.getName());
    }

    private void reloadSymbolText() {
        compare = getCompare(inputCurrencyEntity, ansCurrencyEntity);
        String input = textViewInputNumbers.getText() + "";
        if (input.length() == 1) reloadAllText();
        else {
            input = input.substring(1);
            textViewInputNumbers.setText(inputCurrencyEntity.getSymbol() + ""  + input);
            textViewAns.setText(ansCurrencyEntity.getSymbol() + "" + calculate(input));
            textViewCompare.setText(1 + " " + inputCurrencyEntity.getName() + " = " + compare + " " + ansCurrencyEntity.getName());
        }
    }

    private void setupSpinnerAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter);
        ansSpinner.setAdapter(adapter);

        inputSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandlerInput(parent, view, position, id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ansSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandlerAns(parent, view, position, id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void onItemSelectedHandlerInput(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        String currency = (String) adapter.getItem(position);
        inputCurrencyEntity = getCurrency(currency);
        reloadSymbolText();

    }

    private void onItemSelectedHandlerAns(AdapterView<?> adapterView, View view, int position, long id) {
        Adapter adapter = adapterView.getAdapter();
        String currency = (String) adapter.getItem(position);
        ansCurrencyEntity = getCurrency(currency);
        reloadSymbolText();
    }

    private CurrencyEntity getCurrency(String currency) {
        for (CurrencyEntity currencyEntity : currencyEntities) {
            if (currencyEntity.getName().equals(currency)) return currencyEntity;
        }
        return currencyEntities[0];
    }

    private void setOnClickListeners()
    {
        buttonNumber0.setOnClickListener(this);
        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);

        buttonClear.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
    }

    private void setOnTouchListener()
    {
        buttonNumber0.setOnTouchListener(this);
        buttonNumber1.setOnTouchListener(this);
        buttonNumber2.setOnTouchListener(this);
        buttonNumber3.setOnTouchListener(this);
        buttonNumber4.setOnTouchListener(this);
        buttonNumber5.setOnTouchListener(this);
        buttonNumber6.setOnTouchListener(this);
        buttonNumber7.setOnTouchListener(this);
        buttonNumber8.setOnTouchListener(this);
        buttonNumber9.setOnTouchListener(this);

        buttonClear.setOnTouchListener(this);
        buttonClearAll.setOnTouchListener(this);
        buttonPercent.setOnTouchListener(this);
        buttonDot.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_add_or_sub:
                break;
            case R.id.button_zero:
                addNumber("0");
                break;
            case R.id.button_one:
                addNumber("1");
                break;
            case R.id.button_two:
                addNumber("2");
                break;
            case R.id.button_three:
                addNumber("3");
                break;
            case R.id.button_four:
                addNumber("4");
                break;
            case R.id.button_five:
                addNumber("5");
                break;
            case R.id.button_six:
                addNumber("6");
                break;
            case R.id.button_seven:
                addNumber("7");
                break;
            case R.id.button_eight:
                addNumber("8");
                break;
            case R.id.button_nine:
                addNumber("9");
                break;
            case R.id.button_bs:
                break;
            case R.id.button_dot:
                break;
            case R.id.button_clear:
                clearNumber();
                break;
            case R.id.button_clear_all:
                reloadAllText();
                break;
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    private void clearNumber() {
        inputString = textViewInputNumbers.getText() + "";
        if (!textViewInputNumbers.getText().equals("")) {
            if (inputString.length() >=2) inputString = inputString.substring(0,inputString.length() - 1);
            else inputString = inputCurrencyEntity.getSymbol();
            textViewInputNumbers.setText(inputString);
            if (inputString.equals(inputCurrencyEntity.getSymbol())) textViewAns.setText(ansCurrencyEntity.getSymbol());
            else textViewAns.setText(ansCurrencyEntity.getSymbol() + calculate(inputString.substring(1)));
        }
        else textViewInputNumbers.setText("");
    }

    private void addNumber(String number) // xử lí sự kiện thêm một số
    {
        String input = textViewInputNumbers.getText()+"";
        if (input.length() == 1 && number.equals("0")) {
            reloadAllText();
        }
        else {
            input = input.substring(1);
            input += number;
            textViewInputNumbers.setText(inputCurrencyEntity.getSymbol()+ "" + input);
            textViewAns.setText(ansCurrencyEntity.getSymbol()+ ""+ calculate(input));
        }
    }

    private String calculate(String input) // xử lí khi ấn dấu "=", xử lí phép toán
    {
        String result = "";
        int inputNumber = Integer.parseInt(input);
        float resultNumber = (float)inputNumber * compare;
        return String.valueOf(resultNumber);
    }

    private float getCompare(CurrencyEntity input, CurrencyEntity ans) {
        return ((float)input.getCompareWithOneVND() / (float)ans.getCompareWithOneVND());
    }

}
