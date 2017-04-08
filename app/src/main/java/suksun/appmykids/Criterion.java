package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Criterion extends AppCompatActivity {

    EditText txth,txtw,txtdate;
    Button btnsavecri;

    //รับตัวแปรที่ส่ง username
    String strusername;

    private String txthh,txtww,txtdatee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criterion);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        //การผูกตัวแปลกับ ID

        txth = (EditText)findViewById(R.id.txth);
        txtw = (EditText)findViewById(R.id.txtw);
        txtdate = (EditText)findViewById(R.id.txtdate);



        btnsavecri = (Button)findViewById(R.id.btnsavecri);
        btnsavecri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txthh = txth.getText().toString();
                txtww = txtw.getText().toString();

                txtdatee = txtdate.getText().toString();

                Toast.makeText(getApplicationContext(),"txth is" + txthh + "txtw is" + txtww +"txtdate is" + txtdatee , Toast.LENGTH_SHORT).show();
                updatetocri();
            }
        });

    }

    private void updatetocri() {

        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_criterion.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("height", txthh)
                .add("weight",txtww)
                .add("dateadd", txtdatee)
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
      });//สิ้นสุดการทำงาน

    }
}
