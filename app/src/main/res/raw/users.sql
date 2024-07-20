-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 20, 2024 at 02:04 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(50) NOT NULL,
  `token` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `name`, `token`) VALUES
(1, 'ashish@gmail.com', '$2y$10$zMJhbVb5XgkZQOVLzN/uoevgrelOSH2cvQ6Cdt1sv17XaHSzwgs2K', 'Ashish', NULL),
(2, 'raj@example.com', '$2y$10$CQQnxOa1ACmLLeSuq7CJjO3lNojsbF873KXP3Qems3qgVA3.AGgNO', 'Raj', NULL),
(4, 'test@example.com', '$2y$10$fJwHeb4zRW4/UM5Psizno.RXNiWGSnu6a8Qdr3uwX07KVPAWrDZqi', 'Test', '65ba963497a08036bf6cb68e80250ddb1578e51fbe69e6189888777c320e788ea16bda0785b647bda97f9329d6c7f0b1'),
(5, 'a@b.com', '$2y$10$im7.z6KAFLBsc5BH/XDsDeFYnzLwT0B/.RSfRO/5YByoaue1g2e6q', 'A', NULL),
(11, 'testnew@example.com', '$2y$10$MWWzDOp.J7oX/9G5lvF49uChaQuRrAGZ4W2l8riXnbdatAHBt/rya', 'TestNew', 'a911e5e5551edd7b0832ecee634cb70c9e5ed2769e231f3f92af1bdd9aae64faffe3ecaa9f3e1ffc887332a97af03d70'),
(10, 'test1@example.com', '$2y$10$hX53QdVjdaO5FzWxA7LpReiK3BDbc5T/mRNnXTZt1ygB4maJ3gv1O', 'Test1', '160d3f4b9d6b35c336c8c3ad0c7b5b1eaa12ac534e27ea9d42573a7c0a723966f7a2a39a6f3e369d0996a5a4a97d892e'),
(12, 'test2@example.com', '$2y$10$ksWwuwPDHWpH7LY5onfWLus8DPe0cMBUEydtYFsbQgmD9inM/FPza', 'Test2', '41c292e3d8b3e65ca2ec37087c0f9174a8ccb220f0f332f12a84fc3eb086d9d3fa5e778c58bd96aa88248a3a949db711'),
(13, 'test3@example.com', '$2y$10$Rwu2meapDp.cm0qzfQBVI.6XJNAkLYqQ3Uhn0XwgbyxviWS6OCyim', 'Test3', 'd95c51efa5ee6b46a6fabc378e5dbd5e10344c1664a9a3835b2622e302b4ba17cdfac1ccf043d5b1c0ef9e7035dcfc4f');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
