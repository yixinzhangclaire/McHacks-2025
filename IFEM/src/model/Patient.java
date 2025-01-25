package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.util.*;

// line 2 "model.ump"
// line 100 "model.ump"
public class Patient extends User {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Patient Attributes
  private String id;

  // Patient Associations
  private List<HospitalStay> hospitalStaies;
  private MedicalRecord medicalRecord;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public Patient(String aEmail, String aPassword, Person aPerson, String aId, MedicalRecord aMedicalRecord) {
    super(aEmail, aPassword, aPerson);
    id = aId;
    hospitalStaies = new ArrayList<HospitalStay>();
    if (aMedicalRecord == null || aMedicalRecord.getPatient() != null) {
      throw new RuntimeException(
          "Unable to create Patient due to aMedicalRecord. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    medicalRecord = aMedicalRecord;
  }

  public Patient(String aEmail, String aPassword, Person aPerson, String aId) {
    super(aEmail, aPassword, aPerson);
    id = aId;
    hospitalStaies = new ArrayList<HospitalStay>();
    medicalRecord = new MedicalRecord(this);
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public boolean setId(String aId) {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId() {
    return id;
  }

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

  /* Code from template association_GetOne */
  public MedicalRecord getMedicalRecord() {
    return medicalRecord;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitalStaies() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addHospitalStay(HospitalStay aHospitalStay) {
    boolean wasAdded = false;
    if (hospitalStaies.contains(aHospitalStay)) {
      return false;
    }
    hospitalStaies.add(aHospitalStay);
    if (aHospitalStay.indexOfPatient(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aHospitalStay.addPatient(this);
      if (!wasAdded) {
        hospitalStaies.remove(aHospitalStay);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeHospitalStay(HospitalStay aHospitalStay) {
    boolean wasRemoved = false;
    if (!hospitalStaies.contains(aHospitalStay)) {
      return wasRemoved;
    }

    int oldIndex = hospitalStaies.indexOf(aHospitalStay);
    hospitalStaies.remove(oldIndex);
    if (aHospitalStay.indexOfPatient(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aHospitalStay.removePatient(this);
      if (!wasRemoved) {
        hospitalStaies.add(oldIndex, aHospitalStay);
      }
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

  public void delete() {
    ArrayList<HospitalStay> copyOfHospitalStaies = new ArrayList<HospitalStay>(hospitalStaies);
    hospitalStaies.clear();
    for (HospitalStay aHospitalStay : copyOfHospitalStaies) {
      aHospitalStay.removePatient(this);
    }
    MedicalRecord existingMedicalRecord = medicalRecord;
    medicalRecord = null;
    if (existingMedicalRecord != null) {
      existingMedicalRecord.delete();
    }
    super.delete();
  }

  public String toString() {
    return super.toString() + "[" +
        "id" + ":" + getId() + "]" + System.getProperties().getProperty("line.separator") +
        "  " + "medicalRecord = "
        + (getMedicalRecord() != null ? Integer.toHexString(System.identityHashCode(getMedicalRecord())) : "null");
  }
}