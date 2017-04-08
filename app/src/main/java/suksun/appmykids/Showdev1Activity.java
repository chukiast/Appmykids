package suksun.appmykids;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Showdev1Activity extends AppCompatActivity {
    //ประกาศตัวแปล ID

    Button btnbackdve1;

    //ประกาศตัวแปล

    private  String txtid,txtstring1,txtstandaction,txthandaction,
             txthandtomouth,txtvoiced,txtpalygoods,txtdateadd,
             txtusername;

    private   TextView txt1,txt2,txt3,txt4,txt5,txt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev1);

        //รับตัวแปรที่ส่ง username
        final String strusername;
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        btnbackdve1 = (Button)findViewById(R.id.btnbackdve1);
        btnbackdve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev1Activity.this,MainActivity.class);
                //่ส่งตัวแปร username
                gotomaid.putExtra("username",strusername);
                startActivity(gotomaid);

            }
        });


       // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev1id");
        txtstring1 = getIntent().getStringExtra("txtstring1");

        txtstandaction = getIntent().getStringExtra("standaction");
        txthandaction = getIntent().getStringExtra("handaction");
        txthandtomouth = getIntent().getStringExtra("handtomouth");
        txtvoiced = getIntent().getStringExtra("voiced");
        txtpalygoods = getIntent().getStringExtra("palygoods");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtstandaction.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txthandaction.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txthandtomouth.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtvoiced.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtpalygoods.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +txtstring1.toString());

    }

}
