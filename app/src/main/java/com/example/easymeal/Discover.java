package com.example.easymeal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Locale;


public class Discover extends Fragment {


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView list = getView().findViewById(R.id.recycler_view);

        // Putting Data in Array
        ArrayList<TiffinCenter> projects =  new ArrayList<>();
        projects.add(new TiffinCenter("New Tiffin Center","Jain Nagar","Pricing starts from Rs100", R.drawable.tiffincenter));
        projects.add(new TiffinCenter("Shudh Tiffin Center","Housing Board","Pricing starts from Rs50", R.drawable.tiffincenter));
        projects.add(new TiffinCenter("Sunny's Kitchen","Adarsh Nagar","Pricing starts from Rs70", R.drawable.tiffincenter));
        projects.add(new TiffinCenter("Mahakal Tiffin Center","Bhawani dham", "Pricing starts Rs50", R.drawable.ic_launcher_background));
        projects.add(new TiffinCenter("Braj Bhojnalaya","Kiran Nagar", "Pricing starts Rs50", R.drawable.ic_launcher_background));
        projects.add(new TiffinCenter("Raj darbar","GandhiNagar", "Pricing starts from Rs50", R.drawable.ic_launcher_background));
        projects.add(new TiffinCenter("RajOriya Tiffin Center","Minal","Pricing starts from Rs80", R.drawable.tiffincenter));
        projects.add(new TiffinCenter("Padmavati Tiffin Services","Lalghati","Pricing starts from Rs70", R.drawable.tiffincenter));
        projects.add(new TiffinCenter("Yadav JI ka Tiffin Box","Gandhinagar", "Pricing starts Rs75", R.drawable.ic_launcher_background));
        projects.add(new TiffinCenter("Sanjeev Tiffin Services","Gandhinagar", "Pricing starts Rs65", R.drawable.ic_launcher_background));
        projects.add(new TiffinCenter("Raj darbar","GandhiNagar", "Pricing starts from Rs50", R.drawable.ic_launcher_background));

        TiffinCenterAdapter adapter= new TiffinCenterAdapter(projects,getActivity().getApplicationContext());
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        SearchView searchView = getView().findViewById(R.id.searchEditText);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<TiffinCenter> centers = new ArrayList<>();

                for(TiffinCenter center:projects){
                    if(center.getTcAddress().toLowerCase(Locale.ROOT).contains(newText.toLowerCase(Locale.ROOT))){
                        centers.add(center);

                    }

                }
                if(!centers.isEmpty()){
                    adapter.filterList(centers);
                    adapter.notifyDataSetChanged();
                }

                return false;
            }
        });




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }
}