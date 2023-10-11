/****************************************************************************************************/
/*                                                                                                  */
/* File: Element.java                                                                               */
/* Description: Represents a single element of content                                              */
/* Created: 2023 in Mexico                                                                          */
/* License type: Apache                                                                             */
/*                                                                                                  */
/* Author: Luis Olea                                                                                */
/*                                                                                                  */
/****************************************************************************************************/

//libraries
import java.util.*;

//represents a single collapsible topic
public class Element {
	
	//properties
	String text, html;
	ArrayList<Element> children;
	static int nb = 0;
	
	//constructor
	public Element(String text){
		html = "";
		this.text = text;
		children = new ArrayList<>();
	}
	
	//generate HTML
	public String generateHTML(){
		//escape some chars
		//text = text.replace("-","&minus;");
		//text = text.replace("'","&lsquo;");
		//interpret buttons
		if(text.contains("CopyButton(")){
			int idx = text.indexOf("CopyButton(") + "CopyButton(".length();
			String copyTxt = text.substring(idx, text.indexOf(")"));
			nb++;
			text = text.replace("CopyButton("+copyTxt+")", "<button id='b"+nb+"' onclick='clicked(\"b"+nb+"\")'>Copy &lsquo;"+copyTxt+"&lsquo;</button>");
		}
		//interpret links
		if(text.contains("Link(")){
			int idx = text.indexOf("Link(") + "Link(".length();
			String link = text.substring(idx, text.indexOf(")"));
			String linkdisplay;
			String replace = "Link("+link+")";
			if(link.contains(",")){
				linkdisplay = link.split(",")[0];
				link = link.split(",")[1].trim();
			} else {
				linkdisplay = link;
			}
			if(!link.startsWith("http://") && !link.startsWith("https://")){
				text = text.replace(replace, "<a target='_blank' href='http://"+link+"'>"+linkdisplay+"</a>");
			} else {
				text = text.replace(replace, "<a target='_blank' href='"+link+"'>"+linkdisplay+"</a>");
			}
		}
		//print html for all children nodes
		if(children.size()==0){
			html += "<p>"+text+"</p>\n";
		} else {
			html += "<div data-role='main' class='ui-content'>\n";
			html += "<div data-role='collapsible'>\n";
			html += "<h1>"+text+"</h1>\n";
			for(Element element: children){
				html += element.generateHTML();
			}
			html += "</div></div>\n";
		}
		return html;
	}
}