package com.example.bhargav5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull; //*
import androidx.annotation.Nullable; //*
import java.util.ArrayList; //*
import java.util.List; //*
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class AlbumsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_albums, container, false);
        GridView gridView = view.findViewById(R.id.gridViewAlbums);

        List<String> albums = new ArrayList<>();
        albums.add("Dangerous Woman");
        albums.add("Inside");
        albums.add("Midnight Memories");
        albums.add("Hello");
        albums.add("Justice");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_list_item_1, albums);
        gridView.setAdapter(adapter);


        return inflater.inflate(R.layout.fragment_albums, container, false);
    }
}