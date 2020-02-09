package fun.codefarmer.securitybysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.codefarmer.securitybysql.mapper")
public class SecuritybysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritybysqlApplication.class, args);
    }

}
