package com.example.musicapp.service;

import com.example.musicapp.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    Song save(Song song);
    void delete(int id);
}
