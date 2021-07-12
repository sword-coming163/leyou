package com.leyou.sms.utils;

import com.leyou.sms.pojo.SmsProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.*;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;;
@Component
@EnableConfigurationProperties(SmsProperties.class)
public class SmsUtils {

//    @Autowired
    private  SmsProperties properties;


    public SendSmsResponse sendSms(String phone, String code, String signName, String template) throws ClientAbortException {

        try{
            System.out.println("短信执行了1");
            Credential cred = new Credential("AKIDQcYv20rEajdPu9P4eo23ISk25sQp66d2", "SSDuY2HJBzXuqYCNIx1qpbQwKjibEb9S");
//            Credential cred = new Credential(properties.getAccessKeyId(),properties.getAccessKeySecret());
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String phone0 = "+86"+phone;
            String[] phoneNumberSet1 = {phone0};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID(template);
            req.setSmsSdkAppid("1400509923");
            req.setSign(signName);
            String[] templateParams = {code,"5"};
            req.setTemplateParamSet(templateParams);

            SendSmsResponse resp = client.SendSms(req);
            System.out.println("发送了");
            return resp;

        } catch (TencentCloudSDKException e) {
            return null;
        }

    }

}
