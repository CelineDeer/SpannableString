package com.hxl.twoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hp_laptop on 2017/6/26.
 */

public class ServiceOne extends Service{

    public final String progressName = "com.hxl.twoservice.ServiceTwo";

    @Override
    public void onCreate() {
        super.onCreate();
        keepServiceTwo();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        keepServiceTwo();
    }

    private void keepServiceTwo(){
        Boolean isRunning = Utils.isProgressRunning(ServiceOne.this,progressName);
        if (!isRunning){
            try {
                starsTwo.startService();
                Toast.makeText(this, "重新启动ServiceTwo", Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) starsTwo;
    }


    private StrongService starsTwo = new StrongService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void startService() throws RemoteException {
            Intent intent = new Intent(getBaseContext(),ServiceTwo.class);
            getBaseContext().startService(intent);
        }

        @Override
        public void stopService() throws RemoteException {
            Intent intent = new Intent(getBaseContext(),ServiceTwo.class);
            getBaseContext().stopService(intent);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","service1--->  onStartCommand");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","service1---> onDestroy");
        keepServiceTwo();
    }
}
