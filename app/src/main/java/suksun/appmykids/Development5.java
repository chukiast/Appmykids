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

public class Development5 extends AppCompatActivity {


    //ประกาศตัวแปล ID
    RadioButton rdbwaltrue,rdbwalfalse,rdbpentrue,rdbpenfalse,rdbchotrue,rdbchofalse,
            rdbturtrue,rdbturfalse,rdbplatrue,rdbplafalse ;

    Button btnsavedve5;
    String rdbwal,rdbpen,rdbcho,rdbtur,rdbpla;
    RadioGroup rdg42,rdg43,rdg44,rdg45,rdg46 ;

    //รับตัวแปรที่ส่ง username
    String strusername;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbwaltrue = (RadioButton) findViewById(R.id.rdbwaltrue);
        rdbwalfalse = (RadioButton) findViewById(R.id.rdbwalfalse);
        rdbpentrue = (RadioButton) findViewById(R.id.rdbpentrue);
        rdbpenfalse = (RadioButton) findViewById(R.id.rdbpenfalse);
        rdbchotrue = (RadioButton) findViewById(R.id.rdbchotrue);
        rdbchofalse = (RadioButton) findViewById(R.id.rdbchofalse);
        rdbturtrue = (RadioButton) findViewById(R.id.rdbturtrue);
        rdbturfalse = (RadioButton)findViewById(R.id.rdbturfalse);
        rdbplatrue = (RadioButton)findViewById(R.id.rdbplatrue);
        rdbplafalse = (RadioButton) findViewById(R.id.rdbplafalse);

        btnsavedve5 = (Button)findViewById(R.id.btnsavedve5);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg42 = (RadioGroup)findViewById(R.id.rdg42);
        rdg42.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwaltrue:
                        rdbwal = "ทำได้";
                        break;
                    case R.id.rdbwalfalse:
                        rdbwal = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg43 = (RadioGroup)findViewById(R.id.rdg43);
        rdg43.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbpentrue:
                        rdbpen = "ทำได้";
                        break;
                    case R.id.rdbpenfalse:
                        rdbpen = "ทำไม่ได้";
                        break;
                }

            }
        });



        rdg44 = (RadioGroup)findViewById(R.id.rdg44);
        rdg44.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbchotrue:
                        rdbcho = "ทำได้";
                        break;
                    case R.id.rdbchofalse:
                        rdbcho = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg45 = (RadioGroup)findViewById(R.id.rdg45);
        rdg45.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbturtrue:
                        rdbtur = "ทำได้";
                        break;
                    case R.id.rdbturfalse:
                        rdbtur = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg46 = (RadioGroup)findViewById(R.id.rdg46);
        rdg46.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbplatrue:
                        rdbpla = "ทำได้";
                        break;
                    case R.id.rdbplafalse:
                        rdbpla = "ทำไม่ได้";
                        break;
                }
            }
        });

        //ควบคุมปุ่ม
        btnsavedve5 = (Button)findViewById(R.id.btnsavedve5);
        btnsavedve5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                //แสดงการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"rdbwal is" + rdbwal + "rdbpen is" + rdbpen + "rdbcho is" + rdbcho
                        + "rdbtur is" + rdbtur + "rdbpla is" + rdbpla, Toast.LENGTH_SHORT).show();
                updatetodev5();

            }
        });




    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev5() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev5.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("walkinggrip", rdbwal)
                .add("pencilgrip", rdbpen)
                .add("chooseacolor", rdbcho)
                .add("turnstospeak", rdbtur)
                .add("playimitations", rdbpla)
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
