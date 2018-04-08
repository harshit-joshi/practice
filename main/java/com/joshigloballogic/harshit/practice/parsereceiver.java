package com.joshigloballogic.harshit.practice;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class parsereceiver extends AppCompatActivity {
    String outputvalue;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsereceiver);
        txt=(TextView) findViewById(R.id.values);
        outputvalue=getIntent().getExtras().getString("Value");
        txt.setText(outputvalue);
    }
    public void goback(View view)
    {
       startActivity(new Intent(this,parsing.class));
    }

}
