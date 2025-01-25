/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.7523.c616a4dce modeling language!*/


import java.util.*;

// line 72 "model.ump"
// line 147 "model.ump"
public class AssessmentDoc
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssessmentDoc Attributes
  private String description;

  //AssessmentDoc Associations
  private HospitalStay hospitalStay;
  private Doctor doctor;
  private TreatmentPlan treatmentPlan;
  private List<Test> tests;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssessmentDoc(String aDescription, HospitalStay aHospitalStay, Doctor aDoctor)
  {
    description = aDescription;
    boolean didAddHospitalStay = setHospitalStay(aHospitalStay);
    if (!didAddHospitalStay)
    {
      throw new RuntimeException("Unable to create assessmentDoc due to hospitalStay. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aDoctor == null || aDoctor.getAssessmentDoc() != null)
    {
      throw new RuntimeException("Unable to create AssessmentDoc due to aDoctor. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctor = aDoctor;
    tests = new ArrayList<Test>();
  }

  public AssessmentDoc(String aDescription, HospitalStay aHospitalStay, String aEmailForDoctor, String aPasswordForDoctor, IFEM aIFEMForDoctor, Person aPersonForDoctor, int aEmployeeIDForDoctor)
  {
    description = aDescription;
    boolean didAddHospitalStay = setHospitalStay(aHospitalStay);
    if (!didAddHospitalStay)
    {
      throw new RuntimeException("Unable to create assessmentDoc due to hospitalStay. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctor = new Doctor(aEmailForDoctor, aPasswordForDoctor, aIFEMForDoctor, aPersonForDoctor, aEmployeeIDForDoctor, this);
    tests = new ArrayList<Test>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }
  /* Code from template association_GetOne */
  public HospitalStay getHospitalStay()
  {
    return hospitalStay;
  }
  /* Code from template association_GetOne */
  public Doctor getDoctor()
  {
    return doctor;
  }
  /* Code from template association_GetOne */
  public TreatmentPlan getTreatmentPlan()
  {
    return treatmentPlan;
  }

  public boolean hasTreatmentPlan()
  {
    boolean has = treatmentPlan != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Test getTest(int index)
  {
    Test aTest = tests.get(index);
    return aTest;
  }

  public List<Test> getTests()
  {
    List<Test> newTests = Collections.unmodifiableList(tests);
    return newTests;
  }

  public int numberOfTests()
  {
    int number = tests.size();
    return number;
  }

  public boolean hasTests()
  {
    boolean has = tests.size() > 0;
    return has;
  }

  public int indexOfTest(Test aTest)
  {
    int index = tests.indexOf(aTest);
    return index;
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
      existingHospitalStay.removeAssessmentDoc(this);
    }
    hospitalStay.addAssessmentDoc(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTreatmentPlan(TreatmentPlan aTreatmentPlan)
  {
    boolean wasSet = false;
    TreatmentPlan existingTreatmentPlan = treatmentPlan;
    treatmentPlan = aTreatmentPlan;
    if (existingTreatmentPlan != null && !existingTreatmentPlan.equals(aTreatmentPlan))
    {
      existingTreatmentPlan.removeAssessmentDoc(this);
    }
    if (aTreatmentPlan != null)
    {
      aTreatmentPlan.addAssessmentDoc(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTests()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTest(Test aTest)
  {
    boolean wasAdded = false;
    if (tests.contains(aTest)) { return false; }
    tests.add(aTest);
    if (aTest.indexOfAssessmentDoc(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTest.addAssessmentDoc(this);
      if (!wasAdded)
      {
        tests.remove(aTest);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTest(Test aTest)
  {
    boolean wasRemoved = false;
    if (!tests.contains(aTest))
    {
      return wasRemoved;
    }

    int oldIndex = tests.indexOf(aTest);
    tests.remove(oldIndex);
    if (aTest.indexOfAssessmentDoc(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTest.removeAssessmentDoc(this);
      if (!wasRemoved)
      {
        tests.add(oldIndex,aTest);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTestAt(Test aTest, int index)
  {  
    boolean wasAdded = false;
    if(addTest(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTestAt(Test aTest, int index)
  {
    boolean wasAdded = false;
    if(tests.contains(aTest))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTests()) { index = numberOfTests() - 1; }
      tests.remove(aTest);
      tests.add(index, aTest);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTestAt(aTest, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    HospitalStay placeholderHospitalStay = hospitalStay;
    this.hospitalStay = null;
    if(placeholderHospitalStay != null)
    {
      placeholderHospitalStay.removeAssessmentDoc(this);
    }
    Doctor existingDoctor = doctor;
    doctor = null;
    if (existingDoctor != null)
    {
      existingDoctor.delete();
    }
    if (treatmentPlan != null)
    {
      TreatmentPlan placeholderTreatmentPlan = treatmentPlan;
      this.treatmentPlan = null;
      placeholderTreatmentPlan.removeAssessmentDoc(this);
    }
    ArrayList<Test> copyOfTests = new ArrayList<Test>(tests);
    tests.clear();
    for(Test aTest : copyOfTests)
    {
      aTest.removeAssessmentDoc(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalStay = "+(getHospitalStay()!=null?Integer.toHexString(System.identityHashCode(getHospitalStay())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "doctor = "+(getDoctor()!=null?Integer.toHexString(System.identityHashCode(getDoctor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "treatmentPlan = "+(getTreatmentPlan()!=null?Integer.toHexString(System.identityHashCode(getTreatmentPlan())):"null");
  }
}