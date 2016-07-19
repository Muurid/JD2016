-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 19 2016 г., 21:02
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `luksha`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cars`
--

CREATE TABLE `cars` (
  `ID` int(11) NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Cost` int(11) NOT NULL,
  `Consumption` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cars`
--

INSERT INTO `cars` (`ID`, `Brand`, `Model`, `Category`, `Cost`, `Consumption`) VALUES
(1, 'BMW', '7er', 'business', 70, 12.5),
(2, 'Toyota', 'LC 200', 'off-road', 120, 15.7),
(3, 'Opel', 'Astra', 'economy', 25, 9.5),
(4, 'Batmobil', 'Spiceship', 'off-road', 1000, 100.5);

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `ID` int(11) NOT NULL,
  `FK_User` int(11) NOT NULL,
  `FK_Car` int(11) NOT NULL,
  `StartRent` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`ID`, `FK_User`, `FK_Car`, `StartRent`, `EndRent`, `TotalCost`) VALUES
(1, 1, 1, '2016-06-30 22:00:01.000000', '2016-07-02 22:00:01.000000', 500),
(2, 18, 2, '2016-07-08 07:01:10.000000', '2016-07-01 07:01:10.000000', 7733),
(3, 18, 2, '2016-07-19 03:54:16.000000', '2016-07-26 03:54:18.000000', 7733),
(4, 18, 2, '2016-07-19 04:00:42.000000', '2016-07-24 04:00:43.000000', 600),
(5, 18, 2, '2016-07-19 04:04:31.000000', '2016-07-24 04:04:34.000000', 600),
(6, 18, 2, '2016-07-19 04:04:31.000000', '2016-07-24 04:04:34.000000', 600),
(7, 18, 2, '2016-07-19 04:06:07.000000', '2016-07-25 04:06:09.000000', 720),
(8, 18, 2, '2016-07-19 04:09:35.000000', '2016-07-24 04:09:37.000000', 600),
(9, 18, 1, '2016-07-19 05:16:55.000000', '2016-07-27 05:16:56.000000', 560),
(10, 18, 4, '2016-07-20 05:18:56.000000', '2016-07-31 05:18:59.000000', 11000),
(11, 18, 2, '2016-07-20 05:20:41.000000', '2016-07-31 05:20:43.000000', 1320),
(12, 18, 3, '2016-07-19 05:25:56.000000', '2016-09-07 05:25:57.000000', 1250),
(13, 18, 4, '2016-07-20 05:53:03.000000', '2016-08-19 05:53:05.000000', 30000),
(14, 20, 4, '2016-07-07 07:02:18.000000', '2016-08-01 07:02:21.000000', 25000);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`ID`, `Name`) VALUES
(1, 'Administrator'),
(2, 'User'),
(3, 'Guest');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Login` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `FK_Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Login`, `Password`, `Email`, `FK_Role`) VALUES
(1, 'Administrator', 'admin123', 'admin@carrent.com', 1),
(2, 'User', 'qwerty123', 'admin@google.com', 2),
(3, 'CoolBoy', '12345678', 'hanson@facebook.com', 2),
(4, 'CoolGirl', '87654321', 'pretty@vk.com', 2),
(5, 'Batman', '123qwe', 'iambat@gmail.com', 2),
(18, 'test', 'test', 'test', 2),
(20, 'admin', 'admin', 'admin@mail', 1);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_Role` (`FK_Role`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`FK_Role`) REFERENCES `roles` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
