CREATE DATABASE STUDENTS
GO
USE STUDENTS
GO

CREATE TABLE Student
(
	IDStudent INT PRIMARY KEY IDENTITY,
	FirstName NVARCHAR(20) NOT NULL,
	LastName NVARCHAR(20) NOT NULL,
	Grade INT NOT NULL,
	PicturePath NVARCHAR(200) NOT NULL
)
GO

CREATE PROCEDURE createStudent
	@FirstName NVARCHAR(20),
	@LastName NVARCHAR(20),
	@Grade INT,
	@PicturePath NVARCHAR(200),
	@IDStudent INT OUTPUT
AS 
BEGIN 
	INSERT INTO Student VALUES(@FirstName, @LastName, @Grade, @PicturePath)
	SET @IDStudent = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateStudent
	@FirstName NVARCHAR(20),
	@LastName NVARCHAR(20),
	@Grade INT,
	@PicturePath NVARCHAR(200),
	@IDStudent INT
	 
AS 
BEGIN 
	UPDATE Student SET 
		FirstName = @FirstName, 
		LastName = @LastName, 
		Grade = @Grade,
		PicturePath = @PicturePath
	WHERE 
		IDStudent = @IDStudent
END
GO


CREATE PROCEDURE deleteStudent
	@IDStudent INT	 
AS 
BEGIN 
	DELETE  
	FROM 
			Student
	WHERE 
		IDStudent = @IDStudent
END
GO

CREATE PROCEDURE selectStudent
	@IDStudent INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		Student
	WHERE 
		IDStudent = @IDStudent
END
GO

CREATE PROCEDURE selectStudents
AS 
BEGIN 
	SELECT * FROM Student
END
GO