package com.academy.service.impl;

import com.academy.model.Course;
import com.academy.repo.IGenericRepo;
import com.academy.repo.ICourseRepo;
import com.academy.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, String> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, String> getRepo() {
        return repo;
    }
}
