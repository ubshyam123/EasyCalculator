package com.tuneintoshyamstech.easycalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String str = "";
    Character op ='q';
    float num, numtemp;
    TextView showResult;
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, subtract, multiply, divide, equal, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        showResult = (TextView) findViewById(R.id.result_id);


        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);

        add = (Button)findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.div);
        equal = (Button) findViewById(R.id.equal);
        clear = (Button) findViewById(R.id.clear);

        //Number selection
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(0);
            }
        });
        //Operation selection
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op='+';
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op='-';
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op='*';
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform();
                op='/';
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });



    }

    private void insert(int i) {
        str = str + i;
        num = Float.parseFloat(str);
        showResult.setText(str);

    }

    private void perform() {
        calculate();
        numtemp = num;
        num=0;
        str="";
    }

    private void calculate() {
        float fullResult = 0;
        boolean completed =  false;
        switch (op){
            case '+':
                fullResult = num + numtemp;
                completed = true;
                break;
            case '/':
                if(num!=0) {
                    fullResult = numtemp / num;
                    completed = true;
                }else{
                    Toast.makeText(MainActivity.this,"Cannot Divide by Zero",Toast.LENGTH_SHORT).show();
                }
                break;
            case '-':
                fullResult = numtemp - num;
                completed = true;
                break;
            case '*':
                fullResult = num * numtemp;
                completed = true;
                break;
            case 'q':
                break;
        }
        if(completed) {
            showResult.setText("" + fullResult);
            str = "";
            num = fullResult;
            numtemp = 0;
            op='q';
        }

    }

    private void reset() {
        str="";
        num=0;
        numtemp=0;
        showResult.setText("");
        showResult.setHint("00.00");
        op='q';
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
