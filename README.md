# GSU-Java
6.Заказ. В БД хранится информация о заказах магазина и товарах в них. 
---
Для заказа необходимо хранить:
* номер заказа;
* товары в заказе;
* дату поступления.

Для товаров в заказе необходимо хранить:
* товар;
* количество.

Для товара необходимо хранить:
* название;
* описание;
* цену.
---
* Вывести полную информацию о заданном заказе.
* Вывести номера заказов, сумма которых не превосходит заданную, и количество различных товаров равно заданному.
* Вывести номера заказов, содержащих заданный товар.
* Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня.
* Сформировать новый заказ, состоящий из товаров, заказанных в текущий день.
* Удалить все заказы, в которых присутствует заданное количество заданного товара.
---
В каждом из заданий необходимо выполнить следующие действия:
* Организацию соединения с базой данных вынести в отдельный класс, метод которого возвращает соединение.
* Создать БД. Привести таблицы к одной из нормированных форм.
* Создать класс для выполнения запросов на извлечение информации из БД с использованием компилированных запросов.
* Создать класс на добавление информации.
* Создать HTMLдокумент с полями для формирования запроса.
Результаты выполнения запроса передать клиенту в виде HTML документа.