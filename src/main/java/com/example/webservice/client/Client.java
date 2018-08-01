package com.example.webservice.client;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.rmi.RemoteException;

import com.eastcom_sw.poc.service.PocService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


/**
 * @author Sunk
 * @create 2018-4-20-8:54
 **/
public class Client {

    public static void main(String args[]) throws Exception{ 
            cl1();
    }
    
    public static void cl1(){
        JaxWsDynamicClientFactory jdc = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =jdc.createClient("http://172.16.132.205:7071/test/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects=client.invoke("getName","411001");
        System.out.println("*****1111"+objects[0].toString());
        System.out.println("&&&&&&&&&&&&&"+objects[0]);
    }
    
    public static void cl2(){
    
         String endpoint = "http://localhost:7081/webservice/workOrderWebservice?wsdl";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(endpoint);
        call.setOperationName(new QName("http://service.webservice.eastcom.com/", "workOrderImpl"));
        call.addParameter("opDetail", XMLType.XSD_DATE, ParameterMode.IN);
        call.addParameter("attachRef", XMLType.XSD_DATE, ParameterMode.IN);
        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
        String t = "<opDetail>" +
                "<recordInfo>" +
                "<fieldInfo><fieldEnName>EMIS_ID</fieldEnName><fieldContent><![CDATA[[2018]测试-2018-07-31 09:53]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_NAME</fieldEnName><fieldContent><![CDATA[关于一体化皮站小区北向性能对接调整的需求]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_PERSON</fieldEnName><fieldContent><![CDATA[王亚柳]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_DEPARTMENT</fieldEnName><fieldContent><![CDATA[省公司-网络优化中心]]></fieldContent>" +
                "</fieldInfo><fieldInfo><fieldEnName>PHONE_NUM</fieldEnName><fieldContent><![CDATA[13707088163]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>ADMIN</fieldEnName><fieldContent><![CDATA[张小群]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>ATTRIBUTION</fieldEnName><fieldContent><![CDATA[无线]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>URGENCY</fieldEnName><fieldContent><![CDATA[一般]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>RANGE</fieldEnName><fieldContent><![CDATA[全省]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>FREQUENCY</fieldEnName><fieldContent><![CDATA[每周]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM1</fieldEnName><fieldContent><![CDATA[综合资源管理系统]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_TIME</fieldEnName><fieldContent><![CDATA[20180711]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM1_START</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM1_END</fieldEnName><fieldContent><![CDATA[20180711192727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM2</fieldEnName><fieldContent><![CDATA[EOMS系统]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM1_TIME</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM2_TIME</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM2_START</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM2_END</fieldEnName><fieldContent><![CDATA[20180711202727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM3</fieldEnName><fieldContent><![CDATA[集客专线服务保障平台]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM3_TIME</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM3_START</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>HOME_SYSTEM3_END</fieldEnName><fieldContent><![CDATA[20180711132727]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>EXPECTED_TIME</fieldEnName><fieldContent><![CDATA[201807111]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>SCORE</fieldEnName><fieldContent><![CDATA[10]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_CLASS</fieldEnName><fieldContent><![CDATA[分类]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DEMAND_TYPE</fieldEnName><fieldContent><![CDATA[分类]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>DOMAIN</fieldEnName><fieldContent><![CDATA[系统归属]]></fieldContent></fieldInfo>" +
                "<fieldInfo><fieldEnName>OPERATION</fieldEnName><fieldContent><![CDATA[驳回 EOMS系统]]></fieldContent></fieldInfo>" +
                "</recordInfo>" +
                "</opDetail>";
        String b = "<attachRef>" +
                "<attachInfo><attachName>不限量套餐提取数据0710-表格设计.xlsx</attachName><attachURL>/home/ftpuser/emis</attachURL><attachLength>4692039</attachLength><emisId><![CDATA[[2018]测试-2018-07-31 09:53]]></emisId></attachInfo>" +
                "<attachInfo><attachName>网管IT需求说明书模板.xlsx</attachName><attachURL>/home/ftpuser/emis</attachURL><attachLength>11402</attachLength><emisId><![CDATA[[2018]测试-2018-07-31 09:53]]></emisId></attachInfo></attachRef>";

        String result = (String) call.invoke(new Object[]{t, b});
        System.out.println("====================" + result);
    }
    
    public static void cl1() {
        try {
            // 接口地址
//            String address = "http://10.70.76.155:8080/ipnetService/ws/getAppAccManageService?wsdl";
            String address = "http://localhost:8018/ws/getAppAccManageService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(PocService.class);
            // 创建一个代理接口实现
            PocService cs = (PocService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String add = "<accounts>\n" +
                    "\t<primaryAccount>\n" +
                    "\t\t<operUser>sunkai</operUser>\n" +
                    "\t\t<appId>P-OM-101-ZJ-01</appId>\n" +
                    "\t\t<accType>01</accType>\n" +
                    "\t\t<uid>tt</uid>\n" +
                    "\t\t<name>孙恺</name>\n" +
                    "\t\t<orgCode>温州网络部-温州动力中心-温州动力维护组-温州动力基站环境分析组V3</orgCode>\n" +
                    "\t\t<userPasswordMD5>f73dc22d19b2f56b762b68f6e6fa33dae2559f0a</userPasswordMD5>\n" +
                    "\t\t<userPasswordSHA1>f73dc22d19b2f56b762b68f6e6fa33dae2559f0a</userPasswordSHA1>\n" +
                    "\t\t<userPasswordPBKDF2>f73dc22d19b2f56b762b68f6e6fa33dae2559f0a</userPasswordPBKDF2>\n" +
                    "\t\t<mobile1>13148437881</mobile1>\n" +
                    "\t\t<mobile2>135</mobile2>\n" +
                    "\t\t<email>sunkai@eastcom-sw.com</email>\n" +
                    "\t\t<area>杭州市</area>\n" +
                    "\t\t<userType>0</userType>\n" +
                    "\t\t<supervisorId>lv</supervisorId>\n" +
                    "\t\t<actualResponsible>lv</actualResponsible>\n" +
                    "\t\t<employeeNumber>01</employeeNumber>\n" +
                    "\t\t<WONumber>01</WONumber>\n" +
                    "\t</primaryAccount>\n" +
                    "</accounts>";
            
            // 调用代理接口的方法调用并返回结果
            String result = cs.addAccount(add);
            
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
