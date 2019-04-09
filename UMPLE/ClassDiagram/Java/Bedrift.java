/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 37 "model.ump"
// line 76 "model.ump"
public class Bedrift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bedrift Attributes
  private int bedriftid;
  private String bedriftnavn;
  private String bedriftbeskrivelse;

  //Bedrift Associations
  private List<Prosjekt> prosjekts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Bedrift(int aBedriftid, String aBedriftnavn, String aBedriftbeskrivelse)
  {
    bedriftid = aBedriftid;
    bedriftnavn = aBedriftnavn;
    bedriftbeskrivelse = aBedriftbeskrivelse;
    prosjekts = new ArrayList<Prosjekt>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBedriftid(int aBedriftid)
  {
    boolean wasSet = false;
    bedriftid = aBedriftid;
    wasSet = true;
    return wasSet;
  }

  public boolean setBedriftnavn(String aBedriftnavn)
  {
    boolean wasSet = false;
    bedriftnavn = aBedriftnavn;
    wasSet = true;
    return wasSet;
  }

  public boolean setBedriftbeskrivelse(String aBedriftbeskrivelse)
  {
    boolean wasSet = false;
    bedriftbeskrivelse = aBedriftbeskrivelse;
    wasSet = true;
    return wasSet;
  }

  public int getBedriftid()
  {
    return bedriftid;
  }

  public String getBedriftnavn()
  {
    return bedriftnavn;
  }

  public String getBedriftbeskrivelse()
  {
    return bedriftbeskrivelse;
  }
  /* Code from template association_GetMany */
  public Prosjekt getProsjekt(int index)
  {
    Prosjekt aProsjekt = prosjekts.get(index);
    return aProsjekt;
  }

  public List<Prosjekt> getProsjekts()
  {
    List<Prosjekt> newProsjekts = Collections.unmodifiableList(prosjekts);
    return newProsjekts;
  }

  public int numberOfProsjekts()
  {
    int number = prosjekts.size();
    return number;
  }

  public boolean hasProsjekts()
  {
    boolean has = prosjekts.size() > 0;
    return has;
  }

  public int indexOfProsjekt(Prosjekt aProsjekt)
  {
    int index = prosjekts.indexOf(aProsjekt);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProsjekts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prosjekt addProsjekt(int aProsjektid, String aProsjektnavn, String aProsjektbeskrivelse, Arrangement aArrangement, Studie aStudie)
  {
    return new Prosjekt(aProsjektid, aProsjektnavn, aProsjektbeskrivelse, aArrangement, this, aStudie);
  }

  public boolean addProsjekt(Prosjekt aProsjekt)
  {
    boolean wasAdded = false;
    if (prosjekts.contains(aProsjekt)) { return false; }
    Bedrift existingBedrift = aProsjekt.getBedrift();
    boolean isNewBedrift = existingBedrift != null && !this.equals(existingBedrift);
    if (isNewBedrift)
    {
      aProsjekt.setBedrift(this);
    }
    else
    {
      prosjekts.add(aProsjekt);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProsjekt(Prosjekt aProsjekt)
  {
    boolean wasRemoved = false;
    //Unable to remove aProsjekt, as it must always have a bedrift
    if (!this.equals(aProsjekt.getBedrift()))
    {
      prosjekts.remove(aProsjekt);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addProsjektAt(Prosjekt aProsjekt, int index)
  {  
    boolean wasAdded = false;
    if(addProsjekt(aProsjekt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProsjekts()) { index = numberOfProsjekts() - 1; }
      prosjekts.remove(aProsjekt);
      prosjekts.add(index, aProsjekt);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProsjektAt(Prosjekt aProsjekt, int index)
  {
    boolean wasAdded = false;
    if(prosjekts.contains(aProsjekt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProsjekts()) { index = numberOfProsjekts() - 1; }
      prosjekts.remove(aProsjekt);
      prosjekts.add(index, aProsjekt);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProsjektAt(aProsjekt, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=prosjekts.size(); i > 0; i--)
    {
      Prosjekt aProsjekt = prosjekts.get(i - 1);
      aProsjekt.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "bedriftid" + ":" + getBedriftid()+ "," +
            "bedriftnavn" + ":" + getBedriftnavn()+ "," +
            "bedriftbeskrivelse" + ":" + getBedriftbeskrivelse()+ "]";
  }
}