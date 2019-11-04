package com.oorjitchowdhary.sanjeevani;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    TextView para1, para2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        para1 = findViewById(R.id.para1);
        para2 = findViewById(R.id.para2);

        para1.setMovementMethod(new ScrollingMovementMethod());
        para2.setMovementMethod(new ScrollingMovementMethod());
    }
}
