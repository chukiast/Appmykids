package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev3Activity extends AppCompatActivity {

    Button btnbackdve3;

    //ประกาศตัวแปล

    private String txtid,txtstring9,txtstandalone,txtdrawacircle2,
            txtobjects2,txtspeaking,txtpants,txtdateadd,
            txtusername;

    private TextView txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev3);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        btnbackdve3 = (Button)findViewById(R.id.btnbackdve3);
        btnbackdve3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev3Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev3id");
        txtstring9 = getIntent().getStringExtra("txtstring9");

        txtstandalone = getIntent().getStringExtra("standalone");
        txtdrawacircle2 = getIntent().getStringExtra("drawacircle2");
        txtobjects2 = getIntent().getStringExtra("objects2");
        txtspeaking = getIntent().getStringExtra("speaking");
        txtpants = getIntent().getStringExtra("pants");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");

        // โชว์ข้อมูล

        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtstandalone.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtdrawacircle2.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtobjects2.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtspeaking.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtpants.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
               +txtstring9.toString());


    }
}
