CREATE TABLE Hospital(

id NUMBER PRIMARY KEY,
name VARCHAR2(100),
numberOfDoctors NUMBER,
numberOfPatient NUMBER

);

CREATE TABLE Doctor(

id NUMBER PRIMARY KEY,
userName VARCHAR2(100),
salary NUMBER(10,2),
hospital_id NUMBER,
doctor_details_id NUMBER

);

CREATE TABLE DoctorDetails(

id NUMBER PRIMARY KEY,
fullAddress VARCHAR2(200),
firstName VARCHAR2(100),
lastName VARCHAR2(100),
age NUMBER

);

CREATE TABLE Patient(

id NUMBER PRIMARY KEY,
name VARCHAR2(100),
typeOfDisease VARCHAR2(100)

);

CREATE TABLE Hospital_Patient(

hospital_id NUMBER,
patient_id NUMBER,
PRIMARY KEY(hospital_id,patient_id)

);

ALTER TABLE Doctor
ADD CONSTRAINT FK_DOCTOR_DETAILS
FOREIGN KEY(doctorDetails_id)
REFERENCES DoctorDetails(id);

ALTER TABLE Doctor
ADD CONSTRAINT FK_HOSPITAL
FOREIGN KEY(hospital_id)
REFERENCES Hospital(id);

ALTER TABLE Patient
ADD CONSTRAINT FK_DOCTOR
FOREIGN KEY(doctor_id)
REFERENCES Doctor(id);

ALTER TABLE Hospital_Patient
ADD CONSTRAINT FK_HP_HOSPITAL
FOREIGN KEY(hospital_id)
REFERENCES Hospital(id);

ALTER TABLE Hospital_Patient
ADD CONSTRAINT FK_HP_PATIENT
FOREIGN KEY(patient_id)
REFERENCES Patient(id);