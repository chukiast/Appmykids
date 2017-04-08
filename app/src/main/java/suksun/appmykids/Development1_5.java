package suksun.appmykids;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Calendar;

public class Development1_5 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbruntrue,rdbrunfalse,rdbholtrue,rdbholfalse,rdbopetrue,rdbopefalse,rdbwoodtrue, rdbwoodfalse,rdbchotrue,rdbchufalse,rdbthetrue,rdbthefalse,rdblmitrue,rdblmifalse,rdbsaytrue,rdbsayfalse,rdbinttrue,rdbintfalse;
    Button btnsavedve1_5;

    //ประกาศตัวแปล
    String rdbrun,rdbhol,rdbope,rdbwood,rdbcho,rdbthe,rdblmi,rdbsay,rdbint;
    RadioGroup rdg6,rdg7,rdg8,rdg9,rdg10,rdg11,rdg12,rdg13,rdg14;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development1_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");


        //การผูกตัวแปลกับ ID

        rdbruntrue = (RadioButton) findViewById(R.id.rdbruntrue);
        rdbrunfalse = (RadioButton) findViewById(R.id.rdbrunfalse);
        rdbholtrue = (RadioButton) findViewById(R.id.rdbholtrue);
        rdbholfalse = (RadioButton) findViewById(R.id.rdbholfalse);
        rdbopetrue = (RadioButton) findViewById(R.id.rdbopetrue);
        rdbopefalse = (RadioButton) findViewById(R.id.rdbopefalse);
        rdbwoodtrue = (RadioButton) findViewById(R.id.rdbwoodtrue);
        rdbwoodfalse = (RadioButton) findViewById(R.id.rdbwoodfalse);
        rdbchotrue = (RadioButton) findViewById(R.id.rdbchotrue);
        rdbchufalse = (RadioButton) findViewById(R.id.rdbchufalse);
        rdbthetrue = (RadioButton) findViewById(R.id.rdbthetrue);
        rdbthefalse = (RadioButton) findViewById(R.id.rdbthefalse);
        rdblmitrue = (RadioButton) findViewById(R.id.rdblmitrue);
        rdblmifalse = (RadioButton) findViewById(R.id.rdblmifalse);
        rdbsaytrue = (RadioButton) findViewById(R.id.rdbsaytrue);
        rdbsayfalse = (RadioButton) findViewById(R.id.rdbsayfalse);
        rdbinttrue = (RadioButton) findViewById(R.id.rdbinttrue);
        rdbintfalse = (RadioButton) findViewById(R.id.rdbintfalse);

        btnsavedve1_5 = (Button)findViewById(R.id.btnsavedve1_5);


        //ทำให้เลือกได้หัวข้อเดียว
        rdg6 = (RadioGroup)findViewById(R.id.rdg6);
        rdg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbruntrue:
                        rdbrun = "ทำได้";
                        break;
                    case R.id.rdbrunfalse:
                        rdbrun = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg7 = (RadioGroup)findViewById(R.id.rdg7);
        rdg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbholtrue:
                        rdbhol = "ทำได้";
                        break;
                    case R.id.rdbholfalse:
                        rdbhol = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg8 = (RadioGroup)findViewById(R.id.rdg8);
        rdg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbopetrue:
                        rdbope = "ทำได้";
                        break;
                    case R.id.rdbopefalse:
                        rdbope = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg9 = (RadioGroup)findViewById(R.id.rdg9);
        rdg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwoodtrue:
                        rdbwood = "ทำได้";
                        break;
                    case R.id.rdbwoodfalse:
                        rdbwood = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg10 = (RadioGroup)findViewById(R.id.rdg10);
        rdg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbchotrue:
                        rdbcho = "ทำได้";
                        break;
                    case R.id.rdbchufalse:
                        rdbcho = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg11 = (RadioGroup)findViewById(R.id.rdg11);
        rdg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbthetrue:
                        rdbthe = "ทำได้";
                        break;
                    case R.id.rdbthefalse:
                        rdbthe = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg12 = (RadioGroup)findViewById(R.id.rdg12);
        rdg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdblmitrue:
                        rdblmi = "ทำได้";
                        break;
                    case R.id.rdblmifalse:
                        rdblmi = "ทำไม่ได้";
                        break;
                }

            }
        });

        rdg13 = (RadioGroup)findViewById(R.id.rdg13);
        rdg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbsaytrue:
                        rdbsay = "ทำได้";
                        break;
                    case R.id.rdbsayfalse:
                        rdbsay = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg14 = (RadioGroup)findViewById(R.id.rdg14);
        rdg14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbinttrue:
                        rdbint = "ทำได้";
                        break;
                    case R.id.rdbintfalse:
                        rdbint = "ทำไม่ได้";
                        break;
                }
            }
        });

        btnsavedve1_5 = (Button)findViewById(R.id.btnsavedve1_5);
        btnsavedve1_5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {


                //แสดงข้อมูลที่บันทึก
                Toast.makeText(getApplicationContext(),"rdbrun is"+ rdbrun +"rdbhol is" + rdbhol + "rdbope is"+ rdbope +
                "wood is" + rdbwood + "rdbcho is" + rdbcho + "rdbthe is" + rdbthe +"rdblim is" + rdblmi +"rdbsay is" + rdbsay + "rdbint is" + rdbint,Toast.LENGTH_SHORT).show();
                updatetodev1_5();

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev1_5() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev1_5.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("run", rdbrun)
                .add("holdingtheball", rdbhol)
                .add("openbook", rdbope)
                .add("wood", rdbwood)
                .add("choosetheorder", rdbcho)
                .add("lmitatewords", rdblmi)
                .add("sayaword", rdbsay)
                .add("interested", rdbint)
                .add("theorgan", rdbthe)
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

