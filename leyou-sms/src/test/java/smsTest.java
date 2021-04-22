
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.apache.catalina.connector.ClientAbortException;

public class smsTest {
    public SendSmsResponse sendSms(String phone,String code,String signName,String template) throws ClientAbortException {

        try{

            Credential cred = new Credential("AKIDQcYv20rEajdPu9P4eo23ISk25sQp66d2","SSDuY2HJBzXuqYCNIx1qpbQwKjibEb9S");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {phone};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setTemplateID(template);
            req.setSmsSdkAppid("1400509923");
            req.setSign(signName);
            String[] templateParams = {code};
            req.setTemplateParamSet(templateParams);

            SendSmsResponse resp = client.SendSms(req);
            return resp;

        } catch (TencentCloudSDKException e) {
            return null;
        }

    }
    public static void main(String[] args) throws ClientAbortException {
        String phone = "13354059832";
        String code = "12345";
        String signName = "张帅博客";
        String id ="926879";
        smsTest smsTest = new smsTest();
        smsTest.sendSms(phone,code,signName,id);
    }



}
