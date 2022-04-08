package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientResponse;
import com.example.postofficeapi.model.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("post-core-api")
public interface PostFeign {


    @GetMapping("/post/check")
    String checkPost();

    @GetMapping("/post/all")
    List<PostResponse> getAllPosts();

    @GetMapping("/post/{postID}")
    PostResponse getPostById(@PathVariable String postID);


}
