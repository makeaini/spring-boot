import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pppcar.spring.boot.Application;
import com.pppcar.spring.boot.service.AuthorServiceI;

//// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
//// 指定我们SpringBoot工程的Application启动类
@SpringBootTest(classes = Application.class)
///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class HelloServiceTest {
   
    @Autowired
    private AuthorServiceI authorServiceI;
   
    @Test
    public void testGetName(){
    }
}