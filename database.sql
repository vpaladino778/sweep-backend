CREATE DATABASE IF NOT EXISTS sweep;
USE SWEEP;

CREATE TABLE IF NOT EXISTS Profile (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description TEXT,
  linkedin_link VARCHAR(128),
  country_id VARCHAR(2) NOT NULL,
  state_province VARCHAR(64) NOT NULL,
  profile_image_link VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS Mentor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  gcp_user_id VARCHAR(32) NOT NULL,
  email VARCHAR(64) NOT NULL
);


CREATE TABLE IF NOT EXISTS User(
  id INT AUTO_INCREMENT PRIMARY KEY,
  gcp_user_id VARCHAR(32),
  email VARCHAR(64)
);


CREATE TABLE IF NOT EXISTS Availability (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mentor_id INT NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  INDEX(mentor_id),
  FOREIGN KEY (mentor_id) REFERENCES Mentor(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Appointment (
  id INT AUTO_INCREMENT PRIMARY KEY,
  mentor_id INT NOT NULL,
  user_id INT NOT NULL,
  start_time DATETIME NOT NULL,
  end_time DATETIME NOT NULL,
  -- Here we don't delete because we want to keep appointment records if a mentor/user is deleted
  FOREIGN KEY (mentor_id) REFERENCES Mentor(id),
  FOREIGN KEY (user_id) REFERENCES User(id),
  INDEX (mentor_id, user_id)
);
