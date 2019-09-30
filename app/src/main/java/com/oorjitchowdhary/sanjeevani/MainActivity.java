package com.oorjitchowdhary.sanjeevani;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLearn(View view){
        startActivity(new Intent(MainActivity.this, BlogActivity.class));
    }

    public void goToContact(View view){
        startActivity(new Intent(MainActivity.this, ContactUsActivity.class));
    }

    public void goToAbout(View view){
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }


}
