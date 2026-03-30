package com.example.musicapp.service;

import com.example.musicapp.dto.SongDTO;
import com.example.musicapp.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void save(SongDTO dto);
    void delete(int id);
}
