package com.example.easymeal;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easymeal.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Profile extends Fragment {

    FirebaseFirestore db;
    FirebaseUser mAuth;
    FragmentProfileBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance().getCurrentUser();
        String curr_uid = mAuth.getUid();

        db = FirebaseFirestore.getInstance();
        db.collection("users").document(curr_uid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot snapshot = task.getResult();
                HashMap<String, Object> mp = (HashMap<String, Object>) snapshot.getData();
                binding.name.setText((CharSequence) mp.get("username"));
                binding.phone.setText((CharSequence) mp.get("phone"));
                binding.email.setText((CharSequence) mp.get("email"));
                binding.houseno.setText((CharSequence) mp.get("house"));
                binding.colony.setText((CharSequence) mp.get("area"));
                binding.city.setText((CharSequence) mp.get("City"));
                binding.state.setText((CharSequence) mp.get("State"));
                binding.pincode.setText((CharSequence) mp.get("Pincode"));
            }
        });
    }
}