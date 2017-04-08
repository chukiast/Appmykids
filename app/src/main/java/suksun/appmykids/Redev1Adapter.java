package suksun.appmykids;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class Redev1Adapter extends BaseAdapter {

    // ประกาศตัวแปร
    private Context context;
    private String[] txtstring1,txtstring2;


    public Redev1Adapter (Context context,String[] txtstring1,String[] txtstring2){
       this.context = context;
        this.txtstring1 = txtstring1;
        this.txtstring2 = txtstring2;

    }

    @Override
    public int getCount() {
        return txtstring1.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.columnreportdev1,viewGroup,false);

        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol1);
        txtdetailmem.setText(txtstring1[i]);

        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol2);
        txtdatemem.setText(txtstring2[i]);

        return view1;
    }
}
