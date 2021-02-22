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

### Use a docker
```bash
git clone git@github.com:OrlovDiga/ClickApp.git
cd PROJECT_ROOT
mvn clean package (optional. else don't execute, then pull from dockerHub)
docker-compose up --build
```

## Usage

### Usage web application

Open any browser and go to http://localhost:8081/index.html

You will see this:

![alt text](https://github.com/OrlovDiga/ClickApp/blob/master/.git_files/startImage.png?raw=true)


### Usage api

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
