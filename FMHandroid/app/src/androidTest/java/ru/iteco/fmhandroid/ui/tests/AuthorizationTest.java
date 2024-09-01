package ru.iteco.fmhandroid.ui.tests;

import ru.iteco.fmhandroid.ui.common.BaseSteps;
import ru.iteco.fmhandroid.ui.data.Helper;
import ru.iteco.fmhandroid.ui.pages.AuthorizationPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.AppActivity;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {

    AuthorizationPage authPage = new AuthorizationPage();
    BaseSteps baseSteps = new BaseSteps();
    MainPage mainPage = new MainPage();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        try {
            authPage.waitUntilPageLoaded();

        } catch (Exception e) {
            baseSteps.logOut();
            authPage.waitUntilPageLoaded();
        }
    }

    @Test
    @DisplayName("Авторизация пользователя с зарегистрированными логином и паролем и выход из приложения")
    public void loginLogOutTest() {
        authPage.authValidLoginAndPass(Helper.authInfo());
        authPage.signIn();
        mainPage.waitUntilPageLoaded();
        baseSteps.logOut();
    }

    @Test
    @DisplayName("Авторизация пользователя с незарегистрированными логином и паролем")
    public void unregLoginAndPassTest() {
        authPage.authUnregLoginAndPass(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с незарегистрированными паролем")
    public void unregPassTest() {
        authPage.authUnregPass(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с логином и паролем с пробелами")
    public void spaceDataTest() {
        authPage.authSpaceData(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: Главная страница доступна   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с пуcтыми логином и паролем")
    public void emptyDataTest() {
        authPage.authEmptyData(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("Авторизация пользователя с логином и паролеи кириллицей")
    public void loginKirilLoginAndPassTest() {
        authPage.authKirilLoginAndPass(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с XSS-инъекцией в поле \"логин\"")
    public void loginXSSLoginTest() {
        authPage.XSSLogin(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с XSS-инъекцией в поле \"пароль\"")
    public void loginXSSPassTest() {
        authPage.XSSPass(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с SQL-инъекцией в поле \"логин\"")
    public void loginSQLLoginTest() {
        authPage.SQLLogin(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }

    @Test
    @DisplayName("Авторизация пользователя с SQL-инъекцией в поле \"пароль\"")
    public void loginSQLPassTest() {
        authPage.SQLPass(Helper.authInfo());
        authPage.signIn();
        baseSteps.checkWrongAuthDataToast();
        // Ожидаемый результат: "Wromg logim or password"
        // Фактический результат: "Something get wrong. Try again later"   BUG
    }
}