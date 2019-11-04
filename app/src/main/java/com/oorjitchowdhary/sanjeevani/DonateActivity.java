package com.oorjitchowdhary.sanjeevani;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DonateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
    }

    public void donate(View view) {
        TextInputEditText nameet = findViewById(R.id.name_edit);
        TextInputEditText ageet = findViewById(R.id.age_edit);
        TextInputEditText addresset = findViewById(R.id.address_edit);
        TextInputEditText bloodgroupet = findViewById(R.id.bloodgroup_edit);
        TextInputEditText genderet = findViewById(R.id.gender_edit);
        TextInputEditText messageet = findViewById(R.id.message_edit);

        String name = nameet.getText().toString();
        String age = ageet.getText().toString();
        String address = addresset.getText().toString();
        String bloodgroup = bloodgroupet.getText().toString();
        String gender = genderet.getText().toString();
        String message = messageet.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> donerDetails = new HashMap<>();
        donerDetails.put("name", name);
        donerDetails.put("age", age);
        donerDetails.put("address", address);
        donerDetails.put("blood group", bloodgroup);
        donerDetails.put("gender", gender);
        donerDetails.put("message", message);

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(address) || TextUtils.isEmpty(bloodgroup)){
            Toast.makeText(this, "Please complete the form", Toast.LENGTH_SHORT).show();
        } else {
            db.collection("Doners").add(donerDetails)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(DonateActivity.this, "Thank you for your donation.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(DonateActivity.this, MainActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DonateActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
