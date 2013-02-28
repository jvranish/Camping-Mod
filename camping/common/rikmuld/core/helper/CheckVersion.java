package camping.common.rikmuld.core.helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import camping.common.rikmuld.core.lib.ModInfo;
import camping.common.rikmuld.core.register.ModLogger;


public class CheckVersion {
	
	public static final String MOD_MESSAGE_VERSION_NEW = "There is an Updated version off the camping mod. Version:";
	public static final String MOD_MESSAGE_VERSION_GOOD = "You have the latest version off the camping mod";
	public static final String MOD_MESSAGE_VERSION_DATE = "The version came out at: ";
	public static final String MOD_MESSAGE_VERSION_WHATSNEW = "The new version mainly includes: ";
	public static final String MOD_MESSAGE_VERSION_CURR = "Your version is: ";
	
	static URL url;
	static URLConnection conn;
	static DocumentBuilderFactory factory;
	static DocumentBuilder builder;
	static Document doc;
	static Transformer xform;
	
	public static void GetXmlFile()
	{
		try 
		{
			url = new URL("http://rikmuld.com/version.xml");
		} 	
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			conn = url.openConnection();
		} 	
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try
		{
			builder = factory.newDocumentBuilder();
		}
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		}
		
		try 
		{
			doc = builder.parse(conn.getInputStream());
		} 
		catch (SAXException e1)
		{	
			e1.printStackTrace();
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public static void CheckNewestVersion()
	{
		GetXmlFile();
		
		NodeList Version = doc.getElementsByTagName("VersionNumber");
		NodeList VersionDate = doc.getElementsByTagName("VersionDate");
		NodeList VersionNew = doc.getElementsByTagName("NewInVersion");
		
		Node NewestVersion = Version.item(0);
		Node NewestVersionDate = VersionDate.item(0);
		Node NewestVersionNew = VersionNew.item(0);
		
		String NewVersion = NewestVersion.getTextContent();
		String NewVersionDate = NewestVersionDate.getTextContent();
		String NewVersionNew = NewestVersionNew.getTextContent();
		
		if(NewVersion.equals(ModInfo.MOD_VERSION))
		{
			ModLogger.log(Level.INFO,(MOD_MESSAGE_VERSION_GOOD));
			
		}
		else 
		{
			ModLogger.log(Level.INFO,(MOD_MESSAGE_VERSION_NEW + NewVersion));
			ModLogger.log(Level.INFO,(MOD_MESSAGE_VERSION_CURR + ModInfo.MOD_VERSION));
			ModLogger.log(Level.INFO,(MOD_MESSAGE_VERSION_WHATSNEW + NewVersionNew));
		}
		ModLogger.log(Level.INFO,(MOD_MESSAGE_VERSION_DATE + NewVersionDate));
	}
}
