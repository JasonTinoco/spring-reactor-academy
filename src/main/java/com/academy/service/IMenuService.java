package com.academy.service;

import com.academy.model.Menu;
import reactor.core.publisher.Flux;

public interface IMenuService extends ICRUD<Menu, String> {
    Flux<Menu> getMenus(String[] roles);
}
