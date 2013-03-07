package rikmuld.core.helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import rikmuld.core.lib.Colors;
import rikmuld.core.lib.ModInfo;




public class CheckVersion {
	
	public static final String MOD_MESSAGE_VERSION_NEW = "There is an Updated version off the camping mod";
	public static final String MOD_MESSAGE_VERSION_VERSION = "Version: ";
	public static final String MOD_MESSAGE_VERSION_GOOD = "Your camping mod is up to date";
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
		if(doc!=null)
		{
			NodeList Version = doc.getElementsByTagName("VersionNumber");
			NodeList VersionDate = doc.getElementsByTagName("VersionDate");
			NodeList VersionNew = doc.getElementsByTagName("NewInVersion");
			
			Node NewestVersion = Version.item(0);
			Node NewestVersionDate = VersionDate.item(0);
			Node NewestVersionNew = VersionNew.item(0);
			
			String NewVersion = NewestVersion.getTextContent();
			String NewVersionDate = NewestVersionDate.getTextContent();
			String NewVersionNew = NewestVersionNew.getTextContent();

			if(!MinecraftServer.getServer().isDedicatedServer()&&ModLoader.getMinecraftInstance().thePlayer!=null)
			{
				if(!NewVersion.equals(ModInfo.MOD_VERSION))
				{	
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_RED+MOD_MESSAGE_VERSION_NEW);
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_RED+MOD_MESSAGE_VERSION_VERSION + NewVersion); 
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_RED+MOD_MESSAGE_VERSION_CURR + ModInfo.MOD_VERSION);
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_RED+MOD_MESSAGE_VERSION_WHATSNEW + NewVersionNew);
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_RED+MOD_MESSAGE_VERSION_DATE + NewVersionDate);
				}
				else
				{
					ModLoader.getMinecraftInstance().thePlayer.addChatMessage(Colors.COLOR_GREEN_LIGHT+MOD_MESSAGE_VERSION_GOOD);
				}
			}
		}
	}
}
