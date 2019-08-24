package com.oorjitchowdhary.sanjeevani;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactUsActivity extends AppCompatActivity {
    MaterialButton send;
    TextInputEditText name, designation, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        send = findViewById(R.id.send);
        name = findViewById(R.id.name);
        designation = findViewById(R.id.designation);
        message = findViewById(R.id.message);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_str = name.getText().toString();
                String designation_str = designation.getText().toString();
                String msg_str = message.getText().toString();

                Intent sendMail = new Intent(Intent.ACTION_SEND);
                sendMail.putExtra(Intent.EXTRA_EMAIL, new String[]{"oorjit.chowdhary@hotmail.com"});
                sendMail.putExtra(Intent.EXTRA_SUBJECT, name_str + " wants to get in touch.");
                sendMail.putExtra(Intent.EXTRA_TEXT, msg_str);
                sendMail.setType("message/rfc822");
                startActivity(Intent.createChooser(sendMail, "Sent."));
            }
        });
    }
}
