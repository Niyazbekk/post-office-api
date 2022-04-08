package com.example.postofficeapi.feign;

import com.example.postofficeapi.model.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


//Выходит ошибка если добавить RequestMapping

@FeignClient("client-core-api")
public interface ClientFeign {


    @GetMapping("/client/check")
    String checkClient();

    @GetMapping("/client/all")
    List<ClientResponse> getAllClients();

    @GetMapping("/client/{clientId}")
    ClientResponse getClientById(@PathVariable String clientId);


}

