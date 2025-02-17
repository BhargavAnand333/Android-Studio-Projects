package com.example.bhargav5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List; //*
import androidx.annotation.NonNull; //*
import androidx.annotation.Nullable; //*
import android.widget.ArrayAdapter;


public class ArtistsFragment extends Fragment {

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        ListView listView = view.findViewById(R.id.listViewArtists);

        List<String> artists = new ArrayList<>();
        artists.add("Taylor Swift");
        artists.add("One Direction");
        artists.add("Kendrick Lamar");
        artists.add("Ariana Grande");
        artists.add("Justin Bieber");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, artists);
        listView.setAdapter(adapter);

        return view;
    }
}