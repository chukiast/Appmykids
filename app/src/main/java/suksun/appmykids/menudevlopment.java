package suksun.appmykids;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class menudevlopment extends AppCompatActivity {


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menudevlopment);


        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");



        Button btndev1 = (Button) findViewById(R.id.btndev1);
        btndev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev1 = new Intent(menudevlopment.this, Development1.class);
                //่ส่งตัวแปร username
                gotodev1.putExtra("username",strusername);
                startActivity(gotodev1);
            }
        });

        Button btndev1_5 = (Button) findViewById(R.id.btndev1_5);
        btndev1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev1_5 = new Intent(menudevlopment.this, Development1_5.class);
                //่ส่งตัวแปร username
                gotodev1_5.putExtra("username",strusername);
                startActivity(gotodev1_5);
            }
        });

        Button btndev2 = (Button) findViewById(R.id.btndev2);
        btndev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev2 = new Intent(menudevlopment.this, Development2.class);
                //่ส่งตัวแปร username
                gotodev2.putExtra("username",strusername);
                startActivity(gotodev2);
            }
        });

        Button btndev2_5 = (Button) findViewById(R.id.btndev2_5);
        btndev2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev2_5 = new Intent(menudevlopment.this, Development2_5.class);
                //่ส่งตัวแปร username
                gotodev2_5.putExtra("username",strusername);
                startActivity(gotodev2_5);
            }
        });

        Button btndev3 = (Button) findViewById(R.id.btndev3);
        btndev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev3 = new Intent(menudevlopment.this, Development3.class);
                //่ส่งตัวแปร username
                gotodev3.putExtra("username",strusername);
                startActivity(gotodev3);
            }
        });

        Button btndev3_5 = (Button) findViewById(R.id.btndev3_5);
        btndev3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev3_5 = new Intent(menudevlopment.this, Development3_5.class);
                //่ส่งตัวแปร username
                gotodev3_5.putExtra("username",strusername);
                startActivity(gotodev3_5);
            }
        });

        Button btndev4 = (Button) findViewById(R.id.btndev4);
        btndev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev4 = new Intent(menudevlopment.this, Development4.class);
                //่ส่งตัวแปร username
                gotodev4.putExtra("username",strusername);
                startActivity(gotodev4);
            }
        });

        Button btndev5 = (Button) findViewById(R.id.btndev5);
        btndev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev5 = new Intent(menudevlopment.this, Development5.class);
                //่ส่งตัวแปร username
                gotodev5.putExtra("username",strusername);
                startActivity(gotodev5);
            }
        });

        Button btndev6 = (Button) findViewById(R.id.btndev6);
        btndev6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotodev6 = new Intent(menudevlopment.this, Development6.class);
                //่ส่งตัวแปร username
                gotodev6.putExtra("username",strusername);
                startActivity(gotodev6);
            }
        });


    }
}
