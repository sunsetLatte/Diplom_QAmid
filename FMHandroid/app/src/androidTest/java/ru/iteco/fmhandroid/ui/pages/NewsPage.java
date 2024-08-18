package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Data.from;
import static ru.iteco.fmhandroid.ui.data.Data.fromFutureDay;
import static ru.iteco.fmhandroid.ui.data.Data.to;
import static ru.iteco.fmhandroid.ui.data.Data.toFutureDay;
import static ru.iteco.fmhandroid.ui.data.Helper.withIndex;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static ru.iteco.fmhandroid.ui.data.Data.Rand.randomCategory;
import static org.junit.Assert.assertEquals;


public class NewsPage {
    private final ViewInteraction headerPage = onView(withText("News"));

    public void checkHeaderPage() {
        headerPage.check(matches(isDisplayed()));
        headerPage.check(matches(withText("News")));
    }

    private final ViewInteraction hamburgerMenuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction logOutMenuButton = onView(withId(R.id.authorization_image_button));
    private final ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction sortButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction newsCardBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
    private final ViewInteraction headerNewsCardBlock = onView(withText("News"));
    private final ViewInteraction expandMaterialButton = onView(withId(R.id.expand_material_button));
    //    private final ViewInteraction expandNewsButton = onView(withId(R.id.expand_news_button));
    private final ViewInteraction expandNewsButton = onView(withId(R.id.view_news_item_image_view));
    private final Helper helper = new Helper();


    private final ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    private final ViewInteraction filterNewsButton = onView(withId(R.id.filter_button));

    public ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction startDateField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public ViewInteraction endDateField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));


    private final ViewInteraction buttonToMainPage = onView(
            allOf(withId(android.R.id.title), withText("Main"),
                    isDisplayed()));
    private final ViewInteraction buttonToNewsPage = onView(
            allOf(withId(android.R.id.title), withText("News"),
                    isDisplayed()));
    private final ViewInteraction buttonToAboutPage = onView(
            allOf(withId(android.R.id.title), withText("About"),
                    isDisplayed()));
    private final ViewInteraction logOutButton = onView(
            allOf(withId(android.R.id.title), withText("Log out"),
                    isDisplayed()));


    public void goToOurMissionPage() {
        ourMissionButton.perform(click());
    }


    public void goToMainPage() {
        hamburgerMenuButton.perform(click());
        buttonToMainPage.perform(click());
    }

    public void goToAboutPage() {
        hamburgerMenuButton.perform(click());
        buttonToAboutPage.perform(click());
    }

    public void logOut() {
        logOutMenuButton.perform(click());
        logOutButton.perform(click());
    }

    public void clickSortNewsButton() {
        sortButton.check(matches(isDisplayed()));
        sortButton.perform(click());
    }

    public void clickFilterButton() {
        filterButton.check(matches(isDisplayed()));
        filterButton.perform(click());
    }

    public void checkNewsCardsBlock() {
        newsCardBlock.check(matches(isDisplayed()));
        headerNewsCardBlock.check(matches(isDisplayed()));
    }

    public void clickExpandButton() {
        expandMaterialButton.perform(click());
    }

    public void expandNewsAtIndex(int newsIndex) {
        expandNewsButton.perform(actionOnItemAtPosition(newsIndex, click()));
    }

    public void verifyNewsContentAtIndex(int newsIndex) {
        String newsContent = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), newsIndex)));
        ViewInteraction newsDescription = onView(allOf(withId(R.id.news_item_description_text_view), withText(newsContent)));
        newsDescription.check(matches(isDisplayed()));
    }

    public void clickFilterNewsButton() {
        filterNewsButton.check(matches(isDisplayed()));
        filterNewsButton.perform(click());
    }

    public void clickCancelButton() {
        cancelButton.check(matches(isDisplayed()));
        cancelButton.perform(click());
    }

    public void enterStartDate() {
        startDateField.perform(replaceText(from));
    }

    public void enterEndDate() {
        endDateField.perform(replaceText(to));
    }

    public void enterWrongStartDate() {
        startDateField.perform(replaceText(to));
    }

    public void enterWrongEndDate() {
        endDateField.perform(replaceText(from));
    }

    public void enterSameStartDate() {
        startDateField.perform(replaceText(to));
    }

    public void enterSameEndDate() {
        endDateField.perform(replaceText(to));
    }

    public void enterFutureStartDate() {
        startDateField.perform(replaceText(fromFutureDay));
    }

    public void enterFutureEndDate() {
        endDateField.perform(replaceText(toFutureDay));
    }


    public void checkFirstNewsPublicationDate() {
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(from, firstNewsPublicationDate);
    }

    public void checkLastNewsPublicationDate() {
        String lastNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(to, lastNewsPublicationDate);
    }

    public void checkFirstNewsPublicationSameDate() {
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(to, firstNewsPublicationDate);
    }

    public void checkLastNewsPublicationSameDate() {
        String lastNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(to, lastNewsPublicationDate);
    }


    public void fillInNewsCategory(String text) {
        categoryField.perform(replaceText(text));
    }

}