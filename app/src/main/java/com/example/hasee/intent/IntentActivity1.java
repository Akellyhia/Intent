package com.example.hasee.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

public class IntentActivity1 extends AppCompatActivity {

    private EditText phone,url;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);
        phone = (EditText) findViewById(R.id.phone);
        url = (EditText) findViewById(R.id.url);
        text = (TextView) findViewById(R.id.textview1);
    }
    public void componentname(View view){
        ComponentName componentName = new ComponentName(this, IntentActivity2.class);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        startActivity(intent);
    }
    public void intentfilter(View view){
        String action = "com.gdmec07150650.kisme";
        Intent intent = new Intent();
        intent.setAction(action);
        startActivity(intent);
    }
    public void view(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }
    public void dial(View view){
        Intent intent = new Intent();
        Uri uri = Uri.parse("tel:" + phone.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }
    public void startActivityforresult(View view){
        Bundle bundle = new Bundle();
        bundle.putString("value", url.getText().toString());
        Intent intent = new Intent(IntentActivity1.this,IntentActivity2.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle = data.getExtras();
                text.setText(bundle.getString("result"));
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
