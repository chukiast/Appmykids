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

public class Reportdev6Activity extends AppCompatActivity {

    ListView listdev6;

    //รับตัวแปรที่ส่ง username
    String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev6);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listdev6 = (ListView)findViewById(R.id.listdev6);

        //สร้าง    ListView
     SynJSON synJSON = new SynJSON();
        synJSON.execute();
    }

    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev6.php";
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
                final     String[] txtstring17  = new String[jsonArray.length()];
                final    String[] txtstring18 = new String[jsonArray.length()];
                final  String[] txtstringid = new String[jsonArray.length()];


                final     String[] write1 = new String[jsonArray.length()];
                final     String[] acting = new String[jsonArray.length()];
                final     String[] plunge  = new String[jsonArray.length()];
                final     String[] dressedup = new String[jsonArray.length()];

                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                        txtstring17[a] = striter + (a);
                    txtstring18[a] = jsonObject.getString("dateadd");


                    //เพิ่มใหม่
                    txtstringid[a]= jsonObject.getString("dev6id");
                    write1[a]= jsonObject.getString("write1");
                    acting[a]= jsonObject.getString("acting");
                    plunge[a]= jsonObject.getString("plunge");
                    dressedup[a]= jsonObject.getString("dressedup");

                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;

                    }//if
                }//for

                Redev6Adapter redev6Adapter = new Redev6Adapter(Reportdev6Activity.this,txtstring17,txtstring18);
                listdev6.setAdapter(redev6Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev6Activity.this,Showdev6Activity.class);

                        gotoshow.putExtra("dev6id",txtstringid[position]);
                        gotoshow.putExtra("txtstring17",txtstring17[position]);

                        gotoshow.putExtra("write1",write1[position]);
                        gotoshow.putExtra("acting",acting[position]);
                        gotoshow.putExtra("plunge",plunge[position]);
                        gotoshow.putExtra("dressedup",dressedup[position]);

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