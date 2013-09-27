package joke;

import java.net.*;
import java.io.*;
import dk.brics.xact.*;
import dk.brics.xact.operations.*;

public class Joke {
	static {
XML.getNamespaceMap().put("h", "http://www.w3.org/1999/xhtml");
		XML.getNamespaceMap().put("jml", "http://www.daimi.au.dk/AWT/JokeML");
		XML.loadXMLSchema("file:schemas/xhtml1-transitional.dtd");
		
} public XML makeJokes(XML jokelist) {
XML result = dk.brics.xact.XML.parseTemplate("<h:p><[CONTENT]></h:p><h:h2>Let the jokes begin</h:h2><[JOKES]>");
		int i = 0;
		boolean first = true;
		for (Element e : jokelist.getElements("jml:joke[jml:setup]")) {
String link = ("#joke" + i);
			String id = ("joke" + i);
			result  =  result.plug("CONTENT", dk.brics.xact.XML.parseTemplate("<h:a href=[0GENERATEDGAP0]><[0GENERATEDGAP1]>. joke</h:a><h:br/><[CONTENT]>").plug("0GENERATEDGAP1", i).plug("0GENERATEDGAP0", link));
			result  =  result.plug("JOKES", dk.brics.xact.XML.parseTemplate("<h:div id=[0GENERATEDGAP0]><h:b><[0GENERATEDGAP1]>. joke:</h:b></h:div><h:p><h:b>Q: </h:b><[0GENERATEDGAP2]><h:br/><h:b>A: </h:b>Or was it the other way around, I can't really remember?\n"+
"								 </h:p><[JOKES]>").plug("0GENERATEDGAP1", i).plug("0GENERATEDGAP2", e.getString("jml:setup")).plug("0GENERATEDGAP0", id));
			i++;
			
} 
		
		return result.close();
		
} 
	public static void main(String[] args) throws IOException {
XML jokelist = XML.parseDocument(new URL("file:generated/joke/jokes.xml"));
		Joke j = new Joke();
		XML template = XML.parseTemplateResource(Joke.class, "jokeTemplate.xml");
		XML xhtml = template.plug("STUFF", j.makeJokes(jokelist)).plug("TITLE", dk.brics.xact.XML.parseTemplate("JOKES, JOKES FOR EVERYONE!!"));
		xhtml  =  xhtml.analyze("h:html");
		System.out.println(xhtml.toDocument());
		
} 
	}

