package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.CredentialsReader;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final String BASE_URL = "https://ok.ru/";

    private SelenideElement userNameField = $(byXpath("//input[@name='st.email']"));
    private SelenideElement passwordField = $(byXpath("//input[@name='st.password']"));
    private SelenideElement loginButton = $(byXpath("//input[@value='Войти в Одноклассники']"));
    private SelenideElement loginCheckElement = $(byXpath("//*[@id='toolbar_search']/toolbar-search/form/div/label/input"));

    public void open() {
        Selenide.open(BASE_URL);
    }
    public void enterUserName(String userName) {
        userNameField.setValue(userName);
    }
    public void enterPassword(String password) {
        passwordField.setValue(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }
    public boolean isUserLoggedIn() {
        return loginCheckElement.isDisplayed();
    }
}