package ru.iteco.fmhandroid.ui.common;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.common.TestUtils.waitDisplayed;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.util.HumanReadables;

public class BaseSteps {

    Helper helper = new Helper();
    AuthorizationPage authPage = new AuthorizationPage();

    public void logOut() {
        ViewInteraction userButton = onView(withId(R.id.authorization_image_button));
        userButton.check(matches(isDisplayed()));
        userButton.perform(click());

        ViewInteraction logOutButton = onView(withText("Log out"));
        logOutButton.check(matches(isDisplayed()));
        logOutButton.perform(click());
    }

    public void logIn() {

        try {
            onView(isRoot()).perform(waitDisplayed(R.id.trademark_image_view, 20_000));
        } catch (Exception e) {
            authPage.authValidLoginAndPass(Helper.authInfo());
            authPage.signIn();
        }
    }

    public void checkToast(int id, boolean visible) {
        if (visible) {
            helper.toast(id).check(matches(isDisplayed()));
        } else {
            helper.toast(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkWrongAuthDataToast() {
        checkToast(R.string.wrong_login_or_password, true);
    }

    public void checkEmptyAuthDataToast() {
        checkToast(R.string.empty_login_or_password, true);
    }

    public void checkEmptyFields() {
        checkToast(R.string.empty_fields, true);
    }

    public void checkWrongPeriod() {
        checkToast(R.string.wrong_news_date_period, true);
    }

    public ViewInteraction nothingToShowWarning = onView(withText("There is nothing here yet…"));


    public void  nothingToShowWarning() {
        nothingToShowWarning.check(matches(isDisplayed()));
        nothingToShowWarning.check(matches(withText("There is nothing here yet...")));
    }
}