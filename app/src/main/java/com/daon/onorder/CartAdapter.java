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

import com.daon.onorder.Model.OrderModel;
import com.daon.onorder.fragment.CartFragment;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<OrderModel> mData = null ;
    private Context context;
    CartFragment cartFragment;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cartName;
        TextView cartCount;
        TextView cartPirce;
        TextView cartTprice;
        RelativeLayout cartLayout;
        ImageView cartImg;
        ImageView cartMinus;
        ImageView cartPlus;
        ImageView cartDel;


        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            cartName = itemView.findViewById(R.id.cartitem_text_name);
            cartImg = itemView.findViewById(R.id.cartitem_img);
            cartPirce = itemView.findViewById(R.id.cartitem_text_price);
            cartCount = itemView.findViewById(R.id.cartitem_text_count);
            cartTprice = itemView.findViewById(R.id.cartitem_text_tprice);
            cartMinus = itemView.findViewById(R.id.cartitem_img_minus);
            cartPlus = itemView.findViewById(R.id.cartitem_img_plus);
            cartDel = itemView.findViewById(R.id.cartitem_img_del);
//            cartCount = itemView.findViewById(R.id.order_count);
//            cartLayout = itemView.findViewById(R.id.order_layout);

        }
    }
    public CartAdapter(Context mcontext, ArrayList<OrderModel> list, CartFragment fragment) {
        mData = list ;
        context = mcontext;
        cartFragment = fragment;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.cart_item, parent, false) ;
        CartAdapter.ViewHolder vh = new CartAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.


    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder holder, int position) {

        GlideApp.with(context).load(mData.get(position).getUrl()).circleCrop().into(holder.cartImg);
        holder.cartName.setText(mData.get(position).getName());
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String formattedStringPrice = myFormatter.format(Integer.parseInt(mData.get(position).getPrice()));
        holder.cartPirce.setText(formattedStringPrice+"원");
        holder.cartCount.setText(mData.get(position).getCount());
        String formattedStringtPrice = myFormatter.format(Integer.parseInt(mData.get(position).getPrice())*Integer.parseInt(mData.get(position).getCount()));
        holder.cartTprice.setText("총 "+formattedStringtPrice+"원");

        holder.cartMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mData.get(position).getCount() != "0") {
                    mData.get(position).setCount(String.valueOf(Integer.parseInt(mData.get(position).getCount()) - 1));
                    notifyDataSetChanged();
                    cartFragment.initViews(mData);
                    ((MenuActivity)context).callCart(mData);
                }
            }
        });
        holder.cartPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mData.get(position).setCount(String.valueOf(Integer.parseInt(mData.get(position).getCount()) + 1));
                    notifyDataSetChanged();
                cartFragment.initViews(mData);
                ((MenuActivity)context).callCart(mData);
            }
        });
        holder.cartDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(position);
                notifyDataSetChanged();
                cartFragment.initViews(mData);
                ((MenuActivity)context).callCart(mData);
            }
        });

    }

    public void removeData(){
        mData.clear();
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}