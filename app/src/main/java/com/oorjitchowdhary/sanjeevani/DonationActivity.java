package com.oorjitchowdhary.sanjeevani;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.oorjitchowdhary.sanjeevani.Models.Doner;

public class DonationActivity extends AppCompatActivity {

    private Doner mDonations;
    private TextView name_text, age_text, address_text, bloodgroup_text, message_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        name_text = findViewById(R.id.name_details);
        age_text = findViewById(R.id.age_details);
        address_text = findViewById(R.id.address_details);
        bloodgroup_text = findViewById(R.id.bloodgroup_details);
        message_text = findViewById(R.id.message_details);

        if (getIntent().hasExtra("selected_donation")){
            mDonations = getIntent().getParcelableExtra("selected_donation");
            setDonationProperties();
        }
    }

    private void setDonationProperties() {
        name_text.setText(mDonations.getName());
        age_text.setText( mDonations.getAge() + " years old | " + mDonations.getGender());
        address_text.setText(mDonations.getAddress());
        bloodgroup_text.setText("Blood group: " + mDonations.getBloodgroup());
        message_text.setText(mDonations.getMessage());
    }
}
