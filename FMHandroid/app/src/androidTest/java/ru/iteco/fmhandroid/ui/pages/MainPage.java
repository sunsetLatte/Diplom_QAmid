package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.common.TestUtils.waitDisplayed;
import ru.iteco.fmhandroid.R;

public class MainPage {

    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 5000));

    }
}