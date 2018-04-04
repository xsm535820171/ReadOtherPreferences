package com.my.readotherpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button getper;
    Context otherperference;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getper= (Button) findViewById(R.id.getper);
        getper.setOnClickListener(this);
        try {
            otherperference=createPackageContext("com.my.app",CONTEXT_IGNORE_SECURITY);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        sharedPreferences=getSharedPreferences("otheret",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getper:
                String et=sharedPreferences.getString("et",null);
                Toast.makeText(MainActivity.this,"其他"+et,Toast.LENGTH_LONG).show();
        }

    }
}
