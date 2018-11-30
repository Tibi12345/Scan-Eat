package com.example.priyanka.qrbarcodescanner;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button = (Button)findViewById(R.id.scannerBtn);
        button1 = (Button)findViewById(R.id.database);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);


    }

    private void scaneaza()
    {
        startActivity(new Intent(MainActivity.this, ScanActivity.class));
    }



    @Override
    public void onClick(View v)
    {
       if(v==this.button)
       {
           scaneaza();

       }
       else
       {
           if(v==this.button1)
           {
               startActivity(new Intent(MainActivity.this,ProductsListActivity.class));
           }
       }
    }




    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}




