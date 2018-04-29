/**
 * 
 */
package com.myapp.logging;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.myapp.logging.HadoopLogger.HADOOPLOGTYPE;

/**
 * @author NaveenKumar
 *
 */
public class LogMessage {

	private String subStage;
	private String sourceName;
	private String tablenameorFileName;
	private String message;
	private HADOOPLOGTYPE logType;
	
	LogMessage(HADOOPLOGTYPE aLongType,String aSubStage, String aSourceName,String aTableOrFileName, String aMessage){
		this.logType = aLongType;
		this.subStage = aSubStage;
		this.sourceName = aSourceName;
		this.tablenameorFileName = aTableOrFileName;
		this.message = aMessage;
				
	}
	@Override
	public boolean equals(Object aNewMessage) {
		if(aNewMessage == null) return false;
		if(! (aNewMessage instanceof LogMessage)) return false;
		
		LogMessage newMessage = (LogMessage) aNewMessage;
		return new EqualsBuilder()
				.append(subStage, newMessage.subStage)
				.append(sourceName,newMessage.sourceName)
				.append(tablenameorFileName, newMessage.tablenameorFileName)
				.append(message, newMessage.message)
				.append(logType,newMessage.logType)
				.isEquals();
		
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).
							append(logType).
							append(subStage).
							append(sourceName).
							append(tablenameorFileName).
							append(message).
							toHashCode();
							
	}
	public String toString() {
		return subStage + ":" + sourceName + ":" + tablenameorFileName + ":" + message + ":" + logType;
	}
	
}
