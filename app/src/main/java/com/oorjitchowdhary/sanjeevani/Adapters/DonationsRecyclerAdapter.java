package com.oorjitchowdhary.sanjeevani.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import com.oorjitchowdhary.sanjeevani.Models.Doner;
import com.oorjitchowdhary.sanjeevani.R;

public class DonationsRecyclerAdapter extends RecyclerView.Adapter<DonationsRecyclerAdapter.ViewHolder> {

    private ArrayList<Doner> mDonations = new ArrayList<>();

    public DonationsRecyclerAdapter(ArrayList<Doner> mDonations) {
        this.mDonations = mDonations;
    }


    @NonNull
    @Override
    public DonationsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonationsRecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mDonations.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mDonations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
        }
    }
}
