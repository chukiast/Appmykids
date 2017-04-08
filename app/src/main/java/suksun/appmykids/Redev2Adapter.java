package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev2Adapter extends  BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring5,txtstring6;

    public Redev2Adapter (Context context,String[] txtstring5,String[] txtstring6) {
        this.context = context;
        this.txtstring5 = txtstring5;
        this.txtstring6 = txtstring6;

    }


        public int getCount() {
            return txtstring5.length;
        }


        public Object getItem(int position) {
            return null;
        }


        public long getItemId(int position) {
            return 0;
        }


        public View getView(int i, View view, ViewGroup viewGroup){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view1 = layoutInflater.inflate(R.layout.columnreportdev2,viewGroup,false);
            TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol5);
            txtdetailmem.setText(txtstring5[i]);
            TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol6);
            txtdatemem.setText(txtstring6[i]);

            return view1;
        }
    }





