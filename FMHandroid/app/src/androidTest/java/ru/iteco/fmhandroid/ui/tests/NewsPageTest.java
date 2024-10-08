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
public class NewsPageTest {
    private final BaseSteps baseSteps = new BaseSteps();
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
        mainPage.waitUntilPageLoaded();
        mainPage.goToNewsPage();
    }

    @Test
    @DisplayName("Навигация из страницы Новостей по разделам приложения")
    public void navigatingPagesOfNewsMenu() {

        newsPage.goToMainPage();
        mainPage.checkHeaderPage();
        pressBack();

        newsPage.goToOurMissionPage();
        missionPage.checkHeaderPage();
        pressBack();

        newsPage.goToAboutPage();
        aboutPage.checkHeaderPage();
        pressBack();

        newsPage.logOut();
    }
    // Ожидаемый результат: Осуществлен переход по всем страницам меню
    // Фактический результат: Страница "About" недоступна                 BUG

    @Test
    @DisplayName("Отображение новостей на странице \"Новости\"")
    public void shouldShowNewCardsBlock() {
        newsPage.checkNewsCardsBlock();
    }


    @Test
    @DisplayName("Отмена фильтрации")
    public void clickCancelFilter() {
        newsPage.clickFilterButton();
        newsPage.clickCancelButton();
        newsPage.checkHeaderPage();
    }

    @Test
    @DisplayName("Фильтрация без ввода фильтров")
    public void clickFilterWithoutChoiceFilters() {
        newsPage.clickFilterButton();
        newsPage.clickFilterNewsButton();
        newsPage.checkHeaderPage();
    }

    @Test
    @DisplayName("Фильтрация новостей на странице \"Новости\" по дате От До (От идет перед До)")
    public void shouldFilterByDateFromTo() {
        newsPage.clickFilterButton();
        newsPage.enterStartDate();
        newsPage.enterEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkLastNewsPublicationDate();
    }

    @Test
    @DisplayName("Фильтрация новостей на странице \"Новости\" по дате От До (От идет после До) (negative)")
    public void shouldFilterByDateToFrom() {
        newsPage.clickFilterButton();
        newsPage.enterWrongStartDate();
        newsPage.enterWrongEndDate();
        newsPage.clickFilterNewsButton();
        baseSteps.checkWrongPeriod();
    }
    // Ожидаемый результат: Сообщение "Wrong period"
    // Фактический результат: Сообщение "There is nothing here yet..."          BUG

    @Test
    @DisplayName("Фильтрация новостей на странице \"Новости\" по дате От До (От совпадает с До)")
    public void shouldFilterByDateFromToSame() {
        newsPage.clickFilterButton();
        newsPage.enterSameStartDate();
        newsPage.enterSameEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkFirstNewsPublicationSameDate();
        newsPage.checkLastNewsPublicationSameDate();
    }

    @Test
    @DisplayName("Фильтрация новостей на странице \"Новости\" по дате От конкретного дня")
    public void shouldFilterByDateFrom() {
        newsPage.clickFilterButton();
        newsPage.enterStartDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkFirstNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются от конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG

    @Test
    @DisplayName("Фильтрация новостей на странице \"Новости\" по дате До конкретного дня")
    public void shouldFilterByDateTo() {
        newsPage.clickFilterButton();
        newsPage.enterEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkLastNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются до конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG
}