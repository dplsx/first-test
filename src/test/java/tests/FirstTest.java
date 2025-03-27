package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import pages.LoginPage;
import pages.MainPage;
import utils.CredentialsReader;

import java.io.IOException;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirstTest {
    private static Properties credentials;

    @BeforeAll
    public static void setup() throws IOException {
        CredentialsReader.loadProperties();
    }


    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(CredentialsReader.get("username"), CredentialsReader.get("password"));
        assertTrue(loginPage.isUserLoggedIn());
    }

    @Test
    void findUserTest() {
        String testName = "Эмилия Куцарева";
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickInputSearch();
        mainPage.inputText(testName);
        mainPage.pressEnter();
        mainPage.checkTheName(testName);
    }

    @Test
    void likePhoto() {
        MainPage mainPage = new MainPage();
        mainPage.open();
        mainPage.clickPhotos();
        mainPage.clickPersonalAlbum();
        mainPage.clickPhoto();
        mainPage.clickLikeButton();
        mainPage.checkTheLike();
    }

}
