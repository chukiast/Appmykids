package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

public class Showdev1_5Activity extends AppCompatActivity {

    Button btnbackdve1_5;
    //ประกาศตัวแปล

    private String txtid,txtstring3,txtrun,txtholdingtheball,
            txtopenbook,txtwood,txtchoosetheorder,txttheorgan,
            txtlmitatewords,txtsayaword,txtlinterested,txtdateadd,txtusername;

    private TextView txt1,txt2,txt3,txt4,txt5,
            txt6,txt7,txt8,txt9,txt10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev1_5);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");



        btnbackdve1_5 = (Button)findViewById(R.id.btnbackdve1_5);
        btnbackdve1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev1_5Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล

        txtid = getIntent().getStringExtra("dev15id");
        txtstring3 = getIntent().getStringExtra("txtstring3");

        txtrun = getIntent().getStringExtra("run");
        txtholdingtheball = getIntent().getStringExtra("holdingtheball");
        txtopenbook = getIntent().getStringExtra("openbook");
        txtwood = getIntent().getStringExtra("wood");
        txtchoosetheorder = getIntent().getStringExtra("choosetheorder");
        txttheorgan = getIntent().getStringExtra("theorgan");
        txtlmitatewords = getIntent().getStringExtra("lmitatewords");
        txtsayaword = getIntent().getStringExtra("sayaword");
        txtlinterested = getIntent().getStringExtra("linterested");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
          +"     : "+" "+txtrun.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     : "+" "+txtholdingtheball.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     : "+" "+txtopenbook.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     : "+" "+txtwood.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"     : "+" "+txtchoosetheorder.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +"     : "+" "+txttheorgan.toString());

        txt7 = (TextView)findViewById(R.id.txt7);
        txt7.setText(txt7.getText().toString()
                +"     : "+" "+txtlmitatewords.toString());

        txt8 = (TextView)findViewById(R.id.txt8);
        txt8.setText(txt8.getText().toString()
                +"     : "+" "+txtsayaword.toString());

        txt9 = (TextView)findViewById(R.id.txt9);
        txt9.setText(txt9.getText().toString()
                +"     : "+" "+txtlinterested.toString());

        txt10 = (TextView)findViewById(R.id.txt10);
        txt10.setText(txt10.getText().toString()
               +txtstring3.toString());

    }
}
