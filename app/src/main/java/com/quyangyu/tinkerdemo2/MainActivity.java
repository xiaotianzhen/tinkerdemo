package com.quyangyu.tinkerdemo2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //加载补丁
    public void loadPath(View view) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch_signed_7zip.apk";
        File file = new File(path);
        if (file.exists()){
            Toast.makeText(this, "补丁已经存在", Toast.LENGTH_SHORT).show();
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }else {
            Toast.makeText(this, "补丁不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
