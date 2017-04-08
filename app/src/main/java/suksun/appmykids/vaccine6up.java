package suksun.appmykids;

import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class vaccine6up extends AppCompatActivity {

    private CheckBox chkdtdt;
    private Button btnsavevac6up;
    private EditText txt_datevac6up;

   // private RadioGroup rdg59;
    private String chkdtd,txt_datevac6upup;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine6up);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        chkdtdt = (CheckBox)findViewById(R.id.chkdtdt);

        btnsavevac6up = (Button)findViewById(R.id.btnsavevac6up);

        txt_datevac6up = (EditText)findViewById(R.id.txt_datevac6up);




        //ควบคุมปุ่ม
        btnsavevac6up = (Button)findViewById(R.id.btnsavevac6up);
        btnsavevac6up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txt_datevac6upup = txt_datevac6up.getText().toString();

                //ทำการบันทึกลงฐานข้อมูล 1
                if(chkdtdt.isChecked()){
                    chkdtd= "ได้รับ";
                }

                Toast.makeText(getApplicationContext(),"chkdtdt is" + chkdtd +"txt_datevac6up is" + txt_datevac6up, Toast.LENGTH_SHORT).show();
                updatetovac6up();
            }
        });
    }

    private void updatetovac6up() {

        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac6.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("dT",chkdtd)
                .add("dateadd", txt_datevac6upup)
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
