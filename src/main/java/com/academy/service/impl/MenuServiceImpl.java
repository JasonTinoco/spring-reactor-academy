package com.academy.service.impl;

import com.academy.model.Menu;
import com.academy.repo.IGenericRepo;
import com.academy.repo.IMenuRepo;
import com.academy.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends CRUDImpl<Menu, String> implements IMenuService {

    private final IMenuRepo repo;

    @Override
    protected IGenericRepo<Menu, String> getRepo() {
        return repo;
    }

    @Override
    public Flux<Menu> getMenus(String[] roles) {
        return repo.getMenus(roles);
    }
}