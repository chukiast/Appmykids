package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class menurevac extends AppCompatActivity {

    Button btnrevac9m_1,btnrevac1_5,btnrevac2,btnrevac2_5,btnrevac6,btnrevac6up ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menurevac);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");





        btnrevac9m_1 = (Button)findViewById(R.id.btnrevac9m_1);
        btnrevac9m_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac9m_1 = new Intent(menurevac.this,Showvaccine9m_1.class);
                //่ส่งตัวแปร username
                gotobtnrevac9m_1.putExtra("username",strusername);
                startActivity(gotobtnrevac9m_1);
            }
        });

        btnrevac1_5 = (Button)findViewById(R.id.btnrevac1_5);
        btnrevac1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac1_5 = new Intent(menurevac.this,Showvaccine1_5.class);
                //่ส่งตัวแปร username
                gotobtnrevac1_5.putExtra("username",strusername);
                startActivity(gotobtnrevac1_5);
            }
        });

        btnrevac2 = (Button)findViewById(R.id.btnrevac2);
        btnrevac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac2 = new Intent(menurevac.this,Showvaccine2.class);
                //่ส่งตัวแปร username
                gotobtnrevac2.putExtra("username",strusername);
                startActivity(gotobtnrevac2);
            }
        });

        btnrevac2_5 = (Button)findViewById(R.id.btnrevac2_5);
        btnrevac2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac2_5 = new Intent(menurevac.this,Showvaccine2_5.class);
                //่ส่งตัวแปร username
                gotobtnrevac2_5.putExtra("username",strusername);
                startActivity(gotobtnrevac2_5);
            }
        });

        btnrevac6 = (Button)findViewById(R.id.btnrevac6);
        btnrevac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac6 = new Intent(menurevac.this,Showvaccine6.class);
                //่ส่งตัวแปร username
                gotobtnrevac6.putExtra("username",strusername);
                startActivity(gotobtnrevac6);
            }
        });

        btnrevac6up = (Button)findViewById(R.id.btnrevac6up);
        btnrevac6up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobtnrevac6up = new Intent(menurevac.this,Showvaccine6up.class);
                //่ส่งตัวแปร username
                gotobtnrevac6up.putExtra("username",strusername);
                startActivity(gotobtnrevac6up);
            }
        });

    }
}
