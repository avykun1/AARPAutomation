package com.cucumber.framework.utility;

import com.cucumber.framework.helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import sun.util.resources.cldr.tig.CalendarData_tig_ER;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * @author bsingh5
 *
 */
public class DateTimeHelper {
	private static final Logger log = LoggerHelper.getLogger(DateTimeHelper.class);

	public static String getCurrentDateTime() {

		//DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());

		return time;
	}


	public static void main(String[] args) {

		System.out.println(getCurrentDate());
	}
	public static int getDate(String date) {
		int d=0;
		try {
			Date date1 = new SimpleDateFormat("MM/DD/yyyy").parse(date);
			System.out.println("DateHelper : (date) : "+date1);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			d= calendar.get(Calendar.DATE);
		}
		catch(ParseException e){
			log.error("invalid date format of "+ date);
		}
		return d;

	}
	public static int getMonth(String date)  {
		int m = 0;
		try {
			m=Integer.parseInt(date.split("/")[0]);
		}
		catch (Exception e){
			log.error("invalid date format of"+ date);
		}
		return m;

	}

	public static int getYear(String date)  {
		int y=0;
		try {
			Date date1 = new SimpleDateFormat("MM/DD/yyyy").parse(date);
			Calendar calendar = Calendar.getInstance();
			y= calendar.get(Calendar.YEAR);
		}
		catch (ParseException e){
			log.error("invalid date format of"+ date);
		}
		return  y;

	}
	public static String getCurrentDate(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate= formatter.format(date);
		return strDate;
	}

	public static String getCurrentDate(String format){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate= formatter.format(date);
		return strDate;
	}

	public static String getCurrentDateInESTTimeZone(String format){
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate= formatter.format(date);
		return strDate;
	}

	public static String getCurrentDateTrailingZeros(){

		String str[]=getCurrentDate().split("/");
		String createdDate="";
		if(str[0].charAt(0)=='0'){
			createdDate=createdDate+str[0].charAt(1)+"/";
		}
		else{
			createdDate=createdDate+str[0]+"/";
		}

		if(str[1].charAt(0)=='0'){
			createdDate=createdDate+str[1].charAt(1);
		}
		else{
			createdDate=createdDate+str[1];
		}
		createdDate=createdDate+"/"+str[2];
		return  createdDate;
	}


	public static String getCurrentFirstOfTheMonth(){

		String str[]=getCurrentDate().split("/");
		String createdDate="";
		if(str[0].charAt(0)=='0'){
			createdDate=createdDate+str[0].charAt(1)+"/";
		}
		else{
			createdDate=createdDate+str[0]+"/";
		}

		createdDate=createdDate+"1";
		createdDate=createdDate+"/"+str[2];
		return  createdDate;
	}

	public static String getPastMonthFirstDate(){
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.set (Calendar.MONTH, calendar.get (Calendar.MONTH)-1);
			date = calendar.getTime();
			String accDate = format.format(date);
			String[] str = accDate.split("/");
			String pastDate = str[0]+"/01/"+str[2];
		System.out.println("Past Date ------"+pastDate);
			return pastDate;
	}


	public static String getFutureMonthFirstDate(){
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set (Calendar.MONTH, calendar.get (Calendar.MONTH)+1);
		date = calendar.getTime();
		String accDate = format.format(date);
		String[] str = accDate.split("/");
		String pastDate = str[0]+"/01/"+str[2];
		System.out.println("Future Date ------"+pastDate);
		return pastDate;
	}

	public static String getDateTrailingZeros(String date){
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			try {
				//Setting the date to the given date
				c.setTime(sdf.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			String str[] = date.split("/");
			String createdDate = "";
			if (str[0].charAt(0) == '0') {
				createdDate = createdDate + str[0].charAt(1) + "/";
			} else {
				createdDate = createdDate + str[0] + "/";
			}

			if (str[1].charAt(0) == '0') {
				createdDate = createdDate + str[1].charAt(1);
			} else {
				createdDate = createdDate + str[1];
			}
			createdDate = createdDate + "/" + str[2];
			return createdDate;
		}
		catch(Exception e) {
			log.info("Unable to parse the date");
		}
		return null;

	}

	public static String addDays(String oldDate, int noOfDays){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try{
			//Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		//Number of Days to add
		c.add(Calendar.DATE, noOfDays);
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		return  newDate;
	}

	public static String addMonths(String oldDate, int noOfMoths){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try{
			//Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		//Number of Days to add
		c.add(Calendar.MONTH, noOfMoths);
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		return  newDate;
	}

	public static String addYears(String oldDate,int noOfYears){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try{
			//Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		}catch(ParseException e){
			e.printStackTrace();
		}

		//Number of Days to add
		c.add(Calendar.YEAR, noOfYears);
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		return  newDate;
	}
	public static int getDiffMonths(String startDate,String endDate)  {
		int diffMonth=0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(sdf.parse(startDate));
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(sdf.parse(endDate));

			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		}
		catch (Exception e){

		}
		return  diffMonth;

	}

	public static String getEndOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date currentMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String endDate= formatter.format(currentMonthLastDay);
		return endDate;

	}

	public static String changeDatePattern(String inputPattern,String targetDate, String outputPattern){
		SimpleDateFormat inFormat = new SimpleDateFormat(inputPattern);
		Date today = new Date();

		Date d1 = null;
		try {
			d1 = inFormat.parse(targetDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat outFormat = new SimpleDateFormat(outputPattern);

		return outFormat.format(d1);



	}
	public static String convertDate(String date)  {
		//	Date date1=null;
		String dateStr=null;
		try {
			//	String dateStr = "21/20/2011";
			DateFormat srcDf = new SimpleDateFormat("dd-MMM-yyyy");

			DateFormat destDf = new SimpleDateFormat("MM/dd/yyyy");

			// parse the date string into Date object
			Date date1 = srcDf.parse(date);



			// format the date into another format
			dateStr = destDf.format(date1);

			System.out.println("Converted date is : " + dateStr);
			return dateStr;


		}
		catch (ParseException e){
			log.error("invalid date format of"+ date);
		}

		try {
			//	String dateStr = "21/20/2011";
			DateFormat srcDf = new SimpleDateFormat("MM/dd/yyyy");

			DateFormat destDf = new SimpleDateFormat("MM/dd/yyyy");

			// parse the date string into Date object
			Date date1 = srcDf.parse(date);



			// format the date into another format
			dateStr = destDf.format(date1);

			System.out.println("Converted date is : " + dateStr);
			return dateStr;


		}
		catch (ParseException e){
			log.error("invalid date format of"+ date);
		}

		return  dateStr;

	}

	public static String getCurrentDateEST()
    {
        String createdDate = "";
    try{

        // I am setting the time zone to EST
        TimeZone.setDefault(TimeZone.getTimeZone("EST"));
        // Now my default time zone is in EST
        System.out.println(TimeZone.getDefault());
        // I get Eastern Time printed
        Date today=new Date();
        log.info(today);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
     /*   df.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
        String time = df.format(today);
        System.out.println(time);
        df.setTimeZone(TimeZone.getTimeZone("EST"));*/
       String  time = df.format(today);

        String str[] = time.split("/");

        if (str[0].charAt(0) == '0') {
            createdDate = createdDate + str[0].charAt(1) + "/";
        } else {
            createdDate = createdDate + str[0] + "/";
        }

        if (str[1].charAt(0) == '0') {
            createdDate = createdDate + str[1].charAt(1);
        } else {
            createdDate = createdDate + str[1];
        }
        createdDate = createdDate + "/" + str[2];

    }
		catch(Exception e) {
        log.info("Unable to parse the date");
    }

        return createdDate;

    }

	public static String getEndOfNextMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date nextMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String endDate= formatter.format(nextMonthLastDay);
		return endDate;

	}

	public static String getFirstDayOfNextMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date nextMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String startDate= formatter.format(nextMonthFirstDay);
		return startDate;

	}

	public static String getCurrentSecondDayOfTheMonth(){

		String str[]=getCurrentDate().split("/");
		String createdDate="";
		if(str[0].charAt(0)=='0'){
			createdDate=createdDate+str[0].charAt(1)+"/";
		}
		else{
			createdDate=createdDate+str[0]+"/";
		}

		createdDate=createdDate+"2";
		createdDate=createdDate+"/"+str[2];
		return  createdDate;
	}

	//subhashini added 4/10/2021

	public static String findNextDay()
	{
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String nextDay = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
		return nextDay;
	}

	public static String findPrevDay()
	{
		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
		return prevDate;
	}

	public static String getPreviousMonthLastDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);

		int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, max);

		return calendar.getTime().toString();
	}


	public static String getDateSixMonthsOlder() {

		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinus6Months = currentDate.minusMonths(6);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String sixMonthOlderDate = sdf.format(currentDateMinus6Months);

		System.out.println("Six Month Older Date : " + sixMonthOlderDate);
		return sixMonthOlderDate;
	}

	//subhashini ended

	// added by Venkat
	public static String getFirstOfThePreviousMonth(String date){

		Calendar calendar = Calendar.getInstance();
		try {
			Date dateFormat1 = new SimpleDateFormat("MM/dd/yyyy").parse(date);
			calendar.setTime (dateFormat1);
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			calendar.set (Calendar.MONTH, calendar.get(Calendar.MONTH)-1); // set to the previous month

		} catch (ParseException e){
			log.error("invalid date format of"+ date);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String firstDate = formatter.format(calendar.getTime());
		return firstDate;
	}

	public static int getDayFromTheGivenDate(String date) {
		int day=0;
		try {
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(date);
			System.out.println("DateHelper : (date) : "+date1);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			day = calendar.get(Calendar.DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}

	public static String getFirstDayOfTheMonthFromGivenDate(String date){
		Calendar calendar = Calendar.getInstance();
		try {
			Date formattedDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
			calendar.setTime(formattedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = formatter.format(calendar.getTime());
		return  newDate;
	}

	public static String getLastButOneDayOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)-1);
		Date currentMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String lastButOneDay= formatter.format(currentMonthLastDay);
		return lastButOneDay;
	}

	public static String getTwoDaysBeforeEndDateOfCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)-2);
		Date currentMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String lastButOneDay= formatter.format(currentMonthLastDay);
		return lastButOneDay;
	}

	public static int getNoOfDaysInCurrentMonth(){

		Calendar cal = Calendar.getInstance();
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("No. of Days in the current month: " +days);
		return  days;
	}

	public static String getFirstDayOfMonthFromThreeMonthsLater(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 4);
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		Date nextMonthFirstDay = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date nextMonthLastDay = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String startDate= formatter.format(nextMonthFirstDay);
		return startDate;
	}

	public static boolean validateDateFormat(String strDate){

		if(strDate.trim().equals("")){
			return true;
		} else{

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			simpleDateFormat.setLenient(false);

			try{
				Date date = simpleDateFormat.parse(strDate);
				System.out.println(strDate+" is valid date format");

			} catch (ParseException e){
				System.out.println(strDate+" is invalid date format");
				return false;
			}

			return true;
		}
	}

}
