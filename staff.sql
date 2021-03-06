USE [master]
GO
CREATE DATABASE [Staff22]
CREATE LOGIN [guest] WITH PASSWORD=N'ojSWcY2pzbQVSTGuonNDXkyqqBLF0o1lVrbzO9nNWLM=', DEFAULT_DATABASE=[master], DEFAULT_LANGUAGE=[us_english], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO
ALTER LOGIN [guest] ENABLE
GO
USE [Staff22]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Degree](
	[degreeID] [varchar](6) NOT NULL,
	[staffID] [varchar](6) NOT NULL,
	[name_major] [varchar](100) NULL,
	[name_university] [varchar](100) NULL,
	[academic_level] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[degreeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Position](
	[posID] [varchar](6) NOT NULL,
	[name_pos] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[posID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[roomID] [varchar](6) NOT NULL,
	[name_room] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[roomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Salary](
	[salaryID] [varchar](6) NOT NULL,
	[staffID] [varchar](6) NULL,
	[basicSalary] [real] NULL,
	[applicableDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[salaryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalaryPayment](
	[salaryPayID] [bigint] NOT NULL,
	[staffID] [varchar](6) NULL,
	[salaryID] [varchar](6) NULL,
	[timeshID] [varchar](6) NULL,
	[mon] [int] NULL,
	[yea] [int] NULL,
	[insurance] [real] NULL,
	[bonus] [real] NULL,
	[actReceived] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[salaryPayID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Staff](
	[staffID] [varchar](6) NOT NULL,
	[full_name] [varchar](100) NULL,
	[gender] [bit] NULL,
	[bod] [date] NULL,
	[experience] [int] NULL,
	[adr] [varchar](100) NULL,
	[phone] [varchar](11) NULL,
	[posID] [varchar](6) NOT NULL,
	[roomID] [varchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[staffID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Timesheets](
	[timeshID] [varchar](6) NOT NULL,
	[staffID] [varchar](6) NOT NULL,
	[day_off] [int] NOT NULL,
	[day_on] [int] NOT NULL,
	[mon] [int] NOT NULL,
	[yea] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[timeshID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Degree] ([degreeID], [staffID], [name_major], [name_university], [academic_level]) VALUES (N'DEG001', N'NV0001', N'Computer Science', N'Infomation Technology', 1)
INSERT [dbo].[Degree] ([degreeID], [staffID], [name_major], [name_university], [academic_level]) VALUES (N'DEG002', N'NV0001', N' Accountant', N'Bank University', 1)
GO
INSERT [dbo].[Position] ([posID], [name_pos]) VALUES (N'POS001', N'Manager')
INSERT [dbo].[Position] ([posID], [name_pos]) VALUES (N'POS002', N'Marketing')
INSERT [dbo].[Position] ([posID], [name_pos]) VALUES (N'POS003', N'System Manager')
INSERT [dbo].[Position] ([posID], [name_pos]) VALUES (N'POS004', N' Accountant')
INSERT [dbo].[Position] ([posID], [name_pos]) VALUES (N'POS005', N'Saler')
GO
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO001', N'DevOpss')
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO002', N'Marketing')
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO003', N'Administrative offices')
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO004', N'IT')
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO005', N'Customer care')
INSERT [dbo].[Room] ([roomID], [name_room]) VALUES (N'ROO006', N'Maketting-2')
GO
INSERT [dbo].[Salary] ([salaryID], [staffID], [basicSalary], [applicableDate]) VALUES (N'SAL001', N'NV0001', 1E+07, CAST(N'2022-01-01' AS Date))
INSERT [dbo].[Salary] ([salaryID], [staffID], [basicSalary], [applicableDate]) VALUES (N'SAL002', N'NV0002', 5000000, CAST(N'2022-01-01' AS Date))
INSERT [dbo].[Salary] ([salaryID], [staffID], [basicSalary], [applicableDate]) VALUES (N'SAL003', N'NV0003', 6000000, CAST(N'2022-01-01' AS Date))
INSERT [dbo].[Salary] ([salaryID], [staffID], [basicSalary], [applicableDate]) VALUES (N'SAL004', N'NV0004', 8000000, CAST(N'2022-01-01' AS Date))
GO
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (3, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (4, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (5, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (6, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (7, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (8, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (9, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (10, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (11, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (12, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (13, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (14, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (15, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (16, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (17, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (18, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (19, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (20, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (21, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (22, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (23, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (24, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (25, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (26, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (27, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (28, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (29, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (30, N'NV0002', N'SAL002', N'TIM004', 6, 2022, 250000, 2000000, 6750000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (31, N'NV0003', N'SAL003', N'TIM005', 6, 2022, 300000, 0, 5700000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (32, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (33, N'NV0003', N'SAL003', N'TIM005', 6, 2022, 300000, 0, 5700000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (34, N'NV0004', N'SAL004', N'TIM008', 6, 2022, 400000, 2000000, 9600000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (35, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (36, N'NV0003', N'SAL003', N'TIM005', 6, 2022, 300000, 0, 5700000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (37, N'NV0004', N'SAL004', N'TIM008', 6, 2022, 400000, 2000000, 9600000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (38, N'NV0001', N'SAL001', N'TIM003', 6, 2022, 500000, 2000000, 1.15E+07)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (39, N'NV0002', N'SAL002', N'TIM004', 6, 2022, 250000, 2000000, 6750000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (40, N'NV0003', N'SAL003', N'TIM005', 6, 2022, 300000, 0, 5700000)
INSERT [dbo].[SalaryPayment] ([salaryPayID], [staffID], [salaryID], [timeshID], [mon], [yea], [insurance], [bonus], [actReceived]) VALUES (41, N'NV0004', N'SAL004', N'TIM008', 6, 2022, 400000, 2000000, 9600000)
GO
INSERT [dbo].[Staff] ([staffID], [full_name], [gender], [bod], [experience], [adr], [phone], [posID], [roomID]) VALUES (N'NV0001', N'Nguyen Van A', 1, CAST(N'2001-02-12' AS Date), 4, N'70 Nguyen Dinh Chieu', N'0978987678', N'POS001', N'ROO001')
INSERT [dbo].[Staff] ([staffID], [full_name], [gender], [bod], [experience], [adr], [phone], [posID], [roomID]) VALUES (N'NV0002', N'Nguyen Van B', 0, CAST(N'2003-02-19' AS Date), 1, N'Le Thanh Ton 12', N'0968520710', N'POS001', N'ROO002')
INSERT [dbo].[Staff] ([staffID], [full_name], [gender], [bod], [experience], [adr], [phone], [posID], [roomID]) VALUES (N'NV0003', N'Nguyen Hoai Anh', 1, CAST(N'2002-02-12' AS Date), 2, N'Nguyen Dinh Chieu 600', N'0912320710', N'POS001', N'ROO001')
INSERT [dbo].[Staff] ([staffID], [full_name], [gender], [bod], [experience], [adr], [phone], [posID], [roomID]) VALUES (N'NV0004', N'Lê Vinh Quang', 1, CAST(N'2001-03-04' AS Date), 0, N'S? 69, ?p 4', N'0968520710', N'POS001', N'ROO001')
GO
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM001', N'NV0001', 2, 28, 1, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM002', N'NV0001', 1, 30, 3, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM003', N'NV0001', 0, 30, 6, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM004', N'NV0002', 0, 30, 6, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM005', N'NV0003', 2, 28, 6, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM006', N'NV0001', 1, 29, 5, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM007', N'NV0003', 0, 31, 5, 2022)
INSERT [dbo].[Timesheets] ([timeshID], [staffID], [day_off], [day_on], [mon], [yea]) VALUES (N'TIM008', N'NV0004', 0, 30, 6, 2022)
GO
ALTER TABLE [dbo].[Degree]  WITH CHECK ADD FOREIGN KEY([staffID])
REFERENCES [dbo].[Staff] ([staffID])
GO
ALTER TABLE [dbo].[Salary]  WITH CHECK ADD FOREIGN KEY([staffID])
REFERENCES [dbo].[Staff] ([staffID])
GO
ALTER TABLE [dbo].[SalaryPayment]  WITH CHECK ADD FOREIGN KEY([salaryID])
REFERENCES [dbo].[Salary] ([salaryID])
GO
ALTER TABLE [dbo].[SalaryPayment]  WITH CHECK ADD FOREIGN KEY([staffID])
REFERENCES [dbo].[Staff] ([staffID])
GO
ALTER TABLE [dbo].[SalaryPayment]  WITH CHECK ADD FOREIGN KEY([timeshID])
REFERENCES [dbo].[Timesheets] ([timeshID])
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD FOREIGN KEY([posID])
REFERENCES [dbo].[Position] ([posID])
GO
ALTER TABLE [dbo].[Staff]  WITH CHECK ADD FOREIGN KEY([roomID])
REFERENCES [dbo].[Room] ([roomID])
GO
ALTER TABLE [dbo].[Timesheets]  WITH CHECK ADD FOREIGN KEY([staffID])
REFERENCES [dbo].[Staff] ([staffID])
GO
USE [master]
GO
ALTER DATABASE [Staff22] SET  READ_WRITE 
GO
