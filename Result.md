# Отчет о работе:

В ходе выполнения дипломной работы было проведено [ручное](https://github.com/sunsetLatte/Diplom_QAmid/tree/main/manualTesting) и [автоматизированное](https://github.com/sunsetLatte/Diplom_QAmid/tree/main/FMHandroid/app/src/androidTest/java/ru/iteco/fmhandroid/ui/tests) тестирование приложения "Мобильный хоспис".  
По [плану тестирования](Plan.md) было запланировано около 150-180 часов на выполнение работ по тестированию.  

По итогу написано 38 автотестов.  

В результате тестирования было обнаружено 14 ошибок в работе приложения.  
Заведен [Баг репорт](https://github.com/sunsetLatte/Diplom_QAmid/blob/main/BugReport.xlsx).    

В корень проекта так же загружен [отчет Allure](https://github.com/sunsetLatte/Diplom_QAmid/blob/main/FMHandroid/allure-results.zip).  

![Allure1](https://github.com/sunsetLatte/Diplom_QAmid/blob/main/FMHandroid/allure-images/Allure1.png)
![Allure2](https://github.com/sunsetLatte/Diplom_QAmid/blob/main/FMHandroid/allure-images/Allure2.png)
![Allure3](https://github.com/sunsetLatte/Diplom_QAmid/blob/main/FMHandroid/allure-images/Allure3.png)

## Затраченное время:
- ручное тестирование: создание тест-кейсов — 30ч, прохождение тестов — 3ч;
- автоматизированное тестирование: написание автотестов — 90ч, прохождение автотестов — 10мин.

## Сложности при выполнении тестирования:
- совместная работа над новостями с другими тестировщиками — новости часто добавляются новые, переименовываются и удаляются;
- приложение не всегда держит в памяти новости предыдущих дней, из-за чего могут упасть тесты, которые проходили ранее;
- из-за особенностей работы приложения необходимо актуализировать код под дату сегодняшнего дня для прохождения тестов по фильтрации;
- а так же для прохождения теста "Создание новости за сегодняшний день", тк дата изменилась.