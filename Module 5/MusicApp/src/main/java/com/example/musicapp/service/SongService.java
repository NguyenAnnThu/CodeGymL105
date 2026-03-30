package com.example.musicapp.service;

import com.example.musicapp.dto.SongDTO;
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
    public void save(SongDTO dto) {
        Song song=new Song();
        if(dto.getId()!=0) {
            song=findById(dto.getId());
        }
        song.setTitle(dto.getTitle());
        song.setArtist(dto.getArtist());
        song.setGenre(dto.getGenre());
        songRepository.save(song);
    }

    @Override
    public void delete(int id) {
        songRepository.deleteById(id);
    }
}
