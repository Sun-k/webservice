package com.example.webservice.service;

/**
 * @author Sunk
 * @create 2018-4-19-16:43
 **/

import com.example.webservice.bean.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    String getNames(@WebParam(name="userId") String[] userId);

    @WebMethod
    User getUser(@WebParam(name="userId") String userId);
}
