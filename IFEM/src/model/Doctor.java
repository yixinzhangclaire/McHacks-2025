/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 41 "model.ump"
// line 129 "model.ump"
public class Doctor extends Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Associations
  private AssessmentDoc assessmentDoc;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Doctor(String aEmail, String aPassword, IFEM aIFEM, Person aPerson, int aEmployeeID, AssessmentDoc aAssessmentDoc)
  {
    super(aEmail, aPassword, aIFEM, aPerson, aEmployeeID);
    if (aAssessmentDoc == null || aAssessmentDoc.getDoctor() != null)
    {
      throw new RuntimeException("Unable to create Doctor due to aAssessmentDoc. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    assessmentDoc = aAssessmentDoc;
  }

  public Doctor(String aEmail, String aPassword, IFEM aIFEM, Person aPerson, int aEmployeeID, String aDescriptionForAssessmentDoc, HospitalStay aHospitalStayForAssessmentDoc)
  {
    super(aEmail, aPassword, aIFEM, aPerson, aEmployeeID);
    assessmentDoc = new AssessmentDoc(aDescriptionForAssessmentDoc, aHospitalStayForAssessmentDoc, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public AssessmentDoc getAssessmentDoc()
  {
    return assessmentDoc;
  }

  public void delete()
  {
    AssessmentDoc existingAssessmentDoc = assessmentDoc;
    assessmentDoc = null;
    if (existingAssessmentDoc != null)
    {
      existingAssessmentDoc.delete();
    }
    super.delete();
  }

}