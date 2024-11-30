package com.academy.service.impl;

import com.academy.model.Student;
import com.academy.repo.IGenericRepo;
import com.academy.repo.IStudentRepo;
import com.academy.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, String> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, String> getRepo() {
        return repo;
    }
}
