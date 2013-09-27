package example;

import dk.brics.xact.*;
import dk.brics.xact.operations.*;
import java.util.Date;

public class Example1 {
	static {
XML.getNamespaceMap().put("h", "http://www.w3.org/1999/xhtml");
		XML.loadXMLSchema("file:schemas/xhtml1-transitional.dtd");
		
} public static void main(String[] args) {
XML x = dk.brics.xact.XML.parseTemplate("<h:html><h:head><h:title><[TITLE]></h:title></h:head><h:body><h:h1><[TITLE]></h:h1><h:div><[BODY]></h:div><h:div><h:a href=[LINK]>Awesome link!</h:a></h:div></h:body></h:html>");
		x  =  x.plug("TITLE", "You can plug in a string");
		x  =  x.plug("BODY", dk.brics.xact.XML.parseTemplate("<h:b>But also XML</h:b><[FOOT]>"));
		x  =  x.plug("FOOT", dk.brics.xact.XML.parseTemplate("<h:br/>And also plug in more gaps<[FOOT]>"));
		x  =  x.plug("FOOT", dk.brics.xact.XML.parseTemplate("<h:br/>Repeatedly"));
		x  =  x.plug("LINK", "http://www.google.com");
		x.analyze("h:html");
		System.out.println(x.toTemplate(XMLIndentation.XHTML));
		
} 
	}

