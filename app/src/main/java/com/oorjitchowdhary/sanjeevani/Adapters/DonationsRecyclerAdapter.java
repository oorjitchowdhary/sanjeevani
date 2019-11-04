package com.oorjitchowdhary.sanjeevani.Adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import com.oorjitchowdhary.sanjeevani.Models.Doner;
import com.oorjitchowdhary.sanjeevani.R;

public class DonationsRecyclerAdapter extends RecyclerView.Adapter<DonationsRecyclerAdapter.ViewHolder> {

    private ArrayList<Doner> mDonations = new ArrayList<>();
    private OnDonationListener mOnDonationListener;

    public DonationsRecyclerAdapter(ArrayList<Doner> mDonations, OnDonationListener onDonationListener) {
        this.mDonations = mDonations;
        this.mOnDonationListener = onDonationListener;
    }


    @NonNull
    @Override
    public DonationsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        return new ViewHolder(view, mOnDonationListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationsRecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mDonations.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        OnDonationListener onDonationListener;

        public ViewHolder(@NonNull View itemView, OnDonationListener onDonationListener) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);

            this.onDonationListener = onDonationListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onDonationListener.OnDonationClick(getAdapterPosition());
        }
    }

    public interface OnDonationListener {
        void OnDonationClick(int position);
    }
}
