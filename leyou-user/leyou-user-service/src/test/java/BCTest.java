import com.leyou.utils.CodecUtils;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: 98050
 * @Time: 2018-11-06 15:13
 * @Feature: BCryptPasswordEncoder测试
 */
public class BCTest {

    @Test
    public void BcTest(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String username = "zhangsan";
        String password = "zhangsan";
        System.out.println(CodecUtils.passwordBcryptEncode(username,password));
        System.out.println(CodecUtils.passwordBcryptEncode(username,password));
        System.out.println(CodecUtils.passwordConfirm(username+password,"$2a$10$WEC9tuYGYgb8e4NUGJDF3eYuk4yJD.2rHqdldl.22u/mtcRyvW9U."));
//        System.out.println(CodecUtils.);
    }
}
