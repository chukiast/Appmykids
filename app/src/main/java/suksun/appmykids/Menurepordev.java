package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menurepordev extends AppCompatActivity {

    private Button btndev1,btndev1_5,btndev2,btndev2_5,btndev3,btndev3_5,btndev4,btndev5,btndev6;

    //รับตัวแปรที่ส่ง username
     String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menurepordev);




        //gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();



        btndev1 = (Button)findViewById(R.id.btndev1);
        btndev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev1 = new Intent(Menurepordev.this,Reportdev1Activity.class);
                //่ส่งตัวแปร username
                gotoredev1.putExtra("username",strusername);
                startActivity(gotoredev1);
            }
        });

        btndev1_5 = (Button)findViewById(R.id.btndev1_5);
        btndev1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev1_5 = new Intent(Menurepordev.this,Reportdev1_5Activity.class);
                //่ส่งตัวแปร username
                gotoredev1_5.putExtra("username",strusername);
                startActivity(gotoredev1_5);
            }
        });


        btndev2 = (Button)findViewById(R.id.btndev2);
        btndev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev2 = new Intent(Menurepordev.this,Reportdev2Activity.class);
                //่ส่งตัวแปร username
                gotoredev2.putExtra("username",strusername);
                startActivity(gotoredev2);


            }
        });

        btndev2_5 = (Button)findViewById(R.id.btndev2_5);
        btndev2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev2_5 = new Intent(Menurepordev.this,Reportdev2_5Activity.class);
                //่ส่งตัวแปร username
                gotoredev2_5.putExtra("username",strusername);
                startActivity(gotoredev2_5);
            }
        });

        btndev3 = (Button)findViewById(R.id.btndev3);
        btndev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev3 = new Intent(Menurepordev.this,Reportdev3Activity.class);
                //่ส่งตัวแปร username
                gotoredev3.putExtra("username",strusername);
                startActivity(gotoredev3);
            }
        });


        btndev3_5 = (Button)findViewById(R.id.btndev3_5);
        btndev3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev3_5 = new Intent(Menurepordev.this, Reportdev35Activity.class);
                //่ส่งตัวแปร username
                gotoredev3_5.putExtra("username",strusername);
                startActivity(gotoredev3_5);
            }
        });

        btndev4 =(Button)findViewById(R.id.btndev4);
        btndev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev4 = new Intent(Menurepordev.this,Repotdev4Activity.class);
                //่ส่งตัวแปร username
                gotoredev4.putExtra("username",strusername);
                startActivity(gotoredev4);
            }
        });

        btndev5 = (Button)findViewById(R.id.btndev5);
        btndev5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev5 = new Intent(Menurepordev.this,Reportdev5Activity.class);
                //่ส่งตัวแปร username
                gotoredev5.putExtra("username",strusername);
                startActivity(gotoredev5);
            }
        });

        btndev6 = (Button)findViewById(R.id.btndev6);
        btndev6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoredev6 = new Intent(Menurepordev.this,Reportdev6Activity.class);
                //่ส่งตัวแปร username
                gotoredev6.putExtra("username",strusername);
                startActivity(gotoredev6);
            }
        });







    }
}
