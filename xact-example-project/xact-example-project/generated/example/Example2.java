package example;

import dk.brics.xact.*;
import dk.brics.xact.operations.*;

public class Example2 {
	static {
XML.getNamespaceMap().put("h", "http://www.w3.org/1999/xhtml");
		XML.loadXMLSchema("file:schemas/xhtml1-transitional.dtd");
		
} public static XML addExtraListItems(XML xml, XML itemToInsert) {
return xml.appendContent("//h:ul", dk.brics.xact.XML.parseTemplate("<h:li><[INSERT]></h:li>").plug("INSERT", itemToInsert.getString()));
		
} 
	public static XML getEmail() {
return dk.brics.xact.XML.parseTemplate("nobody@example.com");
		
} 
	public static void main(String[] args) {
XML xml = XML.parseTemplateResource(Example2.class, "example.xml");
		xml  =  xml.plug("TITLE", "Amazing recipes");
		XML result = addExtraListItems(xml, dk.brics.xact.XML.parseTemplate("Spiced ham")).plug("GREETING", "Behold my collection of recipes!").plug("GOODBYE", dk.brics.xact.XML.parseTemplate("Please send more recipes to <h:a href=[0GENERATEDGAP0]><h:b><[EMAIL]></h:b></h:a>").plug("0GENERATEDGAP0", ("mailto:" + getEmail().getString()))).plug("EMAIL", getEmail()).close();
		result.analyze("h:html");
		System.out.println(result.toTemplate(XMLIndentation.XHTML));
		
} 
	}

