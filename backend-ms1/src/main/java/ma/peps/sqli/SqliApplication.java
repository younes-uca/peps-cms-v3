package ma.peps.sqli;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import ma.peps.sqli.zynerator.security.common.AuthoritiesConstants;
import ma.peps.sqli.zynerator.security.bean.User;
import ma.peps.sqli.zynerator.security.bean.Permission;
import ma.peps.sqli.zynerator.security.bean.Role;
import ma.peps.sqli.zynerator.security.service.facade.UserService;
import ma.peps.sqli.zynerator.security.service.facade.RoleService;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.peps.sqli.dao")
//@EnableFeignClients("ma.peps.sqli.required.facade")
public class SqliApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(SqliApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Slot.edit"));
        permissions.add(new Permission("Slot.list"));
        permissions.add(new Permission("Slot.view"));
        permissions.add(new Permission("Slot.add"));
        permissions.add(new Permission("Slot.delete"));
        permissions.add(new Permission("Container.edit"));
        permissions.add(new Permission("Container.list"));
        permissions.add(new Permission("Container.view"));
        permissions.add(new Permission("Container.add"));
        permissions.add(new Permission("Container.delete"));
        permissions.add(new Permission("ContainerType.edit"));
        permissions.add(new Permission("ContainerType.list"));
        permissions.add(new Permission("ContainerType.view"));
        permissions.add(new Permission("ContainerType.add"));
        permissions.add(new Permission("ContainerType.delete"));
    }

}


