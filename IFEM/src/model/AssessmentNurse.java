package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.util.*;
import java.sql.Time;

// line 24 "model.ump"
// line 169 "model.ump"
public class AssessmentNurse {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // AssessmentNurse Associations
  private List<HospitalStay> hospitalStaies;
  private List<Nurse> nurses;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public AssessmentNurse() {
    hospitalStaies = new ArrayList<HospitalStay>();
    nurses = new ArrayList<Nurse>();
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
  public Nurse getNurse(int index) {
    Nurse aNurse = nurses.get(index);
    return aNurse;
  }

  public List<Nurse> getNurses() {
    List<Nurse> newNurses = Collections.unmodifiableList(nurses);
    return newNurses;
  }

  public int numberOfNurses() {
    int number = nurses.size();
    return number;
  }

  public boolean hasNurses() {
    boolean has = nurses.size() > 0;
    return has;
  }

  public int indexOfNurse(Nurse aNurse) {
    int index = nurses.indexOf(aNurse);
    return index;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitalStaies() {
    return 0;
  }

  /* Code from template association_AddManyToOne */
  public HospitalStay addHospitalStay(Time aArrivalTime, Time aAvgWaitTime, int aQueuePosition,
      AssessmentDoc aAssessmentDoc) {
    return new HospitalStay(aArrivalTime, aAvgWaitTime, aQueuePosition, this, aAssessmentDoc);
  }

  public boolean addHospitalStay(HospitalStay aHospitalStay) {
    boolean wasAdded = false;
    if (hospitalStaies.contains(aHospitalStay)) {
      return false;
    }
    AssessmentNurse existingAssessmentNurse = aHospitalStay.getAssessmentNurse();
    boolean isNewAssessmentNurse = existingAssessmentNurse != null && !this.equals(existingAssessmentNurse);
    if (isNewAssessmentNurse) {
      aHospitalStay.setAssessmentNurse(this);
    } else {
      hospitalStaies.add(aHospitalStay);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHospitalStay(HospitalStay aHospitalStay) {
    boolean wasRemoved = false;
    // Unable to remove aHospitalStay, as it must always have a assessmentNurse
    if (!this.equals(aHospitalStay.getAssessmentNurse())) {
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
  public static int minimumNumberOfNurses() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addNurse(Nurse aNurse) {
    boolean wasAdded = false;
    if (nurses.contains(aNurse)) {
      return false;
    }
    nurses.add(aNurse);
    if (aNurse.indexOfAssessmentNurse(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aNurse.addAssessmentNurse(this);
      if (!wasAdded) {
        nurses.remove(aNurse);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeNurse(Nurse aNurse) {
    boolean wasRemoved = false;
    if (!nurses.contains(aNurse)) {
      return wasRemoved;
    }

    int oldIndex = nurses.indexOf(aNurse);
    nurses.remove(oldIndex);
    if (aNurse.indexOfAssessmentNurse(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aNurse.removeAssessmentNurse(this);
      if (!wasRemoved) {
        nurses.add(oldIndex, aNurse);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addNurseAt(Nurse aNurse, int index) {
    boolean wasAdded = false;
    if (addNurse(aNurse)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfNurses()) {
        index = numberOfNurses() - 1;
      }
      nurses.remove(aNurse);
      nurses.add(index, aNurse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveNurseAt(Nurse aNurse, int index) {
    boolean wasAdded = false;
    if (nurses.contains(aNurse)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfNurses()) {
        index = numberOfNurses() - 1;
      }
      nurses.remove(aNurse);
      nurses.add(index, aNurse);
      wasAdded = true;
    } else {
      wasAdded = addNurseAt(aNurse, index);
    }
    return wasAdded;
  }

  public void delete() {
    for (int i = hospitalStaies.size(); i > 0; i--) {
      HospitalStay aHospitalStay = hospitalStaies.get(i - 1);
      aHospitalStay.delete();
    }
    ArrayList<Nurse> copyOfNurses = new ArrayList<Nurse>(nurses);
    nurses.clear();
    for (Nurse aNurse : copyOfNurses) {
      aNurse.removeAssessmentNurse(this);
    }
  }

}