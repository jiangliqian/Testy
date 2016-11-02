package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.www.butterknife.R;

/**
 * Created by Administrator on 16-11-1.
 */
public class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder>{
    LayoutInflater mLayouInflater;
    String[] recycleview=null;
    public TestRecyclerAdapter(Context context){
        mLayouInflater=LayoutInflater.from(context);
        recycleview=new String[20];
        for (int i=0;i<20;i++){
            int index = i+1;
            recycleview[i] = "item"+index;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayouInflater.inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvRecycler.setText(recycleview[position]);
    }

    @Override
    public int getItemCount() {
        return recycleview.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvRecycler;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvRecycler = (TextView) itemView.findViewById(R.id.tv_recycleView);
        }
    }
}
