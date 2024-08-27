package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;


public class AboutPage {
    private final ViewInteraction headerPage = onView(withText("Version:"));

    public void checkHeaderPage() {
        headerPage.check(matches(isDisplayed()));
        headerPage.check(matches(withText("Version:")));
    }

    private final ViewInteraction privacyPolicyValue = onView(withId(R.id.about_privacy_policy_value_text_view));
    private final ViewInteraction termsOfUseValue = onView(withId(R.id.about_terms_of_use_value_text_view));
    private final ViewInteraction backButton = onView(withId(R.id.about_back_image_button));

    public void clickBackButton() {
        backButton.check(matches(isDisplayed()));
        backButton.perform(click());
    }

    public void goToPrivacyPolicy() {
        privacyPolicyValue.perform(click());

    }

    public void goToTermsOfUse() {
        termsOfUseValue.perform(click());
    }
}