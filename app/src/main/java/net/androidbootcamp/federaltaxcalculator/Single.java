package net.androidbootcamp.federaltaxcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Single extends AppCompatActivity {
    double deductionSingle = 6300;
    double taxDueSingle;
    double incomeSingle;
    //declare variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //set a launcher icon

        final EditText enteredIncomeSingle = (EditText) findViewById(R.id.txtIncomeSingle);
        final RadioButton deducSingle = (RadioButton) findViewById(R.id.radDeducSingle);
        final RadioButton noDeducSingle = (RadioButton) findViewById(R.id.radNoDeducSingle);
        final Button goBackSingle = (Button)findViewById(R.id.btnBackSingle);
        //references to use a button, radio button, and number text field
        goBackSingle.setVisibility(View.INVISIBLE);
        //hide the button

        Button calcSingle = (Button) findViewById(R.id.btnSingle);
        //reference to use a button
        calcSingle.setOnClickListener(new View.OnClickListener() {
            final TextView resultSingle = (TextView) findViewById(R.id.txtResultSingle);

            @Override
            public void onClick(View view) {
                incomeSingle = Double.parseDouble(enteredIncomeSingle.getText().toString());
                if (deducSingle.isChecked()) {
                    incomeSingle -= deductionSingle;
                }//deduction

                if (incomeSingle > 0 && incomeSingle < 9275) {
                    taxDueSingle = incomeSingle * 0.1;
                } else if (incomeSingle > 9276 && incomeSingle < 37650) {
                    taxDueSingle = 927.50 + (incomeSingle - 9275) * 0.15;
                } else if (incomeSingle > 37651 && incomeSingle < 91150) {
                    taxDueSingle = 5183.75 + (incomeSingle - 37650) * 0.25;
                } else if (incomeSingle > 91151 && incomeSingle < 190150) {
                    taxDueSingle = 18558 + (incomeSingle - 91150) * 0.28;
                } else if (incomeSingle > 190151 && incomeSingle < 413350) {
                    taxDueSingle = 46278.75 + (incomeSingle - 190150) * 0.33;
                } else if (incomeSingle > 413351 && incomeSingle < 415050) {
                    taxDueSingle = 119934.75 + (incomeSingle - 413350) * 0.35;
                } else if (incomeSingle > 415051) {
                    taxDueSingle = 120529.75 + (incomeSingle - 415050) * 0.396;
                }
                DecimalFormat formatSingle = new DecimalFormat("$.##");
                resultSingle.setText("Your Tax Due is " + formatSingle.format(taxDueSingle));
                //displays a result
                goBackSingle.setVisibility(View.VISIBLE);
                //presents a button to go back to the main activity
            }
        });

        goBackSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Single.this, MainActivity.class));
            }
        }); //when the button is clicked, go back to the main activity
    }
}
