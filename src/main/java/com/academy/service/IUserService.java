package com.academy.service;

import com.academy.model.User;
import reactor.core.publisher.Mono;

public interface IUserService extends ICRUD<User, String> {

    Mono<User> saveHash(User user);
    Mono<com.academy.security.User> searchByUser(String username);
}