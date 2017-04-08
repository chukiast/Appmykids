package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev2_5Adapter extends BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring7,txtstring8;

    public Redev2_5Adapter (Context context,String[] txtstring7,String[] txtstring8){
        this.context = context;
        this.txtstring7 = txtstring7;
        this.txtstring8 = txtstring8;

    }

    public int getCount() {
        return txtstring7.length;
    }


    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev2_5,viewGroup,false);
        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol7);
        txtdetailmem.setText(txtstring7[i]);
        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol8);
        txtdatemem.setText(txtstring8[i]);

        return view1;
    }
}

