package com.src.practice.fusion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
	private String name;
	private String location;
	private String speciality;
	private int age;
	private int reviewScore;
	private int score;

	public Doctor() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return "Name = " + this.name + ", Location = " + this.location + ", Speciality = " + this.speciality
				+ ", Age = " + this.age + ", Review score = " + this.reviewScore + ", Score = " + this.getScore();
	}

	public List<Doctor> readDoctorsFromFile(String filename) throws IOException {
		List<Doctor> doctors = new ArrayList<Doctor>();

		FileReader fr = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fr);
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			Doctor doctor = new Doctor();
			// System.out.println(line);
			String[] field = line.split(",");
			doctor.name = field[0];
			doctor.location = field[1];
			doctor.speciality = field[2];
			doctor.age = Integer.parseInt(field[3]);
			doctor.reviewScore = Integer.parseInt(field[4]);
			doctors.add(doctor);
		}
		return doctors;
	}
}
