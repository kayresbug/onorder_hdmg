package com.daon.onorder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.daon.onorder.Model.MenuModel;
import com.squareup.picasso.Picasso;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    public ArrayList<MenuModel> mData = null ;
    private Context context;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView price;
        TextView info;
        ImageView plus_btn;
        ImageView menu_img;
        RelativeLayout menuBody;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView1 = itemView.findViewById(R.id.text1);
            plus_btn = itemView.findViewById(R.id.menuitem_img_plus);
            menu_img = itemView.findViewById(R.id.menuitem_img_menu);
            price = itemView.findViewById(R.id.menuitem_text_price);
            menuBody = itemView.findViewById(R.id.menuitem_layout_body);
            info = itemView.findViewById(R.id.menuitem_text_info);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public MenuAdapter(Context mcontext, ArrayList<MenuModel> list) {
        mData = list ;
        context = mcontext;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.menu_layout, parent, false) ;
        MenuAdapter.ViewHolder vh = new MenuAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder holder, int position) {

        holder.textView1.setText(mData.get(position).name) ;
        if (mData.get(position).name.contains("전골")){
            holder.textView1.setTextSize(16f);
        }
//        GlideApp.with(context).load("https://t1.daumcdn.net/cfile/tistory/996F4F415AFA75B82B").into(holder.menu_img);
        String menu = "file:///android_asset/";
        menu = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Download/assets/";
        menu = menu + mData.get(position).getPicurl();
        File c = new File(menu);
        int imenu = context.getResources().getIdentifier(mData.get(position).getPicurl(), "drawable", context.getPackageName());

//        Picasso.get().load(mData.get(position).getPicurl()).into(holder.menu_img);
        Glide.with(context).load(imenu).into(holder.menu_img);
        DecimalFormat myFormatter = new DecimalFormat("###,###");
        String formattedStringPrice = myFormatter.format(Integer.parseInt(mData.get(position).getPrice()));
        holder.price.setText(formattedStringPrice+"원");
        holder.info.setText(mData.get(position).getInfo());
        holder.plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mData.get(position).getName();
                String price = mData.get(position).getPrice();
                if (name.contains("흑돼지")){
                    ((MenuActivity)context).timerReset();
                    ((MenuActivity)context).callDetail(position);
                }else {
                    if (name.contains("한라산") || name.equals("참이슬") || name.equals("진로")){
                        ((MenuActivity)context).timerReset();
                        ((MenuActivity)context).callDetail(position);
                    }else {
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat format = new SimpleDateFormat("HH", Locale.getDefault());
                        int time = Integer.parseInt(format.format(calendar.getTime()));
                        ((MenuActivity) context).timerReset();
                        ((MenuActivity) context).callItem(mData.get(position).getName(), price, mData.get(position).getPicurl(), mData.get(position).getCode(), "1");
                    }
                }

            }
        });
        holder.menuBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)context).timerReset();
                ((MenuActivity)context).callDetail(position);
            }
        });
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        Log.d("daon_test", String.valueOf(mData.size()));
        return mData.size() ;
    }

    public void updateData(ArrayList<MenuModel> viewModels) {
        mData.clear();
        mData.addAll(viewModels);
        notifyDataSetChanged();
    }

}