package com.src.practice.fusion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoctorMainClass {

	public static void main(String[] args) throws IOException {

		Doctor doctor = new Doctor();
		List<Doctor> doctorList = doctor.readDoctorsFromFile("./resource/doctors.txt");
		Doctor inputDoctor = new Doctor();
		inputDoctor.setName("Mark Lin");
		inputDoctor.setLocation("San Jose");
		inputDoctor.setAge(43);
		inputDoctor.setSpeciality("Orthopedic");
		inputDoctor.setReviewScore(3);

		List<Doctor> matchingDoctors = new ArrayList<Doctor>();
		matchingDoctors = DoctorComparator.findSimilarDoctors(inputDoctor, doctorList);

		for (Doctor d : matchingDoctors) {
			System.out.println(d);
		}
	}
}
