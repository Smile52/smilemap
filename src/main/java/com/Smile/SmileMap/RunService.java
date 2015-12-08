package com.Smile.SmileMap;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.Trace;

/**开启后台服务
 * Created by Smile on 2015/12/8.
 */
public class RunService extends Service {
    protected static LBSTraceClient client = null;
    //鹰眼服务ID
    long serviceId  =105804;
    //entity标识
    String entityName = "Personal";

    int  traceType = 2;
    protected static Trace trace=null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"定位后台服务开启成功",Toast.LENGTH_SHORT).show();
        //实例化轨迹服务客户端
        client=new LBSTraceClient(getApplicationContext());
        trace = new Trace(getApplicationContext(), serviceId, entityName, traceType);
        //实例化开启轨迹服务回调接口
        OnStartTraceListener startTraceListener = new OnStartTraceListener() {
            //开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTraceCallback(int arg0, String arg1) {
                Toast.makeText(getApplicationContext(),arg1,Toast.LENGTH_SHORT).show();
            }
            //轨迹服务推送接口（用于接收服务端推送消息，arg0 : 消息类型，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTracePushCallback(byte arg0, String arg1) {
            }
        };

        //开启轨迹服务
        client.startTrace(trace, startTraceListener);

        super.onCreate();
    }
}
