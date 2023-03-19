package com.example.easymeal;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TiffinCenterAdapter extends RecyclerView.Adapter<TiffinCenterAdapter.ProjectViewHolder> {
    private ArrayList<TiffinCenter> project;

    Context context ;



    public TiffinCenterAdapter(ArrayList<TiffinCenter> project, Context applicationContext) {
        this.project = project;
        this.context  = context;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiffin_center_list, parent, false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        TiffinCenter tiffinCenter = project.get(position);

        holder.priceRange.setText(tiffinCenter.getPricing());
        holder.appTitle.setText(tiffinCenter.getName());
        holder.tCAddress.setText(tiffinCenter.getTcAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Tiffin_detail.class);
                intent.putExtra("tiffin_center_name", tiffinCenter.getName());
                intent.putExtra("tiffin_center_address", tiffinCenter.getTcAddress());
                intent.putExtra("tiffin_center_price", tiffinCenter.getPricing());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return project.size();
    }

    public void filterList(ArrayList<TiffinCenter> centers) {
        project = centers;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        private ImageView appImage;
        private TextView appTitle;
        private TextView tCAddress;
        private TextView priceRange;
        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            appImage= itemView.findViewById(R.id.image_view);
            appTitle = itemView.findViewById(R.id.text_view_first);
            tCAddress= itemView.findViewById(R.id.text_view_second);
            priceRange= itemView.findViewById(R.id.text_view_third);


        }






    }

}
