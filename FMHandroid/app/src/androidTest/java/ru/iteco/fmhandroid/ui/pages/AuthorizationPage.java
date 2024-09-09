package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Helper.SQLAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.XSSAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.emptyAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.kirilAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.spaceAuthData;
import static ru.iteco.fmhandroid.ui.data.Helper.unregAuthData;
import static ru.iteco.fmhandroid.ui.common.TestUtils.waitDisplayed;
import android.widget.EditText;
import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Helper;

public class AuthorizationPage {

    private final ViewInteraction headerPage = onView(withText("News"));
    public void checkHeaderPage() {
        headerPage.check(matches(isDisplayed()));
        headerPage.check(matches(withText("News")));
    }

    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 10_000));
    }

    ViewInteraction loginInputText = onView(
            allOf(
                    isDescendantOfA(withId(R.id.login_text_input_layout)),
                    isAssignableFrom(EditText.class)
            )
    );

    ViewInteraction passwordInputText = onView(
            allOf(
                    isDescendantOfA(withId(R.id.password_text_input_layout)),
                    isAssignableFrom(EditText.class)
            )
    );

    ViewInteraction signInButton = onView(withId(R.id.enter_button));

    public void signIn() {
        signInButton.perform(click());
    }


    public void authValidLoginAndPass(Helper.User info) {
        loginInputText.perform(replaceText(info.getLogin()));
        passwordInputText.perform(replaceText(info.getPassword()));
    }

    public void authUnregLoginAndPass(Helper.User info) {
        loginInputText.perform(replaceText(unregAuthData().getLogin()));
        passwordInputText.perform(replaceText(info.getPassword()));
    }

    public void authUnregLogin(Helper.User info) {
        loginInputText.perform(replaceText(unregAuthData().getLogin()));
        passwordInputText.perform(replaceText(info.getPassword()));
    }

    public void authUnregPass(Helper.User info) {
        loginInputText.perform(replaceText(info.getLogin()));
        passwordInputText.perform(replaceText(unregAuthData().getPassword()));
    }

    public void authEmptyData(Helper.User info) {
        loginInputText.perform(replaceText(emptyAuthData().getLogin()));
        passwordInputText.perform(replaceText(emptyAuthData().getPassword()));
    }

    public void authSpaceData(Helper.User info) {
        loginInputText.perform(replaceText(spaceAuthData().getLogin()));
        passwordInputText.perform(replaceText(spaceAuthData().getPassword()));
    }

    public void authKirilLoginAndPass(Helper.User info) {
        loginInputText.perform(replaceText(kirilAuthData().getLogin()));
        passwordInputText.perform(replaceText(kirilAuthData().getPassword()));
    }

    public void XSSLogin(Helper.User info) {
        loginInputText.perform(replaceText(XSSAuthData().getLogin()));
        passwordInputText.perform(replaceText(info.getPassword()));
    }

    public void XSSPass(Helper.User info) {
        loginInputText.perform(replaceText(info.getLogin()));
        passwordInputText.perform(replaceText(XSSAuthData().getPassword()));
    }

    public void SQLLogin(Helper.User info) {
        loginInputText.perform(replaceText(SQLAuthData().getLogin()));
        passwordInputText.perform(replaceText(info.getPassword()));
    }

    public void SQLPass(Helper.User info) {
        loginInputText.perform(replaceText(info.getLogin()));
        passwordInputText.perform(replaceText(SQLAuthData().getPassword()));
    }
}