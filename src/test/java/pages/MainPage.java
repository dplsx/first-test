package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final String BASE_URL = "https://ok.ru/";

    private SelenideElement publishButton = $(byXpath("//*[@id=\"hook_Block_PostingFormDropdown\"]/posting-form-dropdown/div/button"));
    private SelenideElement noteButton = $(byXpath("//*[@id=\"hook_Block_PostingFormDropdown\"]/posting-form-dropdown/div/div/span[2]/a"));
    private SelenideElement inputWindow = $(byXpath("//*[@id=\"hook_Block_pf0#-1#0\"]/section/div[2]/div[1]/div/div/div[2]/div"));
    private SelenideElement submitButton = $(byXpath("//*[@id=\"gpf_3849225036\"]/div[10]/div/div/div/div[5]/div[2]/button"));
    private SelenideElement feedList = $(byXpath("//*[@id=\"hook_Loader_3460246899\"]/div[1]"));
    private SelenideElement inputSearch = $(byXpath("//*[@id=\"toolbar_search\"]/toolbar-search/form/div/label/input"));
    private SelenideElement profileName = $(byXpath("//*[@id=\"tabpanel-users\"]/div[2]/div/div/div/div[1]/div[1]/a/div"));
    private SelenideElement photos = $(byXpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[5]/a/div"));
    private SelenideElement personalAlbum = $(byXpath("//*[@id=\"hook_Block_PhotoVitrineAlbumsBlock\"]/div/ul/li/photo-album-card/div/div[3]/a"));
    private SelenideElement photo = $(byXpath("//*[@id=\"img_990043927118\"]"));
    private SelenideElement likeButton = $(byXpath("//*[@id=\"hook_Block_2161488007\"]/div/span"));
    private SelenideElement likeCounter = $(byXpath("//*[@id=\"hook_Block_2161488007\"]/div/span/span[2]"));

    public void open() {
        Selenide.open(BASE_URL);
    }
    public void clickPublishButton() {
        publishButton.click();
    }
    public void clickNoteButton() {
        noteButton.click();
    }
    public void writeIntoInputWindow(String text) {
        inputWindow.setValue(text);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void publishText(String text) {
        clickPublishButton();
        clickNoteButton();
        writeIntoInputWindow(text);
        clickSubmitButton();
    }
    public void isNotePosted(String text) {
        feedList.shouldHave(text(text));
    }
    public void clickInputSearch() {
        inputSearch.click();
    }
    public void inputText(String text) {
        inputSearch.setValue(text);
    }
    public void pressEnter() {
        inputSearch.pressEnter();
    }
    public void checkTheName(String text) {
        profileName.shouldHave(text(text));
    }
    public void clickPhotos() {
        photos.click();
    }
    public void clickPersonalAlbum() {
        personalAlbum.click();
    }
    public void clickPhoto() {
        photo.click();
    }
    public void clickLikeButton() {
        likeButton.click();
    }
    public void checkTheLike() {
        likeCounter.shouldHave(text("1"));
    }




}
