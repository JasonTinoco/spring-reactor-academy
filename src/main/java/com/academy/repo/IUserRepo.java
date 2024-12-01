package com.academy.repo;

import com.academy.model.User;
import reactor.core.publisher.Mono;

public interface IUserRepo extends IGenericRepo<User, String> {

    Mono<User> findOneByUsername(String username);
}