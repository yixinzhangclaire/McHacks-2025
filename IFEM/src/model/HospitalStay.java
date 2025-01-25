/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Time;

// line 24 "model.ump"
// line 108 "model.ump"
public class HospitalStay
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HospitalStay Attributes
  private Time arrivalTime;
  private Time avgWaitTime;
  private int queuePosition;

  //HospitalStay Associations
  private IFEM iFEM;
  private AssessmentDoc assessmentDoc;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HospitalStay(Time aArrivalTime, IFEM aIFEM, AssessmentDoc aAssessmentDoc)
  {
    arrivalTime = aArrivalTime;
    avgWaitTime = null;
    queuePosition = 0;
    boolean didAddIFEM = setIFEM(aIFEM);
    if (!didAddIFEM)
    {
      throw new RuntimeException("Unable to create hospitalStay due to iFEM. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddAssessmentDoc = setAssessmentDoc(aAssessmentDoc);
    if (!didAddAssessmentDoc)
    {
      throw new RuntimeException("Unable to create hospitalStay due to assessmentDoc. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setArrivalTime(Time aArrivalTime)
  {
    boolean wasSet = false;
    arrivalTime = aArrivalTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvgWaitTime(Time aAvgWaitTime)
  {
    boolean wasSet = false;
    avgWaitTime = aAvgWaitTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setQueuePosition(int aQueuePosition)
  {
    boolean wasSet = false;
    queuePosition = aQueuePosition;
    wasSet = true;
    return wasSet;
  }

  public Time getArrivalTime()
  {
    return arrivalTime;
  }

  public Time getAvgWaitTime()
  {
    return avgWaitTime;
  }

  public int getQueuePosition()
  {
    return queuePosition;
  }
  /* Code from template association_GetOne */
  public IFEM getIFEM()
  {
    return iFEM;
  }
  /* Code from template association_GetOne */
  public AssessmentDoc getAssessmentDoc()
  {
    return assessmentDoc;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIFEM(IFEM aIFEM)
  {
    boolean wasSet = false;
    if (aIFEM == null)
    {
      return wasSet;
    }

    IFEM existingIFEM = iFEM;
    iFEM = aIFEM;
    if (existingIFEM != null && !existingIFEM.equals(aIFEM))
    {
      existingIFEM.removeHospitalStay(this);
    }
    iFEM.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAssessmentDoc(AssessmentDoc aAssessmentDoc)
  {
    boolean wasSet = false;
    if (aAssessmentDoc == null)
    {
      return wasSet;
    }

    AssessmentDoc existingAssessmentDoc = assessmentDoc;
    assessmentDoc = aAssessmentDoc;
    if (existingAssessmentDoc != null && !existingAssessmentDoc.equals(aAssessmentDoc))
    {
      existingAssessmentDoc.removeHospitalStay(this);
    }
    assessmentDoc.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IFEM placeholderIFEM = iFEM;
    this.iFEM = null;
    if(placeholderIFEM != null)
    {
      placeholderIFEM.removeHospitalStay(this);
    }
    AssessmentDoc placeholderAssessmentDoc = assessmentDoc;
    this.assessmentDoc = null;
    if(placeholderAssessmentDoc != null)
    {
      placeholderAssessmentDoc.removeHospitalStay(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "queuePosition" + ":" + getQueuePosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalTime" + "=" + (getArrivalTime() != null ? !getArrivalTime().equals(this)  ? getArrivalTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "avgWaitTime" + "=" + (getAvgWaitTime() != null ? !getAvgWaitTime().equals(this)  ? getAvgWaitTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iFEM = "+(getIFEM()!=null?Integer.toHexString(System.identityHashCode(getIFEM())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "assessmentDoc = "+(getAssessmentDoc()!=null?Integer.toHexString(System.identityHashCode(getAssessmentDoc())):"null");
  }
}