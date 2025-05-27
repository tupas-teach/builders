-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 12:30 PM
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
-- Table structure for table `otp_requests`
--

CREATE TABLE `otp_requests` (
  `id` int(11) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `otp_code` varchar(6) NOT NULL,
  `expiry_time` datetime NOT NULL,
  `is_used` tinyint(4) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `otp_requests`
--

INSERT INTO `otp_requests` (`id`, `user_email`, `otp_code`, `expiry_time`, `is_used`, `created_at`) VALUES
(1, 'warkoman05@gmail.com', '383458', '2025-05-16 03:07:51', 1, '2025-05-16 09:57:51'),
(2, 'warkoman05@gmil.com', '023058', '2025-05-16 03:20:33', 0, '2025-05-16 10:10:33'),
(3, 'warkoman05@gmil.com', '573847', '2025-05-16 03:22:28', 0, '2025-05-16 10:12:28'),
(4, 'warkoman05@gmail.com', '263416', '2025-05-16 03:24:08', 0, '2025-05-16 10:14:08'),
(5, 'alexded192@gmail.com', '157928', '2025-05-27 15:18:20', 1, '2025-05-27 07:08:20'),
(6, 'mike@stcecilia.edu.ph', '944007', '2025-05-27 15:21:15', 0, '2025-05-27 07:11:15'),
(7, 'warkoman05@gmail.com', '822192', '2025-05-27 15:24:48', 1, '2025-05-27 07:14:48'),
(8, 'warkoman05@gmail.com', '255352', '2025-05-27 15:36:02', 1, '2025-05-27 07:26:02'),
(9, 'warkoman05@gmail.com', '804723', '2025-05-27 17:37:16', 1, '2025-05-27 09:27:16'),
(10, 'tupasdave76@gmail.com', '725122', '2025-05-27 18:28:39', 1, '2025-05-27 10:18:39'),
(11, 'tupasdave76@gmail.com', '486707', '2025-05-27 18:30:19', 1, '2025-05-27 10:20:19');

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
  `c_budget` varchar(255) NOT NULL,
  `c_status` varchar(255) NOT NULL,
  `c_email` varchar(255) NOT NULL,
  `c_gender` varchar(255) NOT NULL,
  `accept` varchar(255) NOT NULL,
  `approval` varchar(255) NOT NULL,
  `c_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_client`
--

INSERT INTO `tbl_client` (`c_id`, `p_id`, `u_id`, `p_name`, `u_fn`, `worker_assign`, `c_date`, `c_duedate`, `c_budget`, `c_status`, `c_email`, `c_gender`, `accept`, `approval`, `c_image`) VALUES
(1, 2, 8, 'project 3 village', 'mikes', 'mike', '2025-05-16', '2025-05-31', '', 'active', 'mark@gmailo.com', 'male', 'Pending', 'Waiting Approval', 'src/userimages/Screenshot (18).png');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `l_action` varchar(255) NOT NULL,
  `l_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`l_id`, `u_id`, `l_action`, `l_timestamp`) VALUES
(1, 1, 'Login Success', '2025-05-15 11:56:51'),
(2, 1, 'Login', '2025-05-15 15:01:42'),
(3, 1, 'Login', '2025-05-15 15:17:07'),
(4, 1, 'Login', '2025-05-15 15:18:34'),
(5, 1, 'Login', '2025-05-15 15:23:29'),
(6, 1, 'Login', '2025-05-15 15:25:38'),
(8, 4, 'Login', '2025-05-15 15:31:03'),
(9, 4, 'Login', '2025-05-15 15:50:45'),
(10, 1, 'Login', '2025-05-15 15:51:02'),
(11, 1, 'Login', '2025-05-15 15:57:22'),
(12, 1, 'Login', '2025-05-15 16:04:00'),
(13, 1, 'Login', '2025-05-15 16:06:50'),
(14, 1, 'Login', '2025-05-15 16:10:04'),
(15, 1, 'Login', '2025-05-15 16:17:41'),
(16, 1, 'Login', '2025-05-15 16:19:41'),
(17, 1, 'Login', '2025-05-16 01:09:32'),
(18, 1, 'Login', '2025-05-16 01:12:17'),
(19, 1, 'Login', '2025-05-16 01:17:53'),
(20, 1, 'Login', '2025-05-16 01:21:05'),
(21, 1, 'Login', '2025-05-16 04:26:04'),
(22, 1, 'Login', '2025-05-16 04:31:32'),
(23, 1, 'Login', '2025-05-16 04:34:30'),
(24, 1, 'Login', '2025-05-16 04:35:14'),
(25, 1, 'Login', '2025-05-16 04:47:20'),
(26, 1, 'Login Failed - Wrong Password', '2025-05-16 04:53:38'),
(27, 1, 'Login Failed - Wrong Password', '2025-05-16 04:53:51'),
(28, 1, 'Login Failed - Wrong Password', '2025-05-16 04:53:59'),
(29, 2, 'Login', '2025-05-16 04:54:16'),
(30, 2, 'Login', '2025-05-16 04:54:58'),
(31, 2, 'Login', '2025-05-16 04:55:23'),
(32, 2, 'Login', '2025-05-16 04:56:44'),
(33, 1, 'Login', '2025-05-16 04:59:43'),
(34, 1, 'Login', '2025-05-16 05:00:11'),
(35, 1, 'Login', '2025-05-16 05:03:23'),
(36, 1, 'Login', '2025-05-16 05:27:12'),
(37, 1, 'Login', '2025-05-16 05:35:41'),
(38, 1, 'Login', '2025-05-16 05:36:26'),
(39, 2, 'Login', '2025-05-16 05:38:11'),
(40, 1, 'Login', '2025-05-16 05:45:55'),
(41, 1, 'Login', '2025-05-16 05:51:54'),
(42, 1, 'Login', '2025-05-16 12:04:27'),
(43, 1, 'Login', '2025-05-16 12:05:47'),
(44, 1, 'Login', '2025-05-16 12:08:03'),
(45, 1, 'Login', '2025-05-16 12:09:31'),
(46, 1, 'Login', '2025-05-16 12:12:38'),
(47, 1, 'Login', '2025-05-16 12:16:43'),
(48, 1, 'Login', '2025-05-16 12:21:50'),
(49, 1, 'Login', '2025-05-16 12:27:19'),
(50, 1, 'Login', '2025-05-16 12:29:59'),
(51, 1, 'Login', '2025-05-16 12:32:30'),
(52, 1, 'Login', '2025-05-16 12:36:23'),
(53, 1, 'Login', '2025-05-16 12:39:07'),
(54, 1, 'Login', '2025-05-16 12:41:41'),
(55, 1, 'Login', '2025-05-16 12:46:46'),
(56, 1, 'Login', '2025-05-16 12:54:45'),
(57, 1, 'Login', '2025-05-16 12:59:05'),
(58, 1, 'Login', '2025-05-16 13:00:05'),
(59, 1, 'Login', '2025-05-16 13:02:08'),
(60, 1, 'Login Failed - Wrong Password', '2025-05-16 13:03:00'),
(61, 1, 'Login', '2025-05-16 13:03:17'),
(62, 1, 'Login', '2025-05-16 13:07:05'),
(63, 1, 'Login', '2025-05-16 13:12:20'),
(64, 2, 'Login', '2025-05-16 13:13:34'),
(65, 2, 'Login', '2025-05-16 13:16:07'),
(66, 2, 'Login', '2025-05-16 13:18:12'),
(67, 2, 'Login', '2025-05-16 13:19:48'),
(68, 2, 'Login', '2025-05-16 13:23:05'),
(69, 2, 'Login', '2025-05-16 13:26:02'),
(70, 1, 'Login', '2025-05-16 13:28:24'),
(71, 1, 'Login', '2025-05-16 14:19:05'),
(72, 1, 'Login', '2025-05-16 14:20:40'),
(73, 2, 'Login', '2025-05-16 14:21:42'),
(74, 2, 'Login', '2025-05-16 14:27:28'),
(75, 1, 'Login', '2025-05-16 14:30:17'),
(76, 1, 'Login', '2025-05-16 14:31:15'),
(77, 1, 'Login', '2025-05-16 14:38:43'),
(78, 1, 'Login Failed - Wrong Password', '2025-05-16 14:40:06'),
(79, 1, 'Login', '2025-05-16 14:40:19'),
(80, 7, 'Login', '2025-05-16 14:43:05'),
(81, 1, 'Login', '2025-05-16 15:08:52'),
(82, 1, 'Login', '2025-05-16 15:17:12'),
(83, 1, 'Login', '2025-05-16 15:18:04'),
(84, 1, 'Login', '2025-05-16 23:07:30'),
(85, 1, 'Login', '2025-05-16 23:11:40'),
(86, 1, 'Login', '2025-05-16 23:12:53'),
(87, 1, 'Login', '2025-05-16 23:13:54'),
(88, 1, 'Login', '2025-05-17 00:02:29'),
(89, 1, 'Login', '2025-05-17 00:07:08'),
(90, 1, 'Login', '2025-05-17 00:08:49'),
(91, 1, 'Login', '2025-05-17 00:12:38'),
(92, 1, 'Login', '2025-05-17 00:25:07'),
(93, 1, 'Login', '2025-05-17 00:27:42'),
(94, 1, 'Login', '2025-05-17 00:28:03'),
(95, 1, 'Login', '2025-05-17 00:29:44'),
(96, 1, 'Login', '2025-05-17 00:36:40'),
(97, 1, 'Login', '2025-05-17 00:40:19'),
(98, 1, 'Login Failed - Wrong Password', '2025-05-17 00:46:18'),
(99, 1, 'Login Failed - Wrong Password', '2025-05-17 00:46:30'),
(100, 1, 'Login', '2025-05-17 00:46:39'),
(101, 1, 'Login', '2025-05-17 00:51:07'),
(102, 1, 'Login', '2025-05-17 01:23:05'),
(103, 1, 'Login', '2025-05-17 01:30:32'),
(104, 1, 'Login', '2025-05-17 01:33:06'),
(105, 1, 'Login', '2025-05-17 01:33:32'),
(106, 2, 'Login', '2025-05-17 01:36:59'),
(107, 1, 'Login', '2025-05-17 01:42:52'),
(108, 1, 'Login', '2025-05-17 01:43:58'),
(109, 1, 'Login', '2025-05-17 01:44:33'),
(110, 1, 'Login', '2025-05-17 07:07:54'),
(111, 1, 'Login', '2025-05-17 07:10:13'),
(112, 1, 'Login', '2025-05-17 07:39:08'),
(113, 1, 'Login', '2025-05-17 08:00:02'),
(114, 1, 'Login', '2025-05-17 08:17:43'),
(115, 2, 'Login Failed - Wrong Password', '2025-05-17 08:20:50'),
(116, 2, 'Login', '2025-05-17 08:20:59'),
(117, 2, 'Login', '2025-05-17 08:26:16'),
(118, 1, 'Login', '2025-05-18 01:23:04'),
(119, 2, 'Login', '2025-05-18 01:31:03'),
(120, 2, 'Login', '2025-05-18 01:42:42'),
(121, 2, 'Login', '2025-05-18 01:51:39'),
(122, 1, 'Login', '2025-05-18 02:47:41'),
(123, 2, 'Login', '2025-05-18 03:01:35'),
(124, 2, 'Login', '2025-05-18 03:06:56'),
(125, 2, 'Login', '2025-05-18 03:11:40'),
(126, 1, 'Login', '2025-05-18 03:15:56'),
(127, 1, 'Login', '2025-05-18 03:17:45'),
(128, 1, 'Login', '2025-05-18 03:19:01'),
(129, 2, 'Login', '2025-05-18 03:21:37'),
(130, 2, 'Login', '2025-05-18 03:27:11'),
(131, 2, 'Login', '2025-05-18 03:30:26'),
(132, 2, 'Login', '2025-05-18 03:38:20'),
(133, 2, 'Login Failed - Wrong Password', '2025-05-18 03:40:57'),
(134, 2, 'Login', '2025-05-18 03:41:07'),
(135, 2, 'Login', '2025-05-18 03:46:06'),
(136, 2, 'Login', '2025-05-18 03:57:53'),
(137, 1, 'Login', '2025-05-18 04:02:51'),
(138, 2, 'Login', '2025-05-18 04:04:20'),
(139, 2, 'Login', '2025-05-18 04:07:25'),
(140, 2, 'Login', '2025-05-18 04:25:33'),
(141, 8, 'Login Failed - Wrong Password', '2025-05-23 06:36:02'),
(142, 8, 'Login', '2025-05-23 06:36:05'),
(143, 8, 'Login', '2025-05-23 06:40:02'),
(144, 8, 'Login', '2025-05-23 06:52:16'),
(145, 8, 'Login', '2025-05-23 06:58:42'),
(146, 8, 'Login', '2025-05-23 07:15:14'),
(147, 8, 'Login', '2025-05-23 07:28:45'),
(148, 8, 'Login', '2025-05-23 07:32:57'),
(149, 8, 'Login', '2025-05-23 07:37:13'),
(150, 8, 'Login', '2025-05-23 07:39:20'),
(151, 8, 'Login', '2025-05-23 07:44:53'),
(152, 8, 'Login', '2025-05-23 07:48:23'),
(153, 8, 'Login', '2025-05-23 09:11:01'),
(154, 8, 'Login', '2025-05-23 09:14:37'),
(155, 2, 'Login Failed - Wrong Password', '2025-05-23 09:15:38'),
(156, 2, 'Login', '2025-05-23 09:15:44'),
(157, 2, 'Login', '2025-05-27 07:09:10'),
(158, 6, 'Login Failed - Wrong Password', '2025-05-27 07:16:15'),
(159, 6, 'Login Failed - Wrong Password', '2025-05-27 07:16:33'),
(160, 6, 'Login Failed - Wrong Password', '2025-05-27 07:16:35'),
(161, 6, 'Login Failed - Wrong Password', '2025-05-27 07:16:37'),
(162, 6, 'Login Failed - Wrong Password', '2025-05-27 07:22:29'),
(163, 6, 'Login Failed - Wrong Password', '2025-05-27 07:22:30'),
(164, 6, 'Login Failed - Wrong Password', '2025-05-27 07:22:32'),
(165, 6, 'Login Failed - Wrong Password', '2025-05-27 07:22:33'),
(166, 6, 'Login Failed - Wrong Password', '2025-05-27 07:24:32'),
(167, 6, 'Login Failed - Wrong Password', '2025-05-27 07:24:44'),
(168, 6, 'Login Failed - Wrong Password', '2025-05-27 07:24:45'),
(169, 6, 'Login Failed - Wrong Password', '2025-05-27 07:27:55'),
(170, 6, 'Login Failed - Wrong Password', '2025-05-27 07:29:27'),
(171, 6, 'Login Failed - Wrong Password', '2025-05-27 07:29:31'),
(172, 6, 'Login Failed - Wrong Password', '2025-05-27 07:32:52'),
(173, 6, 'Login Failed - Wrong Password', '2025-05-27 07:33:02'),
(174, 6, 'Login Failed - Wrong Password', '2025-05-27 07:34:15'),
(175, 6, 'Login Failed - Wrong Password', '2025-05-27 07:34:18'),
(176, 6, 'Login Failed - Wrong Password', '2025-05-27 07:34:20'),
(177, 6, 'Login Failed - Wrong Password', '2025-05-27 07:36:36'),
(178, 6, 'Login Failed - Wrong Password', '2025-05-27 07:36:38'),
(179, 8, 'Login', '2025-05-27 07:37:28'),
(180, 8, 'Login Failed - Wrong Password', '2025-05-27 07:41:43'),
(181, 8, 'Login', '2025-05-27 07:41:50'),
(182, 8, 'Login', '2025-05-27 07:43:50'),
(183, 8, 'Login', '2025-05-27 07:45:51'),
(184, 8, 'Login', '2025-05-27 07:49:18'),
(185, 8, 'Login', '2025-05-27 07:49:54'),
(186, 2, 'Login', '2025-05-27 07:54:17'),
(187, 8, 'Login', '2025-05-27 07:56:29'),
(188, 8, 'Login', '2025-05-27 07:57:00'),
(189, 8, 'Login', '2025-05-27 07:58:32'),
(190, 8, 'Login', '2025-05-27 07:59:15'),
(191, 8, 'Login Failed - Wrong Password', '2025-05-27 08:00:04'),
(192, 8, 'Login Failed - Wrong Password', '2025-05-27 08:00:15'),
(193, 8, 'Login', '2025-05-27 08:00:22'),
(194, 6, 'Login Failed - Wrong Password', '2025-05-27 08:01:59'),
(195, 8, 'Login', '2025-05-27 08:02:35'),
(196, 8, 'Login', '2025-05-27 08:04:56'),
(197, 8, 'Login', '2025-05-27 08:09:35'),
(198, 8, 'Login Failed - Wrong Password', '2025-05-27 08:13:16'),
(199, 8, 'Login', '2025-05-27 08:13:25'),
(200, 8, 'Login', '2025-05-27 08:17:50'),
(201, 8, 'Login', '2025-05-27 08:22:47'),
(202, 8, 'Login', '2025-05-27 08:26:29'),
(203, 8, 'Login', '2025-05-27 08:31:00'),
(204, 8, 'Login', '2025-05-27 08:32:13'),
(205, 8, 'Login Failed - Wrong Password', '2025-05-27 08:41:17'),
(206, 8, 'Login', '2025-05-27 08:41:24'),
(207, 8, 'Login', '2025-05-27 08:46:06'),
(208, 8, 'Login Failed - Wrong Password', '2025-05-27 09:11:55'),
(209, 8, 'Login', '2025-05-27 09:12:04'),
(210, 8, 'Login Failed - Wrong Password', '2025-05-27 09:15:11'),
(211, 8, 'Login', '2025-05-27 09:15:20'),
(212, 6, 'Login Failed - Wrong Password', '2025-05-27 09:16:16'),
(213, 6, 'Login Failed - Wrong Password', '2025-05-27 09:22:21'),
(214, 6, 'Login Failed - Wrong Password', '2025-05-27 09:22:31'),
(215, 6, 'Login Failed - Wrong Password', '2025-05-27 09:22:38'),
(216, 6, 'Login Failed - Wrong Password', '2025-05-27 09:25:39'),
(217, 6, 'Login Failed - Wrong Password', '2025-05-27 09:25:48'),
(218, 6, 'Login Failed - Wrong Password', '2025-05-27 09:28:22'),
(219, 6, 'Login', '2025-05-27 09:45:50'),
(220, 8, 'Login Failed - Wrong Password', '2025-05-27 10:16:32'),
(221, 8, 'Login Failed - Wrong Password', '2025-05-27 10:16:39'),
(222, 8, 'Login Failed - Wrong Password', '2025-05-27 10:16:49'),
(223, 8, 'Login Failed - Wrong Password', '2025-05-27 10:19:19'),
(224, 8, 'Login Failed - Wrong Password', '2025-05-27 10:19:29'),
(225, 8, 'Login Failed - Wrong Password', '2025-05-27 10:20:50'),
(226, 8, 'Login Failed - Wrong Password', '2025-05-27 10:24:55'),
(227, 1, 'Login', '2025-05-27 10:25:08'),
(228, 1, 'Login', '2025-05-27 10:27:52'),
(229, 1, 'Login', '2025-05-27 10:28:21');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_projects`
--

CREATE TABLE `tbl_projects` (
  `p_id` int(10) NOT NULL,
  `u_id` int(20) NOT NULL,
  `u_fn` varchar(255) NOT NULL,
  `p_name` varchar(255) NOT NULL,
  `p_date` date NOT NULL,
  `p_location` varchar(255) NOT NULL,
  `p_budget` varchar(255) NOT NULL,
  `p_contact` varchar(255) NOT NULL,
  `p_updatedate` date NOT NULL,
  `p_status` varchar(255) NOT NULL,
  `u_type` varchar(255) NOT NULL,
  `approval` varchar(255) DEFAULT NULL,
  `p_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_projects`
--

INSERT INTO `tbl_projects` (`p_id`, `u_id`, `u_fn`, `p_name`, `p_date`, `p_location`, `p_budget`, `p_contact`, `p_updatedate`, `p_status`, `u_type`, `approval`, `p_image`) VALUES
(1, 1, 'mike', 'Select', '2025-05-15', 'cebu', '1000', '0912345678', '2025-05-31', 'Available', 'Dave', 'decline', ''),
(2, 1, 'mike', 'project 3 village', '2025-05-16', 'Cebu', '1000000000', '0912345678', '2025-05-31', 'Available', 'mike', 'decline', ''),
(5, 2, 'Dave sala', 'project 1 owner house', '2025-05-08', 'usa', '14567', '12344556', '2025-05-08', 'Available', 'norilyn', NULL, '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(10) NOT NULL,
  `u_fn` varchar(255) NOT NULL,
  `u_middle` varchar(255) NOT NULL,
  `u_ln` varchar(255) NOT NULL,
  `u_username` varchar(255) NOT NULL,
  `u_Contact` varchar(255) NOT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` varchar(255) NOT NULL,
  `u_gender` varchar(255) NOT NULL,
  `u_email` varchar(255) NOT NULL,
  `u_status` varchar(255) NOT NULL,
  `u_image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fn`, `u_middle`, `u_ln`, `u_username`, `u_Contact`, `u_password`, `u_type`, `u_gender`, `u_email`, `u_status`, `u_image`) VALUES
(1, 'Dave', 'S', 'Tupas', 'admin', '1234567890', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'admin', 'male', 'alexded192@gmail.com', 'active', 'default.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `otp_requests`
--
ALTER TABLE `otp_requests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD PRIMARY KEY (`c_id`),
  ADD KEY `pid` (`p_id`),
  ADD KEY `u-id` (`u_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `user_id` (`u_id`);

--
-- Indexes for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `uid` (`u_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `otp_requests`
--
ALTER TABLE `otp_requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tbl_client`
--
ALTER TABLE `tbl_client`
  MODIFY `c_id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=230;

--
-- AUTO_INCREMENT for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  MODIFY `p_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_client`
--
ALTER TABLE `tbl_client`
  ADD CONSTRAINT `tbl_client_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `user_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
