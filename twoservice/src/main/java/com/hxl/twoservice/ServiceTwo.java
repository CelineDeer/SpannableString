package com.hxl.twoservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by hp_laptop on 2017/6/26.
 */

public class ServiceTwo extends Service {
    public final String progressName = "com.hxl.twoservice.ServiceTwo";

    @Override
    public void onCreate() {
        super.onCreate();
        keepServiceOne();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) startOne;
    }

    private void keepServiceOne(){
        Boolean isRunning = Utils.isProgressRunning(ServiceTwo.this,progressName);
        if (!isRunning){
            try {
                startOne.startService();
                Toast.makeText(this, "重新启动ServiceOne", Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        keepServiceOne();
    }

    private StrongService startOne = new StrongService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void startService() throws RemoteException {
            Intent intent  = new Intent(getBaseContext(),ServiceOne.class);
            getBaseContext().startService(intent);
        }

        @Override
        public void stopService() throws RemoteException {
            Intent intent = new Intent(getBaseContext(),ServiceOne.class);
            getBaseContext().stopService(intent);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","service2---> onStartCommand");
// 在API11之后构建Notification的方式
        Notification.Builder builder = new Notification.Builder(this.getApplicationContext()); //获取一个Notification构造器
        Intent nfIntent = new Intent(this, MainActivity.class);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, nfIntent, 0)) // 设置PendingIntent
                 .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher))
        // 设置下拉列表中的图标(大图标)
                 .setContentTitle("下拉列表中的Title") // 设置下拉列表里的标题
                 .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏内的小图标
                 .setContentText("要显示的内容") // 设置上下文内容
         .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间
         Notification notification = builder.build(); // 获取构建好的Notification
         notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音

        startForeground(1, notification);// 开始前台服务
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","service2---> onDestroy");
        keepServiceOne();

    }
}
