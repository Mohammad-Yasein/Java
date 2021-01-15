package com.assignments.dojooverflow.services;

import com.assignments.dojooverflow.models.Tag;
import com.assignments.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTagBySubject(String subject) {
        return tagRepository.findBySubject(subject).orElse(null);
    }

    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    public boolean validateTagsString(String tags) {
        return tags.matches("[0-9a-zA-Z ]+(,[0-9a-zA-Z ]+){1,2}");
    }
}
