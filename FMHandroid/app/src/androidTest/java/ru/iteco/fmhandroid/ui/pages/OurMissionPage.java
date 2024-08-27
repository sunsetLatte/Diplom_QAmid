package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;
import static ru.iteco.fmhandroid.ui.common.TestUtils.isNotDisplayed;
import androidx.test.espresso.contrib.RecyclerViewActions;
import org.hamcrest.Matchers;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Data;
import ru.iteco.fmhandroid.ui.data.Helper;

public class OurMissionPage {
    private final ViewInteraction headerOurMissionPage = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction hamburgerMenuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction headerQuotesPage = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction logOutMenuButton = onView(withId(R.id.authorization_image_button));
    private final ViewInteraction QuaotesCardBlock = onView(withId(R.id.our_mission_item_list_recycler_view));
    private final ViewInteraction headerQuaotesCardBlock = onView(withText("Love is all"));
    private final ViewInteraction recyclerViewItem = onView(withId(R.id.our_mission_item_list_recycler_view));
    private final Helper helper = new Helper();
    private final Data data = new Data();


    public void checkHeaderPage() {
        headerOurMissionPage.check(matches(isDisplayed()));
        headerOurMissionPage.check(matches(withText("Love is all")));

    }

    private final ViewInteraction buttonToMainPage = onView(
            Matchers.allOf(withId(android.R.id.title), withText("Main"),
                    isDisplayed()));
    private final ViewInteraction buttonToNewsPage = onView(
            Matchers.allOf(withId(android.R.id.title), withText("News"),
                    isDisplayed()));
    private final ViewInteraction buttonToAboutPage = onView(
            Matchers.allOf(withId(android.R.id.title), withText("About"),
                    isDisplayed()));
    private final ViewInteraction logOutButton = onView(
            Matchers.allOf(withId(android.R.id.title), withText("Log out"),
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


    public void logOut() {
        logOutMenuButton.perform(click());
        logOutButton.perform(click());
    }

    public void checkQuotesCardsBlock() {
        QuaotesCardBlock.check(matches(isDisplayed()));
        headerQuaotesCardBlock.check(matches(isDisplayed()));
    }

    public void checkAvailQuote(int index) {
        ViewInteraction quoteTitle = onView(
                allOf(withId(R.id.our_mission_item_title_text_view), withText(data.getQuoteTitleByIndex(index)),
                        withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                        isDisplayed()));
        onView(withId(R.id.our_mission_item_list_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(index));
        quoteTitle.check(matches(isDisplayed()));
        quoteTitle.check(matches(withText(data.getQuoteTitleByIndex(index))));
    }

    public void checkAvailQuoteDescription(int index) {
        ViewInteraction quoteDescription = onView(
                allOf(withId(R.id.our_mission_item_description_text_view), withText(data.getQuoteDescriptionByIndex(index)),
                        withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                        isDisplayed()));
        quoteDescription.check(matches(isDisplayed()));
        quoteDescription.check(matches(withText(data.getQuoteDescriptionByIndex(index))));
    }

    public void checkNotDisplayedAvailQuoteDescription(int index) {
        ViewInteraction quoteDescription = onView(
                allOf(withId(R.id.our_mission_item_description_text_view), withText(data.getQuoteDescriptionByIndex(index)),
                        withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                        isDisplayed()));
        quoteDescription.check(isNotDisplayed());
    }

    public void dropDownQuote(int numberQuote) {
        recyclerViewItem.perform(actionOnItemAtPosition(numberQuote, click()));
    }
}