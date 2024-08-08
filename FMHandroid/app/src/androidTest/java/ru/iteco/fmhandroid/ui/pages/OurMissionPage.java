package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionPage {
    private final ViewInteraction headerOurMissionPage = onView(withId(R.id.our_mission_title_text_view));

    public void checkHeaderPage() {
        headerOurMissionPage.check(matches(isDisplayed()));
        headerOurMissionPage.check(matches(withText("Love is all")));

    }
}