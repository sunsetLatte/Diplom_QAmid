package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.common.BaseSteps;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;
import static ru.iteco.fmhandroid.ui.data.Data.Rand.randomCategory;

public class NewsPageTest {

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
        mainPage.waitUntilPageLoaded();
        mainPage.goToNewsPage();
    }

    @Test    //     Навигация из страницы Новостей по разделам приложения
    public void navigatingPagesOfNewsMenu() {

        newsPage.goToMainPage();
        newsPage.checkHeaderPage();
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

    @Test    //  Отмена фильтрации
    public void clickCancelFilter() {
        newsPage.clickFilterButton();
        newsPage.clickCancelButton();
        newsPage.checkHeaderPage();
    }

    @Test    //  Фильтрации без ввода фильтров
    public void clickFilterWithoutChoiceFilters() {
        newsPage.clickFilterButton();
        newsPage.clickFilterNewsButton();
        newsPage.checkHeaderPage();
    }

    @Test    //  Фильтрация новостей со страницы "Новости" по категории
    public void shouldFilterByCathegory() {
        newsPage.clickFilterButton();
        newsPage.fillInNewsCategory(randomCategory());
        newsPage.clickFilterNewsButton();
        newsPage.checkNewsCardsBlock();
    }

    @Test    //  Фильтрация новостей на страничке "Новости" по дате От До (От идет перед До)
    public void shouldFilterByDateFromTo() {
        newsPage.clickFilterButton();
        newsPage.enterStartDate();
        newsPage.enterEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkLastNewsPublicationDate();
    }

    @Test    //  Фильтрация новостей на страничке "Новости" по дате От До (От идет после До) (negative)
    public void shouldFilterByDateToFrom() {
        newsPage.clickFilterButton();
        newsPage.enterWrongStartDate();
        newsPage.enterWrongEndDate();
        newsPage.clickFilterNewsButton();
        baseSteps.checkWrongPeriod();
    }
    // Ожидаемый результат: Сообщение "Wrong period"
    // Фактический результат: Сообщение "There is nothing here yet..."          BUG

    @Test    //  Фильтрация новостей на страничке "Новости" по дате От До (От совпадает с До)
    public void shouldFilterByDateFromToSame() {
        newsPage.clickFilterButton();
        newsPage.enterSameStartDate();
        newsPage.enterSameEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkFirstNewsPublicationSameDate();
        newsPage.checkLastNewsPublicationSameDate();
    }

    @Test    //  Фильтрация новостей на страничке "Редактирование новостей" по дате От конкретного дня
    public void shouldFilterByDateFrom() {
        newsPage.clickFilterButton();
        newsPage.enterStartDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkFirstNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются от конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG

    @Test    //  Фильтрация новостей на страничке "Новости" по дате До конкретного дня
    public void shouldFilterByDateTo() {
        newsPage.clickFilterButton();
        newsPage.enterEndDate();
        newsPage.clickFilterNewsButton();
        newsPage.checkLastNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются до конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG

}