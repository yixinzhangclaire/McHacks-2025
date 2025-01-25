package model;
/*PLEASE DO NOT EDIT THIS CODE*/

/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/

import java.util.*;

// line 34 "model.ump"
// line 111 "model.ump"
public class Doctor extends Employee {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Doctor Associations
  private List<AssessmentDoc> assessmentDocs;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public Doctor(String aEmail, String aPassword, Person aPerson, int aEmployeeID) {
    super(aEmail, aPassword, aPerson, aEmployeeID);
    assessmentDocs = new ArrayList<AssessmentDoc>();
  }

  // ------------------------
  // INTERFACE
  // ------------------------
  /* Code from template association_GetMany */
  public AssessmentDoc getAssessmentDoc(int index) {
    AssessmentDoc aAssessmentDoc = assessmentDocs.get(index);
    return aAssessmentDoc;
  }

  public List<AssessmentDoc> getAssessmentDocs() {
    List<AssessmentDoc> newAssessmentDocs = Collections.unmodifiableList(assessmentDocs);
    return newAssessmentDocs;
  }

  public int numberOfAssessmentDocs() {
    int number = assessmentDocs.size();
    return number;
  }

  public boolean hasAssessmentDocs() {
    boolean has = assessmentDocs.size() > 0;
    return has;
  }

  public int indexOfAssessmentDoc(AssessmentDoc aAssessmentDoc) {
    int index = assessmentDocs.indexOf(aAssessmentDoc);
    return index;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssessmentDocs() {
    return 0;
  }

  /* Code from template association_AddManyToManyMethod */
  public boolean addAssessmentDoc(AssessmentDoc aAssessmentDoc) {
    boolean wasAdded = false;
    if (assessmentDocs.contains(aAssessmentDoc)) {
      return false;
    }
    assessmentDocs.add(aAssessmentDoc);
    if (aAssessmentDoc.indexOfDoctor(this) != -1) {
      wasAdded = true;
    } else {
      wasAdded = aAssessmentDoc.addDoctor(this);
      if (!wasAdded) {
        assessmentDocs.remove(aAssessmentDoc);
      }
    }
    return wasAdded;
  }

  /* Code from template association_RemoveMany */
  public boolean removeAssessmentDoc(AssessmentDoc aAssessmentDoc) {
    boolean wasRemoved = false;
    if (!assessmentDocs.contains(aAssessmentDoc)) {
      return wasRemoved;
    }

    int oldIndex = assessmentDocs.indexOf(aAssessmentDoc);
    assessmentDocs.remove(oldIndex);
    if (aAssessmentDoc.indexOfDoctor(this) == -1) {
      wasRemoved = true;
    } else {
      wasRemoved = aAssessmentDoc.removeDoctor(this);
      if (!wasRemoved) {
        assessmentDocs.add(oldIndex, aAssessmentDoc);
      }
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssessmentDocAt(AssessmentDoc aAssessmentDoc, int index) {
    boolean wasAdded = false;
    if (addAssessmentDoc(aAssessmentDoc)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfAssessmentDocs()) {
        index = numberOfAssessmentDocs() - 1;
      }
      assessmentDocs.remove(aAssessmentDoc);
      assessmentDocs.add(index, aAssessmentDoc);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssessmentDocAt(AssessmentDoc aAssessmentDoc, int index) {
    boolean wasAdded = false;
    if (assessmentDocs.contains(aAssessmentDoc)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfAssessmentDocs()) {
        index = numberOfAssessmentDocs() - 1;
      }
      assessmentDocs.remove(aAssessmentDoc);
      assessmentDocs.add(index, aAssessmentDoc);
      wasAdded = true;
    } else {
      wasAdded = addAssessmentDocAt(aAssessmentDoc, index);
    }
    return wasAdded;
  }

  public void delete() {
    ArrayList<AssessmentDoc> copyOfAssessmentDocs = new ArrayList<AssessmentDoc>(assessmentDocs);
    assessmentDocs.clear();
    for (AssessmentDoc aAssessmentDoc : copyOfAssessmentDocs) {
      aAssessmentDoc.removeDoctor(this);
    }
    super.delete();
  }

}