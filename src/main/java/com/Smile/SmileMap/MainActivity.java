package com.Smile.SmileMap;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baidu.trace.LBSTraceClient;
import com.baidu.trace.OnStartTraceListener;
import com.baidu.trace.OnStopTraceListener;
import com.baidu.trace.Trace;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton actionButton;

    protected static LBSTraceClient client = null;
    //鹰眼服务ID
    long serviceId = 105804;
    //entity标识
    String entityName = "Personal";

    int traceType = 2;
    protected static Trace trace = null;
    //实例化轨迹服务

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = (FloatingActionButton) findViewById(R.id.id_startservice);

      /*  //实例化轨迹服务客户端
        client=new LBSTraceClient(MainActivity.this);
        trace = new Trace(MainActivity.this, serviceId, entityName, traceType);
//实例化开启轨迹服务回调接口
        OnStartTraceListener startTraceListener = new OnStartTraceListener() {
            //开启轨迹服务回调接口（arg0 : 消息编码，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTraceCallback(int arg0, String arg1) {
                Toast.makeText(MainActivity.this,arg1,Toast.LENGTH_SHORT).show();
            }
            //轨迹服务推送接口（用于接收服务端推送消息，arg0 : 消息类型，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onTracePushCallback(byte arg0, String arg1) {
            }
        };

//开启轨迹服务
        client.startTrace(trace, startTraceListener);*/

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, RunService.class));
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

       /* //实例化停止轨迹服务回调接口
        OnStopTraceListener stopTraceListener = new OnStopTraceListener(){
            // 轨迹服务停止成功
            @Override
            public void onStopTraceSuccess() {
            }
            // 轨迹服务停止失败（arg0 : 错误编码，arg1 : 消息内容，详情查看类参考）
            @Override
            public void onStopTraceFailed(int arg0, String arg1) {
            }
        };

//停止轨迹服务
        client.stopTrace(trace, stopTraceListener);
    }*/
    }
}
