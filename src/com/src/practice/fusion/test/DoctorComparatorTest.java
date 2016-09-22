package com.src.practice.fusion.test;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import com.src.practice.fusion.Doctor;
import com.src.practice.fusion.DoctorComparator;

public class DoctorComparatorTest {

	// Test case for null List of doctors
	@Test
	public void testFindSimilarDoctorsWhenListIsNull() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		Assert.assertNull(DoctorComparator.findSimilarDoctors(d1, null));
	}

	// Test case for null doctor
	@Test
	public void testFindSimilarDoctorsWhenDoctorIsNull() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		Assert.assertNull(DoctorComparator.findSimilarDoctors(null, docList));
	}

	// Test case for null - both doctor and list of doctors
	@Test
	public void testFindSimilarDoctorsWhenBothNull() {
		Assert.assertNull(DoctorComparator.findSimilarDoctors(null, null));
	}

	// Test case for doctor to itself
	@Test
	public void testFindSimilarDoctorsWhenBothAreSame() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d1, docList).get(0), is(d1));
	}

	// Positive Test case : 1
	@Test
	public void testFindSimilarDoctorsPositiveTestCase() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		Doctor d2 = new Doctor();
		d2.setName("Candice Cook");
		d2.setLocation("Santa Clara");
		d2.setAge(40);
		d2.setSpeciality("Cardiologist");
		d2.setReviewScore(4);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		docList.add(d2);
		Doctor d = new Doctor();
		d.setName("Smith Wills");
		d.setLocation("Santa Clara");
		d.setAge(43);
		d.setSpeciality("Orthopedic");
		d.setReviewScore(3);
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList), hasSize(2));
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList), contains(d1, d2));
	}

	// Positive test case - speciality match only
	@Test
	public void testFindSimilarDoctorsPositiveTestCase2() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		Doctor d2 = new Doctor();
		d2.setName("Candice Cook");
		d2.setLocation("San Jose");
		d2.setAge(40);
		d2.setSpeciality("Cardiologist");
		d2.setReviewScore(4);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		docList.add(d2);
		Doctor d = new Doctor();
		d.setName("Smith Wills");
		d.setLocation("Santa Clara");
		d.setAge(43);
		d.setSpeciality("Orthopedic");
		d.setReviewScore(3);
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList), hasSize(1));
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList), contains(d1));
	}

	// Negative test case
	@Test
	public void testFindSimilarDoctorsNegativeTestcase() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		Doctor d2 = new Doctor();
		d2.setName("Candice Cook");
		d2.setLocation("Santa Clara");
		d2.setAge(40);
		d2.setSpeciality("Cardiologist");
		d2.setReviewScore(4);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		docList.add(d2);
		Doctor d = new Doctor();
		d.setName("Smith Wills");
		d.setLocation("Santa Barbara");
		d.setAge(43);
		d.setSpeciality("Gynaecologist");
		d.setReviewScore(3);
		Assert.assertEquals(DoctorComparator.findSimilarDoctors(d, docList), new ArrayList<Doctor>());
	}

	// Positive Test case - location match
	@Test
	public void testFindSimilarDoctorsPositiveTestcaseWithLocationMatch() {
		Doctor d1 = new Doctor();
		d1.setName("Mark Lin");
		d1.setLocation("San Jose");
		d1.setAge(43);
		d1.setSpeciality("Orthopedic");
		d1.setReviewScore(3);
		Doctor d2 = new Doctor();
		d2.setName("Candice Cook");
		d2.setLocation("Santa Clara");
		d2.setAge(40);
		d2.setSpeciality("Cardiologist");
		d2.setReviewScore(4);
		List<Doctor> docList = new ArrayList<Doctor>();
		docList.add(d1);
		docList.add(d2);
		Doctor d = new Doctor();
		d.setName("Smith Wills");
		d.setLocation("Santa Clara");
		d.setAge(43);
		d.setSpeciality("Gynaecologist");
		d.setReviewScore(3);
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList), hasSize(1));
		Assert.assertThat(DoctorComparator.findSimilarDoctors(d, docList).get(0), is(d2));
	}
}
