package com.example.user.youtubelibrarypageclone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LibraryFragment extends Fragment {

    private RecyclerView recyclerView;
    private LibraryFragmentRecyclerViewAdapter adapter;
    private ArrayList<String> titleList = new ArrayList<>();
    private ArrayList<String> authorList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.library_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addTitles();
        addAuthors();
        recyclerView = view.findViewById(R.id.library_recyclerView);
        adapter = new LibraryFragmentRecyclerViewAdapter(getContext(),titleList,authorList,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void addTitles(){
        for(int i = 0; i <=10;i++){
            titleList.add("Title " + Integer.toString(i));
        }
    }
    private void addAuthors(){
        for(int i = 0; i <=10;i++){
            authorList.add("Author " + Integer.toString(i));
        }
    }


}
