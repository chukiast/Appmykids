package suksun.appmykids;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;

import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Development1 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbstatrue, rdbstafalse, rdbhatrue, rdbhafalse,rdbhattrue,rdbhatfalse,rdbvitrue,rdbvifalse,rdbpatrue,rdbpafalse;
    Button btnsavedev1;

    //ประกาศตัวแปล
    String rdbstat, rdbha,rdbhat,rdbvi,rdbpa;
    RadioGroup rdg1,rdg2,rdg3,rdg4,rdg5;

    //รับตัวแปรที่ส่ง username
     String strusername;
    //private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development1);


        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");




        //การผูกตัวแปลกับ ID
        rdbstatrue = (RadioButton) findViewById(R.id.rdbstatrue);
        rdbstafalse = (RadioButton) findViewById(R.id.rdbstafalse);
        rdbhatrue = (RadioButton) findViewById(R.id.rdbhatrue);
        rdbhafalse = (RadioButton) findViewById(R.id.rdbhafalse);
        rdbhattrue = (RadioButton)findViewById(R.id.rdbhattrue);
        rdbhatfalse = (RadioButton)findViewById(R.id.rdbhatfalse);
        rdbvitrue = (RadioButton)findViewById(R.id.rdbvitrue);
        rdbvifalse = (RadioButton)findViewById(R.id.rdbvifalse);
        rdbpatrue = (RadioButton)findViewById(R.id.rdbpatrue);
        rdbpafalse = (RadioButton)findViewById(R.id.rdbpafalse);
        btnsavedev1 = (Button) findViewById(R.id.btnsavedve1);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg1 = (RadioGroup)findViewById(R.id.rdg1);
        rdg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbstatrue:
                        rdbstat = "ทำได้";
                        break;
                    case R.id.rdbstafalse:
                            rdbstat = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg2 = (RadioGroup)findViewById(R.id.rdg2);
        rdg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbhatrue:
                        rdbha = "ทำได้";
                        break;
                    case R.id.rdbhafalse:
                            rdbha = "ทำไม่ได้";
                        break;
                }
            }
        });
        rdg3 = (RadioGroup)findViewById(R.id.rdg3);
        rdg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbhattrue:
                        rdbhat = "ทำได้";
                        break;
                    case R.id.rdbhatfalse:
                        rdbhat = "ทำไม่ได้";
                        break;
                }
            }
        });
        rdg4 = (RadioGroup)findViewById(R.id.rdg4);
        rdg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbvitrue:
                        rdbvi = "ทำได้";
                        break;
                    case  R.id.rdbvifalse:
                        rdbvi = "ทำไม่ได้";
                        break;
                }
            }
        });
        rdg5 = (RadioGroup)findViewById(R.id.rdg5);
        rdg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbpatrue:
                        rdbpa = "ทำได้";
                        break;
                    case R.id.rdbpafalse:
                        rdbpa = "ทำไม่ได้";
                        break;
                }
            }
        });


        //ควบคุมปุ่ม
        btnsavedev1 = (Button)findViewById(R.id.btnsavedve1);
        btnsavedev1.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                //ทำการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(), "rdbstat is" + rdbstat + "rdbha is" + rdbha +
                        "rdbhat is" + rdbhat + "rdbvi is "+rdbvi + "rdbpa is"+rdbpa, Toast.LENGTH_SHORT).show();
                    updatetodev1();
                    }
        });




        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev1() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
      //  cal.getTime().toString();


//ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_dev1.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("standaction", rdbstat)
                .add("handaction", rdbha)
                .add("handtomouth", rdbhat)
                .add("voiced", rdbvi)
                .add("playgoods", rdbpa)
                .add("dateadd", cal.getTime().toString())
                .add("username", strusername)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(strURL).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    finish();
                    Log.i("success", "insert");
                } catch (Exception e) {
                    Log.d("appkids", "error" + e.toString());
                }


            }
        });
    }


}