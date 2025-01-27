/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/



// line 34 "model.ump"
// line 194 "model.ump"
public class AssessmentNurse
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Triage { Resuscitation, Emergent, Urgent, LessUrgent, NonUrgent }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssessmentNurse Attributes
  private Triage triage;

  //AssessmentNurse Associations
  private Nurse nurse;
  private HospitalStay hospitalStay;
  private IFEMs iFEMs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssessmentNurse(Triage aTriage, Nurse aNurse, HospitalStay aHospitalStay, IFEMs aIFEMs)
  {
    triage = aTriage;
    boolean didAddNurse = setNurse(aNurse);
    if (!didAddNurse)
    {
      throw new RuntimeException("Unable to create assessmentNurse due to nurse. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddHospitalStay = setHospitalStay(aHospitalStay);
    if (!didAddHospitalStay)
    {
      throw new RuntimeException("Unable to create assessmentNurse due to hospitalStay. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddIFEMs = setIFEMs(aIFEMs);
    if (!didAddIFEMs)
    {
      throw new RuntimeException("Unable to create assessmentNurse due to iFEMs. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTriage(Triage aTriage)
  {
    boolean wasSet = false;
    triage = aTriage;
    wasSet = true;
    return wasSet;
  }

  public Triage getTriage()
  {
    return triage;
  }
  /* Code from template association_GetOne */
  public Nurse getNurse()
  {
    return nurse;
  }
  /* Code from template association_GetOne */
  public HospitalStay getHospitalStay()
  {
    return hospitalStay;
  }
  /* Code from template association_GetOne */
  public IFEMs getIFEMs()
  {
    return iFEMs;
  }
  /* Code from template association_SetOneToMany */
  public boolean setNurse(Nurse aNurse)
  {
    boolean wasSet = false;
    if (aNurse == null)
    {
      return wasSet;
    }

    Nurse existingNurse = nurse;
    nurse = aNurse;
    if (existingNurse != null && !existingNurse.equals(aNurse))
    {
      existingNurse.removeAssessmentNurse(this);
    }
    nurse.addAssessmentNurse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHospitalStay(HospitalStay aHospitalStay)
  {
    boolean wasSet = false;
    if (aHospitalStay == null)
    {
      return wasSet;
    }

    HospitalStay existingHospitalStay = hospitalStay;
    hospitalStay = aHospitalStay;
    if (existingHospitalStay != null && !existingHospitalStay.equals(aHospitalStay))
    {
      existingHospitalStay.removeAssessmentNurse(this);
    }
    hospitalStay.addAssessmentNurse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIFEMs(IFEMs aIFEMs)
  {
    boolean wasSet = false;
    if (aIFEMs == null)
    {
      return wasSet;
    }

    IFEMs existingIFEMs = iFEMs;
    iFEMs = aIFEMs;
    if (existingIFEMs != null && !existingIFEMs.equals(aIFEMs))
    {
      existingIFEMs.removeAssessmentNurse(this);
    }
    iFEMs.addAssessmentNurse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Nurse placeholderNurse = nurse;
    this.nurse = null;
    if(placeholderNurse != null)
    {
      placeholderNurse.removeAssessmentNurse(this);
    }
    HospitalStay placeholderHospitalStay = hospitalStay;
    this.hospitalStay = null;
    if(placeholderHospitalStay != null)
    {
      placeholderHospitalStay.removeAssessmentNurse(this);
    }
    IFEMs placeholderIFEMs = iFEMs;
    this.iFEMs = null;
    if(placeholderIFEMs != null)
    {
      placeholderIFEMs.removeAssessmentNurse(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "triage" + "=" + (getTriage() != null ? !getTriage().equals(this)  ? getTriage().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "nurse = "+(getNurse()!=null?Integer.toHexString(System.identityHashCode(getNurse())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalStay = "+(getHospitalStay()!=null?Integer.toHexString(System.identityHashCode(getHospitalStay())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "iFEMs = "+(getIFEMs()!=null?Integer.toHexString(System.identityHashCode(getIFEMs())):"null");
  }
}