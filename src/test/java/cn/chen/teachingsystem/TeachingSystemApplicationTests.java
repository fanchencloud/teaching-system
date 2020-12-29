package cn.chen.teachingsystem;

import cn.chen.teachingsystem.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class TeachingSystemApplicationTests {

    @Test
    void contextLoads() {

        String chen = MD5Utils.encryption("123456", "che1n");
        log.info("password = {}", chen);
    }

}
