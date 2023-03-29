package com.example.easymeal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;


public class CheckoutActivity extends AppCompatActivity  {

    private String mTotalAmount;
    private LinearLayout mCODView,mCardView,mUpiView;
    private FirebaseFirestore db;
    private String USER_LIST = "UserList";
    private String CART_ITEMS = "CartItems";
    private String USER_ORDERS = "UserOrders";
    private String RES_LIST = "RestaurantList";
    private String RES_ORDERS = "RestaurantOrders";
    private String[] getItemsArr, getOrderedItemsArr;
    private String upiID,resName,resUid,userAddress,mid,extraInst,userPhone,uid,userName,resSpotImage,resDelTime;
    private long customerID;
    private long orderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


    }



}