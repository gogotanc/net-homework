package cn.gogotanc.work.service;

import cn.gogotanc.work.utils.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml", "classpath:spring-dao.xml"})
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() throws Exception {
        int result = userService.login("seller", "asdfasdfasdfasf");
        assertEquals(Constant.RESULT_CODE_ERROR, result);
    }

}