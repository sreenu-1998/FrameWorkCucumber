package Log;

import org.apache.log4j.Logger;
//import Log.LogListener;

public class LoggerUtil {
	private static Logger logger = Logger.getLogger(LogListener.class);

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void log(String message) {
		logger.info(message);
	}

	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}
}
