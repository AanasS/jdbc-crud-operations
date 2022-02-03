package com.JDBCexample.demo.utils;

public class Utils {// this function for casting util date to sql date
	public static java.sql.Date getSqlDate(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}

}
