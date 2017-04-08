package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev2_5Activity extends AppCompatActivity {

    Button btnbackdve2_5;
    String txtid,txtjump,txtfixtheproblem,txtpoint7,
            txtfeedback,txtwashhands,txtdateadd,txtusername,txtstring7 ;


    private TextView txt1,txt2,txt3,txt4,txt5,txt6;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev2_5);


        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        btnbackdve2_5 = (Button)findViewById(R.id.btnbackdve2_5);
        btnbackdve2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev2_5Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });



        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev25id");
        txtpoint7 = getIntent().getStringExtra("txtpoint7");

        txtjump = getIntent().getStringExtra("jump");
        txtfixtheproblem = getIntent().getStringExtra("fixtheproblem");
        txtpoint7 = getIntent().getStringExtra("point7");
        txtfeedback = getIntent().getStringExtra("feedback");
        txtwashhands = getIntent().getStringExtra("washhands");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtjump.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtfixtheproblem.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtpoint7.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtfeedback.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtwashhands.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
             +txtstring7.toString());
    }
}
