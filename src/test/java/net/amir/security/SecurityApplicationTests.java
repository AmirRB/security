package net.amir.security;

import net.amir.security.scurity.ApplicationUserPermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() {

        System.out.println(ApplicationUserPermission.COURSE_READ);
        System.out.println(ApplicationUserPermission.COURSE_READ.getPermission());
        System.out.println(ApplicationUserPermission.COURSE_READ.name());
        System.out.println(ApplicationUserPermission.COURSE_READ.ordinal());
    }

}
