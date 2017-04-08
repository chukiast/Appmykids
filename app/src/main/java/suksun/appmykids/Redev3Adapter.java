package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Redev3Adapter extends BaseAdapter{

    // ประกาศตัวแปร
    private  Context context;
    private String[] txtstring9,txtstring10;


    public Redev3Adapter (Context context,String[] txtstring9,String[] txtstring10) {
        this.context = context;
        this.txtstring9 = txtstring9;
        this.txtstring10 = txtstring10;

    }

    public int getCount() {
        return txtstring9.length;
    }


    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev3,viewGroup,false);
        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol9);
        txtdetailmem.setText(txtstring9[i]);
        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol10);
        txtdatemem.setText(txtstring10[i]);

        return view1;


    }


}
