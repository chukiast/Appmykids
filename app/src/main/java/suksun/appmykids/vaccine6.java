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

public class vaccine6 extends AppCompatActivity {

    private CheckBox chkdtp5,chkopv5;
    private  Button btnsavevac6;
    private EditText txt_datevac6,txt_datevac26;

    //RadioGroup rdg57,rdg58;
    private  String chkdt,chkop,txt_datevac6y,txt_datevac26y;
    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine6);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");

        chkdtp5 = (CheckBox)findViewById(R.id.chkdtp5);
        chkopv5 = (CheckBox)findViewById(R.id.chkopv5);



        btnsavevac6 = (Button)findViewById(R.id.btnsavevac6);
        txt_datevac6 = (EditText)findViewById(R.id.txt_datevac6);
        txt_datevac26 = (EditText)findViewById(R.id.txt_datevac26);



        btnsavevac6 = (Button)findViewById(R.id.btnsavevac6);
        btnsavevac6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_datevac6y = txt_datevac6.getText().toString();
                txt_datevac26y = txt_datevac26.getText().toString();


                //ทำการบันทึกลงฐานข้อมูล 1
                if(chkdtp5.isChecked()){
                    chkdt= "ได้รับ";
                }
                if(chkopv5.isChecked()){
                    chkop= "ได้รับ";
                }
                //ทำการบันทึกลงฐานข้อมูล 1
                Toast.makeText(getApplicationContext(),"chkdtp5 is" + chkdt + "chkopv5 is" + chkop +"txt_datevac1 is" + txt_datevac6 +"txt_datevac2 is" + txt_datevac26, Toast.LENGTH_SHORT).show();
                updatetovac6();
            }
        });


    }

    private void updatetovac6() {
        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_vac4_6.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("DTP5", chkdt)
                .add("OPV5", chkop)
                .add("dateadd", txt_datevac6y)
                .add("dateadd2", txt_datevac26y)
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
