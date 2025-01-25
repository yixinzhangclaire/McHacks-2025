package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.util.*;
import java.sql.Time;

// line 64 "model.ump"
// line 138 "model.ump"
public class AssessmentDoc {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // AssessmentDoc Associations
  private List<HospitalStay> hospitalStaies;
  private List<Doctor> doctors;
  private List<TreatmentPlan> treatmentPlans;
  private List<Test> tests;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public AssessmentDoc() {
    hospitalStaies = new ArrayList<HospitalStay>();
    doctors = new ArrayList<Doctor>();
    treatmentPlans = new ArrayList<TreatmentPlan>();
    tests = new ArrayList<Test>();
  }

  // ------------------------
  // INTERFACE
  // ------------------------
  /* Code from template association_GetMany */
  public HospitalStay getHospitalStay(int index) {
    HospitalStay aHospitalStay = hospitalStaies.get(index);
    return aHospitalStay;
  }

  public List<HospitalStay> getHospitalStaies() {
    List<HospitalStay> newHospitalStaies = Collections.unmodifiableList(hospitalStaies);
    return newHospitalStaies;
  }

  public int numberOfHospitalStaies() {
    int number = hospitalStaies.size();
    return number;
  }

  public boolean hasHospitalStaies() {
    boolean has = hospitalStaies.size() > 0;
    return has;
  }

  public int indexOfHospitalStay(HospitalStay aHospitalStay) {
    int index = hospitalStaies.indexOf(aHospitalStay);
    return index;
  }

  /* Code from template association_GetMany */
  public Doctor getDoctor(int index) {
    Doctor aDoctor = doctors.get(index);
    return aDoctor;
  }

  public List<Doctor> getDoctors() {
    List<Doctor> newDoctors = Collections.unmodifiableList(doctors);
    return newDoctors;
  }

  public int numberOfDoctors() {
    int number = doctors.size();
    return number;
  }

  public boolean hasDoctors() {
    boolean has = doctors.size() > 0;
    return has;
  }

  public int indexOfDoctor(Doctor aDoctor) {
    int index = doctors.indexOf(aDoctor);
    return index;
  }

  /* Code from template association_GetMany */
  public TreatmentPlan getTreatmentPlan(int index) {
    TreatmentPlan aTreatmentPlan = treatmentPlans.get(index);
    return aTreatmentPlan;
  }

  public List<TreatmentPlan> getTreatmentPlans() {
    List<TreatmentPlan> newTreatmentPlans = Collections.unmodifiableList(treatmentPlans);
    return newTreatmentPlans;
  }

  public int numberOfTreatmentPlans() {
    int number = treatmentPlans.size();
    return number;
  }

  public boolean hasTreatmentPlans() {
    boolean has = treatmentPlans.size() > 0;
    return has;
  }

  public int indexOfTreatmentPlan(TreatmentPlan aTreatmentPlan) {
    int index = treatmentPlans.indexOf(aTreatmentPlan);
    return index;
  }

  /* Code from template association_GetMany */
  public Test getTest(int index) {
    Test aTest = tests.get(index);
    return aTest;
  }

  public List<Test> getTests() {
    List<Test> newTests = Collections.unmodifiableList(tests);
    return newTests;
  }

  public int numberOfTests() {
    int number = tests.size();
    return number;
  }

  public boolean hasTests() {
    boolean has = tests.size() > 0;
    return has;
  }

  public int indexOfTest(Test aTest) {
    int index = tests.indexOf(aTest);
    return index;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitalStaies() {
    return 0;
  }

  /* Code from template association_AddManyToOne */
  public HospitalStay addHospitalStay(Time aArrivalTime, Time aAvgWaitTime, int aQueuePosition,
      AssessmentNurse aAssessmentNurse) {
    return new HospitalStay(aArrivalTime, aAvgWaitTime, aQueuePosition, aAssessmentNurse, this);
  }

  public boolean addHospitalStay(HospitalStay aHospitalStay) {
    boolean wasAdded = false;
    if (hospitalStaies.contains(aHospitalStay)) {
      return false;
    }
    AssessmentDoc existingAssessmentDoc = aHospitalStay.getAssessmentDoc();
    boolean isNewAssessmentDoc = existingAssessmentDoc != null && !this.equals(existingAssessmentDoc);
    if (isNewAssessmentDoc) {
      aHospitalStay.setAssessmentDoc(this);
    } else {
      hospitalStaies.add(aHospitalStay);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHospitalStay(HospitalStay aHospitalStay) {
    boolean wasRemoved = false;
    // Unable to remove aHospitalStay, as it must always have a assessmentDoc
    if (!this.equals(aHospitalStay.getAssessmentDoc())) {
      hospitalStaies.remove(aHospitalStay);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addHospitalStayAt(HospitalStay aHospitalStay, int index) {
    boolean wasAdded = false;
    if (addHospitalStay(aHospitalStay)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfHospitalStaies()) {
        index = numberOfHospitalStaies() - 1;
      }
      hospitalStaies.remove(aHospitalStay);
      hospitalStaies.add(index, aHospitalStay);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHospitalStayAt(HospitalStay aHospitalStay, int index) {
    boolean wasAdded = false;
    if (hospitalStaies.contains(aHospitalStay)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfHospitalStaies()) {
        index = numberOfHospitalStaies() - 1;
      }
      hospitalStaies.remove(aHospitalStay);
      hospitalStaies.add(index, aHospitalStay);
      wasAdded = true;
    } else {
      wasAdded = addHospitalStayAt(aHospitalStay, index);
    }
    return wasAdded;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctors() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctor(Doctor aDoctor) {
    boolean wasAdded = false;
    if (doctors.contains(aDoctor)) {
      return false;
    }
    doctors.add(aDoctor);
    if (aDoctor.indexOfAssessmentDoc(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aDoctor.addAssessmentDoc(this);
      if (!wasAdded) {
        doctors.remove(aDoctor);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeDoctor(Doctor aDoctor) {
    boolean wasRemoved = false;
    if (!doctors.contains(aDoctor)) {
      return wasRemoved;
    }

    int oldIndex = doctors.indexOf(aDoctor);
    doctors.remove(oldIndex);
    if (aDoctor.indexOfAssessmentDoc(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aDoctor.removeAssessmentDoc(this);
      if (!wasRemoved) {
        doctors.add(oldIndex, aDoctor);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorAt(Doctor aDoctor, int index) {
    boolean wasAdded = false;
    if (addDoctor(aDoctor)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfDoctors()) {
        index = numberOfDoctors() - 1;
      }
      doctors.remove(aDoctor);
      doctors.add(index, aDoctor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorAt(Doctor aDoctor, int index) {
    boolean wasAdded = false;
    if (doctors.contains(aDoctor)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfDoctors()) {
        index = numberOfDoctors() - 1;
      }
      doctors.remove(aDoctor);
      doctors.add(index, aDoctor);
      wasAdded = true;
    } else {
      wasAdded = addDoctorAt(aDoctor, index);
    }
    return wasAdded;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTreatmentPlans() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addTreatmentPlan(TreatmentPlan aTreatmentPlan) {
    boolean wasAdded = false;
    if (treatmentPlans.contains(aTreatmentPlan)) {
      return false;
    }
    treatmentPlans.add(aTreatmentPlan);
    if (aTreatmentPlan.indexOfAssessmentDoc(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aTreatmentPlan.addAssessmentDoc(this);
      if (!wasAdded) {
        treatmentPlans.remove(aTreatmentPlan);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeTreatmentPlan(TreatmentPlan aTreatmentPlan) {
    boolean wasRemoved = false;
    if (!treatmentPlans.contains(aTreatmentPlan)) {
      return wasRemoved;
    }

    int oldIndex = treatmentPlans.indexOf(aTreatmentPlan);
    treatmentPlans.remove(oldIndex);
    if (aTreatmentPlan.indexOfAssessmentDoc(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aTreatmentPlan.removeAssessmentDoc(this);
      if (!wasRemoved) {
        treatmentPlans.add(oldIndex, aTreatmentPlan);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addTreatmentPlanAt(TreatmentPlan aTreatmentPlan, int index) {
    boolean wasAdded = false;
    if (addTreatmentPlan(aTreatmentPlan)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfTreatmentPlans()) {
        index = numberOfTreatmentPlans() - 1;
      }
      treatmentPlans.remove(aTreatmentPlan);
      treatmentPlans.add(index, aTreatmentPlan);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreatmentPlanAt(TreatmentPlan aTreatmentPlan, int index) {
    boolean wasAdded = false;
    if (treatmentPlans.contains(aTreatmentPlan)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfTreatmentPlans()) {
        index = numberOfTreatmentPlans() - 1;
      }
      treatmentPlans.remove(aTreatmentPlan);
      treatmentPlans.add(index, aTreatmentPlan);
      wasAdded = true;
    } else {
      wasAdded = addTreatmentPlanAt(aTreatmentPlan, index);
    }
    return wasAdded;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTests() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addTest(Test aTest) {
    boolean wasAdded = false;
    if (tests.contains(aTest)) {
      return false;
    }
    tests.add(aTest);
    if (aTest.indexOfAssessmentDoc(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aTest.addAssessmentDoc(this);
      if (!wasAdded) {
        tests.remove(aTest);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeTest(Test aTest) {
    boolean wasRemoved = false;
    if (!tests.contains(aTest)) {
      return wasRemoved;
    }

    int oldIndex = tests.indexOf(aTest);
    tests.remove(oldIndex);
    if (aTest.indexOfAssessmentDoc(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aTest.removeAssessmentDoc(this);
      if (!wasRemoved) {
        tests.add(oldIndex, aTest);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestAt(Test aTest, int index) {
    boolean wasAdded = false;
    if (addTest(aTest)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfTests()) {
        index = numberOfTests() - 1;
      }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestAt(Test aTest, int index) {
    boolean wasAdded = false;
    if (tests.contains(aTest)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfTests()) {
        index = numberOfTests() - 1;
      }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    } else {
      wasAdded = addTestAt(aTest, index);
    }
    return wasAdded;
  }

  public void delete() {
    for (int i = hospitalStaies.size(); i > 0; i--) {
      HospitalStay aHospitalStay = hospitalStaies.get(i - 1);
      aHospitalStay.delete();
    }
    ArrayList<Doctor> copyOfDoctors = new ArrayList<Doctor>(doctors);
    doctors.clear();
    for (Doctor aDoctor : copyOfDoctors) {
      aDoctor.removeAssessmentDoc(this);
    }
    ArrayList<TreatmentPlan> copyOfTreatmentPlans = new ArrayList<TreatmentPlan>(treatmentPlans);
    treatmentPlans.clear();
    for (TreatmentPlan aTreatmentPlan : copyOfTreatmentPlans) {
      aTreatmentPlan.removeAssessmentDoc(this);
    }
    ArrayList<Test> copyOfTests = new ArrayList<Test>(tests);
    tests.clear();
    for (Test aTest : copyOfTests) {
      aTest.removeAssessmentDoc(this);
    }
  }

}