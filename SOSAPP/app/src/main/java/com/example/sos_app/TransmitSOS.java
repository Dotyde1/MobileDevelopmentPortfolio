package com.example.sos_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TransmitSOS extends Worker {
    public TransmitSOS(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }

    @Override
    public ListenableWorker.Result doWork() {


        if(SosActivity.ActiveSOS)
        // Do the work here--in this case, upload the images.
        SendSOS();

        // Indicate whether the work finished successfully with the Result
        return ListenableWorker.Result.success();
    }
    public void SendSOS() {
        System.out.println("Test");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SOS");

        myRef.setValue("Hello, World!");
    }
}
