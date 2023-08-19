package com.example.instagrambenzeriodev1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class AnasayfaFragment extends Fragment {

    private RecyclerView benimrecyc;
    //Aşagı kodda bir arraylist oluşturulur.
    private ArrayList<Insta> instas;
    //Adaptör çağrılır,oluşturulur
    private MyrecycAdaptor myadaptor ;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anasayfa, container, false);
        return view ;
    }

}