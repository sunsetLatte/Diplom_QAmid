package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.Data.SQL;
import static ru.iteco.fmhandroid.ui.data.Data.XSS;
import static ru.iteco.fmhandroid.ui.data.Data.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Data.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Data.kirilLogin;
import static ru.iteco.fmhandroid.ui.data.Data.kirilPassword;
import static ru.iteco.fmhandroid.ui.data.Data.login;
import static ru.iteco.fmhandroid.ui.data.Data.password;
import static ru.iteco.fmhandroid.ui.data.Data.spaceLogin;
import static ru.iteco.fmhandroid.ui.data.Data.spacePassword;
import static ru.iteco.fmhandroid.ui.data.Data.unregLogin;
import static ru.iteco.fmhandroid.ui.data.Data.unregPassword;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.test.espresso.Root;
import androidx.test.espresso.ViewInteraction;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;


public class Helper {

    public static class User {
        private final String login;
        private final String password;

        public User(String login, String pass) {
            this.login = login;
            this.password = pass;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static User authInfo() {
        return new User(login, password);
    }

    public static User unregAuthData() {
        return new User(unregLogin, unregPassword);
    }
    public static User emptyAuthData() {
        return new User(emptyLogin, emptyPassword);
    }
    public static User spaceAuthData() {
        return new User(spaceLogin, spacePassword);
    }
    public static User kirilAuthData() {
        return new User(kirilLogin, kirilPassword);
    }
    public static User XSSAuthData() {
        return new User(XSS, XSS);
    }
    public static User SQLAuthData() {
        return new User(SQL, SQL);
    }

    public static class ToastMatcher extends TypeSafeMatcher<Root> {

        @Override
        public void describeTo(Description description) {
            description.appendText("is toast");
        }

        @Override
        public boolean matchesSafely(Root root) {
            int type = root.getWindowLayoutParams().get().type;
            if (type == WindowManager.LayoutParams.TYPE_TOAST) {
                IBinder windowToken = root.getDecorView().getWindowToken();
                IBinder appToken = root.getDecorView().getApplicationWindowToken();
                if (windowToken == appToken) {
                    return true;
                }
            }
            return false;
        }
    }
    public ViewInteraction toast(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }
}