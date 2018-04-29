/**
 * 
 */
package com.myapp.logging;

import java.io.Serializable;
import org.apache.hadoop.fs.Path;

/**
 * @author NaveenKumar
 *
 */
public interface HadoopLogger extends AutoCloseable, Serializable {

	public enum PRODUCT_TYPE {

		CARDS("Cards", "cards"), REATAIL_OTHERS("Retail Other", "retail_other"), HOMELOANS("Home Loans",
				"homeloans"), REFERENCE("Reference",
						"reference"), LEGACY("Legacy", "legacy"), OTHER("Other", "other"), ALL("All", "all");
		private String name;
		private String code;

		private PRODUCT_TYPE(String aName, String aCode) {
			this.name = aName;
			this.code = aCode;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static PRODUCT_TYPE getProductType(String code) {

			for (PRODUCT_TYPE type : PRODUCT_TYPE.values())
				if (code.equalsIgnoreCase(type.code))
					return type;
			return OTHER;
		}
	};

	public enum DDI_LAYER {
		SOURCE("Source", "SOURCE"), DATA_INEGRITY("Data Integrity", "DI"), DEDUP("De Deuplication",
				"DEDUP"), DATA_STANDARDIZATION("Data Standardisation", "DS"), FSR("FSR", "FSR"), UNIVERSAL_KEY(
						"Universal Key", "UK"), MERGE("Merge", "MERGE"), TRANSFORMATION("Transformation",
								"TRANSFORMATION"), VAP("VAP", "VAP"), PUBLISH("Publish", "PUBLISH"), DATA_QUALITY(
										"Data Quality", "DQ"), COMMON("COMMON", "COMMON"), FLATTEN("FLATTEN",
												"FL"), LINEAGE("LINEAGE", "LINEAGE"), OTHER("OTHER", "OTHER");
		private String name;
		private String code;

		private DDI_LAYER(String aName, String aCode) {
			this.name = aName;
			this.code = aCode;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public static DDI_LAYER getDDILayer(String code) {
			for (DDI_LAYER layer : DDI_LAYER.values()) {
				if (code.equalsIgnoreCase(layer.code))
					return layer;
			}
			return OTHER;
		}
	}

		public enum HADOOPLOGTYPE {
			DEBUG(0), INFO(1), WARN(2), EVENT(2), EXCEPTION(3), FATAL(4), ABEND(5), LINEAGE_SUMMARY(6), LINEAGE_DETAIL(7);
			private int level;
			private HADOOPLOGTYPE(int aLevel) {
				level=aLevel;
			}

			public int getLevel() {
				return level;
			}

			public static HADOOPLOGTYPE getLogLevelFromStringValue(String level, HADOOPLOGTYPE defaultValue) {
				if (level == null)
					return defaultValue;
				for (HADOOPLOGTYPE logType : HADOOPLOGTYPE.values()) {
					if (level.equalsIgnoreCase(logType.toString()))
						return logType;
				}
				return defaultValue;
			}
		};

		public enum EVENT_TYPE {
			FILE_ARRIVAL("Raw data file arrived at","FILE ARRIVAL"), 
			DATA_AVAILABLE("Data Sourcing compfeted & published at ", "DATA AVAILABLE");

			private String message;
			private String code;

			private EVENT_TYPE(String message, String aCode) {
				this.message = message;
				this.code = aCode;
			}
			public String getSubStage() {
				return code;
			}
			public String getMessage() {
				return message;
			}
		}
	public void exception(String subStage, String message);
	public void exception(String substage, String tableNameorFileName, String message);
	public void debug(String subStage, String message);
	public void debug(String subStage, String tableNameorFileName, String message);
	public void info(String subStage, String message);
	public void info(String subStage, String tableNameorFileName, String message);
	public void warn(String subStage, String message);
	public void warn(String substage, String tableNameorFileName, String message);
	public void warn(String subStage, Throwable message);
	public void warn(String subStage, String tableNameorFileName, Throwable message);
	public void exception(String subStage, String message, Throwable throwable);
	public void exception(String subStage, String tableNameorFileName, String message, Throwable throwable);
	public void log(HADOOPLOGTYPE messageType, String subStage, String message);
	public void log(HADOOPLOGTYPE messageType, String substage, String sourceName, String message);
	public void log(HADOOPLOGTYPE messageType, String subStage, String sourceName, String tablenameorFileName,String message);
	public void abend (String subStage, String message);
	public void abend(String subStage, String tableNameorFileName, String message);
	public void logSummary (HADOOPLOGTYPE messageType, String tableNameorFileName);
	
	
	public void logLineageSummary(String applicationId, String subStage, String lineageMessage);
	public void logLineageDetail(String applicationld, String subStage, String lineageMessage);
	
	public void event(String subStage, String tableNameorFileName, String message);
	public void setControlPoint(String controlPoint);
	public void setProduct(String product);
	public Path getFileName();
	public boolean isLoglineageMessage();
	public String getName();
	public void close() throws Exception;
	public void setStage(String stage);

}
