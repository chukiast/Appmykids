package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuvaccine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuvaccine);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        Button btnvac9m_1 = (Button)findViewById(R.id.btnvac9m_1);
        btnvac9m_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac9m_1 = new Intent(menuvaccine.this,vaccine9m_1.class);
                //่ส่งตัวแปร username
                gotovac9m_1.putExtra("username",strusername);
                startActivity(gotovac9m_1);
            }
        });

        Button btnvac1_5 = (Button)findViewById(R.id.btnvac1_5);
        btnvac1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac1_5 = new Intent(menuvaccine.this,vaccine1_5.class);
                //่ส่งตัวแปร username
                gotovac1_5.putExtra("username",strusername);
                startActivity(gotovac1_5);
            }
        });

        Button btnvac2 = (Button)findViewById(R.id.btnvac2);
        btnvac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac2 = new Intent(menuvaccine.this,vaccine2.class);
                //่ส่งตัวแปร username
                gotovac2.putExtra("username",strusername);
                startActivity(gotovac2);
            }
        });

        Button btnvac2_5 = (Button)findViewById(R.id.btnvac2_5);
        btnvac2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac2_5 = new Intent(menuvaccine.this,vaccine2_5.class);
                //่ส่งตัวแปร username
                gotovac2_5.putExtra("username",strusername);
                startActivity(gotovac2_5);
            }
        });

        Button btnvac6 = (Button)findViewById(R.id.btnvac6);
        btnvac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac6 = new Intent(menuvaccine.this,vaccine6.class);
                //่ส่งตัวแปร username
                gotovac6.putExtra("username",strusername);
                startActivity(gotovac6);
            }
        });

        final Button btnvac6up = (Button)findViewById(R.id.btnvac6up);
        btnvac6up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovac6up = new Intent(menuvaccine.this,vaccine6up.class);
                //่ส่งตัวแปร username
                gotovac6up.putExtra("username",strusername);
                startActivity(gotovac6up);
            }
        });
}
}
