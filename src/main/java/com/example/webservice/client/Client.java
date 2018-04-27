package com.example.webservice.client;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.jaxws.support.JaxWsClientEndpointImpl;

/**
 * @author Sunk
 * @create 2018-4-20-8:54
 **/
public class Client {

    public static void main(String args[]) throws Exception{

        JaxWsDynamicClientFactory jdc = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =jdc.createClient("http://172.16.132.205:7071/test/user?wsdl");
        Object[] objects=client.invoke("getName","411001");
        System.out.println("*****1111"+objects[0].toString());
        System.out.println("&&&&&&&&&&&&&"+objects[0]);

    }
}
