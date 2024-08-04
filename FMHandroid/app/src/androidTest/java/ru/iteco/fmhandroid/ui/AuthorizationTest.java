package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.TestUtils.waitDisplayed;
import android.widget.EditText;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)


public class AuthorizationTest {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    String login = "login2";
    String password = "password2";


    @After
    public void logout() {
        TestUtils.logOut();
    }

    @Test
    public void loginTest() {

        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 6000));

        ViewInteraction loginInputText = onView(
                allOf(
                        isDescendantOfA(withId(R.id.login_text_input_layout)),
                        isAssignableFrom(EditText.class)
                )
        );
        loginInputText.check(matches(isDisplayed()));
        loginInputText.perform(replaceText(login), closeSoftKeyboard());

        ViewInteraction passwordInputText = onView(
                allOf(
                        isDescendantOfA(withId(R.id.password_text_input_layout)),
                        isAssignableFrom(EditText.class)
                )
        );
        passwordInputText.check(matches(isDisplayed()));
        passwordInputText.perform(replaceText(password), closeSoftKeyboard());

        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.check(matches(isDisplayed()));
        signInButton.perform(click());

        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));

        ViewInteraction newsTitle = onView(withId(R.id.container_list_news_include_on_fragment_main));
        newsTitle.check(matches(isDisplayed()));

    }
}
