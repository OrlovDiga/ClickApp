# Click App
[![Build Status](https://travis-ci.com/OrlovDiga/ClickApp.svg?branch=master)](https://travis-ci.com/OrlovDiga/ClickApp)

Testing work to Java Developer.

<details><summary>Technical assignment:</summary>
"Напишите приложение "Счетчик кликов" 
Это должно быть веб приложение которое написано на java, maven, postgresql, html, javascript, css.
Веб интерфейс должен представлять собой кнопку и цифру, клик по кнопке должен увеличивать цифру.
После перезапуска приложения цифра не должна сбрасываться.
Код приложения должен быть покрыт unit тестами.

Нужно иметь ввиду что у приложения может быть множество пользователей и счетчик должен работать корректно и не пропускать клики.

</details>

## Installation

### Use a maven

```bash
git clone git@github.com:OrlovDiga/ClickApp.git
cd PROJECT_ROOT
mvn clean package
java -jar target/click_listrener_app-0.0.1-SNAPSHOT.jar
```

Also before, you need to start Postgres database + change *```application.properties```*

You can go to ./db and execute:
```bash
docker build -t click_db .
docker run -p 5432:5432 click_db
```

### Use a docker
```bash
git clone git@github.com:OrlovDiga/ClickApp.git
cd PROJECT_ROOT
docker-compose up --build 
```

## Usage

This application has multiple entry points:

#### Public routes:

* POST */click/increment* - do click increment.
* GET */click* - get click sum.

<details><summary>Request examples:</summary>

#### */click/increment*
`POST`
```
  response
1
 ```


#### */click
`GET`
 ```
   response
1
  ```
</details>

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://github.com/OrlovDiga/ClickApp/blob/master/LICENSE)
