package androidshop;

import androidshop.models.user.ERole;
import androidshop.models.user.Role;
import androidshop.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class AndroidServer {

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(AndroidServer.class, args);
    }

    @PostConstruct
    private void doAddRolesInDatabase() {
        if (roleRepository.findByName(ERole.ROLE_USER).isEmpty() && roleRepository.findByName(ERole.ROLE_ADMIN).isEmpty())
            roleRepository.saveAll(Arrays.asList(new Role(ERole.ROLE_USER), new Role(ERole.ROLE_ADMIN)));
    }
}
