package com.src.practice.fusion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoctorComparator {

	public static void order(List<Doctor> doctors) {

		Collections.sort(doctors, new Comparator<Doctor>() {

			public int compare(Doctor d1, Doctor d2) {
				return d1.getScore() > d2.getScore() ? -1 : d1.getScore() == d2.getScore() ? 0 : 1;
			}
		});
	}

	public static List<Doctor> findSimilarDoctors(Doctor doctor, List<Doctor> doctorList) {

		if (doctorList == null || doctor == null)
			return null;

		List<Doctor> similarDoctors = new ArrayList<Doctor>();
		for (Doctor d : doctorList) {
			if (matchDoctors(doctor, d) == 0) {
				similarDoctors.add(d);
			}
		}
		DoctorComparator.order(similarDoctors);
		return similarDoctors;
	}

	public static int matchDoctors(Doctor doc1, Doctor doc2) {

		String s1 = doc1.getSpeciality();
		String s2 = doc2.getSpeciality();
		int sComp = s1.compareTo(s2);

		String l1 = doc1.getLocation();
		String l2 = doc2.getLocation();
		int lComp = l1.compareTo(l2);

		int ratingscore = doc2.getReviewScore();
		if (ratingscore > 5) {
			doc2.setReviewScore(5);
			ratingscore = 5;
		}

		if (sComp == 0 && lComp == 0) {
			doc2.setScore(doc2.getScore() + 110 + ratingscore);
			return 0;
		}

		if (sComp == 0 && lComp != 0) {
			doc2.setScore(doc2.getScore() + 100 + ratingscore);
			return 0;
		}

		if (sComp != 0 && lComp == 0) {
			doc2.setScore(doc2.getScore() + 10 + ratingscore);
			return 0;
		}

		return -1;

	}
}
