package com.joshigloballogic.harshit.practice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hello(View view)
    {
    startActivity(new Intent(this,hello.class));
    }
    public void buddies(View view)
    {
        startActivity(new Intent(this,buddy.class));
    }
    public void parsecontent(View View)
    {
        startActivity(new Intent(this,parsing.class));
    }
    public void broadcasting(View view)
    {
        startActivity(new Intent(this,broadcast.class));
    }
   public void intents(View view)
   {
        startActivity(new Intent(this,intentfilter.class));
    }
    }

