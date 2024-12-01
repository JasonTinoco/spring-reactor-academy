package com.academy.service.impl;

import com.academy.model.Role;
import com.academy.repo.IGenericRepo;
import com.academy.repo.IRoleRepo;
import com.academy.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, String> implements IRoleService {

    private final IRoleRepo repo;

    @Override
    protected IGenericRepo<Role, String> getRepo() {
        return repo;
    }
}
