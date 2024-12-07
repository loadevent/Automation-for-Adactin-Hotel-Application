package TestCases;

import org.junit.jupiter.api.*;
import utils.BaseTest;

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

        try {
            Thread.sleep(2000);
            newRegistrationPage = homePage.clickRegister();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
    @Test
    @DisplayName("New User Registration Form")
    @Order(2)
    public void registerNewUser() throws Exception {
        newRegistrationPage.setUsername("landrei1")
                .setPassword("3NUU64_")
                .setFullname("Teriann Santi")
                .setEmail("tsanti0@mailinator.com")
                .typeCaptcha()
                .clickTerms()
                .clickRegister();
    }
}
