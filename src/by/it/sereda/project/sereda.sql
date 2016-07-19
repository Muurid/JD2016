-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:2016
-- Время создания: Июл 19 2016 г., 16:20
-- Версия сервера: 10.1.10-MariaDB
-- Версия PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `sereda`
--

-- --------------------------------------------------------

--
-- Структура таблицы `rent`
--

CREATE TABLE `rent` (
  `ID` int(11) NOT NULL,
  `RoomCount` int(11) NOT NULL COMMENT 'Число комнат',
  `Price` int(11) NOT NULL COMMENT 'Цена',
  `Rating` decimal(10,0) NOT NULL COMMENT 'Площадь',
  `Floor` int(11) NOT NULL COMMENT 'Этаж',
  `Guests` int(11) NOT NULL COMMENT 'Этажность дома',
  `Address` varchar(500) NOT NULL COMMENT 'Адрес',
  `Hotels` varchar(10000) NOT NULL COMMENT 'Описание',
  `FK_Users` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Предложения номеров';

--
-- Дамп данных таблицы `rent`
--

INSERT INTO `rent` (`ID`, `RoomCount`, `Price`, `Rating`, `Floor`, `Guests`, `Address`, `Hotels`, `FK_Users`) VALUES
(1, 2, 65, '9', 0, 2, '1 Держинского проспект Минск Беларусь', 'Реннесанс Минск', 2),
(10, 3, 110, '9', 4, 6, 'Улица Липская 5, Киев, 01021, Украина', 'Отель Национальный', 1),
(12, 2, 100, '10', 0, 1, '24 Kugu Street Рига Латвия ', 'Radisson Blu Daugava', 1),
(13, 2, 120, '9', 2, 4, 'Grzybowska 63, Warsaw, 00-844, Poland\r\n', 'Hilton Warsaw Hotel', 1),
(14, 1, 100, '9', 1, 3, 'ul. Wspolna 72, Средместье, 00-687 Варшава, Польша', 'Hampton by Hilton', 1),
(18, 1, 130, '10', 0, 2, 'Bolesława Prusa 2, Средместье, 00-493 Варшава, Польша', 'Hotel Bristol', 1),
(20, 1, 100, '10', 0, 1, 'Marlene-Dietrich-Platz 2, Митте, 10785 Берлин, Германия', 'Grand Hyatt', 1),
(21, 2, 70, '5', 2, 2, 'TEST: пр. Держинского, д.1, Минск, Беларусь', 'TEST: Метрополь Москва', 6);

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
(2, 'user'),
(3, 'hotel');

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
(1, 'admin', 'padmin', 'admin@it.by', 1),
(2, 'user', 'user', 'user@mail.ru', 2),
(3, 'logintest', 'emailtest', 'passtest', 1),
(4, 'raddison', 'radisonpass', 'hotel@raddison.com', 3),
(5, 'hotel2012', '2012', 'hotel2012@gmail.com', 3),
(6, 'UserLogin', 'UserPassword', 'email@gmail.com', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `rent`
--
ALTER TABLE `rent`
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
-- AUTO_INCREMENT для таблицы `rent`
--
ALTER TABLE `rent`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
