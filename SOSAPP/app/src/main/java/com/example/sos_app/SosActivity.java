package com.example.sos_app;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;


public class SosActivity extends AppCompatActivity{

    public static boolean ActiveSOS = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendsos);
        sendData();
    }

    //TODO add functions to buttons and add correct info to the SOS function

    public void DisableSOS(){
        ActiveSOS = false;
        WorkManager.getInstance(this).cancelAllWork();
    }

    public void sendData() {

        // Create Network constraint
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        //Makes the SOS transmitting repeat every 15 minutes
        //15 minutes is due to workmanager constraints
        PeriodicWorkRequest saveRequest =
                new PeriodicWorkRequest.Builder(TransmitSOS.class, 15, TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build();
        Context myContext = null;
        WorkManager.getInstance(this)
                .enqueue(saveRequest);


    }



}
