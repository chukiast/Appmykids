package suksun.appmykids;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Recriterion_Adapter extends BaseAdapter {

    private String[] txtstring19,txtstring20;
    private Context context;


    public Recriterion_Adapter (Context context,String[] txtstring19,String[] txtstring20){
        this.context = context;
        this.txtstring19 = txtstring19;
        this.txtstring20 = txtstring20;

    }
    @Override
    public int getCount() {
        return txtstring19.length;
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
        View view1 = layoutInflater.inflate(R.layout.colucriterion,viewGroup,false);

        TextView txtdetailmem = (TextView)view1.findViewById(R.id.txtcol19);
        txtdetailmem.setText(txtstring19[i]);

        TextView txtdatemem= (TextView)view1.findViewById(R.id.txtcol20);
        txtdatemem.setText(txtstring20[i]);

        return view1;
    }
}
