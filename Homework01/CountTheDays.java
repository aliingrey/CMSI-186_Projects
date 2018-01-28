/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Provides a class with supporting methods for CountTheDays.java program
 *  Author        :  Ali Ingrey
 *  Date          :  1/25/2018
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-01-25  Ali Ingrey    Submitted for Homework 01 in Spring 2018
  * @version 1.0.2  2018-01-28  Ali Ingrey    Edited to make corrections, re-committed
 
public class CountTheDays {
  public static void main ( String [] args ) {

    long dayCount = CalendarStuff.daysBetween( Long.parseLong( args[0] ), Long.parseLong( args[1] ), Long.parseLong( args[2] ), Long.parseLong( args[3] ), Long.parseLong( args[4] ), Long.parseLong( args[5] ) );

    System.out.println( "The distance between the two dates is" + dayCount + "days");
  }
}
