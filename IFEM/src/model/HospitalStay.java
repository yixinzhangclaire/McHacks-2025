/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Time;
import java.util.*;

// line 24 "model.ump"
// line 114 "model.ump"
public class HospitalStay
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Phase { Registered, Triaged, InvestigationPending, Ordered, Pending, Reported }
  public enum Triage { Resuscitation, Emergent, Urgent, LessUrgent, NonUrgent }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HospitalStay Attributes
  private Time arrivalTime;
  private Time avgWaitTime;
  private int queuePosition;
  private Phase phase;

  //HospitalStay Associations
  private IFEM iFEM;
  private List<AssessmentNurse> assessmentNurses;
  private List<AssessmentDoc> assessmentDocs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HospitalStay(Time aArrivalTime, Phase aPhase, IFEM aIFEM)
  {
    arrivalTime = aArrivalTime;
    avgWaitTime = null;
    queuePosition = 0;
    phase = aPhase;
    boolean didAddIFEM = setIFEM(aIFEM);
    if (!didAddIFEM)
    {
      throw new RuntimeException("Unable to create hospitalStay due to iFEM. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    assessmentNurses = new ArrayList<AssessmentNurse>();
    assessmentDocs = new ArrayList<AssessmentDoc>();
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

  public boolean setPhase(Phase aPhase)
  {
    boolean wasSet = false;
    phase = aPhase;
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

  public Phase getPhase()
  {
    return phase;
  }
  /* Code from template association_GetOne */
  public IFEM getIFEM()
  {
    return iFEM;
  }
  /* Code from template association_GetMany */
  public AssessmentNurse getAssessmentNurse(int index)
  {
    AssessmentNurse aAssessmentNurse = assessmentNurses.get(index);
    return aAssessmentNurse;
  }

  public List<AssessmentNurse> getAssessmentNurses()
  {
    List<AssessmentNurse> newAssessmentNurses = Collections.unmodifiableList(assessmentNurses);
    return newAssessmentNurses;
  }

  public int numberOfAssessmentNurses()
  {
    int number = assessmentNurses.size();
    return number;
  }

  public boolean hasAssessmentNurses()
  {
    boolean has = assessmentNurses.size() > 0;
    return has;
  }

  public int indexOfAssessmentNurse(AssessmentNurse aAssessmentNurse)
  {
    int index = assessmentNurses.indexOf(aAssessmentNurse);
    return index;
  }
  /* Code from template association_GetMany */
  public AssessmentDoc getAssessmentDoc(int index)
  {
    AssessmentDoc aAssessmentDoc = assessmentDocs.get(index);
    return aAssessmentDoc;
  }

  public List<AssessmentDoc> getAssessmentDocs()
  {
    List<AssessmentDoc> newAssessmentDocs = Collections.unmodifiableList(assessmentDocs);
    return newAssessmentDocs;
  }

  public int numberOfAssessmentDocs()
  {
    int number = assessmentDocs.size();
    return number;
  }

  public boolean hasAssessmentDocs()
  {
    boolean has = assessmentDocs.size() > 0;
    return has;
  }

  public int indexOfAssessmentDoc(AssessmentDoc aAssessmentDoc)
  {
    int index = assessmentDocs.indexOf(aAssessmentDoc);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssessmentNurses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public AssessmentNurse addAssessmentNurse(Triage aTriage, Nurse aNurse)
  {
    return new AssessmentNurse(aTriage, aNurse, this);
  }

  public boolean addAssessmentNurse(AssessmentNurse aAssessmentNurse)
  {
    boolean wasAdded = false;
    if (assessmentNurses.contains(aAssessmentNurse)) { return false; }
    HospitalStay existingHospitalStay = aAssessmentNurse.getHospitalStay();
    boolean isNewHospitalStay = existingHospitalStay != null && !this.equals(existingHospitalStay);
    if (isNewHospitalStay)
    {
      aAssessmentNurse.setHospitalStay(this);
    }
    else
    {
      assessmentNurses.add(aAssessmentNurse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssessmentNurse(AssessmentNurse aAssessmentNurse)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssessmentNurse, as it must always have a hospitalStay
    if (!this.equals(aAssessmentNurse.getHospitalStay()))
    {
      assessmentNurses.remove(aAssessmentNurse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssessmentNurseAt(AssessmentNurse aAssessmentNurse, int index)
  {  
    boolean wasAdded = false;
    if(addAssessmentNurse(aAssessmentNurse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssessmentNurses()) { index = numberOfAssessmentNurses() - 1; }
      assessmentNurses.remove(aAssessmentNurse);
      assessmentNurses.add(index, aAssessmentNurse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssessmentNurseAt(AssessmentNurse aAssessmentNurse, int index)
  {
    boolean wasAdded = false;
    if(assessmentNurses.contains(aAssessmentNurse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssessmentNurses()) { index = numberOfAssessmentNurses() - 1; }
      assessmentNurses.remove(aAssessmentNurse);
      assessmentNurses.add(index, aAssessmentNurse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssessmentNurseAt(aAssessmentNurse, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssessmentDocs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public AssessmentDoc addAssessmentDoc(String aDescription, Doctor aDoctor)
  {
    return new AssessmentDoc(aDescription, this, aDoctor);
  }

  public boolean addAssessmentDoc(AssessmentDoc aAssessmentDoc)
  {
    boolean wasAdded = false;
    if (assessmentDocs.contains(aAssessmentDoc)) { return false; }
    HospitalStay existingHospitalStay = aAssessmentDoc.getHospitalStay();
    boolean isNewHospitalStay = existingHospitalStay != null && !this.equals(existingHospitalStay);
    if (isNewHospitalStay)
    {
      aAssessmentDoc.setHospitalStay(this);
    }
    else
    {
      assessmentDocs.add(aAssessmentDoc);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssessmentDoc(AssessmentDoc aAssessmentDoc)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssessmentDoc, as it must always have a hospitalStay
    if (!this.equals(aAssessmentDoc.getHospitalStay()))
    {
      assessmentDocs.remove(aAssessmentDoc);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssessmentDocAt(AssessmentDoc aAssessmentDoc, int index)
  {  
    boolean wasAdded = false;
    if(addAssessmentDoc(aAssessmentDoc))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssessmentDocs()) { index = numberOfAssessmentDocs() - 1; }
      assessmentDocs.remove(aAssessmentDoc);
      assessmentDocs.add(index, aAssessmentDoc);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssessmentDocAt(AssessmentDoc aAssessmentDoc, int index)
  {
    boolean wasAdded = false;
    if(assessmentDocs.contains(aAssessmentDoc))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssessmentDocs()) { index = numberOfAssessmentDocs() - 1; }
      assessmentDocs.remove(aAssessmentDoc);
      assessmentDocs.add(index, aAssessmentDoc);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssessmentDocAt(aAssessmentDoc, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    IFEM placeholderIFEM = iFEM;
    this.iFEM = null;
    if(placeholderIFEM != null)
    {
      placeholderIFEM.removeHospitalStay(this);
    }
    for(int i=assessmentNurses.size(); i > 0; i--)
    {
      AssessmentNurse aAssessmentNurse = assessmentNurses.get(i - 1);
      aAssessmentNurse.delete();
    }
    for(int i=assessmentDocs.size(); i > 0; i--)
    {
      AssessmentDoc aAssessmentDoc = assessmentDocs.get(i - 1);
      aAssessmentDoc.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "queuePosition" + ":" + getQueuePosition()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalTime" + "=" + (getArrivalTime() != null ? !getArrivalTime().equals(this)  ? getArrivalTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "avgWaitTime" + "=" + (getAvgWaitTime() != null ? !getAvgWaitTime().equals(this)  ? getAvgWaitTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phase" + "=" + (getPhase() != null ? !getPhase().equals(this)  ? getPhase().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iFEM = "+(getIFEM()!=null?Integer.toHexString(System.identityHashCode(getIFEM())):"null");
  }
}