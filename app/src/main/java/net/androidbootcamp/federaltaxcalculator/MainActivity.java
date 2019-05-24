/**
 * @author Jooha Gud
 * @version Programming Assignment 1
 *          Due date is 2019/03/07
 * The application computes the tax liability of its user.
 * */
package net.androidbootcamp.federaltaxcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //set a launcher icon

        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button submit = (Button)findViewById(R.id.btnSubmit);
        //references to use a button and spinner

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                groupChoice = group.getSelectedItem().toString();
                if (groupChoice.compareTo("Single") == 0){
                    startActivity(new Intent(MainActivity.this, Single.class));
                }//if you choose single then will move to Single activity
                else if (groupChoice.compareTo("Married") == 0){
                    startActivity(new Intent(MainActivity.this, Married.class));
                }//if you choose married then will move to Married activity
            }
        });
    }
}
