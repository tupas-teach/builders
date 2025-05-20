-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2025 at 09:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tupas.residentcial`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_client`
--

CREATE TABLE `tbl_client` (
  `c_id` int(25) NOT NULL,
  `p_id` int(10) NOT NULL,
  `u_id` int(11) NOT NULL,
  `p_name` varchar(255) NOT NULL,
  `u_fn` varchar(255) NOT NULL,
  `worker_assign` varchar(255) NOT NULL,
  `c_date` date NOT NULL,
  `c_duedate` date NOT NULL,
  `c_status` varchar(255) NOT NULL,
  `c_email` varchar(255) NOT NULL,
  `c_gender` varchar(255) NOT NULL,
  `accept` varchar(255) NOT NULL,
  `approval` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_client`
--

INSERT INTO `tbl_client` (`c_id`, `p_id`, `u_id`, `p_name`, `u_fn`, `worker_assign`, `c_date`, `c_duedate`, `c_status`, `c_email`, `c_gender`, `accept`, `approval`) VALUES
(1, 2, 2, 'project 3 village', 'dave', 'dave', '2025-06-10', '2025-08-11', 'active', 'ironman@gmail.com', 'male', 'Accepted', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD PRIMARY KEY (`c_id`),
  ADD KEY `pid` (`p_id`),
  ADD KEY `u-id` (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_client`
--
ALTER TABLE `tbl_client`
  MODIFY `c_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD CONSTRAINT `tbl_client_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
