package com.example.postofficeapi.controller;

import com.example.postofficeapi.feign.ClientFeign;
import com.example.postofficeapi.feign.PostFeign;
import com.example.postofficeapi.model.ClientResponse;
import com.example.postofficeapi.model.PostResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/postOffice")
public class PostOfficeController {

    @Autowired
    ClientFeign clientFeign;

    @Autowired
    PostFeign postFeign;

    @GetMapping("/check")
    public String check(){
        return "post-office-api is working";
    }

    @GetMapping("/client/check")
    public String checkClient(){
        return clientFeign.checkClient();
    }

    @GetMapping("/client/all")
    public List<ClientResponse> getAllClients(){
        return clientFeign.getAllClients();
    }

    @GetMapping("/client/{clientId}")
    public ClientResponse getClientByID(@PathVariable String clientId){
        return clientFeign.getClientById(clientId);
    }

    @GetMapping("/post/check")
    public String checkPost(){
        return postFeign.checkPost();
    }

    @GetMapping("/post/all")
    public List<PostResponse> getAllPosts(){
        return postFeign.getAllPosts();
    }

    @GetMapping("/post/{postID}")
    public PostResponse getPostById(@PathVariable String postID){
        return postFeign.getPostById(postID);
    }

    @GetMapping("/getPostDetails/{postID}")
    public PostResponse getPostDetails(@PathVariable String postID){
        PostResponse postInfo = postFeign.getPostById(postID);
        //ClientResponse senderInfo = clientFeign.getClientById(postInfo.getClientID());
        //ClientResponse receiverInfo = clientFeign.getClientById(postInfo.getPostRecipientId());
        return new PostResponse(
                postID,
                clientFeign.getClientById(postInfo.getClientID()),
                clientFeign.getClientById(postInfo.getPostRecipientId()),
                postInfo.getPostItem(),
                postInfo.getStatus(),
                postInfo.getClientID(),
                postInfo.getPostRecipientId()
        );
    }


}
