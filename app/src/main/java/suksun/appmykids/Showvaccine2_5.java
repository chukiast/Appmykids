package suksun.appmykids;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Showvaccine2_5 extends AppCompatActivity {

    private TextView txt1,txt2;

    //ดัก username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showvaccine2_5);

        //ดัก username (ต่อ)
        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }
    public class SynJSON extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportvac2_5.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("error doinback", "doin");
                return null;
            }
        }
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);

                final String[] MMRs = new String[jsonArray.length()];
                final String[] dateadd = new String[jsonArray.length()];


                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = null;

                    jsonObject = jsonArray.getJSONObject(i);

                    //ดัก username (ต่อ)
                    if(jsonObject.getString("username").equals(strusername)){
                    MMRs[i] = jsonObject.getString("MMRs");
                    dateadd[i] = jsonObject.getString("dateadd");




                    txt1 = (TextView) findViewById(R.id.txt1);
                    txt1.setText("สถานะ : " + " " + MMRs[i]);


                    txt2 = (TextView) findViewById(R.id.txt2);
                    txt2.setText("สถานะ : " + " " + dateadd[i]);

                    }//if

                }//for
                //เสร็จสิน้

            } catch (Exception e) {
                Log.d("sun test", "onpost " + e.toString());
            }
        }
    }
}



