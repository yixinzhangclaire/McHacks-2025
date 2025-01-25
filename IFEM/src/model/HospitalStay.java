/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.sql.Time;
import java.util.*;

// line 26 "model.ump"
// line 129 "model.ump"
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
  private Phase phase;

  //HospitalStay Associations
  private List<Queue> queues;
  private Patient patient;
  private IFEMs iFEMs;
  private List<AssessmentNurse> assessmentNurses;
  private List<AssessmentDoc> assessmentDocs;
  private Child child;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HospitalStay(Time aArrivalTime, Phase aPhase, Patient aPatient, IFEMs aIFEMs, Child aChild)
  {
    arrivalTime = aArrivalTime;
    avgWaitTime = null;
    phase = aPhase;
    queues = new ArrayList<Queue>();
    boolean didAddPatient = setPatient(aPatient);
    if (!didAddPatient)
    {
      throw new RuntimeException("Unable to create hospitalStay due to patient. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddIFEMs = setIFEMs(aIFEMs);
    if (!didAddIFEMs)
    {
      throw new RuntimeException("Unable to create hospitalStay due to iFEMs. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    assessmentNurses = new ArrayList<AssessmentNurse>();
    assessmentDocs = new ArrayList<AssessmentDoc>();
    boolean didAddChild = setChild(aChild);
    if (!didAddChild)
    {
      throw new RuntimeException("Unable to create hospitalStay due to child. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public Phase getPhase()
  {
    return phase;
  }
  /* Code from template association_GetMany */
  public Queue getQueue(int index)
  {
    Queue aQueue = queues.get(index);
    return aQueue;
  }

  public List<Queue> getQueues()
  {
    List<Queue> newQueues = Collections.unmodifiableList(queues);
    return newQueues;
  }

  public int numberOfQueues()
  {
    int number = queues.size();
    return number;
  }

  public boolean hasQueues()
  {
    boolean has = queues.size() > 0;
    return has;
  }

  public int indexOfQueue(Queue aQueue)
  {
    int index = queues.indexOf(aQueue);
    return index;
  }
  /* Code from template association_GetOne */
  public Patient getPatient()
  {
    return patient;
  }
  /* Code from template association_GetOne */
  public IFEMs getIFEMs()
  {
    return iFEMs;
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
  /* Code from template association_GetOne */
  public Child getChild()
  {
    return child;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfQueues()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfQueues()
  {
    return 2;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addQueue(Queue aQueue)
  {
    boolean wasAdded = false;
    if (queues.contains(aQueue)) { return false; }
    if (numberOfQueues() >= maximumNumberOfQueues())
    {
      return wasAdded;
    }

    queues.add(aQueue);
    if (aQueue.indexOfHospitalStay(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aQueue.addHospitalStay(this);
      if (!wasAdded)
      {
        queues.remove(aQueue);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeQueue(Queue aQueue)
  {
    boolean wasRemoved = false;
    if (!queues.contains(aQueue))
    {
      return wasRemoved;
    }

    int oldIndex = queues.indexOf(aQueue);
    queues.remove(oldIndex);
    if (aQueue.indexOfHospitalStay(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aQueue.removeHospitalStay(this);
      if (!wasRemoved)
      {
        queues.add(oldIndex,aQueue);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetOptionalNToMany */
  public boolean setQueues(Queue... newQueues)
  {
    boolean wasSet = false;
    ArrayList<Queue> verifiedQueues = new ArrayList<Queue>();
    for (Queue aQueue : newQueues)
    {
      if (verifiedQueues.contains(aQueue))
      {
        continue;
      }
      verifiedQueues.add(aQueue);
    }

    if (verifiedQueues.size() != newQueues.length || verifiedQueues.size() > maximumNumberOfQueues())
    {
      return wasSet;
    }

    ArrayList<Queue> oldQueues = new ArrayList<Queue>(queues);
    queues.clear();
    for (Queue aNewQueue : verifiedQueues)
    {
      queues.add(aNewQueue);
      if (oldQueues.contains(aNewQueue))
      {
        oldQueues.remove(aNewQueue);
      }
      else
      {
        aNewQueue.addHospitalStay(this);
      }
    }

    for (Queue anOldQueue : oldQueues)
    {
      anOldQueue.removeHospitalStay(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addQueueAt(Queue aQueue, int index)
  {  
    boolean wasAdded = false;
    if(addQueue(aQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfQueues()) { index = numberOfQueues() - 1; }
      queues.remove(aQueue);
      queues.add(index, aQueue);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveQueueAt(Queue aQueue, int index)
  {
    boolean wasAdded = false;
    if(queues.contains(aQueue))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfQueues()) { index = numberOfQueues() - 1; }
      queues.remove(aQueue);
      queues.add(index, aQueue);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addQueueAt(aQueue, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPatient(Patient aPatient)
  {
    boolean wasSet = false;
    if (aPatient == null)
    {
      return wasSet;
    }

    Patient existingPatient = patient;
    patient = aPatient;
    if (existingPatient != null && !existingPatient.equals(aPatient))
    {
      existingPatient.removeHospitalStay(this);
    }
    patient.addHospitalStay(this);
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
      existingIFEMs.removeHospitalStay(this);
    }
    iFEMs.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssessmentNurses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public AssessmentNurse addAssessmentNurse(Triage aTriage, Nurse aNurse, IFEMs aIFEMs)
  {
    return new AssessmentNurse(aTriage, aNurse, this, aIFEMs);
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
  public AssessmentDoc addAssessmentDoc(String aDescription, Doctor aDoctor, IFEMs aIFEMs)
  {
    return new AssessmentDoc(aDescription, this, aDoctor, aIFEMs);
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
  /* Code from template association_SetOneToMany */
  public boolean setChild(Child aChild)
  {
    boolean wasSet = false;
    if (aChild == null)
    {
      return wasSet;
    }

    Child existingChild = child;
    child = aChild;
    if (existingChild != null && !existingChild.equals(aChild))
    {
      existingChild.removeHospitalStay(this);
    }
    child.addHospitalStay(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Queue> copyOfQueues = new ArrayList<Queue>(queues);
    queues.clear();
    for(Queue aQueue : copyOfQueues)
    {
      aQueue.removeHospitalStay(this);
    }
    Patient placeholderPatient = patient;
    this.patient = null;
    if(placeholderPatient != null)
    {
      placeholderPatient.removeHospitalStay(this);
    }
    IFEMs placeholderIFEMs = iFEMs;
    this.iFEMs = null;
    if(placeholderIFEMs != null)
    {
      placeholderIFEMs.removeHospitalStay(this);
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
    Child placeholderChild = child;
    this.child = null;
    if(placeholderChild != null)
    {
      placeholderChild.removeHospitalStay(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalTime" + "=" + (getArrivalTime() != null ? !getArrivalTime().equals(this)  ? getArrivalTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "avgWaitTime" + "=" + (getAvgWaitTime() != null ? !getAvgWaitTime().equals(this)  ? getAvgWaitTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phase" + "=" + (getPhase() != null ? !getPhase().equals(this)  ? getPhase().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "patient = "+(getPatient()!=null?Integer.toHexString(System.identityHashCode(getPatient())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "iFEMs = "+(getIFEMs()!=null?Integer.toHexString(System.identityHashCode(getIFEMs())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "child = "+(getChild()!=null?Integer.toHexString(System.identityHashCode(getChild())):"null");
  }
}