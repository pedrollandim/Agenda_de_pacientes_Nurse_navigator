package com.example.mestrado2kellyv10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PequenoProcedimentosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pequeno_procedimentos);

        Button pequenos_procedimentos_OK= (Button)findViewById(R.id.pequenos_procedimentos_ok);
        pequenos_procedimentos_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
