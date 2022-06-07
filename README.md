# Germes
## Курсовая работа по "Шаблоны программных платформ языка Джава", 4 семестр, РТУ МИРЭА
Для запуска приложения необходимо:
- клонировать репозиторий:
```
git clone https://github.com/MatweyL/Germes.git
```
- создать в **PostgreSQL 14** пользователя *germes*:
```
CREATE USER germes WITH PASSWORD 'onlyone';  
```
- создать в **PostgreSQL 14** базу данных **germes** от имени *germes* и дать пользователю *germes* нужные права доступа:
```
CREATE DATABASE germes OWNER germes;  
GRANT ALL privileges ON DATABASE germes TO germes;
``` 
- проверить, что свободны порты *8080* и *5432*
- открыть папку **target** в комндной строке и ввести команду:
```
java -jar germes-0.0.1-SNAPSHOT.jar
```
- далее нужно перейти на адрес **localhost:8080**. Это главная страница сайта, с нее можно начинать пользование приложением

![image](https://user-images.githubusercontent.com/74009572/169700287-34ffbef4-03e2-4297-8f0f-2b7004e6d11e.png)

- для входа от имени администратора необходимо ввести:  
> username: admin  
> password: admin  

