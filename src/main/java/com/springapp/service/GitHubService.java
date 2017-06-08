package com.springapp.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */
public interface GitHubService {
    @GET("users/{user}/repos")
    Call<List<String>> listRepos(@Path("user") String user);
}