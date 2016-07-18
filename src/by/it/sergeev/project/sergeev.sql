-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 18 2016 г., 22:53
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `sergeev`
--

-- --------------------------------------------------------

--
-- Структура таблицы `ad`
--

CREATE TABLE `ad` (
  `ID` int(11) NOT NULL,
  `Electronics` varchar(50) NOT NULL COMMENT 'электроника',
  `Manufacturer` varchar(50) NOT NULL COMMENT 'производитель',
  `Name` varchar(50) NOT NULL COMMENT 'название',
  `Model` varchar(50) NOT NULL COMMENT 'модель',
  `Price` int(11) NOT NULL COMMENT 'цена',
  `Description` varchar(10000) NOT NULL COMMENT 'Описание',
  `FK_Users` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Объявление';

--
-- Дамп данных таблицы `ad`
--

INSERT INTO `ad` (`ID`, `Electronics`, `Manufacturer`, `Name`, `Model`, `Price`, `Description`, `FK_Users`) VALUES
(1, 'electronics', 'manufacturerккк', 'name', 'model', 3, 'description', 1),
(2, 'notebooks', 'Apple', 'Macbook Pro 15', 'MJLT2', 4799, '15.4" 2880 x 1800 глянцевый, Intel Core i7 2500 МГц, 16 ГБ, 512 Гб (SSD), AMD Radeon R9 M370X, OS X, цвет корпуса серебристый', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`ID`, `Role`) VALUES
(1, 'administrator'),
(2, 'user');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Login` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Name` varchar(50) NOT NULL COMMENT 'имя',
  `Lastname` varchar(50) NOT NULL COMMENT 'фамилия',
  `Address` varchar(50) NOT NULL COMMENT 'адрес',
  `Email` varchar(100) NOT NULL,
  `FK_Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Login`, `Password`, `Name`, `Lastname`, `Address`, `Email`, `FK_Role`) VALUES
(1, 'Spec', '123456', 'Dmitry', 'Sergeev', 'Minsk st.Esenina 57', 'specmedia@yandex.ru', 1),
(2, 'admin', 'admin', 'admin', 'admin', 'address', 'admin@gmail.com', 1),
(4, 'UserLogin', 'UserPassword', 'name', 'lastname', 'address', 'email@gmail.com', 2),
(5, 'UserLogin1', 'UserPassword1', 'name1', 'lastname1', 'address1', 'em1ail@gmail.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `ad`
--
ALTER TABLE `ad`
  ADD PRIMARY KEY (`ID`) USING HASH;

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `ad`
--
ALTER TABLE `ad`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
