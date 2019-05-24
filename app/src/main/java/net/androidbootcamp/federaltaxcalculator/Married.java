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

public class Married extends AppCompatActivity {
    double deductionMarried = 12600;
    double taxDueMarried;
    double incomeMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_married);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText enteredIncomeMarried = (EditText) findViewById(R.id.txtIncomeMarried);
        final RadioButton deducMarried = (RadioButton) findViewById(R.id.radDeducMarried);
        final RadioButton noDeducMarried = (RadioButton) findViewById(R.id.radNoDeducMarried);
        final Button goBackMarried = (Button)findViewById(R.id.btnBackMarried);
        goBackMarried.setVisibility(View.INVISIBLE);

        Button calcSingle = (Button) findViewById(R.id.btnMarried);
        calcSingle.setOnClickListener(new View.OnClickListener() {
            final TextView resultMarried = (TextView) findViewById(R.id.txtResultMarried);

            @Override
            public void onClick(View view) {
                incomeMarried = Double.parseDouble(enteredIncomeMarried.getText().toString());
                if (deducMarried.isChecked()) {
                    incomeMarried -= deductionMarried;
                }

                if (incomeMarried > 0 && incomeMarried < 18550) {
                    taxDueMarried = incomeMarried * 0.1;
                } else if (incomeMarried > 18551 && incomeMarried < 75300) {
                    taxDueMarried = 1855 + (incomeMarried - 18550) * 0.15;
                } else if (incomeMarried > 75301 && incomeMarried < 151900) {
                    taxDueMarried = 10367.50 + (incomeMarried - 75300) * 0.25;
                } else if (incomeMarried > 151901 && incomeMarried < 231450) {
                    taxDueMarried = 29517.50 + (incomeMarried - 151900) * 0.28;
                } else if (incomeMarried > 231451 && incomeMarried < 413350) {
                    taxDueMarried = 51791.50 + (incomeMarried - 231450) * 0.33;
                } else if (incomeMarried > 413351 && incomeMarried < 466950) {
                    taxDueMarried = 111818.50 + (incomeMarried - 413350) * 0.35;
                } else if (incomeMarried > 466951) {
                    taxDueMarried = 130578.50 + (incomeMarried - 466950) * 0.396;
                }
                DecimalFormat formatSingle = new DecimalFormat("$.##");
                resultMarried.setText("Your Tax Due is " + formatSingle.format(taxDueMarried));
                goBackMarried.setVisibility(View.VISIBLE);
            }
        });
        goBackMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Married.this, MainActivity.class));
            }
        });
    }
}
