package com.lulan.shincolle.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import java.util.ArrayList;

import com.lulan.shincolle.utility.LogHelper;

/**
 * custom config for sounds, loot table ...etc.
 */
public abstract class BasicShipConfig
{

	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final String NEW_LINE;

    static
    {
        NEW_LINE = System.getProperty("line.separator");
    }

	protected String defaultEncoding = DEFAULT_ENCODING;
	protected File file;
	protected boolean changed = false;


	public BasicShipConfig() {}

	public BasicShipConfig(File file) throws Exception
	{
		this.file = file;
	}

	//load config file
	public void runConfig() throws Exception
	{
		try
		{
			load();
		}
		catch (Throwable e)
		{
			LogHelper.info("ERROR: load config file: " + this.file + " fail: "+ e);
			e.printStackTrace();

			//for exception, throw out
			if (e instanceof Exception) throw (Exception) e;
		}
	}

	protected void load() throws Throwable
	{
        BufferedReader buffer = null;

        try
        {
    		//check root dir
            if (this.file.getParentFile() != null)
            {
            	file.getParentFile().mkdirs();
            }

            //create new file
            if (!this.file.exists())
            {
                if (this.file.createNewFile())
                {
                	createDefault();
                }
                else
                {
                	throw new IOException("Create new config file fail");
                }
            }

            //read and parse file
            if (this.file.canRead())
            {
            	//init file reader (BOM aware)
                buffer = newUnicodeReader(file);

                String line;
                ArrayList<String> tempList = new ArrayList<String>();
                int lineNum = 0;

                //start read
                while (true)
                {
                	//read line
                    lineNum++;
                    line = buffer.readLine();

                    //end of file, break
                    if (line == null)
                    {
                    	break;
                    }
                    else
                    {
                    	tempList.add(line);
                    }
                }//end read line

                //parse lines
                LogHelper.debug("DEBUG: load custom config lines: "+this.file+" "+tempList.size());
                parse(tempList);

            }//end can read
        }
        catch (Throwable e)
        {
        	throw e;
        }
        //close reader
        finally
        {
            if (buffer != null)
            {
                try
                {
                    buffer.close();
                }
                catch (IOException e) {}
            }
        }
	}

	/** create default file */
	protected void createDefault()
	{
		try
        {
            if (file.getParentFile() != null)
            {
                file.getParentFile().mkdirs();
            }

            if (!file.exists() && !file.createNewFile())
            {
                throw new IOException("Create default config file fail.");
            }

            if (file.canWrite())
            {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos, defaultEncoding));
                ArrayList<String> strDefault = getDefaultContent();

                if (strDefault != null && strDefault.size() > 0)
                {
                    for (String s : strDefault) buffer.write(s);
                }

                buffer.close();
                fos.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}

	/** BOM-aware text reader: UTF-8 (default), UTF-8 BOM, UTF-16 BE/LE */
	private BufferedReader newUnicodeReader(File file) throws IOException
	{
		PushbackInputStream in = new PushbackInputStream(new FileInputStream(file), 4);
		byte[] bom = new byte[4];
		int n = in.read(bom, 0, 4);
		int unread = (n < 0) ? 0 : n;
		String encoding = DEFAULT_ENCODING;

		if (n >= 3 && bom[0] == (byte) 0xEF && bom[1] == (byte) 0xBB && bom[2] == (byte) 0xBF)
		{
			unread = n - 3;
			encoding = "UTF-8";
		}
		else if (n >= 2 && bom[0] == (byte) 0xFE && bom[1] == (byte) 0xFF)
		{
			unread = n - 2;
			encoding = "UTF-16BE";
		}
		else if (n >= 2 && bom[0] == (byte) 0xFF && bom[1] == (byte) 0xFE)
		{
			unread = n - 2;
			encoding = "UTF-16LE";
		}

		if (unread > 0) in.unread(bom, n - unread, unread);

		defaultEncoding = encoding;
		return new BufferedReader(new InputStreamReader(in, encoding));
	}

	/** parse strings */
	abstract protected void parse(ArrayList<String> lines);

	/** strings of default content */
	abstract protected ArrayList<String> getDefaultContent();

	//check string is comment: first non whitespace char = '#'
	protected static boolean isCommentString(String str)
	{
		for (int i = 0; i < str.length(); ++i)
        {
			if (!Character.isWhitespace(str.charAt(i)))
            {
				if (str.charAt(i) == '#')
				{
					return true;
				}
				else
				{
					return false;
				}
            }
        }

		return false;
	}


}
