package com.example.musicapp.service;

import com.example.musicapp.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.musicapp.entity.Song;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        return  songRepository.findById(id).orElse(null);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(int id) {
        songRepository.deleteById(id);
    }
}
