package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.sql.Time;
import java.util.*;

// line 17 "model.ump"
// line 105 "model.ump"
public class HospitalStay {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // HospitalStay Attributes
  private Time arrivalTime;
  private Time avgWaitTime;
  private int queuePosition;

  // HospitalStay Associations
  private List<Patient> patients;
  private AssessmentNurse assessmentNurse;
  private AssessmentDoc assessmentDoc;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public HospitalStay(Time aArrivalTime, Time aAvgWaitTime, int aQueuePosition, AssessmentNurse aAssessmentNurse,
      AssessmentDoc aAssessmentDoc) {
    arrivalTime = aArrivalTime;
    avgWaitTime = aAvgWaitTime;
    queuePosition = aQueuePosition;
    patients = new ArrayList<Patient>();
    boolean didAddAssessmentNurse = setAssessmentNurse(aAssessmentNurse);
    if (!didAddAssessmentNurse) {
      throw new RuntimeException(
          "Unable to create hospitalStay due to assessmentNurse. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddAssessmentDoc = setAssessmentDoc(aAssessmentDoc);
    if (!didAddAssessmentDoc) {
      throw new RuntimeException(
          "Unable to create hospitalStay due to assessmentDoc. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public boolean setArrivalTime(Time aArrivalTime) {
    boolean wasSet = false;
    arrivalTime = aArrivalTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvgWaitTime(Time aAvgWaitTime) {
    boolean wasSet = false;
    avgWaitTime = aAvgWaitTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setQueuePosition(int aQueuePosition) {
    boolean wasSet = false;
    queuePosition = aQueuePosition;
    wasSet = true;
    return wasSet;
  }

  public Time getArrivalTime() {
    return arrivalTime;
  }

  public Time getAvgWaitTime() {
    return avgWaitTime;
  }

  public int getQueuePosition() {
    return queuePosition;
  }

  /* Code from template association_GetMany */
  public Patient getPatient(int index) {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients() {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients() {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients() {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient) {
    int index = patients.indexOf(aPatient);
    return index;
  }

  /* Code from template association_GetOne */
  public AssessmentNurse getAssessmentNurse() {
    return assessmentNurse;
  }

  /* Code from template association_GetOne */
  public AssessmentDoc getAssessmentDoc() {
    return assessmentDoc;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient) {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) {
      return false;
    }
    patients.add(aPatient);
    if (aPatient.indexOfHospitalStay(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aPatient.addHospitalStay(this);
      if (!wasAdded) {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removePatient(Patient aPatient) {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient)) {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfHospitalStay(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aPatient.removeHospitalStay(this);
      if (!wasRemoved) {
        patients.add(oldIndex, aPatient);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(Patient aPatient, int index) {
    boolean wasAdded = false;
    if (addPatient(aPatient)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfPatients()) {
        index = numberOfPatients() - 1;
      }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index) {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfPatients()) {
        index = numberOfPatients() - 1;
      }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } else {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  /* Code from template association_SetOneToMany */
  public boolean setAssessmentNurse(AssessmentNurse aAssessmentNurse) {
    boolean wasSet = false;
    if (aAssessmentNurse == null) {
      return wasSet;
    }

    AssessmentNurse existingAssessmentNurse = assessmentNurse;
    assessmentNurse = aAssessmentNurse;
    if (existingAssessmentNurse != null && !existingAssessmentNurse.equals(aAssessmentNurse)) {
      existingAssessmentNurse.removeHospitalStay(this);
    }
    assessmentNurse.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }

  /* Code from template association_SetOneToMany */
  public boolean setAssessmentDoc(AssessmentDoc aAssessmentDoc) {
    boolean wasSet = false;
    if (aAssessmentDoc == null) {
      return wasSet;
    }

    AssessmentDoc existingAssessmentDoc = assessmentDoc;
    assessmentDoc = aAssessmentDoc;
    if (existingAssessmentDoc != null && !existingAssessmentDoc.equals(aAssessmentDoc)) {
      existingAssessmentDoc.removeHospitalStay(this);
    }
    assessmentDoc.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }

  public void delete() {
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for (Patient aPatient : copyOfPatients) {
      aPatient.removeHospitalStay(this);
    }
    AssessmentNurse placeholderAssessmentNurse = assessmentNurse;
    this.assessmentNurse = null;
    if (placeholderAssessmentNurse != null) {
      placeholderAssessmentNurse.removeHospitalStay(this);
    }
    AssessmentDoc placeholderAssessmentDoc = assessmentDoc;
    this.assessmentDoc = null;
    if (placeholderAssessmentDoc != null) {
      placeholderAssessmentDoc.removeHospitalStay(this);
    }
  }

  public String toString() {
    return super.toString() + "[" +
        "queuePosition" + ":" + getQueuePosition() + "]" + System.getProperties().getProperty("line.separator") +
        "  " + "arrivalTime" + "="
        + (getArrivalTime() != null
            ? !getArrivalTime().equals(this) ? getArrivalTime().toString().replaceAll("  ", "    ") : "this"
            : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "avgWaitTime" + "="
        + (getAvgWaitTime() != null
            ? !getAvgWaitTime().equals(this) ? getAvgWaitTime().toString().replaceAll("  ", "    ") : "this"
            : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "assessmentNurse = "
        + (getAssessmentNurse() != null ? Integer.toHexString(System.identityHashCode(getAssessmentNurse())) : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "assessmentDoc = "
        + (getAssessmentDoc() != null ? Integer.toHexString(System.identityHashCode(getAssessmentDoc())) : "null");
  }
}