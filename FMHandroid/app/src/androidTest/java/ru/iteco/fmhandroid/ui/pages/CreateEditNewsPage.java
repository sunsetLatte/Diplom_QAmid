package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
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
import static ru.iteco.fmhandroid.ui.data.Data.Rand.randomCategory;
import static org.junit.Assert.assertEquals;


public class CreateEditNewsPage {
    private final ViewInteraction headerPage = onView(withText("Control panel"));

    public void checkHeaderPage() {
        headerPage.check(matches(isDisplayed()));
        headerPage.check(matches(withText("Control panel")));
    }

    private final ViewInteraction hamburgerMenuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction logOutMenuButton = onView(withId(R.id.authorization_image_button));
    private final ViewInteraction filterButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction newsCardBlock = onView(withId(R.id.news_list_recycler_view));
    private final ViewInteraction headerNewsCardBlock = onView(withText("Control panel"));
    private final ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    private final ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    private final ViewInteraction filterNewsButton = onView(withId(R.id.filter_button));
    private final ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    private final ViewInteraction choiceCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction categoryNewsList = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction titleField = onView((withId(R.id.news_item_title_text_input_edit_text)));
    private final ViewInteraction datePublishField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    private final ViewInteraction timePublishField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private final ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    private final ViewInteraction saveButton = onView(withId(R.id.save_button));
    private final ViewInteraction switchActiveButton = onView(withId(R.id.switcher));
    private final ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction startDateField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    private final ViewInteraction endDateField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    private final Helper helper = new Helper();


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

    public void goToMainPage() {
        hamburgerMenuButton.perform(click());
        buttonToMainPage.perform(click());
    }

    public void goToNewsPage() {
        hamburgerMenuButton.perform(click());
        buttonToNewsPage.perform(click());
    }

    public void goToAboutPage() {
        hamburgerMenuButton.perform(click());
        buttonToAboutPage.perform(click());
    }

    public void goToOurMissionPage() {
        ourMissionButton.perform(click());
    }

    public void logOut() {
        logOutMenuButton.perform(click());
        logOutButton.perform(click());
    }

    public void clickFilterButton() {
        filterButton.check(matches(isDisplayed()));
        filterButton.perform(click());
    }

    public void checkNewsCardsBlock() {
        newsCardBlock.check(matches(isDisplayed()));
        headerNewsCardBlock.check(matches(isDisplayed()));
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
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 7)));
        assertEquals(from, firstNewsPublicationDate);
    }

    public void checkLastNewsPublicationDate() {
        String lastNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)));
        assertEquals(to, lastNewsPublicationDate);
    }

    public void checkFirstNewsPublicationSameDate() {
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_publication_date_text_view), 1)));
        assertEquals(to, firstNewsPublicationDate);
    }

    public void checkLastNewsPublicationSameDate() {
        String lastNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_publication_date_text_view), 0)));
        assertEquals(to, lastNewsPublicationDate);
    }

    public void fillInNewsCategory(String text) {
        categoryField.perform(replaceText(text));
    }

    public void createNews(String nameNews, String datePublish, String description) {
        addNewsButton.check(matches(isDisplayed()));
        addNewsButton.perform(click());
        choiceCategory.perform(click());
        categoryNewsList.perform(replaceText(randomCategory()), closeSoftKeyboard());
        titleField.check(matches(isDisplayed()));
        titleField.perform(replaceText(nameNews), closeSoftKeyboard());
        datePublishField.perform(replaceText(datePublish), closeSoftKeyboard());
        timePublishField.perform(replaceText("23:37"), closeSoftKeyboard());
        descriptionField.perform(replaceText(description), closeSoftKeyboard());
        saveButton.perform(scrollTo(), click());
    }

    public String getCreatedNewsDescription(int index) {
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), index)));

    }

    public void createEmptyNews() {
        addNewsButton.check(matches(isDisplayed()));
        addNewsButton.perform(click());
        saveButton.perform(scrollTo(), click());
    }

    public void checkContainNewsByIndex(int index, String status) {
        onView(withIndex(
                allOf(withId(R.id.news_item_published_text_view),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()), index))
                .check(matches(withText(status)));
    }

    public void editNewsByIndex(int index) {
        onView(withIndex(
                allOf(withId(R.id.edit_news_item_image_view),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()), index))
                .perform(click());
        switchActiveButton.check(matches(isDisplayed()));
        switchActiveButton.perform(scrollTo(), click());
        saveButton.check(matches(isDisplayed()));
        saveButton.perform(scrollTo(), click());
    }
}
