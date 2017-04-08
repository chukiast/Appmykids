package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowcriActivity extends AppCompatActivity {

    private TextView txt1,txt2,txt3,txt4;

    private String txtid,txtstring19,txth,txtw,txtdateadd,
            txtusername; ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcri);

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("criid");
        txtstring19 = getIntent().getStringExtra("txtstring19");

        txth = getIntent().getStringExtra("height");
        txtw = getIntent().getStringExtra("weight");

        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");




        txt1 = (TextView) findViewById(R.id.txt1);
        txt1.setText(" " + txtw.toString() + "กิโลกรัม");

        txt2 = (TextView) findViewById(R.id.txt2);
        txt2.setText(" " + txth.toString() + "เซนติเมตร");

        txt4 = (TextView) findViewById(R.id.txt4);
        txt4.setText("วันที่บันทึก :" + txtdateadd.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +txtstring19.toString());

    }
}
