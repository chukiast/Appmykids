package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev6Activity extends AppCompatActivity {

    Button btnbackdve6 ;

    //ประกาศตัวแปล

    private  String txtid,txtstring17,txtwrite1,txtacting,
            txtplunge,txtdressedup,txtdateadd,txtusername;

    private TextView txt1,txt2,txt3,txt4,txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev6);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        btnbackdve6 = (Button)findViewById(R.id.btnbackdve6);
        btnbackdve6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev6Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev6id");
        txtstring17 = getIntent().getStringExtra("txtstring17");

        txtwrite1 = getIntent().getStringExtra("write1");
        txtacting = getIntent().getStringExtra("acting");
        txtplunge = getIntent().getStringExtra("plunge");
        txtdressedup = getIntent().getStringExtra("dressedup");

        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");

        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtwrite1.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtacting.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtplunge.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtdressedup.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +txtstring17.toString());



    }

}

