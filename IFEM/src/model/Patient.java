/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 9 "model.ump"
// line 103 "model.ump"
public class Patient extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;

  //Patient Associations
  private MedicalRecord medicalRecord;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aEmail, String aPassword, IFEM aIFEM, String aId, MedicalRecord aMedicalRecord)
  {
    super(aEmail, aPassword, aIFEM);
    id = aId;
    if (aMedicalRecord == null || aMedicalRecord.getPatient() != null)
    {
      throw new RuntimeException("Unable to create Patient due to aMedicalRecord. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    medicalRecord = aMedicalRecord;
  }

  public Patient(String aEmail, String aPassword, IFEM aIFEM, String aId)
  {
    super(aEmail, aPassword, aIFEM);
    id = aId;
    medicalRecord = new MedicalRecord(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public MedicalRecord getMedicalRecord()
  {
    return medicalRecord;
  }

  public void delete()
  {
    MedicalRecord existingMedicalRecord = medicalRecord;
    medicalRecord = null;
    if (existingMedicalRecord != null)
    {
      existingMedicalRecord.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "medicalRecord = "+(getMedicalRecord()!=null?Integer.toHexString(System.identityHashCode(getMedicalRecord())):"null");
  }
}