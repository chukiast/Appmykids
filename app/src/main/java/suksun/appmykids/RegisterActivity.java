package suksun.appmykids;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    Button btnaddrtr, btuout;
    EditText txtaddusername, txtaddpassword, txtpname, txtcname;

    private String txtaddusernamee, txtaddpasswordd, txtpnamee, txtcnamee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        btuout = (Button)findViewById(R.id.btuout);
        btuout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoout = new Intent(RegisterActivity.this,SigninActivity.class);
                startActivity(gotoout);
            }
        });

        //การผูกตัวแปลกับ ID

        txtaddusername = (EditText) findViewById(R.id.txtaddusername);
        txtaddpassword = (EditText) findViewById(R.id.txtaddpassword);
        txtpname = (EditText) findViewById(R.id.txtpname);
        txtcname = (EditText) findViewById(R.id.txtcname);


        btnaddrtr = (Button)findViewById(R.id.btnaddrtr);
        btnaddrtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                txtaddusernamee = txtaddusername.getText().toString();
                txtaddpasswordd = txtaddpassword.getText().toString();
                txtpnamee = txtpname.getText().toString();
                txtcnamee = txtcname.getText().toString();

                Toast.makeText(getApplicationContext(),"txtaddusername is" + txtaddusernamee + "txtaddpassword is" + txtaddpasswordd +"txtpname is" + txtpnamee +
                        "txtcname is" + txtcnamee , Toast.LENGTH_SHORT).show();
                updatetocri();
            }
        });
    }

    public  void clicksave(View view){
        txtaddusernamee = txtaddusername.getText().toString().trim();
        txtaddpasswordd = txtaddpassword.getText().toString().trim();
        txtpnamee = txtpname.getText().toString().trim();
        txtcnamee = txtcname.getText().toString().trim();
        if(checkSpace()){
            MyAlert myAlert = new MyAlert();
            myAlert.mydialog(this,"มีช่องว่าง","กรุณากรอกข้อมูลให้ครบ");
        }else{

        }
    }// clicksave

    private boolean checkSpace() {

        return txtaddusernamee.equals("") || txtaddpasswordd.equals("")
                || txtpnamee.equals("")|| txtcnamee.equals("");
    }



    private void updatetocri() {

        //ทำการบันทึกลงฐานข้อมูล 2
        String strURL = "http://10.0.2.2/webmykids/php_add_rigister.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("username", txtaddusernamee)
                .add("password",txtaddpasswordd)
                .add("pname", txtpnamee)
                .add("cname", txtcnamee)
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
