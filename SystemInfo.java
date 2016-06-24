/*
 * Bryon 
 * 
 * SystemInfo class gathers system information and is
 * serializable when instantiated.
 */
 package model;
import java.io.Serializable;
import java.util.Date;


public class SystemInfo implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private final String LINE_SEPARATOR = System.getProperty("line.separator");
		private transient String lineSeparator;
		private int processors;
		private Date dateCaptured;
		private String name;
		private String jreVendor;
		private String jreVersion;
		private String osName;
		private String osVersion;
		
		public SystemInfo(){
			setOsName(System.getProperty("os.name"));
			setOsVersion(System.getProperty("os.version"));
			setJreVendor(System.getProperty("java.vendor"));
			setJreVersion(System.getProperty("java.version"));
			setLineSeparator(LINE_SEPARATOR);
			setDateCaptured(new Date());
			
		}

		
		@ Override
		public String toString(){
			StringBuffer message = new StringBuffer("                           System Information"+ getLineSeparator());
			message.append("  User: "+ getName()+getLineSeparator());
			message.append("  Date Captured: "+ getDateCaptured()
					        +getLineSeparator()+"  Oprating System: "
					        +getOsName()+" "+getOsVersion()+getLineSeparator()
					        + "  Java Information: "+getJreVendor()+" "+getJreVersion()
					         +getLineSeparator());
			
			return message.toString();
			
		}
		
		
		
		
	

		public String getJreVendor() {
			return jreVendor;
		}

		public void setJreVendor(String jreVendor) {
			this.jreVendor = jreVendor;
		}

		public String getJreVersion() {
			return jreVersion;
		}

		public void setJreVersion(String jreVersion) {
			this.jreVersion = jreVersion;
		}

		public String getOsName() {
			return osName;
		}

		public void setOsName(String osName) {
			this.osName = osName;
		}

		public String getOsVersion() {
			return osVersion;
		}

		public void setOsVersion(String osVersion) {
			this.osVersion = osVersion;
		}



		public int getProcessors() {
			return processors;
		}



		public void setProcessors(int processors) {
			this.processors = processors;
		}



		public String getLINE_SEPARATOR() {
			return LINE_SEPARATOR;
		}



		public String getLineSeparator() {
			if(lineSeparator == null){
				lineSeparator = LINE_SEPARATOR;
			}
			return lineSeparator;
		}



		public void setLineSeparator(String lineSeparator) {
			this.lineSeparator = lineSeparator;
		}



		public Date getDateCaptured() {
			return dateCaptured;
		}



		public void setDateCaptured(Date dateCaptured) {
			this.dateCaptured = dateCaptured;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

}
