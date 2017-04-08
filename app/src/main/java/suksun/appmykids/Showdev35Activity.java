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


public class Showdev35Activity extends AppCompatActivity {

    Button btnbackdve35;

    //ประกาศตัวแปล



    private String txtid,txtstring11,txtstandalone3,txtdrawacircle,
            txtfollow,txtaskaquestion,txtfollowrules,txttowork,txtdateadd,
            txtusername;

    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdev35);

        btnbackdve35 = (Button)findViewById(R.id.btnbackdve35);
        btnbackdve35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomaid = new Intent(Showdev35Activity.this,MainActivity.class);
                startActivity(gotomaid);

            }
        });

        // ส่งตัวแปล
        txtid = getIntent().getStringExtra("dev35id");
        txtstring11 = getIntent().getStringExtra("txtstring11");

        txtstandalone3 = getIntent().getStringExtra("standalone3");
        txtdrawacircle = getIntent().getStringExtra("drawacircle");
        txtfollow = getIntent().getStringExtra("follow ");
        txtaskaquestion = getIntent().getStringExtra("askaquestion");
        txtfollowrules = getIntent().getStringExtra("followrules");
        txttowork = getIntent().getStringExtra("towork");
        txtdateadd = getIntent().getStringExtra("dateadd");
        txtusername = getIntent().getStringExtra("username");


        // โชว์ข้อมูล
        txt1 = (TextView)findViewById(R.id.txt1);
        txt1.setText(txt1.getText().toString()
                +"     : "+" "+txtstandalone3.toString());

        txt2 = (TextView)findViewById(R.id.txt2);
        txt2.setText(txt2.getText().toString()
                +"     :"+" "+txtdrawacircle.toString());

        txt3 = (TextView)findViewById(R.id.txt3);
        txt3.setText(txt3.getText().toString()
                +"     :"+" "+txtfollow.toString());

        txt4 = (TextView)findViewById(R.id.txt4);
        txt4.setText(txt4.getText().toString()
                +"     :"+" "+txtaskaquestion.toString());

        txt5 = (TextView)findViewById(R.id.txt5);
        txt5.setText(txt5.getText().toString()
                +"    :"+" "+txtfollowrules.toString());

        txt6 = (TextView)findViewById(R.id.txt6);
        txt6.setText(txt6.getText().toString()
                +"    :"+" "+txttowork.toString());

        txt7 = (TextView)findViewById(R.id.txt7);
        txt7.setText(txt7.getText().toString()
                +txtstring11.toString());

    }

}
