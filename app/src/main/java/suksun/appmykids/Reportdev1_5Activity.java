package suksun.appmykids;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Reportdev1_5Activity extends AppCompatActivity {

    ListView listdev1_5;
    Button btnback;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev1_5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listdev1_5 = (ListView)findViewById(R.id.listdev1_5);

        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }
    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev1_5.php";
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

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                String striter = "ครั้งที่ ";
                Log.d("suntest", "response" + s);
                JSONArray jsonArray = new JSONArray(s);

                final String[] txtstring3 = new String[jsonArray.length()];
                final String[] txtstring4 = new String[jsonArray.length()];

                final  String[] txtstringid = new String[jsonArray.length()];

                final     String[] run = new String[jsonArray.length()];
                final     String[] holdingtheball = new String[jsonArray.length()];
                final     String[] openbook  = new String[jsonArray.length()];
                final     String[] wood = new String[jsonArray.length()];
                final     String[] choosetheorder = new String[jsonArray.length()];
                final     String[] theorgan = new String[jsonArray.length()];
                final     String[] lmitatewords = new String[jsonArray.length()];
                final     String[] sayaword = new String[jsonArray.length()];
                final     String[] interested = new String[jsonArray.length()];
                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                        txtstring3 [a] = striter + (a);
                    txtstring4 [a] = jsonObject.getString("dateadd");

                    //เพิ่มใหม่

                    txtstringid[a]= jsonObject.getString("dev15id");
                    run[a]= jsonObject.getString("run");
                    holdingtheball[a]= jsonObject.getString("holdingtheball");
                    openbook[a]= jsonObject.getString("openbook");
                    wood[a]= jsonObject.getString("wood");
                    choosetheorder[a]= jsonObject.getString("choosetheorder");
                    theorgan[a]= jsonObject.getString("theorgan");
                    lmitatewords[a]= jsonObject.getString("lmitatewords");
                    sayaword[a]= jsonObject.getString("sayaword");
                    interested[a]= jsonObject.getString("interested");
                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;


                    }//if
                }//for

                Redev1_5Adapter redev1_5Adapter = new Redev1_5Adapter(Reportdev1_5Activity.this, txtstring3, txtstring4);
                listdev1_5.setAdapter(redev1_5Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev1_5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev1_5Activity.this,Showdev1_5Activity.class);

                        gotoshow.putExtra("dev15id",txtstringid[position]);
                        gotoshow.putExtra("txtstring3",txtstring3[position]);

                        gotoshow.putExtra("run",run[position]);
                        gotoshow.putExtra("holdingtheball",holdingtheball[position]);
                        gotoshow.putExtra("openbook",openbook[position]);
                        gotoshow.putExtra("wood",wood[position]);
                        gotoshow.putExtra("choosetheorder",choosetheorder[position]);
                        gotoshow.putExtra("theorgan",theorgan[position]);
                        gotoshow.putExtra("lmitatewords",lmitatewords[position]);
                        gotoshow.putExtra("sayaword",sayaword[position]);
                        gotoshow.putExtra("interested",interested[position]);
                        gotoshow.putExtra("dateadd",dateadd[position]);
                        gotoshow.putExtra("username",username[position]);

                        startActivity(gotoshow);
                    }
                });



                //เสร็จสิน้
            } catch (JSONException e) {
                Log.d("sun test", "onpost " + e.toString());
            }
        }
    }
}
