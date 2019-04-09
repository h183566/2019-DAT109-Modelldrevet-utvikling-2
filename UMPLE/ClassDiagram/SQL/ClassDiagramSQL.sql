-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



/*
class Student
  {
     firstName;
     lastName;
     Integer number;
     * -- 1..* Address;
 
     public String fullName()
     {
       return getFirstName() + " " + getLastName();
    }
 }

 class Address
 {
    String[] line;
 }
*/
CREATE TABLE IF NOT EXISTS `stemme`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*stemme Associations*/
  arrangement_arrangementid INT,
  prosjekt_prosjektid INT,
  
  /*stemme Attributes*/
  stemmeid INT,
  epost VARCHAR(255),
  stemmeverdi INT,
  stemmetidspunkt TIME,
  PRIMARY KEY(stemmeid)

);





CREATE TABLE IF NOT EXISTS `arrangement`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*arrangement Attributes*/
  arrangementid INT,
  arrangementnavn VARCHAR(255),
  arrangementbeskrivelse VARCHAR(255),
  PRIMARY KEY(arrangementid)

);





CREATE TABLE IF NOT EXISTS `bedrift`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*bedrift Attributes*/
  bedriftid INT,
  bedriftnavn VARCHAR(255),
  bedriftbeskrivelse VARCHAR(255),
  PRIMARY KEY(bedriftid)

);





CREATE TABLE IF NOT EXISTS `studie`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*studie Associations*/
  kategori_kategoriid INT,
  
  /*studie Attributes*/
  studieid INT,
  studienavn VARCHAR(255),
  studiebeskrivelse VARCHAR(255),
  PRIMARY KEY(studieid)

);





CREATE TABLE IF NOT EXISTS `kategori`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*kategori Attributes*/
  kategoriid INT,
  kategorinavn VARCHAR(255),
  PRIMARY KEY(kategoriid)

);





CREATE TABLE IF NOT EXISTS `prosjekt`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*prosjekt Associations*/
  arrangement_arrangementid INT,
  bedrift_bedriftid INT,
  studie_studieid INT,
  
  /*prosjekt Attributes*/
  prosjektid INT,
  prosjektnavn VARCHAR(255),
  prosjektbeskrivelse VARCHAR(255),
  PRIMARY KEY(prosjektid)

);


ALTER TABLE `stemme` ADD CONSTRAINT `fk_stemme_arrangement_arrangementid` FOREIGN KEY (`arrangement_arrangementid`) REFERENCES `arrangement`(`arrangementid`);
ALTER TABLE `stemme` ADD CONSTRAINT `fk_stemme_prosjekt_prosjektid` FOREIGN KEY (`prosjekt_prosjektid`) REFERENCES `prosjekt`(`prosjektid`);



ALTER TABLE `studie` ADD CONSTRAINT `fk_studie_kategori_kategoriid` FOREIGN KEY (`kategori_kategoriid`) REFERENCES `kategori`(`kategoriid`);


ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_arrangement_arrangementid` FOREIGN KEY (`arrangement_arrangementid`) REFERENCES `arrangement`(`arrangementid`);
ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_bedrift_bedriftid` FOREIGN KEY (`bedrift_bedriftid`) REFERENCES `bedrift`(`bedriftid`);
ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_studie_studieid` FOREIGN KEY (`studie_studieid`) REFERENCES `studie`(`studieid`);
