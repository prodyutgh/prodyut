-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2017 at 06:47 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `javaecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `product_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq2yge7ebtfuvwufr6lwfwqy9l` (`product_id`),
  KEY `FK3hehkm8chhgh8lhhdt8jfuw7b` (`supplier_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `quantity`, `product_id`, `supplier_id`, `product_title`) VALUES
(1, 6, 2, 9, 'Vivaan test 1 product changed'),
(2, 7, 1, 9, 'Vivaan test 3 product');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `total_amount` double NOT NULL,
  `updated_on` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgw5embugoja0n0665j3f5mfxd` (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `created_on`, `description`, `order_no`, `total_amount`, `updated_on`, `customer_id`) VALUES
(4, '2017-03-26 21:10:22', 'Scott Mens Basic Cotton Round Neck Half Sleeve Solid T-shirts - Pack of 3<br/>Inkovy Full sleeve Men''s cotton Hooded T-shirt<br/>Fanideaz Branded Hooded Cotton Black Zipper Jacket Sleeveless TShirt for Men<br/>', 'ord0e9d1ad', 0, '2017-03-26 21:11:01', 3),
(8, '2017-03-27 05:03:17', 'Scott Mens Basic Cotton Round Neck Half Sleeve Solid T-shirts - Pack of 3<br/>Inkovy Full sleeve Men''s cotton Hooded T-shirt<br/>Fanideaz Branded Hooded Cotton Black Zipper Jacket Sleeveless TShirt for Men<br/>Seven Rocks Men''s V-Neck Cotton Tshirt ...', 'ordabdee70', 2315, '2017-03-27 05:04:26', 3),
(9, '2017-04-20 10:41:33', 'Scott Mens Basic Cotton Round Neck Half Sleeve Solid T-shirts - Pack of 3<br/>Seven Rocks Men''s V-Neck Cotton Tshirt "V-Neck Tshirt"<br/>', 'orda4fdf05', 2814, '2017-04-20 10:46:36', 3);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE IF NOT EXISTS `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjyu2qbqt8gnvno9oe9j2s2ldk` (`order_id`),
  KEY `FK4q98utpd73imf4yhttm3w0eax` (`product_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `quantity`, `order_id`, `product_id`) VALUES
(12, 2, 4, 1),
(13, 1, 4, 2),
(14, 2, 4, 5),
(15, 1, 4, 7),
(25, 1, 8, 2),
(26, 2, 8, 5),
(27, 1, 8, 7),
(28, 1, 8, 1),
(29, 5, 9, 2),
(30, 1, 9, 1);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `product_category_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe05mpyhp4howtq8q4s65wm3q8` (`product_category_id`),
  KEY `FKonrw72p32knh7l81c9hgyp17c` (`supplier_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`, `type`, `product_category_id`, `quantity`, `supplier_id`, `image_name`) VALUES
(1, 'This T-Shirt is made up of 100% Cotton Single Jersey fabric. It is bio-washed and softener treated which makes the fabric ultra soft in touch and feel. The fabric does not pill and the color will not fade easily.The fabric GSM is 190.', 'Seven Rocks Men''s V-Neck Cotton Tshirt "V-Neck Tshirt"', 569, '1', 3, 12, 1, '1.jpg'),
(2, 'Refresh your clothing with the awesome collection of Round Neck Tees from Scott International. These t shirts Basic and are made of 100% Combed Cotton and make a comfort wear for all seasons. ', 'Scott Mens Basic Cotton Round Neck Half Sleeve Solid T-shirts - Pack of 3', 449, '1', 3, 14, 1, '2.jpg'),
(5, 'Keep your dressing cool and classic with this solid tee from Inkovy. You can match it with a pair of coloured jeans or chinos, and casual shoes for a day out with friends', 'Inkovy Full sleeve Men''s cotton Hooded T-shirt', 349, '1', 3, 15, 4, '5.jpg'),
(6, 'The Tshirt is made of 100% Cotton Fabric. It has a Henley neck. It comes in Regular Fit.', 'GRITSTONES Men Black Henley T-Shirt-GSCLHLY720BLK', 315, '1', 3, 5, 4, '6.jpg'),
(7, 'dfg dfg dfg', 'Fanideaz Branded Hooded Cotton Black Zipper Jacket Sleeveless TShirt for Men', 599, '1', 3, 7, 2, '7.jpg'),
(8, 'Pattern: Solid\r\nMaterial: 100% Cotton Fabric\r\nWash Care- Wash with similar colors, Dry Promptly, Steam iron, Do Not bleach, Do not wring.\r\nNeck: Round\r\nSleeves Type: Sleeves Less', 'Gritstones Men''s Button Front Cotton T-Shirt', 394, '1', 3, 6, 2, '8.jpg'),
(9, 'The U.S. Polo Assn. brand captures the authenticity of the sport - Polo, while reflecting its rich history and staying true to its roots in Classic American Style, updated to complement today''s on-the-go lifestyle.', 'U.S. Polo Assn. Men''s T-Shirt', 1050, '1', 3, 14, 2, '9.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `product_categories`
--

CREATE TABLE IF NOT EXISTS `product_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `product_categories`
--

INSERT INTO `product_categories` (`id`, `name`) VALUES
(1, 'Electronics'),
(2, 'Automobiles'),
(3, 'Clothes');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_CUSTOMER'),
(2, 'ROLE_SUPPLIER'),
(3, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`, `role_id`) VALUES
(1, 'p@test.com', 'Pankaj', 'Kumar', 'test@123', 2),
(2, 'anuj@test.com', 'Anuj', 'Kumar', 'test@123', 2),
(3, 'm@test.com', 'Manish', 'Sharma', 'test@123', 1),
(4, 'admin@test.com', 'Manish', 'Admin', 'test@123', 3),
(6, 'mac@test.com', 'Mac', 'Kennith', 'mac', 1),
(7, 'ankit.mittal@test.com', 'Ankit', 'Mittal test', NULL, 1),
(9, 'vivaan@test.com', 'Vivaan', 'Sharma', 'test@123', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_cart`
--

CREATE TABLE IF NOT EXISTS `user_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` datetime DEFAULT NULL,
  `updated_on` datetime DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkrrosoq9uogpv7il806ebp69s` (`product_id`),
  KEY `FKli87yrb5lroj3kkesp5avv1rs` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user_customers`
--

CREATE TABLE IF NOT EXISTS `user_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `billing_address` varchar(255) DEFAULT NULL,
  `cardno_last4digit` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `shipping_address` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pcngqfmcb3aeu2u53mbhxjkgn` (`user_id`),
  KEY `FKrotbv0kf8oo1ix8p9vtoxdj8m` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user_customers`
--

INSERT INTO `user_customers` (`id`, `billing_address`, `cardno_last4digit`, `mobile_no`, `shipping_address`, `user_id`) VALUES
(1, NULL, NULL, NULL, NULL, 3),
(3, NULL, NULL, NULL, NULL, 6),
(4, NULL, NULL, NULL, NULL, 7);

-- --------------------------------------------------------

--
-- Table structure for table `user_suppliers`
--

CREATE TABLE IF NOT EXISTS `user_suppliers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7g6dlsgtyg0jkj2ioej7chou4` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user_suppliers`
--

INSERT INTO `user_suppliers` (`id`, `user_id`) VALUES
(1, 1),
(2, 2),
(4, 9);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `FK3hehkm8chhgh8lhhdt8jfuw7b` FOREIGN KEY (`supplier_id`) REFERENCES `user_suppliers` (`user_id`),
  ADD CONSTRAINT `FKq2yge7ebtfuvwufr6lwfwqy9l` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKgw5embugoja0n0665j3f5mfxd` FOREIGN KEY (`customer_id`) REFERENCES `user_customers` (`user_id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK4q98utpd73imf4yhttm3w0eax` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKe05mpyhp4howtq8q4s65wm3q8` FOREIGN KEY (`product_category_id`) REFERENCES `product_categories` (`id`),
  ADD CONSTRAINT `FKonrw72p32knh7l81c9hgyp17c` FOREIGN KEY (`supplier_id`) REFERENCES `user_suppliers` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `user_cart`
--
ALTER TABLE `user_cart`
  ADD CONSTRAINT `FKkrrosoq9uogpv7il806ebp69s` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKli87yrb5lroj3kkesp5avv1rs` FOREIGN KEY (`customer_id`) REFERENCES `user_customers` (`user_id`);

--
-- Constraints for table `user_customers`
--
ALTER TABLE `user_customers`
  ADD CONSTRAINT `FKrotbv0kf8oo1ix8p9vtoxdj8m` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_suppliers`
--
ALTER TABLE `user_suppliers`
  ADD CONSTRAINT `FKsuqx52bw9ova95t3mrxecosur` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
