package com.daon.onorder.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bekawestberg.loopinglayout.library.LoopingLayoutManager;
import com.daon.onorder.InterfaceApi;
import com.daon.onorder.MenuActivity;
import com.daon.onorder.MenuAdapter;
import com.daon.onorder.Model.MenuModel;
import com.daon.onorder.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class menu1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static ArrayList<MenuModel> arrayList;
    private static int position;

    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    LinearLayout body;
    MenuAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<MenuModel> menuModelArrayList;
    public menu1Fragment() {
    }
    View RootView;

    public static menu1Fragment newInstance(String param1, String param2) {
        menu1Fragment fragment = new menu1Fragment();
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
            arrayList = (ArrayList<MenuModel>) getArguments().get("list");
            position = getArguments().getInt("position");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.fragment_menu1, container, false);

        initViews(arrayList);

        return RootView;
    }
    private void initViews(ArrayList<MenuModel> array){
        layoutManager = new LinearLayoutManager(getContext());
        body = RootView.findViewById(R.id.menuactivity_layout_menu);
        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)getActivity()).timerReset();

            }
        });
        recyclerView = (RecyclerView)RootView.findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        ((LinearLayoutManager)layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);

        adapter = new MenuAdapter(getContext(), array);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.scrollToPosition(position);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity)getActivity()).timerReset();

            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisible = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                ((MenuActivity)getActivity()).timerReset();
                ((MenuActivity)getActivity()).setPosition(lastVisible);
            }
        });

    }

    public void setList(ArrayList<MenuModel> i) {
        adapter = null;
        MenuAdapter adapter = new MenuAdapter(getContext(), i);

    }
}