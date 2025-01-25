/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 99 "model.ump"
// line 178 "model.ump"
public class MedicalRecord
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MedicalRecord Associations
  private Patient patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MedicalRecord(Patient aPatient)
  {
    if (aPatient == null || aPatient.getMedicalRecord() != null)
    {
      throw new RuntimeException("Unable to create MedicalRecord due to aPatient. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patient = aPatient;
  }

  public MedicalRecord(String aEmailForPatient, String aPasswordForPatient, IFEM aIFEMForPatient, Person aPersonForPatient, String aIdForPatient)
  {
    patient = new Patient(aEmailForPatient, aPasswordForPatient, aIFEMForPatient, aPersonForPatient, aIdForPatient, this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }

  public void delete()
  {
    Patient existingPatient = patient;
    patient = null;
    if (existingPatient != null)
    {
      existingPatient.delete();
    }
  }

}