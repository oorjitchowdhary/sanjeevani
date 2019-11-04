package com.oorjitchowdhary.sanjeevani;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.oorjitchowdhary.sanjeevani.Adapters.DonationsRecyclerAdapter;
import com.oorjitchowdhary.sanjeevani.Models.Doner;
import com.oorjitchowdhary.sanjeevani.Util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity implements DonationsRecyclerAdapter.OnDonationListener {

    private RecyclerView mRecyclerView;
    private ArrayList<Doner> mDonations = new ArrayList<>();
    private DonationsRecyclerAdapter mDonationsRecyclerAdapter;

    private FirebaseAuth mAuth;

    private static final String TAG = "AdminActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mAuth = FirebaseAuth.getInstance();
        mRecyclerView = findViewById(R.id.recyclerview);

        insertNotes();
        initRecyclerView();
    }

    public void logout(View view) {
        mAuth.signOut();
        Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AdminActivity.this, MainActivity.class));
        finish();
    }

    private void insertNotes(){
        FirebaseUser user = mAuth.getCurrentUser();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Doners").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documentSnapshot:task.getResult()){
                                Doner donation = new Doner();
                                donation.setName(documentSnapshot.getString("name"));
                                donation.setAge(documentSnapshot.getString("age"));
                                donation.setAddress(documentSnapshot.getString("address"));
                                donation.setBloodgroup(documentSnapshot.getString("blood group"));
                                donation.setGender(documentSnapshot.getString("gender"));
                                donation.setMessage(documentSnapshot.getString("message"));
                                mDonations.add(donation);
                            }
                            mDonationsRecyclerAdapter.notifyDataSetChanged();
                        } else {
                            Log.d(TAG, "onComplete: ", task.getException());
                        }
                    }
                });
    }

    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(12);
        mRecyclerView.addItemDecoration(itemDecorator);
        mDonationsRecyclerAdapter = new DonationsRecyclerAdapter(mDonations, this);
        mRecyclerView.setAdapter(mDonationsRecyclerAdapter);

    }

    @Override
    public void OnDonationClick(int position) {
        Intent intent = new Intent(this, DonationActivity.class);
        intent.putExtra("selected_donation", mDonations.get(position));
        startActivity(intent);
    }
}
