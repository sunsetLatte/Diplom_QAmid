package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Random;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.common.BaseSteps;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class OurMissionPageTest {
    private final BaseSteps baseSteps = new BaseSteps();
    private final MainPage mainPage = new MainPage();
    private final Data data = new Data();
    private final OurMissionPage missionPage = new OurMissionPage();
    private final AboutPage aboutPage = new AboutPage();
    private final NewsPage newsPage = new NewsPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        baseSteps.logIn();
        mainPage.waitUntilPageLoaded();
        mainPage.goToOurMissionPage();
    }

    @Test    //     Навигация из страницы с цитатами по разделам приложения
    public void navigatingPagesOfNewsMenu() {

        missionPage.goToMainPage();
        mainPage.checkHeaderPage();
        pressBack();

        missionPage.goToNewsPage();
        newsPage.checkHeaderPage();
        pressBack();

        missionPage.goToAboutPage();
        aboutPage.checkHeaderPage();
        pressBack();

        missionPage.logOut();
    }

    @Test    //  Отображение цитат на странице с цитатами
    public void shouldShowQuotesCardsBlock() {
        missionPage.checkQuotesCardsBlock();
    }

    @Test    //  Чтение цитаты на странице с цитатами
    public void dropDownQuote() {
        int indexQuote = new Random().nextInt(data.lengthQuotes());
        missionPage.checkAvailQuote(indexQuote);
        missionPage.dropDownQuote(indexQuote);
        missionPage.checkAvailQuoteDescription(indexQuote);
    }
}