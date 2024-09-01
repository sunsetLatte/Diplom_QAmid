package ru.iteco.fmhandroid.ui.tests;
import static androidx.test.espresso.Espresso.pressBack;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.common.BaseSteps;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainPageTest {
    BaseSteps baseSteps = new BaseSteps();

    private final MainPage mainPage = new MainPage();
    private final NewsPage newsPage = new NewsPage();
    private final OurMissionPage missionPage = new OurMissionPage();
    private final AboutPage aboutPage = new AboutPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        baseSteps.logIn();
    }

    @Test
    @DisplayName("Сворачивание/разворачивание новостей на главном экране")
    public void dropDawnNewsBlock() {
        mainPage.checkNewsBlock();
        mainPage.clickExpandButton();
        mainPage.clickExpandButton();
        mainPage.checkNewsBlock();
    }

    @Test
    @DisplayName("Переход с Главной на экран с новостями через кнопку \"Все новости\"")
    public void navigatingllNewsButton() {
        mainPage.clickAllNewsButton();
        newsPage.checkHeaderPage();
        pressBack();
    }

    @Test
    @DisplayName("Навигация из Главной страницы по разделам приложения")
    public void navigatingPagesOfMainMenu() {

        mainPage.goToNewsPage();
        newsPage.checkHeaderPage();
        pressBack();

        mainPage.goToOurMissionPage();
        missionPage.checkHeaderPage();
        pressBack();

        mainPage.goToAboutPage();
        aboutPage.checkHeaderPage();
        pressBack();

        baseSteps.logOut();
    }
}