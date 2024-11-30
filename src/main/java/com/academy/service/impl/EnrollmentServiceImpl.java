package com.academy.service.impl;

import com.academy.model.Enrollment;
import com.academy.repo.IEnrollmentRepo;
import com.academy.repo.IGenericRepo;
import com.academy.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment, String> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, String> getRepo() {
        return repo;
    }

}
