package com.example.postofficeapi.model;


import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    @NotNull(message = "postId can not be empty")
    private String postID;
    @NotNull(message = "Client can not be empty")
    private ClientResponse client;
    @NotNull(message = "Receiver can not be empty")
    private ClientResponse receiver;
    @NotNull(message = "postItem can not be empty")
    private String postItem;
    @NotNull(message = "Status can not be empty")
    private String status;

    private String clientID;
    private String postRecipientId;
}
