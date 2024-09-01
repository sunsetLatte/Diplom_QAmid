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

    public static final String from = "31.08.2024";
    public static final String to = "01.09.2024";

    public static final String fromFutureDay = "20.08.2026";
    public static final String toFutureDay = "18.12.2024";

    public String getNameNews() {
        return "Тестовое объявление...";
    }

    public String getDateCreateNews(int index) {
        return dateCreateNews[index];
    }

    public String getDateCreateTodayNews(int index) {
        return dateCreateTodayNews[index];
    }

    public String getDateCreateFutureNews(int index) {
        return dateCreateFutureNews[index];
    }

    private final String[] dateCreateNews = {
            "01.09.2024",
    };

    private final String[] dateCreateTodayNews = {
            "01.09.2024",
    };

    private final String[] dateCreateFutureNews = {
            "17.12.2025",
    };

    private final String[] quotes = {
            "«Хоспис для меня - это то, каким должен быть мир.\"",
            "Хоспис в своем истинном понимании - это творчество",
            "“В хосписе не работают плохие люди” В.В. Миллионщикова\"",
            "«Хоспис – это философия, из которой следует сложнейшая наука медицинской помощи умирающим и искусство ухода, в котором сочетается компетентность и любовь» С. Сандерс",
            "Служение человеку с теплом, любовью и заботой",
            "\"Хоспис продлевает жизнь, дает надежду, утешение и поддержку.\"",
            "\"Двигатель хосписа - милосердие плюс профессионализм\"\nА.В. Гнездилов, д.м.н., один из пионеров хосписного движения.",
            "Важен каждый!"
    };

    private final String[] missionDescriptions = {
            "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, а если холодно тебя согреют.” Юля Капис, волонтер",
            "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.",
            "Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи.",
            "“Творчески и осознанно подойти к проектированию опыта умирания. Создать пространство физическое и психологическое, чтобы позволить жизни отыграть себя до конца. И тогда человек не просто уходит с дороги. Тогда старение и умирание могут стать процессом восхождения до самого конца” \n" +
                    "Би Джей Миллер, врач, руководитель проекта \"Дзен-хоспис\"",
            "\"Если пациента нельзя вылечить, это не значит, что для него ничего нельзя сделать. То, что кажется мелочью, пустяком в жизни здорового человека - для пациента имеет огромный смысл.\"",
            "\" Хоспис - это мои новые друзья. Полная перезагрузка жизненных ценностей. В хосписе нет страха и одиночества.\"\n" +
                    "Евгения Белоусова, дочь пациентки Ольги Васильевны",
            "\"Делай добро... А добро заразительно. По-моему, все люди милосердны. Нужно просто говорить с ними об этом, суметь разбудить в них чувство сострадания, заложенное от рождения\" - В.В. Миллионщикова",
            "\"Каждый, кто оказывается в стенах хосписа, имеет огромное значение в жизни хосписа и его подопечных\""
    };

    public int lengthQuotes() {
        return quotes.length;
    }

    public String getQuoteTitleByIndex(int index) {
        if (index >= 0 && index < quotes.length) {
            return quotes[index];
        } else {
            return null;
        }
    }

    public String getQuoteDescriptionByIndex(int index) {
        if (index >= 0 && index < missionDescriptions.length) {
            return missionDescriptions[index];
        } else {
            return null;
        }
    }
}