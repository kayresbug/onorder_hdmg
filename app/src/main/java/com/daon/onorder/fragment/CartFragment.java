package com.daon.onorder.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bekawestberg.loopinglayout.library.LoopingLayoutManager;
import com.daon.onorder.CartAdapter;
import com.daon.onorder.MenuActivity;
import com.daon.onorder.MenuAdapter;
import com.daon.onorder.Model.MenuModel;
import com.daon.onorder.Model.OrderModel;
import com.daon.onorder.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextView tPrice;
    TextView tPrice2;
    TextView tCount;
    LinearLayout close;
    LinearLayout payment;
    RecyclerView recyclerView;
    CartAdapter adapter;

    RecyclerView.LayoutManager layoutManager;
    View RootView;
    private static ArrayList<OrderModel> arrayList;

    public CartFragment() {
        // Required empty public constructor
    }
    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            arrayList = (ArrayList<OrderModel>) getArguments().get("list");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_cart, container, false);
        initViews(arrayList);
        return RootView;
    }

    public void initViews(ArrayList<OrderModel> array){
        recyclerView = (RecyclerView)RootView.findViewById(R.id.cart_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new CartAdapter(getContext(), array, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        int price = 0;
        int count = 0;
        DecimalFormat myFormatter = new DecimalFormat("###,###");

        for (int i = 0; i < array.size(); i++){
            price = price + (Integer.parseInt(array.get(i).getPrice())*Integer.parseInt(array.get(i).getCount()));
            count = count + (Integer.parseInt(array.get(i).getCount()));
        }
        String formattedStringPrice = myFormatter.format(price);
        tPrice = RootView.findViewById(R.id.cartfragment_text_tprice);
        tPrice.setText("총 "+ formattedStringPrice+"원");

        tPrice2 = RootView.findViewById(R.id.cartfragment_text_tprice2);
        tPrice2.setText("총 "+ formattedStringPrice+"원");

        tCount = RootView.findViewById(R.id.cartfragment_text_tcount);
        tCount.setText(String.valueOf(count));

        close = RootView.findViewById(R.id.cartfragment_layout_cancle);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)getActivity()).closeCart();
            }
        });
        payment = RootView.findViewById(R.id.cartfragment_layout_payment);
        int finalPrice = price;
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)getActivity()).setPayment(String.valueOf(finalPrice), "credit");
            }
        });
    }
}