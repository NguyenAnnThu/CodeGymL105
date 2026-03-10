package com.example.directionary.service;

import com.example.directionary.entity.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WordService implements IWordService{
    private static List<Word> dictionary = new ArrayList<>();

    static{
        dictionary.add(new Word("hello","xin chào"));
        dictionary.add(new Word("book","quyển sách"));
        dictionary.add(new Word("computer","máy tính"));
        dictionary.add(new Word("teacher","giáo viên"));
        dictionary.add(new Word("student","sinh viên"));
    }
    @Override
    public String search(String word) {
        for(Word w : dictionary){
            if(w.getEnglish().equalsIgnoreCase(word)){
                return w.getVietnamese();
            }
        }

        return "Không tìm thấy từ";
    }
}
