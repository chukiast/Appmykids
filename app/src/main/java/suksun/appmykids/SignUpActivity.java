package suksun.appmykids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
       private EditText txtname,txtphone;
       private String strname,strphone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindwidget();

    } //oncreate

    private void bindwidget() {
           txtname = (EditText)findViewById(R.id.edittext1);
           txtphone = (EditText)findViewById(R.id.edittextphone);
        Button btnadd = (Button)findViewById(R.id.btnadd);
    }

   public void clickSignUpSign(View view){
       strname = txtname.getText().toString().trim();
       strphone = txtphone.getText().toString().trim();


    }


}  //end class
