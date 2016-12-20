package com.example.sixone.text5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sixone on 2016/12/20.
 */

public class input extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        Button bt = (Button) findViewById(R.id.button2);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText a_edit = (EditText) findViewById(R.id.a_edit);
                EditText b_edit = (EditText) findViewById(R.id.b_edit);
                EditText c_edit = (EditText) findViewById(R.id.c_edit);
                EditText d_edit = (EditText) findViewById(R.id.d_edit);

                String a_str =a_edit.getText().toString();
                String b_str =b_edit.getText().toString();
                String c_str =c_edit.getText().toString();
                String d_str =d_edit.getText().toString();

                Intent intent5 = new Intent();
                intent5.setClass(input.this, MainActivity.class);

                //new一個Bundle物件，並將要傳遞的資料傳入
                Bundle bundle = new Bundle();

                bundle.putString("a",a_str );
                bundle.putString("b_str",b_str );
                bundle.putString("c_str",c_str );
                bundle.putString("d_str",d_str );

                //將Bundle物件assign給intent
                intent5.putExtras(bundle);

                //切換Activity
                startActivity(intent5);
                input.this.finish();

            }
            });

    }


}
