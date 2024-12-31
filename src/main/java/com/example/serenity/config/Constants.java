package com.example.serenity.config;

public class Constants {
    public static final String BASE_URI = "http://localhost:7081/api";
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";
    public static final String USER_USERNAME = "user";
    public static final String USER_PASSWORD = "password";

    // API Endpoints
    public static final String GET_BOOKS_ENDPOINT = "/books";
    public static final String GET_BOOK_BY_ID_ENDPOINT = "/books/{id}";
    public static final String DELETE_BOOK_ENDPOINT = "/books/{id}";
}
