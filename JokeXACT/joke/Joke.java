package joke;

import java.net.*;
import java.io.*;
import dk.brics.xact.*;
import dk.brics.xact.operations.*;

public class Joke {
	static {
XML.getNamespaceMap().put("h", "http://www.w3.org/1999/xhtml");
		XML.loadXMLSchema("file:schemas/xhtml1-transitional.dtd");
		
} public XML makeJokes(XML jokelist) {
XML result = dk.brics.xact.XML.parseTemplate("<h:ul><[CONTENT]></h:ul><h:h3>Let the jokes begin</h:h3><[JOKES]>");
		int i = 0;
		for (Element e : jokelist.getElements("jml:joke[jml:setup]")) {
result  =  result.plug("CONTENT", dk.brics.xact.XML.parseTemplate("<h:li><a href=\"#{i}\"><[0GENERATEDGAP0]>. joke</a></h:li><[CONTENT]>").plug("0GENERATEDGAP0", i));
			result  =  result.plug("JOKES", dk.brics.xact.XML.parseTemplate("<h:p><h:b id=\"{i}\"><[0GENERATEDGAP0]>. joke:</h:b><h:br/><h:b>A: </h:b><[0GENERATEDGAP1]><h:br/><h:b>Q: </h:b>Or was it the other way around, I can't really remember?\n"+
"								 </h:p><[JOKES]>").plug("0GENERATEDGAP0", i).plug("0GENERATEDGAP1", e.getString("jml:setup")));
			
} 
		
		return result.close();
		
} 
	public static void main(String[] args) throws IOException {
XML jokelist = XML.parseDocument(new URL("file:bcard.xml"));
		Joke j = new Joke();
		XML template = XML.parseTemplateResource(Joke.class, "jokeTemplate.xml");
		XML xhtml = template.plug("STUFF", j.makeJokes(jokelist)).plug("TITLE", dk.brics.xact.XML.parseTemplate("JOKES, JOKES FOR EVERYONE!!"));
		xhtml  =  xhtml.analyze("h:html");
		System.out.println(xhtml.toDocument());
		
} 
	}

