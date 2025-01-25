package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.util.*;

// line 42 "model.ump"
// line 117 "model.ump"
public class Nurse extends Employee {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Nurse Associations
  private List<AssessmentNurse> assessmentNurses;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public Nurse(String aEmail, String aPassword, Person aPerson, int aEmployeeID) {
    super(aEmail, aPassword, aPerson, aEmployeeID);
    assessmentNurses = new ArrayList<AssessmentNurse>();
  }

  // ------------------------
  // INTERFACE
  // ------------------------
  /* Code from template association_GetMany */
  public AssessmentNurse getAssessmentNurse(int index) {
    AssessmentNurse aAssessmentNurse = assessmentNurses.get(index);
    return aAssessmentNurse;
  }

  public List<AssessmentNurse> getAssessmentNurses() {
    List<AssessmentNurse> newAssessmentNurses = Collections.unmodifiableList(assessmentNurses);
    return newAssessmentNurses;
  }

  public int numberOfAssessmentNurses() {
    int number = assessmentNurses.size();
    return number;
  }

  public boolean hasAssessmentNurses() {
    boolean has = assessmentNurses.size() > 0;
    return has;
  }

  public int indexOfAssessmentNurse(AssessmentNurse aAssessmentNurse) {
    int index = assessmentNurses.indexOf(aAssessmentNurse);
    return index;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssessmentNurses() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addAssessmentNurse(AssessmentNurse aAssessmentNurse) {
    boolean wasAdded = false;
    if (assessmentNurses.contains(aAssessmentNurse)) {
      return false;
    }
    assessmentNurses.add(aAssessmentNurse);
    if (aAssessmentNurse.indexOfNurse(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aAssessmentNurse.addNurse(this);
      if (!wasAdded) {
        assessmentNurses.remove(aAssessmentNurse);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeAssessmentNurse(AssessmentNurse aAssessmentNurse) {
    boolean wasRemoved = false;
    if (!assessmentNurses.contains(aAssessmentNurse)) {
      return wasRemoved;
    }

    int oldIndex = assessmentNurses.indexOf(aAssessmentNurse);
    assessmentNurses.remove(oldIndex);
    if (aAssessmentNurse.indexOfNurse(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aAssessmentNurse.removeNurse(this);
      if (!wasRemoved) {
        assessmentNurses.add(oldIndex, aAssessmentNurse);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssessmentNurseAt(AssessmentNurse aAssessmentNurse, int index) {
    boolean wasAdded = false;
    if (addAssessmentNurse(aAssessmentNurse)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfAssessmentNurses()) {
        index = numberOfAssessmentNurses() - 1;
      }
      assessmentNurses.remove(aAssessmentNurse);
      assessmentNurses.add(index, aAssessmentNurse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssessmentNurseAt(AssessmentNurse aAssessmentNurse, int index) {
    boolean wasAdded = false;
    if (assessmentNurses.contains(aAssessmentNurse)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfAssessmentNurses()) {
        index = numberOfAssessmentNurses() - 1;
      }
      assessmentNurses.remove(aAssessmentNurse);
      assessmentNurses.add(index, aAssessmentNurse);
      wasAdded = true;
    } else {
      wasAdded = addAssessmentNurseAt(aAssessmentNurse, index);
    }
    return wasAdded;
  }

  public void delete() {
    ArrayList<AssessmentNurse> copyOfAssessmentNurses = new ArrayList<AssessmentNurse>(assessmentNurses);
    assessmentNurses.clear();
    for (AssessmentNurse aAssessmentNurse : copyOfAssessmentNurses) {
      aAssessmentNurse.removeNurse(this);
    }
    super.delete();
  }

}