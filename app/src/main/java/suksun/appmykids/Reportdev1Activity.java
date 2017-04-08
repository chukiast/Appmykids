package suksun.appmykids;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
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

public class Reportdev1Activity extends AppCompatActivity {

    ListView listdev1;
    Button btnback;

    //รับตัวแปรที่ส่ง username
     String strusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportdev1);


        //  gotomain.putExtra("username",txtusername.getText().toString().trim());
        strusername = getIntent().getStringExtra("username");
        Toast.makeText(this, "name  "+strusername, Toast.LENGTH_SHORT).show();

        listdev1 = (ListView)findViewById(R.id.listdev1);

        //สร้าง    ListView
    SynJSON synJSON = new SynJSON();
        synJSON.execute();
}

    public class SynJSON extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL = "http://10.0.2.2/webmykids/php_get_reportdev1.php";
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
            final    String[] txtstring1  = new String[jsonArray.length()];
            final    String[] txtstring2 = new String[jsonArray.length()];
            final    String[] txtstringid = new String[jsonArray.length()];


              final     String[] standaction = new String[jsonArray.length()];
              final     String[] handaction = new String[jsonArray.length()];
              final     String[] handtomouth  = new String[jsonArray.length()];
              final     String[] voiced = new String[jsonArray.length()];
              final     String[] palygoods = new String[jsonArray.length()];
              final     String[] dateadd = new String[jsonArray.length()];
              final     String[] username = new String[jsonArray.length()];

              int a = 1;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    //เพื่มใหม่
                    if(jsonObject.getString("username").equals(strusername)){

                        txtstring1[a] = striter + (a);
                        txtstring2[a] = jsonObject.getString("dateadd");

                        //เพิ่มใหม่
                        txtstringid[a]= jsonObject.getString("dev1id");
                        standaction[a]= jsonObject.getString("standaction");
                        handaction[a]= jsonObject.getString("handaction");
                        handtomouth[a]= jsonObject.getString("handtomouth");
                        voiced[a]= jsonObject.getString("voiced");
                        palygoods[a]= jsonObject.getString("palygoods");

                        dateadd[a]= jsonObject.getString("dateadd");
                        username[a]= jsonObject.getString("username");
                        a++;

                    }//if
                }//for

              Redev1Adapter redev1Adapter = new Redev1Adapter(Reportdev1Activity.this,txtstring1,txtstring2);
              listdev1.setAdapter(redev1Adapter);

              //โค้ดแสดงผลอีกหน้า
              listdev1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      Intent gotoshow = new Intent(Reportdev1Activity.this,Showdev1Activity.class);
                      gotoshow.putExtra("dev1id",txtstringid[position]);
                      gotoshow.putExtra("txtstring1",txtstring1[position]);

                      gotoshow.putExtra("standaction",standaction[position]);
                      gotoshow.putExtra("handaction",handaction[position]);
                      gotoshow.putExtra("handtomouth",handtomouth[position]);
                      gotoshow.putExtra("voiced",voiced[position]);
                      gotoshow.putExtra("palygoods",palygoods[position]);

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






