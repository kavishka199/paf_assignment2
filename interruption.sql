-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 12:54 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `interruption`
--

-- --------------------------------------------------------

--
-- Table structure for table `interruption`
--

CREATE TABLE `interruption` (
  `interruptionID` varchar(10) NOT NULL,
  `interruptionName` varchar(10) NOT NULL,
  `interruptionDate` varchar(10) NOT NULL,
  `interruptionAdd` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `interruption`
--

INSERT INTO `interruption` (`interruptionID`, `interruptionName`, `interruptionDate`, `interruptionAdd`) VALUES
('2', 'asanka', '02/04/2022', '20,alawatugoda matale'),
('33', 'dineth', '312', 'zcxc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interruption`
--
ALTER TABLE `interruption`
  ADD PRIMARY KEY (`interruptionID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
