package suksun.appmykids;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class SigninActivity extends AppCompatActivity {

    EditText txtusername, txtpassword;
    Button btnregister ;
    private MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);

        btnregister = (Button)findViewById(R.id.btnregister);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotorit = new Intent(SigninActivity.this,RegisterActivity.class);
                startActivity(gotorit);
            }
        });




 mySQLite = new MySQLite(this);
        synAndDelete();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkuser();
            }
        });

    }// oncreale

    private void checkuser() {
        //เช็คค่าว่าง
        if(txtusername.getText().toString().equals("") ||
                txtpassword.getText().toString().equals("")){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("กรุณาระบุข้อมูล");
            adb.setMessage("ชื่อผู้ใช้และรหัสผ่าน");
            adb.show();

            //ถึงตรงนี้

        }else{
            try{
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,MODE_PRIVATE,null);
                Cursor cursor = sqLiteDatabase.rawQuery("SELECT  username,password from  tbusers " +
                        "WHERE username = '" +txtusername.getText().toString().trim()+"' " +
                        " and password = '"+txtpassword.getText().toString().trim()+"'",null);

                cursor.moveToFirst();
                if (cursor.getCount() > 0){
                    Toast.makeText(getApplicationContext(),"wellcome",Toast.LENGTH_SHORT).show();
                    Intent gotomain = new Intent(SigninActivity.this,MainActivity.class);

                    //เพิ่มใหม่
                    gotomain.putExtra("username",txtusername.getText().toString().trim());
                    startActivity(gotomain);

                }else{
                    AlertDialog.Builder adb = new AlertDialog.Builder(this);
                    adb.setTitle("กรุณาระบุข้อมูล");
                    adb.setMessage("ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง");
                    adb.show();
                }


            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void synAndDelete() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,MODE_PRIVATE,null);
        sqLiteDatabase.delete(mySQLite.tbusers,null,null);
        MySynJSON mySynJSON = new MySynJSON();
        mySynJSON.execute();
    } // sysand delete

    //Create Inner Class
    public class MySynJSON extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://10.0.2.2/webmykids/php_get_users.php").build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }//doInBack

        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("testsun", "strjson -->" + s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strUsername = jsonObject.getString(mySQLite.column_username);
                    String strPassword = jsonObject.getString(mySQLite.column_password);
                    mySQLite.addNewUser(strUsername, strPassword);
                }
                Toast.makeText(SigninActivity.this, "Sys tbusers success", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Log.d("sunss", "onpost -->" + e.toString());
            }
        } // onPostExecute


    }
}// class signinactivity
