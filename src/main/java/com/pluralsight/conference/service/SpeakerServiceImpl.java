package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Speaker;
import com.pluralsight.conference.repository.SpeakerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository speakerRepository;

    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    public Speaker create(Speaker speaker){
        return speakerRepository.create(speaker);
    }
    
    @Override
    public Speaker getSpeaker(int id){
        return speakerRepository.getSpeaker(id);
    }

    @Override
    public Speaker update(Speaker speaker){
        return speakerRepository.update(speaker);
    }

    @Override
    public void batch(){
        List<Speaker> speakers = speakerRepository.findAll();

        List<Object[]> pairs = new ArrayList<>();

        for(Speaker speaker: speakers) {
            Object[] tmp = {"Java", speaker.getId()};

            pairs.add(tmp);
        }

        speakerRepository.update(pairs);
    }

    @Override
    public void delete(int id){
        speakerRepository.delete(id);
    }

}
