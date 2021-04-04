package com.daon.onorder;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.daon.onorder.Model.MenuModel;
import com.daon.onorder.Model.OrderModel;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<OrderModel> mData = null ;
    private Context context;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView orderCount;
        RelativeLayout orderLayout;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView = itemView.findViewById(R.id.order_text);
            orderCount = itemView.findViewById(R.id.order_count);
            orderLayout = itemView.findViewById(R.id.order_layout);

        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    OrderAdapter(Context mcontext, ArrayList<OrderModel> list) {
        mData = list ;
        context = mcontext;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.order_layout, parent, false) ;
        OrderAdapter.ViewHolder vh = new OrderAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(OrderAdapter.ViewHolder holder, int position) {

        holder.textView.setText(mData.get(position).getName()+"  X");
        holder.orderCount.setText(mData.get(position).getCount());
        holder.orderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity menuActivity = new MenuActivity();
                Log.d("daon", "aass = "+mData.get(position).getPrice());
                Log.d("daon", "aass = "+mData.get(position).getCount());
//                if (mData.get(position).getName().contains("흑돼지")) {
//                    menuActivity.removeMenu((Integer.parseInt(mData.get(position).getPrice())));
//                }else{
                    menuActivity.removeMenu((Integer.parseInt(mData.get(position).getPrice()))*Integer.parseInt(mData.get(position).getCount()));
//                }
                mData.remove(position);
                notifyDataSetChanged();

            }
        });
    }

    public void removeData(){
        mData.clear();
        notifyDataSetChanged();
    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}