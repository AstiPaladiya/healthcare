-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2024 at 05:11 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthcare`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`id`, `user_id`, `name`, `description`, `status`, `created_at`, `updated_at`) VALUES
(1, 30, 'health', 'Hello Docotre', 'Active', '2024-11-10 13:15:52', '2024-11-10 13:15:52'),
(2, 30, 'health', 'Hello Docotre', 'Active', '2024-11-10 13:16:03', '2024-11-10 13:16:03'),
(4, 30, 'health', 'Hello Docotre', 'Active', '2024-11-10 13:16:07', '2024-11-10 13:16:07'),
(6, 30, 'Heartattack', 'Specialist', 'Block', '2024-11-10 13:16:12', '2024-11-10 13:29:16');

-- --------------------------------------------------------

--
-- Table structure for table `career`
--

CREATE TABLE `career` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `carrer_name` varchar(400) DEFAULT NULL,
  `time` varchar(400) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `experience` varchar(300) DEFAULT NULL,
  `degree` varchar(500) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `career`
--

INSERT INTO `career` (`id`, `user_id`, `carrer_name`, `time`, `description`, `experience`, `degree`, `status`, `created_at`, `updated_at`) VALUES
(1, 30, 'health', '8 to 10', 'Hello Docotre', '2 year', 'M.D.', 'Active', '2024-11-10 13:48:04', '2024-11-10 13:48:04'),
(2, 30, 'health', '8 to 10', 'Hello Docotre', '2 year', 'M.D.', 'Active', '2024-11-10 13:48:15', '2024-11-10 13:48:15'),
(3, 30, 'health', '8 to 10', 'Hello Docotre', '2 year', 'M.D.', 'Active', '2024-11-10 13:48:17', '2024-11-10 13:48:17'),
(4, 30, 'health', '8 to 10', 'Hello Docotre', '2 year', 'M.D.', 'Active', '2024-11-10 13:48:19', '2024-11-10 13:48:19'),
(6, 30, 'wellness', '8 to 10', 'Hello nurse', '1 year', 'M.S.', 'Block', '2024-11-10 13:48:23', '2024-11-10 13:55:56');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `image` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `role_id`, `name`, `description`, `image`, `status`, `created_at`, `updated_at`) VALUES
(2, 10, 'Operation', 'Hello Docotre', 'img1.jpg', 'Active', '2024-11-09 10:38:58', '2024-11-09 10:38:58'),
(3, 13, 'Heartattack', 'Specialist', 'image2.jpg', 'Block', '2024-11-09 10:39:04', '2024-11-09 10:52:22'),
(4, 10, 'Operation', 'Hello Docotre', 'img1.jpg', 'Active', '2024-11-09 10:39:11', '2024-11-09 10:39:11');

-- --------------------------------------------------------

--
-- Table structure for table `chat_master`
--

CREATE TABLE `chat_master` (
  `id` int(11) NOT NULL,
  `sender_id` int(11) DEFAULT NULL,
  `reciever_id` int(11) DEFAULT NULL,
  `message` text DEFAULT NULL,
  `reciever_by_reciever` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `checkup_booking`
--

CREATE TABLE `checkup_booking` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bussiness_id` int(11) DEFAULT NULL,
  `schedule` varchar(500) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `checkup_booking`
--

INSERT INTO `checkup_booking` (`id`, `user_id`, `bussiness_id`, `schedule`, `price`, `status`, `created_at`, `updated_at`) VALUES
(1, 30, 30, '8 to 20', 120, 'Active', '2024-11-10 18:32:16', '2024-11-10 18:32:16'),
(2, 30, 30, '8 to 20', 120, 'Active', '2024-11-10 18:32:23', '2024-11-10 18:32:23'),
(3, 30, 30, '9 to 10', 220, 'Block', '2024-11-10 18:32:25', '2024-11-10 18:40:29'),
(4, 30, 30, '8 to 20', 120, 'Active', '2024-11-10 18:32:28', '2024-11-10 18:32:28'),
(6, 30, 30, '8 to 20', 120, 'Active', '2024-11-10 18:32:34', '2024-11-10 18:32:34'),
(7, 30, 30, '8 to 20', 120, 'Active', '2024-11-10 18:45:30', '2024-11-10 18:45:30');

-- --------------------------------------------------------

--
-- Table structure for table `complain`
--

CREATE TABLE `complain` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `email` varchar(300) DEFAULT NULL,
  `complain` text DEFAULT NULL,
  `against_complain_id` int(11) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `email` varchar(300) DEFAULT NULL,
  `feedback` text DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `health_record`
--

CREATE TABLE `health_record` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `information` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `health_record`
--

INSERT INTO `health_record` (`id`, `book_id`, `information`, `status`, `created_at`, `updated_at`) VALUES
(1, 4, 'this is health report', 'Active', '2024-11-10 18:57:51', '2024-11-10 18:57:51'),
(2, 2, 'this is  report', 'Block', '2024-11-10 18:58:01', '2024-11-10 19:07:09'),
(3, 4, 'this is health report', 'Active', '2024-11-10 18:58:03', '2024-11-10 18:58:03'),
(5, 4, 'this is health report', 'Active', '2024-11-10 18:58:08', '2024-11-10 18:58:08'),
(6, 4, 'this is health report', 'Active', '2024-11-10 18:58:11', '2024-11-10 18:58:11'),
(7, 4, 'this is health report', 'Active', '2024-11-10 18:58:13', '2024-11-10 18:58:13');

-- --------------------------------------------------------

--
-- Table structure for table `health_wellness`
--

CREATE TABLE `health_wellness` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `schedule` varchar(400) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `health_wellness`
--

INSERT INTO `health_wellness` (`id`, `user_id`, `address`, `schedule`, `description`, `phone_no`, `status`, `created_at`, `updated_at`) VALUES
(1, 30, 'surat', '5 to 9', 'this is health program', 6352778198, 'Active', '2024-11-10 16:49:58', '2024-11-10 16:49:58'),
(2, 30, 'surat', '5 to 9', 'this is health program', 6352778198, 'Active', '2024-11-10 16:50:09', '2024-11-10 16:50:09'),
(3, 30, 'surat', '5 to 9', 'this is health program', 6352778198, 'Active', '2024-11-10 16:50:12', '2024-11-10 16:50:12'),
(4, 30, 'vyara', '2 to 9', 'this is wellness program', 8469892321, 'Block', '2024-11-10 16:50:14', '2024-11-10 17:07:21'),
(6, 30, 'surat', '5 to 9', 'this is health program', 6352778198, 'Active', '2024-11-10 16:50:19', '2024-11-10 16:50:19'),
(8, 30, 'surat', '5 to 9', 'this is health program', 6352778198, 'Active', '2024-11-10 16:50:20', '2024-11-10 16:50:20');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `career_id` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `resume` varchar(300) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`id`, `user_id`, `career_id`, `name`, `email`, `phone_no`, `resume`, `status`, `created_at`, `updated_at`) VALUES
(1, 30, 2, 'specialist', 'vimala@gmail.com', 6352778198, 'resume.pdf', 'Active', '2024-11-10 15:48:38', '2024-11-10 15:48:38'),
(2, 30, 2, 'specialist', 'vimala@gmail.com', 6352778198, 'resume.pdf', 'Active', '2024-11-10 15:48:47', '2024-11-10 15:48:47'),
(3, 30, 2, 'specialist', 'vimala@gmail.com', 6352778198, 'resume.pdf', 'Active', '2024-11-10 15:48:50', '2024-11-10 15:48:50'),
(5, 30, 6, 'Nusing', 'mala@gmail.com', 738299283, 'resume2.pdf', 'Block', '2024-11-10 15:48:55', '2024-11-10 15:59:09');

-- --------------------------------------------------------

--
-- Table structure for table `medical_report`
--

CREATE TABLE `medical_report` (
  `id` int(11) NOT NULL,
  `health_record_id` int(11) DEFAULT NULL,
  `report_name` varchar(400) DEFAULT NULL,
  `report_type` varchar(300) DEFAULT NULL,
  `report_date` date DEFAULT NULL,
  `report_status` varchar(200) DEFAULT NULL,
  `summery` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medical_report`
--

INSERT INTO `medical_report` (`id`, `health_record_id`, `report_name`, `report_type`, `report_date`, `report_status`, `summery`, `status`, `created_at`, `updated_at`) VALUES
(1, 5, 'specialist', 'heart', '2002-09-29', 'danger', 'this report is danger', 'Active', '2024-11-10 19:40:17', '2024-11-10 19:40:17'),
(2, 5, 'specialist', 'heart', '2002-09-29', 'danger', 'this report is danger', 'Active', '2024-11-10 19:40:24', '2024-11-10 19:40:24'),
(3, 5, 'specialist', 'heart', '2002-09-29', 'danger', 'this report is danger', 'Active', '2024-11-10 19:40:27', '2024-11-10 19:40:27'),
(5, 1, 'leg report', 'leg', '2002-09-12', 'normal', 'this report is normal', 'Block', '2024-11-10 19:40:33', '2024-11-10 19:48:02'),
(6, 5, 'specialist', 'heart', '2002-09-29', 'danger', 'this report is danger', 'Active', '2024-11-10 19:40:38', '2024-11-10 19:40:38');

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL,
  `order_master_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_master`
--

CREATE TABLE `order_master` (
  `id` int(11) NOT NULL,
  `bill_no` int(11) DEFAULT NULL,
  `buyer_user_id` int(11) DEFAULT NULL,
  `reciever_name` varchar(300) DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `email` varchar(300) DEFAULT NULL,
  `total_amount` float DEFAULT NULL,
  `selling_date` date DEFAULT NULL,
  `payment_mode` varchar(300) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `privacy_policy`
--

CREATE TABLE `privacy_policy` (
  `id` int(11) NOT NULL,
  `name` varchar(400) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `privacy_policy`
--

INSERT INTO `privacy_policy` (`id`, `name`, `description`, `status`, `created_at`, `updated_at`) VALUES
(1, 'privacy', 'This is privacy', 'Active', '2024-11-09 20:15:11', '2024-11-09 20:15:11'),
(2, 'privacy', 'This is privacy', 'Active', '2024-11-09 20:15:22', '2024-11-09 20:15:22'),
(3, 'policy', 'This is policy', 'Block', '2024-11-09 20:15:24', '2024-11-09 20:22:12'),
(6, 'privacy', 'This is privacy', 'Active', '2024-11-09 20:22:23', '2024-11-09 20:22:23'),
(7, 'privacy', 'This is privacy', 'Active', '2024-11-09 20:27:10', '2024-11-09 20:27:10');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `company_name` varchar(500) DEFAULT NULL,
  `prescription` text DEFAULT NULL,
  `medicine_name` text DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` float DEFAULT NULL,
  `img1` varchar(400) DEFAULT NULL,
  `img2` varchar(400) DEFAULT NULL,
  `img3` varchar(400) DEFAULT NULL,
  `img4` varchar(400) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `available_quantity` int(11) DEFAULT NULL,
  `offer` float DEFAULT NULL,
  `product_status` varchar(200) DEFAULT NULL,
  `blocked_by` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `category_id`, `user_id`, `company_name`, `prescription`, `medicine_name`, `description`, `price`, `img1`, `img2`, `img3`, `img4`, `quantity`, `available_quantity`, `offer`, `product_status`, `blocked_by`, `created_at`, `updated_at`) VALUES
(1, 2, 30, 'himalaya', 'himoglobin', 'sirum', 'this is  sirum medicine', 120.9, 'photo1.jpg', 'photo2.jpg', 'photo3.jpg', 'photo4.jpg', 20, 20, 20, 'Active', 30, '2024-11-11 04:25:08', '2024-11-11 04:25:08'),
(2, 2, 30, 'himalaya', 'himoglobin', 'sirum', 'this is  sirum medicine', 120.9, 'photo1.jpg', 'photo2.jpg', 'photo3.jpg', 'photo4.jpg', 20, 20, 20, 'Active', 30, '2024-11-11 04:25:23', '2024-11-11 04:25:23'),
(3, 2, 30, 'himalaya', 'himoglobin', 'sirum', 'this is  sirum medicine', 120.9, 'photo1.jpg', 'photo2.jpg', 'photo3.jpg', 'photo4.jpg', 20, 20, 20, 'Active', 30, '2024-11-11 04:25:26', '2024-11-11 04:25:26'),
(5, 4, 30, 'lekmi', 'monopoly', 'cupsiup', 'this is   medicine', 820.9, 'photo9.jpg', 'photo8.jpg', 'photo6.jpg', 'photo5.jpg', 60, 40, 20, 'Block', 30, '2024-11-11 04:25:32', '2024-11-11 05:49:45'),
(6, 2, 30, 'himalaya', 'himoglobin', 'sirum', 'this is  sirum medicine', 120.9, 'photo1.jpg', 'photo2.jpg', 'photo3.jpg', 'photo4.jpg', 20, 20, 20, 'Active', 30, '2024-11-11 04:25:35', '2024-11-11 04:25:35'),
(7, 2, 30, 'himalaya', 'himoglobin', 'sirum', 'this is  sirum medicine', 120.9, 'photo1.jpg', 'photo2.jpg', 'photo3.jpg', 'photo4.jpg', 20, 20, 20, 'Active', 30, '2024-11-11 04:32:51', '2024-11-11 04:32:51');

-- --------------------------------------------------------

--
-- Table structure for table `return_order`
--

CREATE TABLE `return_order` (
  `id` int(11) NOT NULL,
  `order_detail_id` int(11) DEFAULT NULL,
  `order_problem` text DEFAULT NULL,
  `img` varchar(400) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(300) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `status`, `created_at`, `updated_at`) VALUES
(4, 'Doctor', 'Block', '2024-11-07 07:52:08', '2024-11-08 12:42:02'),
(5, 'Doctor', 'Block', '2024-11-07 07:55:43', '2024-11-07 11:23:40'),
(7, 'Admin', 'Active', '2024-11-07 08:11:07', NULL),
(10, 'Admin', 'Active', '2024-11-08 12:19:41', '2024-11-08 12:19:41'),
(12, 'Admin', 'Active', '2024-11-09 04:22:50', '2024-11-09 04:22:50'),
(13, 'Doctor', 'Block', '2024-11-09 04:22:57', '2024-11-09 04:23:47'),
(14, 'Admin', 'Active', '2024-11-09 04:25:05', '2024-11-09 04:25:05'),
(15, 'Admin', 'Active', '2024-11-09 04:25:09', '2024-11-09 04:25:09');

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `id` int(11) NOT NULL,
  `plan_name` varchar(300) DEFAULT NULL,
  `plan_detail` text DEFAULT NULL,
  `price` float DEFAULT NULL,
  `time_period` int(11) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscription`
--

INSERT INTO `subscription` (`id`, `plan_name`, `plan_detail`, `price`, `time_period`, `status`, `created_at`, `updated_at`) VALUES
(2, 'Golden Plan', 'This is Golden plan', 100.9, 199, 'Block', '2024-11-09 12:12:45', '2024-11-09 12:28:09'),
(3, 'Silver Plan', 'This is silver plan', 200.9, 299, 'Active', '2024-11-09 12:13:14', '2024-11-09 12:13:14'),
(4, 'Golden Plan', 'This is Golden plan', 100.9, 199, 'Block', '2024-11-09 20:01:20', '2024-11-09 20:01:38'),
(5, 'Silver Plan', 'This is silver plan', 200.9, 299, 'Active', '2024-11-10 11:04:46', '2024-11-10 11:04:46');

-- --------------------------------------------------------

--
-- Table structure for table `subscription_user`
--

CREATE TABLE `subscription_user` (
  `id` int(11) NOT NULL,
  `subscription_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `expiary_date` date DEFAULT NULL,
  `payment_mode` varchar(200) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscription_user`
--

INSERT INTO `subscription_user` (`id`, `subscription_id`, `user_id`, `expiary_date`, `payment_mode`, `status`, `created_at`, `updated_at`) VALUES
(1, 5, 30, '1978-08-08', 'Online', 'Active', '2024-11-10 12:42:09', '2024-11-10 12:42:09'),
(2, 5, 30, '1978-08-08', 'Online', 'Active', '2024-11-10 12:42:21', '2024-11-10 12:42:21'),
(4, 3, 30, '1978-08-09', 'Offline', 'Block', '2024-11-10 12:42:29', '2024-11-10 12:52:25'),
(5, 5, 30, '1978-08-08', 'Online', 'Active', '2024-11-10 12:42:32', '2024-11-10 12:42:32');

-- --------------------------------------------------------

--
-- Table structure for table `terms_condition`
--

CREATE TABLE `terms_condition` (
  `id` int(11) NOT NULL,
  `name` varchar(400) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `terms_condition`
--

INSERT INTO `terms_condition` (`id`, `name`, `description`, `status`, `created_at`, `updated_at`) VALUES
(1, 'terms', 'This is terms', 'Active', '2024-11-09 19:36:13', '2024-11-09 19:36:13'),
(2, 'condition', 'This is description', 'Block', '2024-11-09 19:36:23', '2024-11-09 20:00:42');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `subscription_id` int(11) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `first_name` text DEFAULT NULL,
  `last_name` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `phone_no` bigint(20) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(300) DEFAULT NULL,
  `address` text DEFAULT NULL,
  `emergency_no` bigint(20) DEFAULT NULL,
  `profile` text DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `state` varchar(400) DEFAULT NULL,
  `city` varchar(400) DEFAULT NULL,
  `specialization` text DEFAULT NULL,
  `medical_license` varchar(400) DEFAULT NULL,
  `year_of_expirence` varchar(300) DEFAULT NULL,
  `degree` varchar(250) DEFAULT NULL,
  `certification` text DEFAULT NULL,
  `affiliate_hospital` text DEFAULT NULL,
  `current_position` varchar(400) DEFAULT NULL,
  `work_schedule` varchar(500) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `bio` text DEFAULT NULL,
  `hospital_name` text DEFAULT NULL,
  `website` varchar(400) DEFAULT NULL,
  `expiary_date` date DEFAULT NULL,
  `mac_address` varchar(400) DEFAULT NULL,
  `status` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `role_id`, `subscription_id`, `email`, `first_name`, `last_name`, `password`, `phone_no`, `date_of_birth`, `gender`, `address`, `emergency_no`, `profile`, `pincode`, `state`, `city`, `specialization`, `medical_license`, `year_of_expirence`, `degree`, `certification`, `affiliate_hospital`, `current_position`, `work_schedule`, `registration_date`, `bio`, `hospital_name`, `website`, `expiary_date`, `mac_address`, `status`, `created_at`, `updated_at`) VALUES
(30, 4, 5, 'diya@gmail.com', 'diya', 'Pancha;', 'Asti', 7828479339, '2002-09-25', '23 year', '42,shree ramanager', 8469895145, 'img4.jpg', 395006, 'Gujarat', 'Vyara', 'Student', 'APZx234', '2 year', 'M.D', 'img6.jpg', 'xyz', 'Student', '8am', '1978-08-08', 'I am Nurse', 'ABC', 'careQ', '2002-11-13', 'absc233', 'Block', '2024-11-10 11:11:51', '2024-11-10 12:00:44');

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`),
  ADD KEY `blog_user` (`user_id`);

--
-- Indexes for table `career`
--
ALTER TABLE `career`
  ADD PRIMARY KEY (`id`),
  ADD KEY `career_user` (`user_id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cart_user` (`user_id`),
  ADD KEY `cart_product` (`product_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cat_role` (`role_id`);

--
-- Indexes for table `chat_master`
--
ALTER TABLE `chat_master`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chat_sender` (`sender_id`),
  ADD KEY `chat_reciever` (`reciever_id`);

--
-- Indexes for table `checkup_booking`
--
ALTER TABLE `checkup_booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `book_user` (`user_id`),
  ADD KEY `book_buss` (`bussiness_id`);

--
-- Indexes for table `complain`
--
ALTER TABLE `complain`
  ADD PRIMARY KEY (`id`),
  ADD KEY `com_user` (`user_id`),
  ADD KEY `com_against` (`against_complain_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `feed_user` (`user_id`);

--
-- Indexes for table `health_record`
--
ALTER TABLE `health_record`
  ADD PRIMARY KEY (`id`),
  ADD KEY `check_book` (`book_id`);

--
-- Indexes for table `health_wellness`
--
ALTER TABLE `health_wellness`
  ADD PRIMARY KEY (`id`),
  ADD KEY `health_user` (`user_id`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`id`),
  ADD KEY `job_user` (`user_id`),
  ADD KEY `job_career` (`career_id`);

--
-- Indexes for table `medical_report`
--
ALTER TABLE `medical_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `healthrecord_report` (`health_record_id`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `detail_prd` (`product_id`),
  ADD KEY `detail_order` (`order_master_id`);

--
-- Indexes for table `order_master`
--
ALTER TABLE `order_master`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `bill_no` (`bill_no`),
  ADD KEY `ord_user` (`buyer_user_id`);

--
-- Indexes for table `privacy_policy`
--
ALTER TABLE `privacy_policy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prd_user` (`user_id`),
  ADD KEY `prd_cat` (`category_id`);

--
-- Indexes for table `return_order`
--
ALTER TABLE `return_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `return_orderd` (`order_detail_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subscription_user`
--
ALTER TABLE `subscription_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sub_subuser` (`subscription_id`),
  ADD KEY `sub_user` (`user_id`);

--
-- Indexes for table `terms_condition`
--
ALTER TABLE `terms_condition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_user` (`role_id`),
  ADD KEY `user_sub` (`subscription_id`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `wish_user` (`user_id`),
  ADD KEY `wish_prd` (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `career`
--
ALTER TABLE `career`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `chat_master`
--
ALTER TABLE `chat_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `checkup_booking`
--
ALTER TABLE `checkup_booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `complain`
--
ALTER TABLE `complain`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `health_record`
--
ALTER TABLE `health_record`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `health_wellness`
--
ALTER TABLE `health_wellness`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `job`
--
ALTER TABLE `job`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `medical_report`
--
ALTER TABLE `medical_report`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_master`
--
ALTER TABLE `order_master`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `privacy_policy`
--
ALTER TABLE `privacy_policy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `return_order`
--
ALTER TABLE `return_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `subscription`
--
ALTER TABLE `subscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `subscription_user`
--
ALTER TABLE `subscription_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `terms_condition`
--
ALTER TABLE `terms_condition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `career`
--
ALTER TABLE `career`
  ADD CONSTRAINT `career_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cart_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `cat_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `chat_master`
--
ALTER TABLE `chat_master`
  ADD CONSTRAINT `chat_reciever` FOREIGN KEY (`reciever_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chat_sender` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `checkup_booking`
--
ALTER TABLE `checkup_booking`
  ADD CONSTRAINT `book_buss` FOREIGN KEY (`bussiness_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `complain`
--
ALTER TABLE `complain`
  ADD CONSTRAINT `com_against` FOREIGN KEY (`against_complain_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `com_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feed_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `health_record`
--
ALTER TABLE `health_record`
  ADD CONSTRAINT `check_book` FOREIGN KEY (`book_id`) REFERENCES `checkup_booking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `health_wellness`
--
ALTER TABLE `health_wellness`
  ADD CONSTRAINT `health_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `job_career` FOREIGN KEY (`career_id`) REFERENCES `career` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `job_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `medical_report`
--
ALTER TABLE `medical_report`
  ADD CONSTRAINT `healthrecord_report` FOREIGN KEY (`health_record_id`) REFERENCES `health_record` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `detail_order` FOREIGN KEY (`order_master_id`) REFERENCES `order_master` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_prd` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_master`
--
ALTER TABLE `order_master`
  ADD CONSTRAINT `ord_user` FOREIGN KEY (`buyer_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `prd_cat` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prd_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `return_order`
--
ALTER TABLE `return_order`
  ADD CONSTRAINT `return_orderd` FOREIGN KEY (`order_detail_id`) REFERENCES `order_detail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subscription_user`
--
ALTER TABLE `subscription_user`
  ADD CONSTRAINT `sub_subuser` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sub_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `role_user` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_sub` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD CONSTRAINT `wish_prd` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wish_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
