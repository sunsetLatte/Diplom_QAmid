# План тестирования мобильного приложения "Мобильный хоспис"

### Введение
Целью создания данного плана является описание процесса тестирования мобильного приложения "Мобильный хоспис" с помощью ручного и автоматизированного методов.

## 1. Планирование (5ч)
- **Определение границ приложения**: Определить основные функциональные и нефункциональные требования к приложению. Уточнить ожидаемое поведение приложения в различных сценариях использования.
- **Реализованный функционал**: Подтвердить, что функциональность приложения соответствует требованиям.
- **Основа для тестов**: Создать структуру для тестовых сценариев и чек-листа, которая будет включать все аспекты приложения.

###  Типы тестирования
- **Функциональное тестирование**: Проверка соответствия реализованных функций спецификациям требований.
- **Нефункциональное тестирование**: Оценка производительности, безопасности, удобства использования. 
- **Интеграционное тестирование**: Проверка взаимодействия Android приложения с API.
- **Исследовательское тестирование**: Изучение приложения, исследование сценариев и проектирование возможных тестов.

## 2. Чек-лист (5ч)
- **Регистрация и вход**: Проверка авторизации пользователя, проверка ошибок авторизации (авторизация несуществующим пользователем и с неверным паролем), logout.
- **Проверка безопасности**: Тестирование на XSS и SQL-инъекции.
- **Главный экран**: Проверка отображения страницы, взаимодействия с контентом.
- **Новостная сводка**: Проверка отображения новостей, взаимодействия с контентом (сортировка, фильтрация, добавление новой новости и изменение/удаление существующей).
- **Тематические цитаты**: Проверка отображения цитат.
- **О приложении**: Проверка отображения страницы и перехода по ссылкам.

## 3. Тест-кейсы (30ч)
- Создание тест-кейсов для каждого пункта чек-листа.
- Дополнение тест-кейсов по мере выявления новых требований и функционала.

## 4. Ручное тестирование (5ч)
- Проведение ручного тестирования по всем пунктам тест-кейсов.
- Внесение результатов проверок в файлы чек-листа и тест-кейсов.

### Для итогового отчета по ручному тестированию будут взяты результаты по следующим пунктам:
- работа приложения на светлой/темной теме ОС; 
- при разных ориентациях экрана;
- работа при разных настройках сети 3G/2G, Wi-Fi;
- без подключения к сети и в режиме "В самолете";
- всплывающие окна о поступлении SMS и входящего вызова.

## 5. Автоматизация проверки приложения (85ч)

### Настройка проекта перед написанием UI-тестов (5ч)
- **Добавление библиотек**: Включить в проект библиотеки для автоматизации тестирования, например, Appium, Espresso.
- **Директория для тестов**: Создать директорию в проекте для хранения тестовых скриптов.

### Написание UI-тестов(80ч)
- **Тесты**: Разработать тесты, имитирующие действия пользователя и проверяющие ключевые функции приложения.
- **Проверки**: Убедиться, что каждое действие в тесте сопровождается соответствующей проверкой ожидаемого результата.


### Для итогового отчета по автоматизированному тестированию будут взяты результаты по следующим пунктам:
- авторизация пользователя при различных вариациях логина и пароля (зарегистрированные, незарегистрированные, кириллицей, с пробелами);
- тестирование безопасности;
- работа с новостной лентой — чтение новостей, сортировка, фильтрация, создание и редактирование новости;
- взаимодействие с контентом на страницах цитат и "О приложении";
- навигация по приложению.


## 6. Отчет о тестировании (20ч)

### Подключение Allure к проекту (5ч)
- **Зависимости**: Добавить в проект зависимости для интеграции с Allure.
- **Интеграция**: Настройка интеграции с Allure Server.

### Разметка тестов для отчёта (9ч)
- **Названия функциональностей**: Добавить в тесты метки с названиями проверяемых функций.
- **Описания тестов**: Добавить описания тестов, чтобы в отчетах было понятно, что именно проверяется.
- **Шаги**: Описать шаги внутри тестов для отображения в отчетах.

### Составление отчёта (6ч)
- **Проверка работоспособности**: Убедиться, что отчеты полные и информативные.
- **Выгрузка отчетов**: Настроить процесс экспорта отчетов с мобильных устройств. 

## 7. Перечень и описание возможных рисков

- Автоматизация небольшого проекта может оказаться нецелесообразной, учитывая затраченное на написание и реализацию тестов время, в сравнении с мануальным тестированием.
- Возможно изменение используемого языка прииложения, текста в полях приложения и всплывающих окон. Что вызовет постоянную необходимость обновления тестов.
- Затруднения и сбои при написании и отладке тестов.

## 8. Время, заложенное на непредвиденные ситуации
- 30ч.

## 9. Используемые инструменты
- **Операцинная система**: Windows 11 Pro
- **Устройтва**: Samsung Galaxy A05, эмулятор Android API 29 — как один из наиболее распространенных.
- **Ухарактеристики настроек при создании эмулятора**: name — Pixel 6a, Size 6.13, Resolution 1080x2220, Density 440 dpi, API Level 29, ABI x86, Target Android 10.
- **Версии Android**: смартфон — 14, эмулятор — 10.
- **IDE**: Android Studio — для сборки приложения, проведения автоматизированного тестирования, IntelliJ IDEA — удобная платформа для написания кода и тестов.
- **Язык программирования**: Java - широко используемый язык программирования для разработки и тестирования web и mobile приложений.
- **Автотесты**: Espresso или Appium для Android приложений — для создания автоматизированных UI-тестов для Android.
- **Отчеты**: Allure Framework — используется для визуализации результатов тестирования.
- **Система контроля версий**: Git и Github — для хранения документации, кода приложения и автотестов, отчета о тестировании.

## 10. Критерии начала и окончания тестирования
### Начало
- Готовность тестовой платформы, законченность разработки требуемого функционала и наличие всей необходимой документации.

### Окончание
- Прекращение тестирования, когда не осталось багов с Severity: Critical и Major.
  
## 11. Перечень необходимых специалистов для проведения тестирования
- QA инженер, владеющий навыками ручного и автоматизированного тестирования и работающий на Java, Kotlin, в IntelliJ IDEA, Android Studio, Espresso или Appium, Allure.
 
## 12. Планируемое время выполнения работы
- 150–180ч.