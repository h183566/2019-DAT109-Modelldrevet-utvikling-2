/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;
import java.sql.Time;

// line 31 "model.ump"
// line 71 "model.ump"
public class Arrangement
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Arrangement Attributes
  private int arrangementid;
  private String arrangementnavn;
  private String arrangementbeskrivelse;

  //Arrangement Associations
  private List<Stemme> stemmes;
  private List<Prosjekt> prosjekts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Arrangement(int aArrangementid, String aArrangementnavn, String aArrangementbeskrivelse)
  {
    arrangementid = aArrangementid;
    arrangementnavn = aArrangementnavn;
    arrangementbeskrivelse = aArrangementbeskrivelse;
    stemmes = new ArrayList<Stemme>();
    prosjekts = new ArrayList<Prosjekt>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setArrangementid(int aArrangementid)
  {
    boolean wasSet = false;
    arrangementid = aArrangementid;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrangementnavn(String aArrangementnavn)
  {
    boolean wasSet = false;
    arrangementnavn = aArrangementnavn;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrangementbeskrivelse(String aArrangementbeskrivelse)
  {
    boolean wasSet = false;
    arrangementbeskrivelse = aArrangementbeskrivelse;
    wasSet = true;
    return wasSet;
  }

  public int getArrangementid()
  {
    return arrangementid;
  }

  public String getArrangementnavn()
  {
    return arrangementnavn;
  }

  public String getArrangementbeskrivelse()
  {
    return arrangementbeskrivelse;
  }
  /* Code from template association_GetMany */
  public Stemme getStemme(int index)
  {
    Stemme aStemme = stemmes.get(index);
    return aStemme;
  }

  public List<Stemme> getStemmes()
  {
    List<Stemme> newStemmes = Collections.unmodifiableList(stemmes);
    return newStemmes;
  }

  public int numberOfStemmes()
  {
    int number = stemmes.size();
    return number;
  }

  public boolean hasStemmes()
  {
    boolean has = stemmes.size() > 0;
    return has;
  }

  public int indexOfStemme(Stemme aStemme)
  {
    int index = stemmes.indexOf(aStemme);
    return index;
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
  public static int minimumNumberOfStemmes()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Stemme addStemme(int aStemmeid, String aEpost, int aStemmeverdi, Time aStemmetidspunkt, Prosjekt aProsjekt)
  {
    return new Stemme(aStemmeid, aEpost, aStemmeverdi, aStemmetidspunkt, this, aProsjekt);
  }

  public boolean addStemme(Stemme aStemme)
  {
    boolean wasAdded = false;
    if (stemmes.contains(aStemme)) { return false; }
    Arrangement existingArrangement = aStemme.getArrangement();
    boolean isNewArrangement = existingArrangement != null && !this.equals(existingArrangement);
    if (isNewArrangement)
    {
      aStemme.setArrangement(this);
    }
    else
    {
      stemmes.add(aStemme);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStemme(Stemme aStemme)
  {
    boolean wasRemoved = false;
    //Unable to remove aStemme, as it must always have a arrangement
    if (!this.equals(aStemme.getArrangement()))
    {
      stemmes.remove(aStemme);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStemmeAt(Stemme aStemme, int index)
  {  
    boolean wasAdded = false;
    if(addStemme(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStemmeAt(Stemme aStemme, int index)
  {
    boolean wasAdded = false;
    if(stemmes.contains(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStemmeAt(aStemme, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProsjekts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prosjekt addProsjekt(int aProsjektid, String aProsjektnavn, String aProsjektbeskrivelse, Bedrift aBedrift, Studie aStudie)
  {
    return new Prosjekt(aProsjektid, aProsjektnavn, aProsjektbeskrivelse, this, aBedrift, aStudie);
  }

  public boolean addProsjekt(Prosjekt aProsjekt)
  {
    boolean wasAdded = false;
    if (prosjekts.contains(aProsjekt)) { return false; }
    Arrangement existingArrangement = aProsjekt.getArrangement();
    boolean isNewArrangement = existingArrangement != null && !this.equals(existingArrangement);
    if (isNewArrangement)
    {
      aProsjekt.setArrangement(this);
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
    //Unable to remove aProsjekt, as it must always have a arrangement
    if (!this.equals(aProsjekt.getArrangement()))
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
    for(int i=stemmes.size(); i > 0; i--)
    {
      Stemme aStemme = stemmes.get(i - 1);
      aStemme.delete();
    }
    for(int i=prosjekts.size(); i > 0; i--)
    {
      Prosjekt aProsjekt = prosjekts.get(i - 1);
      aProsjekt.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "arrangementid" + ":" + getArrangementid()+ "," +
            "arrangementnavn" + ":" + getArrangementnavn()+ "," +
            "arrangementbeskrivelse" + ":" + getArrangementbeskrivelse()+ "]";
  }
}