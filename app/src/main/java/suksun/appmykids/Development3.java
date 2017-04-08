package suksun.appmykids;

import android.icu.text.RuleBasedCollator;
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

public class Development3 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbstatrue,rdbstafalse,rdbdratrue,rdbdrafalse,rdbobjtrue,rdbobjfalse,
            rdbspetrue,rdbspefalse,rdbpantrue,rdbpanfalse;

    Button btnsavedev3;
    private String rdbsta,rdbdra,rdbobj,rdbspe,rdbpan;
    RadioGroup rdg25,rdg26,rdg27,rdg28,rdg29;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development3);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbstatrue = (RadioButton)findViewById(R.id.rdbstatrue);
        rdbstafalse = (RadioButton)findViewById(R.id.rdbstafalse);
        rdbdratrue = (RadioButton)findViewById(R.id.rdbdratrue);
        rdbdrafalse = (RadioButton)findViewById(R.id.rdbdrafalse);
        rdbobjtrue = (RadioButton)findViewById(R.id.rdbobjtrue);
        rdbobjfalse = (RadioButton)findViewById(R.id.rdbobjfalse);
        rdbspetrue = (RadioButton)findViewById(R.id.rdbspetrue);
        rdbspefalse = (RadioButton)findViewById(R.id.rdbspefalse);
        rdbpantrue = (RadioButton)findViewById(R.id.rdbpatrue);
        rdbpanfalse = (RadioButton)findViewById(R.id.rdbpanfalse);


        btnsavedev3 = (Button) findViewById(R.id.btnsavedve3);


        //ทำให้เลือกได้หัวข้อเดียว

        rdg25 = (RadioGroup)findViewById(R.id.rdg25);
        rdg25.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbstatrue:
                        rdbsta = "ทำได้";
                        break;
                    case R.id.rdbstafalse:
                        rdbsta = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg26 = (RadioGroup)findViewById(R.id.rdg27);
        rdg26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbobjtrue:
                        rdbobj = "ทำได้";
                        break;
                    case R.id.rdbobjfalse:
                        rdbobj = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg27 = (RadioGroup)findViewById(R.id.rdg26);
        rdg27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbdratrue:
                        rdbdra = "ทำได้";

                        break;
                    case R.id.rdbdrafalse:
                        rdbdra = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg28 = (RadioGroup)findViewById(R.id.rdg28);
        rdg28.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbspetrue:
                        rdbspe = "ทำได้";
                        break;
                    case R.id.rdbspefalse:
                        rdbspe = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg29 = (RadioGroup)findViewById(R.id.rdg29);
        rdg29.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbpantrue:
                        rdbpan = "ทำได้";
                        break;
                    case R.id.rdbpanfalse:
                        rdbpan = "ทำไม่ได้";
                        break;
                }
            }
        });

        //ควบคุมปุ่ม
        btnsavedev3 = (Button)findViewById(R.id.btnsavedve3);
        btnsavedev3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //แสดงการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"rdbsta is" + rdbsta + "rdbdra is" + rdbdra + "rdbobj is" + rdbobj
                        + "rdbspe is" + rdbspe + "rdbpan is" + rdbpan, Toast.LENGTH_SHORT).show();
                updatetodev3();
            }
        });


    }

    private void updatetodev3() {


        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();


        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev3.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("standalone", rdbsta)
                .add("drawacircle2", rdbdra)
                .add("objects2", rdbobj)
                .add("speaking", rdbspe)
                .add("pants", rdbpan)
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
