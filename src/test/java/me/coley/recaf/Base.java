package me.coley.recaf;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * Base testing utilities.
 *
 * @author Matt
 */
public class Base {
	@BeforeAll
	public static void setupLogging() {
		Recaf.setupLogging();
	}

	/**
	 * @param file
	 * 		Path to file in classpath.
	 *
	 * @return File reference.
	 *
	 * @throws IOException
	 * 		Thrown if the URL to the file could not be created.
	 */
	public File getClasspathFile(String file) throws IOException {
		return new File(URLDecoder.decode(getClasspathUrl(file).getFile(), "UTF-8"));
	}

	/**
	 * @param file
	 * 		Path to file in classpath.
	 *
	 * @return URL reference.
	 */
	public URL getClasspathUrl(String file) {
		ClassLoader classLoader = Base.class.getClassLoader();
		return classLoader.getResource(file);
	}
}