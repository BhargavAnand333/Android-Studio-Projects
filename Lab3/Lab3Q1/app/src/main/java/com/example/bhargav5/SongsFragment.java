package com.example.bhargav5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class SongsFragment extends Fragment {



    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        GridView gridView = view.findViewById(R.id.gridViewSongs);

        List<String> songs = new ArrayList<>();
        songs.add("Dangerous Woman");
        songs.add("Inside");
        songs.add("Midnight Memories");
        songs.add("Hello");
        songs.add("Justice");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, songs);
        gridView.setAdapter(adapter);



        return inflater.inflate(R.layout.fragment_songs, container, false);
    }
}