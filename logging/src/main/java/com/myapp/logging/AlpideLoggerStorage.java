/**
 * 
 */
package com.myapp.logging;

import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop. conf.Configuration;
import org.apache.pig.builtin.PigStorage;
import com.myapp.logging.HadoopLogger.DDI_LAYER;
import com.myapp.logging.HadoopLogger.HADOOPLOGTYPE;

/**
 * @author NaveenKumar
 *
 */
public class AlpideLoggerStorage extends PigStorage{
	
	
	public static List<LogMessage> processedMessages=new ArrayList<LogMessage>();
	
	public AlpideLoggerStorage(String aProduct, String aStage, String aMessageType,String aSubStage, String aSourceName, String aTablenameorFileName, String aMessage) {
			super();
			try (HadoopLogger logger = HadoopLogFactory.getInstance(aSourceName, aProduct,DDI_LAYER.getDDILayer(aStage), new Configuration());)
			{
				LogMessage message = new LogMessage(HADOOPLOGTYPE.getLogLevelFromStringValue (aMessageType, HADOOPLOGTYPE. INFO),
					aSubStage, aSourceName, aTablenameorFileName, aMessage);
					if (! processedMessages.contains (message)) {
					logger.log (HADOOPLOGTYPE.getlogLevelFromStringValue (aMessageType, HADOOPLOGTYPE.INFO),aSubStage, aSourceName, aTablenameorFileName, aMessage);
					processedMessages.add(message);
					}
			}
					catch(Exception e) {
					e.printStackTrace();
					}
	}
	
	
}

