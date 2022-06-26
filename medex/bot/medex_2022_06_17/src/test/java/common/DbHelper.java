package common;

import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DbHelper {

	//To get data from postgresql or redshift db and store in list
	public static List getData(String queryParam) {
		List resultList =null;
		String[] dbDetails = queryParam.split("_");
		if (dbDetails.length > 1) {
			if (dbDetails[0].toLowerCase().contains("RedShift".toLowerCase())) {
				RedShiftUtil  redShiftUtil=new RedShiftUtil();
				resultList = redShiftUtil.getData(queryParam);
			}
			else if(dbDetails[0].toLowerCase().contains("PostgreSql".toLowerCase()))
			{
				 PostgreSQLUtil postgreSQLUtil = new PostgreSQLUtil();
		 	 	 resultList = postgreSQLUtil.getData(queryParam);
			}

		}
		return resultList;
	}
	public static String queryCopiedText(String query)
	{
		
		 if(query.contains("@copied_text1"))
 	 	 {
 	 	 query=query.replace("@copied_text1",CommonUtil.getCopiedCountText("1"));
 	 	 }
 	 	 if(query.contains("@copied_text2"))
 	 	 {
 	 	 query=query.replace("@copied_text2",CommonUtil.getCopiedCountText("2"));
 	 	 }
 	 	if(query.contains("@copied_text3"))
	 	 {
	 	 query=query.replace("@copied_text3",CommonUtil.getCopiedCountText("3"));
	 	 }
 	 	if(query.contains("@copied_text4"))
	 	 {
	 	 query=query.replace("@copied_text4",CommonUtil.getCopiedCountText("4"));
	 	 }
 	 	if(query.contains("@copied_text5"))
	 	 {
	 	 query=query.replace("@copied_text5",CommonUtil.getCopiedCountText("5"));
	 	 }
 	 	if(query.contains("@copied_text6"))
	 	 {
	 	 query=query.replace("@copied_text6",CommonUtil.getCopiedCountText("6"));
	 	 }
 	 	if(query.contains("@copied_text7"))
	 	 {
	 	 query=query.replace("@copied_text7",CommonUtil.getCopiedCountText("7"));
	 	 }
 	 	if(query.contains("@copied_text8"))
	 	 {
	 	 query=query.replace("@copied_text8",CommonUtil.getCopiedCountText("8"));
	 	 }
 	 	if(query.contains("@copied_text9"))
	 	 {
	 	 query=query.replace("@copied_text9",CommonUtil.getCopiedCountText("9"));
	 	 }
 	 	if(query.contains("@copied_text10"))
	 	 {
	 	 query=query.replace("@copied_text10",CommonUtil.getCopiedCountText("10"));
	 	 }
		else if(query.contains("@copied_text"))
	 	 {
	 	 query=query.replace("@copied_text",CommonUtil.getCopiedText());
	 	 }
 	 	if(query.contains("N/A"))
 	 	{
 	 		query=query.replace("'N/A'","null");
 	 	}
 	 	 return query;
	}
	
	public static String replaceGlobalText(String query)
	{
		
		 if(query.contains("@global_text1"))
 	 	 {
 	 	 query=query.replace("@global_text1",CommonUtil.getGlobalText("1"));
 	 	 }
 	 	 if(query.contains("@global_text2"))
 	 	 {
 	 	 query=query.replace("@global_text2",CommonUtil.getGlobalText("2"));
 	 	 }
 	 	if(query.contains("@global_text3"))
	 	 {
	 	 query=query.replace("@global_text3",CommonUtil.getGlobalText("3"));
	 	 }
 	 	if(query.contains("@global_text4"))
	 	 {
	 	 query=query.replace("@global_text4",CommonUtil.getGlobalText("4"));
	 	 }
 	 	if(query.contains("@global_text5"))
	 	 {
	 	 query=query.replace("@global_text5",CommonUtil.getGlobalText("5"));
	 	 }
 	 	if(query.contains("@global_text6"))
	 	 {
	 	 query=query.replace("@global_text6",CommonUtil.getGlobalText("6"));
	 	 }
 	 	if(query.contains("@global_text7"))
	 	 {
	 	 query=query.replace("@global_text7",CommonUtil.getGlobalText("7"));
	 	 }
 	 	if(query.contains("@global_text8"))
	 	 {
	 	 query=query.replace("@global_text8",CommonUtil.getGlobalText("8"));
	 	 }
 	 	if(query.contains("@global_text9"))
	 	 {
	 	 query=query.replace("@global_text9",CommonUtil.getGlobalText("9"));
	 	 }
 	 	if(query.contains("@global_text10"))
	 	 {
	 	 query=query.replace("@global_text10",CommonUtil.getGlobalText("10"));
	 	 }
		else if(query.contains("@global_text"))
	 	 {
	 	 query=query.replace("@global_text",CommonUtil.getCopiedText());
	 	 }
 	 	if(query.contains("N/A"))
 	 	{
 	 		query=query.replace("'N/A'","null");
 	 	}
 	 	 return query;
	}
	
	public static String textRandomCopiedText(String query)
	{
		
		 if(query.contains("@verifyRandomCopiedText1"))
 	 	 {
 	 	 query=query.replace("@verifyRandomCopiedText1",CommonUtil.getRandomCopiedCountText("1"));
 	 	 }
 	 	 if(query.contains("@verifyRandomCopiedText2"))
 	 	 {
 	 	 query=query.replace("@verifyRandomCopiedText2",CommonUtil.getRandomCopiedCountText("2"));
 	 	 }
 	 	if(query.contains("@verifyRandomCopiedText3"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText3",CommonUtil.getRandomCopiedCountText("3"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText4"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText4",CommonUtil.getRandomCopiedCountText("4"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText5"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText5",CommonUtil.getRandomCopiedCountText("5"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText6"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText6",CommonUtil.getRandomCopiedCountText("6"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText7"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText7",CommonUtil.getRandomCopiedCountText("7"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText8"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText8",CommonUtil.getRandomCopiedCountText("8"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText9"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText9",CommonUtil.getRandomCopiedCountText("9"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedText10"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText10",CommonUtil.getRandomCopiedCountText("10"));
	 	 }
		else if(query.contains("@verifyRandomCopiedText"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedText",CommonUtil.getCopiedRandomText());
	 	 }
 	 
 	 	 return query;
	}


public static String textRandomCopiedNumber(String query)
	{
		
		 if(query.contains("@verifyRandomCopiedNumber1"))
 	 	 {
 	 	 query=query.replace("@verifyRandomCopiedNumber1",CommonUtil.getRandomCopiedCountNumber("1"));
 	 	 }
 	 	 if(query.contains("@verifyRandomCopiedNumber2"))
 	 	 {
 	 	 query=query.replace("@verifyRandomCopiedNumber2",CommonUtil.getRandomCopiedCountNumber("2"));
 	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber3"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber3",CommonUtil.getRandomCopiedCountNumber("3"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber4"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber4",CommonUtil.getRandomCopiedCountNumber("4"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber5"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber5",CommonUtil.getRandomCopiedCountNumber("5"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber6"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber6",CommonUtil.getRandomCopiedCountNumber("6"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber7"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber7",CommonUtil.getRandomCopiedCountNumber("7"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber8"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber8",CommonUtil.getRandomCopiedCountNumber("8"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber9"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber9",CommonUtil.getRandomCopiedCountNumber("9"));
	 	 }
 	 	if(query.contains("@verifyRandomCopiedNumber10"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber10",CommonUtil.getRandomCopiedCountNumber("10"));
	 	 }
		else if(query.contains("@verifyRandomCopiedNumber"))
	 	 {
	 	 query=query.replace("@verifyRandomCopiedNumber",String.valueOf(CommonUtil.getCopiedRandomNumber()));
	 	 }
 	 
 	 	 return query;
	}

}
