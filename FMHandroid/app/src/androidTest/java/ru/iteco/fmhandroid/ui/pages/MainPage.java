package ru.iteco.fmhandroid.ui.pages;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.common.TestUtils.waitDisplayed;


public class MainPage {

    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 10_000));
    }
    private final ViewInteraction headerPage = onView(withText("News"));

    public void checkHeaderPage() {
        headerPage.check(matches(isDisplayed()));
        headerPage.check(matches(withText("News")));
    }

    private final ViewInteraction hamburgerMenuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction ourMissionButton = onView(withId(R.id.our_mission_image_button));
    private final ViewInteraction newsBlock = onView(withId(R.id.container_list_news_include_on_fragment_main));
    private final ViewInteraction headerNewsBlock = onView(withText("News"));
    private final ViewInteraction expandMaterialButton = onView(withId(R.id.expand_material_button));
    private final ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

    private final ViewInteraction buttonToNewsPage = onView(
            allOf(withId(android.R.id.title), withText("News"),
                    isDisplayed()));
    private final ViewInteraction buttonToAboutPage = onView(
            allOf(withId(android.R.id.title), withText("About"),
                    isDisplayed()));

    public void goToOurMissionPage() {
        ourMissionButton.perform(click());
    }

    public void goToNewsPage() {
        hamburgerMenuButton.perform(click());
        buttonToNewsPage.perform(click());
    }

    public void goToAboutPage() {
        hamburgerMenuButton.perform(click());
        buttonToAboutPage.perform(click());
    }

    public void clickExpandButton() {
        expandMaterialButton.perform(click());
    }

    public void checkNewsBlock() {
        newsBlock.check(matches(isDisplayed()));
        headerNewsBlock.check(matches(isDisplayed()));
        allNewsButton.check(matches(isDisplayed()));
        allNewsButton.check(matches(isClickable()));
    }

    public void clickAllNewsButton() {
        allNewsButton.check(matches(isDisplayed()));
        allNewsButton.perform(click());
    }
}