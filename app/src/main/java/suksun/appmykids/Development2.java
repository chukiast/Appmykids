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

public class Development2 extends AppCompatActivity {

    //ประกาศตัวแปล ID
    RadioButton rdbwortrue,rdbworfalse,rdbthestrue,
            rdbthesfalse,rdbwootrue,rdbwoofalse,rdbseltrue,
            rdbselfalse,rdbusetrue,rdbusefalse;
    Button btnsavedev2;

    //ประกาศตัวแปล
    String rdbwor, rdbthes,rdbwoo,rdbsel,rdbuse;
    RadioGroup rdg15,rdg16,rdg17,rdg18,rdg19;

    //รับตัวแปรที่ส่ง username
    String strusername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development2);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID
        rdbwortrue = (RadioButton)findViewById(R.id.rdbwortrue);
        rdbworfalse = (RadioButton)findViewById(R.id.rdbworfalse);
        rdbthestrue = (RadioButton)findViewById(R.id.rdbthestrue);
        rdbthesfalse = (RadioButton)findViewById(R.id.rdbthesfalse);
        rdbwootrue = (RadioButton)findViewById(R.id.rdbwootrue);
        rdbwoofalse = (RadioButton)findViewById(R.id.rdbwoofalse);
        rdbseltrue = (RadioButton)findViewById(R.id.rdbseltrue);
        rdbselfalse = (RadioButton)findViewById(R.id.rdbselfalse);
        rdbusetrue = (RadioButton)findViewById(R.id.rdbusetrue);
        rdbusefalse = (RadioButton)findViewById(R.id.rdbusefalse);


        btnsavedev2 = (Button) findViewById(R.id.btnsavedve2);

        //ทำให้เลือกได้หัวข้อเดียว
        rdg15 = (RadioGroup)findViewById(R.id.rdg15);
        rdg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwortrue:
                        rdbwor = "ทำได้";
                        break;
                    case R.id.rdbwoofalse:
                        rdbwoo = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg16 = (RadioGroup)findViewById(R.id.rdg16);
        rdg16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbthestrue:
                        rdbthes = "ทำได้";
                        break;
                    case R.id.rdbthesfalse:
                        rdbthes = "ทำไม่ได้";
                        break;
                }
            }
        });


        rdg17 = (RadioGroup)findViewById(R.id.rdg17);
        rdg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbwootrue:
                        rdbwoo = "ทำได้";
                        break;
                    case R.id.rdbwoofalse:
                        rdbwoo = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg18 = (RadioGroup)findViewById(R.id.rdg18);
        rdg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbseltrue:
                        rdbsel = "ทำได้";
                        break;
                    case R.id.rdbselfalse:
                        rdbsel = "ทำไม่ได้";
                        break;
                }
            }
        });

        rdg19 = (RadioGroup)findViewById(R.id.rdg19);
        rdg19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rdbusetrue:
                        rdbuse = "ทำได้";
                        break;
                    case R.id.rdbusefalse:
                        rdbuse = "ทำไม่ได้";
                        break;
                }
            }
        });


        //ควบคุมปุ่ม
        btnsavedev2 = (Button)findViewById(R.id.btnsavedve2);
        btnsavedev2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                //แสดงการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"rdbwor is" + rdbwor + "rdbthes is" + rdbthes + "rdbwoo is" + rdbwoo
                        + "rdbsel is" + rdbsel + "rdbuse is" + rdbuse, Toast.LENGTH_SHORT).show();
                updatetodev2();


            }
        });
     }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatetodev2() {

        //เพิ่มวันที่
        Calendar cal = Calendar.getInstance();
        //  cal.getTime().toString();

        //ทำการบันทึกลงฐานข้อมูล
        String strURL = "http://10.0.2.2/webmykids/php_add_dev2.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("wordsphrasas", rdbwoo)
                .add("thesedisc", rdbthes)
                .add("wood4", rdbwoo)
                .add("select4", rdbsel)
                .add("useaspoon", rdbuse)
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
