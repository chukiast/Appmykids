package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddfamilyActivity extends AppCompatActivity {

        private EditText txtfamily,txtfather;
      private   String  familystring,fatherstring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfamily);

        bindwidget();


    }   //main
      public  void clicksave(View view){
          familystring = txtfamily.getText().toString().trim();
          fatherstring = txtfather.getText().toString().trim();
          if(checkSpace()){
                MyAlert myAlert = new MyAlert();
              myAlert.mydialog(this,"มีช่องว่าง","กรุณากรอกข้อมูลให้ครบ");
          }else{

          }
      }// clicksave

    private boolean checkSpace() {
        return familystring.equals("") || fatherstring.equals("");
    }

    private void bindwidget() {
        txtfamily = (EditText)findViewById(R.id.txtfamily);
        txtfather = (EditText)findViewById(R.id.txtfather);

    }
}// main class
