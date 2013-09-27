package example;

import dk.brics.xact.*;
import dk.brics.xact.operations.*;
import java.util.*;

public class Example3 {
	static {
XML.getNamespaceMap().put("h", "http://www.w3.org/1999/xhtml");
		XML.loadXMLSchema("file:schemas/xhtml1-transitional.dtd");
		
} public static XML makePicture(XML data, int id) {
String name = data.getString("//name");
		String linkId = ("picture" + id);
		XML entry = dk.brics.xact.XML.parseTemplate("<h:h3 id=[0GENERATEDGAP0]><[CAPTION]></h:h3><h:img src=[0GENERATEDGAP1] alt=\"Use your imagination!\"/>").plug("0GENERATEDGAP0", linkId).plug("0GENERATEDGAP1", name);
		return entry.plug("CAPTION", XML.concat(data.getString("//caption")));
		
} 
	private static XML makeTableEntry(XML data, int id) {
String link = ("#picture" + id);
		XML entry = dk.brics.xact.XML.parseTemplate("<h:a href=[0GENERATEDGAP0]><h:b><[CAPTION]></h:b></h:a><h:br/>").plug("0GENERATEDGAP0", link);
		entry  =  entry.plug("CAPTION", data.getString("//caption"));
		return entry;
		
} 
	public static void main(String[] args) {
XML xml = XML.parseTemplateResource(Example3.class, "example3.xml");
		XML data = XML.parseTemplateResource(Example3.class, "example3_2.xml");
		XML result = xml.plug("TITLE", dk.brics.xact.XML.parseTemplate("Amazing pictures of my brave adventures!"));
		XML entryList = dk.brics.xact.XML.parseTemplate("");
		XML tableOfContents = dk.brics.xact.XML.parseTemplate("");
		int i = 1;
		for (Node n : data.get("//entry")) {
XML x = (XML)n;
			entryList  =  XML.concat(entryList, makePicture(x, i));
			tableOfContents  =  XML.concat(tableOfContents, makeTableEntry(x, i));
			i++;
			
} 
		
		result  =  result.plug("GALLERY", entryList);
		result  =  result.plug("TABLE", tableOfContents);
		result.analyze("h:html");
		System.out.println(result.toTemplate(XMLIndentation.XHTML));
		
} 
	}

