package pl.sda.javapoz19.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.javapoz19.model.User;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    private final User user = new User("user", "user");
    private final User user2 = new User("user2", "user2");
    private final User admin = new User("admin", "admin");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindAllUsers() {
        //when
        List<User> actual = userRepository.findAll();

        //then
        assertThat(actual).containsExactlyInAnyOrder(user, user2, admin);
    }

    @Test
    public void shouldFindUserById() {
        //when
        Optional<User> actual = userRepository.findById("user");

        //then
        assertThat(actual.get()).isEqualTo(user);
    }

    @Test
    public void shouldFindUserWithUserNameEqualToUser2() {
        //when
        List<User> actual = userRepository.findByUsername("use2");

        //then
        assertThat(actual).containsExactlyInAnyOrder(user, admin);
    }

    @Test
    @Transactional
    public void shouldAddNewUserToDatabase() {
        //given
        User newUser = new User("newUser", "newUser");

        //when
        userRepository.save(newUser);

        //then
        assertThat(userRepository.findAll()).contains(newUser);
    }

    @Test
    @Transactional
    public void shouldUpdateUser() {
        //given
        User updatedUser = new User("user", "password");

        //when
        userRepository.save(updatedUser);

        //then
        assertThat(userRepository.count()).isEqualTo(3);
        assertThat(userRepository.findById("user").get()).isEqualTo(updatedUser);
    }
}