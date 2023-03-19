package com.example.easymeal;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

public class TiffinCenterAdapter extends RecyclerView.Adapter<TiffinCenterAdapter.ProjectViewHolder> {
    private TiffinCenter[] project;


    public TiffinCenterAdapter(TiffinCenter[] project) {
        this.project = project;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiffin_center_list, parent, false);

        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(project[position]);

    }

    @Override
    public int getItemCount() {
        return project.length;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView appImage;
        private TextView appTitle;
        private TextView tCAddress;
        private TextView priceRange;
        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            appImage= itemView.findViewById(R.id.image_view);
            appTitle = itemView.findViewById(R.id.text_view_first);
            tCAddress= itemView.findViewById(R.id.text_view_second);
            priceRange= itemView.findViewById(R.id.text_view_third);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), Tiffin_detail.class);
            v.getContext().startActivity(intent);
        }


        public void bind(TiffinCenter project) {
            appTitle.setText(project.name);
            tCAddress.setText(project.tcAddress);
            priceRange.setText(project.pricing);
            appImage.setBaseline(project.image);
        }
    }

}

