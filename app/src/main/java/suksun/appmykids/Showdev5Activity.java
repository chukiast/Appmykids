package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev5Activity extends AppCompatActivity {

    Button btnbackdve5 ;

    private  String txtid,txtstring15,txtwalkinggrip,txtpencilgrip,
            txtchooseacolor,txtturnstospeak,txtplayimitations,txtdateadd,
            txtusername;

    private TextView txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev5);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        btnbackdve5 = (Button)findViewById(R.id.btnbackdve5);
        btnbackdve5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev5Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev5id");
        txtstring15 = getIntent().getStringExtra("txtstring15");

        txtwalkinggrip = getIntent().getStringExtra("walkinggrip");
        txtpencilgrip = getIntent().getStringExtra("pencilgrip");
        txtchooseacolor = getIntent().getStringExtra("chooseacolor");
        txtturnstospeak = getIntent().getStringExtra("turnstospeak");
        txtplayimitations = getIntent().getStringExtra("playimitations");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtwalkinggrip.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtpencilgrip.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtchooseacolor.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtturnstospeak.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtplayimitations.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +txtstring15.toString());

    }

}
