package ru.iteco.fmhandroid.ui.data;

import java.util.Random;

public class Data {

    public static final String login = "login2";
    public static final String password = "password2";

    public static final String unregLogin = "login";
    public static final String unregPassword = "password";

    public static final String emptyLogin = " ";
    public static final String emptyPassword = " ";

    public static final String spaceLogin = " login2 ";
    public static final String spacePassword = " password2 ";

    public static final String kirilLogin = "логин2";
    public static final String kirilPassword = "пассворд2";

    public static final String XSS = "<script>alert(‘Hello’)</script>";
    public static final String SQL = "1’ or ‘1’ = ‘1";

    public static class Rand {
        static final Random rand = new Random();
        public static String randomCategory() {
            String[] category = {
                    "Объявление",
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            return category[rand.nextInt(category.length)];
        }
    }

    public static final String from = "17.08.2024";
    public static final String to = "18.08.2024";

    public static final String fromFutureDay = "18.08.2025";
    public static final String toFutureDay = "18.08.2025";

}