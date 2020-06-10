package com.example.sos_app;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TransmitSOS extends Worker {
    private static final String CHANNEL_ID = "SOS" ;
    Location SOSLocation;
    String DeviceID;

    public TransmitSOS(
            @NonNull Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }




    @Override
    public ListenableWorker.Result doWork() {

        DeviceID = SosActivity.deviceId;
        SOSLocation = SosActivity.final_loc;

        SendSOS();
        sendPushNotification();

        // Indicate whether the work finished successfully with the Result
        return ListenableWorker.Result.success();
    }

    private void sendPushNotification() {
        /*
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Active SOS")
                .setContentText("A Sos has been sent")
                .setPriority(NotificationCompat.PRIORITY_MAX);

         */
    }

    public void SendSOS() {


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SOS/"+DeviceID);
        myRef.setValue(SOSLocation);
    }



}

