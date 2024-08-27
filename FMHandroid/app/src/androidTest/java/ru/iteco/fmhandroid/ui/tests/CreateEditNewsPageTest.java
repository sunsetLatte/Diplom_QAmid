package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.common.BaseSteps;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.CreateEditNewsPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreateEditNewsPageTest {
    private final CreateEditNewsPage editNewsPage = new CreateEditNewsPage();
    private final BaseSteps baseSteps = new BaseSteps();
    private final MainPage mainPage = new MainPage();
    private final NewsPage newsPage = new NewsPage();
    private final OurMissionPage missionPage = new OurMissionPage();
    private final AboutPage aboutPage = new AboutPage();
    private final Data data = new Data();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        baseSteps.logIn();
        mainPage.waitUntilPageLoaded();
        mainPage.goToNewsPage();
        newsPage.goToCreateEditNewsPage();
    }

    int randomNumber = new Random().nextInt(100) + 1;
    String descriptionText = "news_" + randomNumber;

    @Test    //     Навигация из страницы Редактирования новостей по разделам приложения
    public void navigatingPagesOfNewsMenu() {

        editNewsPage.goToMainPage();
        mainPage.checkHeaderPage();
        pressBack();

        editNewsPage.goToNewsPage();
        newsPage.checkHeaderPage();
        pressBack();

        editNewsPage.goToOurMissionPage();
        missionPage.checkHeaderPage();
        pressBack();

        editNewsPage.goToAboutPage();
        aboutPage.checkHeaderPage();
        pressBack();

        editNewsPage.logOut();
    }

    @Test    //  Отображение новостей на странице "Редактирование новостей"
    public void shouldShowNewCardsBlock() {
        editNewsPage.checkNewsCardsBlock();
    }

    @Test    //     Создание новости за сегодняшний денm
    public void createTodayNews() {
        int index = 0;
        editNewsPage.createNews(data.getNameNews(), data.getDateCreateTodayNews(0), descriptionText);
        String createdDescription = editNewsPage.getCreatedNewsDescription(index);
        assertEquals(descriptionText, createdDescription);
    }

    @Test    //     Создание новости датой будущего дня
    public void createFutureDateNews() {
        int index = 0;
        editNewsPage.createNews(data.getNameNews(), data.getDateCreateFutureNews(0), descriptionText);
        String createdDescription = editNewsPage.getCreatedNewsDescription(index);
        assertEquals(descriptionText, createdDescription);
    }

    @Test    //     Создание новости с пустыми полями
    public void createEmptyNews() {
        editNewsPage.createEmptyNews();
        baseSteps.checkEmptyFields();
    }

    @Test    //     Редактирование новости с изменением статуса — активная/неактивная
    public void  editStatusNews() {
        int index = 0;
        editNewsPage.checkContainNewsByIndex(index, "ACTIVE");
        editNewsPage.editNewsByIndex(index);
        editNewsPage.checkContainNewsByIndex(0, "NOT ACTIVE");
        editNewsPage.editNewsByIndex(index);
    }

    @Test    //  Отмена фильтрации
    public void clickCancelFilter() {
        editNewsPage.clickFilterButton();
        editNewsPage.clickCancelButton();
        editNewsPage.checkHeaderPage();
    }

    @Test    //  Фильтрация без ввода фильтров
    public void clickFilterWithoutChoiceFilters() {
        editNewsPage.clickFilterButton();
        editNewsPage.clickFilterNewsButton();
        editNewsPage.checkHeaderPage();
    }

    @Test    //  Фильтрация новостей на странице "Редактирование новостей" по дате От До (От идет перед До)
    public void shouldFilterByDateFromTo() {
        editNewsPage.clickFilterButton();
        editNewsPage.enterStartDate();
        editNewsPage.enterEndDate();
        editNewsPage.clickFilterNewsButton();
        editNewsPage.checkLastNewsPublicationDate();
    }

    @Test    //  Фильтрация новостей на странице "Редактирование новостей" по дате От До (От идет после До) (negative)
    public void shouldFilterByDateToFrom() {
        editNewsPage.clickFilterButton();
        editNewsPage.enterWrongStartDate();
        editNewsPage.enterWrongEndDate();
        editNewsPage.clickFilterNewsButton();
        baseSteps.checkWrongPeriod();
    }
    // Ожидаемый результат: Сообщение "Wrong period"
    // Фактический результат: Сообщение "There is nothing here yet..."          BUG

    @Test    //  Фильтрация новостей на странице "Редактирование новостей" по дате От До (От совпадает с До)
    public void shouldFilterByDateFromToSame() {
        editNewsPage.clickFilterButton();
        editNewsPage.enterSameStartDate();
        editNewsPage.enterSameEndDate();
        editNewsPage.clickFilterNewsButton();
        editNewsPage.checkFirstNewsPublicationSameDate();
        editNewsPage.checkLastNewsPublicationSameDate();
    }

    @Test    //  Фильтрация новостей на странице "Редактирование новостей" по дате От конкретного дня
    public void shouldFilterByDateFrom() {
        editNewsPage.clickFilterButton();
        editNewsPage.enterStartDate();
        editNewsPage.clickFilterNewsButton();
        editNewsPage.checkFirstNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются от конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG

    @Test    //  Фильтрация новостей на странице "Редактирование новостей" по дате До конкретного дня
    public void shouldFilterByDateTo() {
        editNewsPage.clickFilterButton();
        editNewsPage.enterEndDate();
        editNewsPage.clickFilterNewsButton();
        editNewsPage.checkLastNewsPublicationDate();
    }
    // Ожидаемый результат: Новости фильтруются до конкретного дня
    // Фактический результат: Сообщение "Wrong period"                   BUG
}
