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

public class Reportdev3Activity extends AppCompatActivity {


    private ListView listdev3;

    //รับตัวแปรที่ส่ง username
    String strusername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev3);

        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listdev3 = (ListView) findViewById(R.id.listdev3);


        //สร้าง    ListView
        SynJSON synJSON = new SynJSON();
        synJSON.execute();

    }

    public class SynJSON extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev3";
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

                final     String[] txtstring9  = new String[jsonArray.length()];
                final     String[] txtstring10 = new String[jsonArray.length()];
                final     String[] txtstringid = new String[jsonArray.length()];


                final     String[] standalone = new String[jsonArray.length()];
                final     String[] drawacircle2 = new String[jsonArray.length()];
                final     String[] objects2  = new String[jsonArray.length()];
                final     String[] speaking = new String[jsonArray.length()];
                final     String[] pants = new String[jsonArray.length()];
                final     String[] dateadd = new String[jsonArray.length()];
                final     String[] username = new String[jsonArray.length()];

                int a = 1;

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){
                    txtstring9[a] = striter + (a);
                    txtstring10[a] = jsonObject.getString("dateadd");


                    //เพิ่มใหม่
                    txtstringid[a]= jsonObject.getString("dev3id");
                    standalone[a]= jsonObject.getString("standalone");
                    drawacircle2[a]= jsonObject.getString("drawacircle2");
                    objects2[a]= jsonObject.getString("objects2");
                    speaking[a]= jsonObject.getString("speaking");
                    pants[a]= jsonObject.getString("pants");
                    dateadd[a]= jsonObject.getString("dateadd");
                    username[a]= jsonObject.getString("username");
                        a++;
                    }//if
                }//for

                Redev3Adapter redev3Adapter = new Redev3Adapter(Reportdev3Activity.this,txtstring9,txtstring10);
                listdev3.setAdapter(redev3Adapter);

                //โค้ดแสดงผลอีกหน้า
                listdev3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent gotoshow = new Intent(Reportdev3Activity.this,Showdev3Activity.class);
                        gotoshow.putExtra("dev3id",txtstringid[position]);
                        gotoshow.putExtra("txtstring9",txtstring9[position]);

                        gotoshow.putExtra("standalone",standalone[position]);
                        gotoshow.putExtra("drawacircle2",drawacircle2[position]);
                        gotoshow.putExtra("objects2",objects2[position]);
                        gotoshow.putExtra("speaking",speaking[position]);
                        gotoshow.putExtra("pants",pants[position]);
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

