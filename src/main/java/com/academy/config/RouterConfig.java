package com.academy.config;

import com.academy.handler.CourseHandler;
import com.academy.handler.EnrollmentHandler;
import com.academy.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routesStudent(StudentHandler handler) {
        return route(GET("/v2/students"), handler::findAll)
                .andRoute(GET("/v2/students/{id}"), handler::findById)
                .andRoute(GET("/v2/students-sort"), handler::findAllSortAge)
                .andRoute(POST("/v2/students"), handler::save)
                .andRoute(PUT("/v2/students/{id}"), handler::update)
                .andRoute(DELETE("/v2/students/{id}"), handler::delete);
    }

    @Bean
    public RouterFunction<ServerResponse> routesCourse(CourseHandler handler) {
        return route(GET("/v2/courses"), handler::findAll)
                .andRoute(GET("/v2/courses/{id}"), handler::findById)
                .andRoute(POST("/v2/courses"), handler::save)
                .andRoute(PUT("/v2/courses/{id}"), handler::update)
                .andRoute(DELETE("/v2/courses/{id}"), handler::delete);
    }

    @Bean
    public RouterFunction<ServerResponse> routesEnrollment(EnrollmentHandler handler) {
        return route(GET("/v2/enrollments"), handler::findAll)
                .andRoute(GET("/v2/enrollments/{id}"), handler::findById)
                .andRoute(POST("/v2/enrollments"), handler::save)
                .andRoute(PUT("/v2/enrollments/{id}"), handler::update)
                .andRoute(DELETE("/v2/enrollments/{id}"), handler::delete);
    }
}
