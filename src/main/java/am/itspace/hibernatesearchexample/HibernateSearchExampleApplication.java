package am.itspace.hibernatesearchexample;

import am.itspace.hibernatesearchexample.model.User;
import am.itspace.hibernatesearchexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateSearchExampleApplication implements CommandLineRunner {

    @Autowired
    public HibernateSearchExampleApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateSearchExampleApplication.class, args);
    }

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder().name("valod").surname("valodyan").age(15).characteristic("good boy an friend").build();
        User user2 = User.builder().name("poxos").surname("poxosyan").age(32).characteristic("good boy ").build();
        User user3 = User.builder().name("varduhi").surname("valodyan").age(21).characteristic("good girl").build();
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
