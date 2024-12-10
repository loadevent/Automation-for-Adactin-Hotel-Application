package TestCases;

import org.junit.jupiter.api.*;
import utils.BaseTest;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NewUserRegistration extends BaseTest {

    @BeforeAll
    public void setup() throws Exception {
        init();
    }

    @Test
    @DisplayName("Open Home Page and click 'New User Register Here'")
    @Order(1)
    public void openNewRegisterForm() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        newRegistrationPage = homePage.clickRegister();


    }
    @Test
    @DisplayName("New User Registration Form")
    @Order(2)
    public void registerNewUser() throws Exception {
        newRegistrationPage.setUsername("jjaquin2")
                .setPassword("3NUU64_")
                .setFullname("Jermaine Jaquin")
                .setEmail("jjaquin2@mailinator.com")
                .typeCaptcha();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        newRegistrationPage
                .clickTerms()
                .clickRegister();

    }
}
