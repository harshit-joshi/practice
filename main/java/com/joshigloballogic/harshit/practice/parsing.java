package com.joshigloballogic.harshit.practice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class parsing extends AppCompatActivity {
    EditText enter;
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsing);
        enter=(EditText) findViewById(R.id.entertext);
    }
    public void goto2(View view)
    {
        Intent intent=new Intent(this,parsereceiver.class);
        output=enter.getText().toString();
        intent.putExtra("Value",output);
        startActivity(intent);
        finish();
    }

}
