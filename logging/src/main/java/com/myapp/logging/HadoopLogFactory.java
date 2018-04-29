/**
 * 
 */
package com.myapp.logging;

import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.Logger;

import com.myapp.logging.HadoopLogger.DDI_LAYER;

/**
 * @author NaveenKumar
 *
 */
public class HadoopLogFactory {
	
	
	
	private static final Logger Log4jLogger = Logger.getLogger(HadoopLogFactory.class);
	
	private static final String HADOOP_LOG_PROPS_SCHEMA = "schemaPath";
	private static final String HADOOP_LOG_PROPS_LOCATION="logLocation";
	private static final String HADOOP_LOG_PROPS_CANLOGMESSAGE = "canLogMessage";
	private static final String HADOOP_LOG_PROPS_CAN_LOGLINEAGE_MESSAGE="canLogLineageMessage";
	private static final String HADOOP_LOG_PROPS_APPLICATION ="application";
	private static final String HADOOP_LOG_PROPS_LOGLEVEL = "logLevel";
	private static final String HADOOP_LOG_PROPS_PRODUCT ="product";
	private static final String HADOOP_LOG_PROPERTIES ="hadooplog4j.properties";
	
	
	private static String schemPath;
	private static String baseLogPath;
	private static Boolean logginEnabled = true;
	private static Boolean lineageLoggingEnabled =true;
	private static String application;
	private static String logLevel;
	public static HadoopLogger getInstance(String aSourceName, String aProduct, DDI_LAYER ddiLayer,
			Configuration configuration) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
			


}
