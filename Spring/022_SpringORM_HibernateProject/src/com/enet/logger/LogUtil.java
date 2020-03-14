package com.enet.logger;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.xml.DOMConfigurator;

public class LogUtil {
	private static Logger LOGGER = null;
	private static LogUtil instance = null;

	private LogUtil(File log4jfile) {
		try {
			try {
				if (log4jfile == null || !log4jfile.exists()) {
					log4jfile = new File("C:\\SpringHBProp\\springhb-log4j.xml");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (log4jfile == null || !log4jfile.exists()) {
				BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(PatternLayout.DEFAULT_CONVERSION_PATTERN)));
				System.out.println("Log4j: Did not find the configuration file. Configured using Basic Configuration");
			} else {
				DOMConfigurator.configure(log4jfile.getAbsolutePath());
				System.out.println("Log4j: Configured using Property Configurator");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER = LogManager.getLogger(LogUtil.class.getName());
		BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(PatternLayout.DEFAULT_CONVERSION_PATTERN)));
	}

	private static Logger getLogger() {
		checkInstance();
		return LOGGER;
	}

	public synchronized static void startLogger(File file) {
		if (instance == null) {
			instance = new LogUtil(file);
		}
	}

	private final static LogUtil checkInstance() {
		if (instance == null) {
			instance = new LogUtil(null);
		}
		return instance;
	}

	public final static void error(Object t) {
		getLogger().error(formatLogMessage(new Throwable(), getString(t)));
	}

	public final static void debug(Object message) {
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(formatLogMessage(new Throwable(), getString(message)));
		}
	}

	public final static void debug(Object message, String sql) {
		if (getLogger().isDebugEnabled()) {
			getLogger().debug(formatLogMessage(new Throwable(), "SQL:{" + sql + "} VALUES:{" + getString(message) + "}"));
		}
	}

	public final static void warn(Object message) {
		getLogger().warn(formatLogMessage(new Throwable(), getString(message)));
	}

	public final static void info(Object message) {
		if (getLogger().isInfoEnabled()) {
			getLogger().info(formatLogMessage(new Throwable(), getString(message)));
		}
	}

	@SuppressWarnings("unchecked")
	private final static String getString(Object message) {
		StringBuffer finalString = new StringBuffer();
		if (message != null) {
			if (message instanceof String || message instanceof StringBuffer) {
				finalString.append((String) message);
			} else if (message instanceof ArrayList) {
				finalString.append("ArrayList Size: " + ((ArrayList) message).size());
			} else if (message instanceof Throwable) {
				finalString.append(getStackTrace((Throwable) message));
			} else {
				try {
					finalString.append("Values: ");
					Object[] args = {};
					Class<Object>[] paramTypes = null;
					Field fields[] = message.getClass().getDeclaredFields();
					for (int i = 0; i < fields.length; i++) {
						if (fields[i] == null) {
							continue;
						}
						if (Modifier.isStatic(fields[i].getModifiers())) {
							continue;
						}
						String fieldName = fields[i].getName();
						Object value = null;
						try {
							String f = fieldName.substring(0, 1);
							fieldName = fieldName.replaceFirst(f, f.toUpperCase());
							Method getMethod = null;
							if (fields[i].getType() == boolean.class) {
								getMethod = message.getClass().getDeclaredMethod("is" + fieldName, paramTypes);
							} else {
								getMethod = message.getClass().getDeclaredMethod("get" + fieldName, paramTypes);
							}
							value = getMethod.invoke(message, args);
							if (value != null && value instanceof ArrayList) {
								value = "(Size=" + (((ArrayList) value).size()) + ")";
							}
							finalString.append(fieldName);
							finalString.append("=");
							finalString.append(value + ";");
						} catch (Exception e) {
						}
					}
				} catch (Exception e) {
				}
			}
		} else {
			finalString.append("Result is null");
		}
		return finalString.toString();
	}

	public static String getStackTrace(Throwable throwable) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}

	private static String formatLogMessage(Throwable t, String reqParams) {
		StringBuffer buffer = new StringBuffer();
		StringBuffer cName = new StringBuffer(40);
		try {
			StackTraceElement elements[] = t.getStackTrace();
			String className = elements[1].getClassName();
			if (className == null)
				className = "";
			className = className.substring(className.lastIndexOf('.') + 1);
			cName.append(className + ":" + elements[1].getMethodName());
		} catch (Exception e) {
		} catch (Error e) {
		}
		while (cName.length() < 40) {
			cName.append(' ');
		}
		// buffer.append("[" + cName + "] - " + reqParams);
		//buffer.append("[" + cName + "] -  " + reqParams);
		return buffer.toString();
	}

	public static void startCallLogging(String args) {
		if (args == null)
			return;
		NDC.clear();
		NDC.push(args.toString());
	}

	public static String readCallLoggingString() {
		return NDC.peek();
	}

	public static void endCallLogging() {
		NDC.pop();
		NDC.remove();
	}
}