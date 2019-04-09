/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.sql.Time;

/**
 * class Student
 * {
 * firstName;
 * lastName;
 * Integer number;
 * -- 1..* Address;
 * 
 * public String fullName()
 * {
 * return getFirstName() + " " + getLastName();
 * }
 * 
 * 
 * class Address
 * 
 * String[] line;
 * 
 */
// line 22 "model.ump"
// line 65 "model.ump"
public class Stemme
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stemme Attributes
  private int stemmeid;
  private String epost;
  private int stemmeverdi;
  private Time stemmetidspunkt;

  //Stemme Associations
  private Arrangement arrangement;
  private Prosjekt prosjekt;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stemme(int aStemmeid, String aEpost, int aStemmeverdi, Time aStemmetidspunkt, Arrangement aArrangement, Prosjekt aProsjekt)
  {
    stemmeid = aStemmeid;
    epost = aEpost;
    stemmeverdi = aStemmeverdi;
    stemmetidspunkt = aStemmetidspunkt;
    boolean didAddArrangement = setArrangement(aArrangement);
    if (!didAddArrangement)
    {
      throw new RuntimeException("Unable to create stemme due to arrangement");
    }
    boolean didAddProsjekt = setProsjekt(aProsjekt);
    if (!didAddProsjekt)
    {
      throw new RuntimeException("Unable to create stemme due to prosjekt");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStemmeid(int aStemmeid)
  {
    boolean wasSet = false;
    stemmeid = aStemmeid;
    wasSet = true;
    return wasSet;
  }

  public boolean setEpost(String aEpost)
  {
    boolean wasSet = false;
    epost = aEpost;
    wasSet = true;
    return wasSet;
  }

  public boolean setStemmeverdi(int aStemmeverdi)
  {
    boolean wasSet = false;
    stemmeverdi = aStemmeverdi;
    wasSet = true;
    return wasSet;
  }

  public boolean setStemmetidspunkt(Time aStemmetidspunkt)
  {
    boolean wasSet = false;
    stemmetidspunkt = aStemmetidspunkt;
    wasSet = true;
    return wasSet;
  }

  public int getStemmeid()
  {
    return stemmeid;
  }

  public String getEpost()
  {
    return epost;
  }

  public int getStemmeverdi()
  {
    return stemmeverdi;
  }

  public Time getStemmetidspunkt()
  {
    return stemmetidspunkt;
  }
  /* Code from template association_GetOne */
  public Arrangement getArrangement()
  {
    return arrangement;
  }
  /* Code from template association_GetOne */
  public Prosjekt getProsjekt()
  {
    return prosjekt;
  }
  /* Code from template association_SetOneToMany */
  public boolean setArrangement(Arrangement aArrangement)
  {
    boolean wasSet = false;
    if (aArrangement == null)
    {
      return wasSet;
    }

    Arrangement existingArrangement = arrangement;
    arrangement = aArrangement;
    if (existingArrangement != null && !existingArrangement.equals(aArrangement))
    {
      existingArrangement.removeStemme(this);
    }
    arrangement.addStemme(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProsjekt(Prosjekt aProsjekt)
  {
    boolean wasSet = false;
    if (aProsjekt == null)
    {
      return wasSet;
    }

    Prosjekt existingProsjekt = prosjekt;
    prosjekt = aProsjekt;
    if (existingProsjekt != null && !existingProsjekt.equals(aProsjekt))
    {
      existingProsjekt.removeStemme(this);
    }
    prosjekt.addStemme(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Arrangement placeholderArrangement = arrangement;
    this.arrangement = null;
    if(placeholderArrangement != null)
    {
      placeholderArrangement.removeStemme(this);
    }
    Prosjekt placeholderProsjekt = prosjekt;
    this.prosjekt = null;
    if(placeholderProsjekt != null)
    {
      placeholderProsjekt.removeStemme(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "stemmeid" + ":" + getStemmeid()+ "," +
            "epost" + ":" + getEpost()+ "," +
            "stemmeverdi" + ":" + getStemmeverdi()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "stemmetidspunkt" + "=" + (getStemmetidspunkt() != null ? !getStemmetidspunkt().equals(this)  ? getStemmetidspunkt().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrangement = "+(getArrangement()!=null?Integer.toHexString(System.identityHashCode(getArrangement())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "prosjekt = "+(getProsjekt()!=null?Integer.toHexString(System.identityHashCode(getProsjekt())):"null");
  }
}