package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev4Activity extends AppCompatActivity {

    Button btnbackdve4 ;

    //ประกาศตัวแปล

    String txtid,txtstring13,txthopping2,txtcutthepaper,
            txtcross2,txtselectobjects,txtsayasentence,txtdateadd,txtenterbutton,
            txtusername;


    private     TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev4);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        btnbackdve4 = (Button)findViewById(R.id.btnbackdve4);
        btnbackdve4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev4Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev4id");
        txtstring13 = getIntent().getStringExtra("txtstring13");

        txthopping2 = getIntent().getStringExtra("hopping2");
        txtcutthepaper = getIntent().getStringExtra("cutthepaper");
        txtcross2 = getIntent().getStringExtra("cross2");
        txtselectobjects = getIntent().getStringExtra("selectobjects");
        txtsayasentence = getIntent().getStringExtra("sayasentence");
        txtenterbutton = getIntent().getStringExtra("enterbutton");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");

        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txthopping2.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtcutthepaper.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtcross2.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtselectobjects.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtsayasentence.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +"    :"+" "+txtenterbutton.toString());

        txt7 = (TextView)findViewById(R.id.txt7);
        txt7.setText(txt7.getText().toString()
                +txtstring13.toString());

    }

}




