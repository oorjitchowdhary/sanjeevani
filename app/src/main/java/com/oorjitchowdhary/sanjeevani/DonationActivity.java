package com.oorjitchowdhary.sanjeevani;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.oorjitchowdhary.sanjeevani.Models.Doner;

public class DonationActivity extends AppCompatActivity {

    private Doner mDonations;
    private TextView name_text;
    private TextView age_text;
    private TextView address_text;
    private TextView bloodgroup_text;
    private static final String TAG = "DonationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        name_text = findViewById(R.id.name_details);
        age_text = findViewById(R.id.age_details);
        address_text = findViewById(R.id.address_details);
        bloodgroup_text = findViewById(R.id.bloodgroup_details);

        if (getIntent().hasExtra("selected_donation")){
            mDonations = getIntent().getParcelableExtra("selected_donation");
            setDonationProperties();
        }
    }

    private void setDonationProperties() {
        name_text.setText("Name: " + mDonations.getName());
        age_text.setText("Age: " + mDonations.getAge());
        address_text.setText("Address: " + mDonations.getAddress());
        bloodgroup_text.setText("Blood group: " + mDonations.getBloodgroup());
    }
}
