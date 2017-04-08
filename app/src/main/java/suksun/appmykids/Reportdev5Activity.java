package suksun.appmykids;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class Reportdev5Activity extends AppCompatActivity {

    ListView listdev5;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev5);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();


        listdev5 = (ListView)findViewById(R.id.listdev5);

        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }

    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev5.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("error doinback","doin");
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                String striter = "ครั้งที่ ";
                Log.d("suntest","response"+s);
                JSONArray jsonArray = new JSONArray(s);
                final     String[] txtstring15  = new String[jsonArray.length()];
                final    String[] txtstring16 = new String[jsonArray.length()];
                final  String[] txtstringid = new String[jsonArray.length()];


                final     String[] walkinggrip = new String[jsonArray.length()];
                final     String[] pencilgrip = new String[jsonArray.length()];
                final     String[] chooseacolor  = new String[jsonArray.length()];
                final     String[] turnstospeak = new String[jsonArray.length()];
                final     String[] playimitations = new String[jsonArray.length()];
                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                        txtstring15[a] = striter + (a);
                    txtstring16[a] = jsonObject.getString("dateadd");


                    //เพิ่มใหม่
                    txtstringid[a]= jsonObject.getString("dev5id");
                    walkinggrip[a]= jsonObject.getString("walkinggrip");
                    pencilgrip[a]= jsonObject.getString("pencilgrip");
                    chooseacolor[a]= jsonObject.getString("chooseacolor");
                    turnstospeak[a]= jsonObject.getString("turnstospeak");
                    playimitations[a]= jsonObject.getString("playimitations");
                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;

                    }//if
                }//for

                Redev5Adapter redev5Adapter = new Redev5Adapter(Reportdev5Activity.this,txtstring15,txtstring16);
                listdev5.setAdapter(redev5Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev5Activity.this,Showdev5Activity.class);
                        gotoshow.putExtra("dev5id",txtstringid[position]);
                        gotoshow.putExtra("txtstring15",txtstring15[position]);

                        gotoshow.putExtra("walkinggrip",walkinggrip[position]);
                        gotoshow.putExtra("pencilgrip",pencilgrip[position]);
                        gotoshow.putExtra("chooseacolor",chooseacolor[position]);
                        gotoshow.putExtra("turnstospeak",turnstospeak[position]);
                        gotoshow.putExtra("playimitations",playimitations[position]);
                        gotoshow.putExtra("dateadd",dateadd[position]);
                        gotoshow.putExtra("username",username[position]);

                        startActivity(gotoshow);
                    }
                });


                //เสร็จสิน้

            }catch (Exception e){
                Log.d("sun test","onpost "+e.toString());
            }
        }
    }
}





