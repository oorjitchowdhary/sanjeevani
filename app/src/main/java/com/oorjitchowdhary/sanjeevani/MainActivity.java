package com.oorjitchowdhary.sanjeevani;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

    public void goToDonate(View view) {
        startActivity(new Intent(MainActivity.this, DonateActivity.class));
    }
    public void goToLogin(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
