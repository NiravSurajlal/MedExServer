package common;

import java.io.PrintWriter;
import java.io.StringWriter;
import com.cucumber.listener.Reporter;

//To print custom message in exception
public class CustomException extends RuntimeException {
	public CustomException(String message)
	{
		super(message);
	}

	public CustomException(String message,Exception e)
	{
		super(message);
		
		
		StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exceptionAsString = sw.toString();
        String[] traceList=exceptionAsString.split("at");
        for(int i=0;i<traceList.length;i++)
        {
        	if(traceList[i].contains("workflow"))
        	{
        		 Reporter.addStepLog("StackTrace : \n"+traceList[i]);
        		 break;
        	}
        }
        
  
	}
	@Override
    public synchronized Throwable fillInStackTrace()
	{
        return this;
    }
}
