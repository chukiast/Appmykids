package suksun.appmykids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Showdev2Activity extends AppCompatActivity {
    Button btnbackdve2;
    //ประกาศตัวแปล

    private String txtid,txtstring5,txtwordsphrasas,txtthesedisc,txtwood4,txtselect4
            ,txtuseaspoon,txtdateadd,txtusername;

    private TextView  txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev2);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        btnbackdve2 = (Button)findViewById(R.id.btnbackdve2);
        btnbackdve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev2Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });


        // ส่งตัวแปล

        txtid = getIntent().getStringExtra("dev2id");
        txtstring5 = getIntent().getStringExtra("txtstring5");

        txtwordsphrasas = getIntent().getStringExtra("wordsphrasas");
        txtthesedisc = getIntent().getStringExtra("thesedisc");
        txtwood4 = getIntent().getStringExtra("wood4");
        txtselect4 = getIntent().getStringExtra("select4");
        txtuseaspoon = getIntent().getStringExtra("useaspoon");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtwordsphrasas.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtthesedisc.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtwood4.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtselect4.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtuseaspoon.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +txtstring5.toString());






    }
}
