package com.hjkj.hyjc.comm.io;

import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader extends Properties
{
	private static final long serialVersionUID = 1L;

	private PropertiesReader(String path)
	{
		String temp = "";
		if (!"/".equals(path.substring(0, 1))) temp = "/" + path;
		try
		{
			InputStream is = getClass().getResourceAsStream(temp);
			load(is);
		}
		catch (Exception e)
		{
			throw new RuntimeException("The properties file in the path " + path + " is not found.");
		}
	}

	public static PropertiesReader getReader(String path)
	{
		return new PropertiesReader(path);
	}
}