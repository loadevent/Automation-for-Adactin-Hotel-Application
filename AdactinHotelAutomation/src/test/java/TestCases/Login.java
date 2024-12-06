package TestCases;

import org.junit.jupiter.api.*;
import org.loadevent.pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BaseTest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Login extends BaseTest {

    @BeforeAll
    public void setup() throws Exception {
        init();
    }
    @Test
    @DisplayName("Login With Valid Credentials")
    public void validLogin(){
        homePage.enterCredentials("kabelotest","3NUU64");
        searchHotelPage = homePage.clickLogin();
    }
//    @AfterAll
//    public void quit(){tearDown();}
}
