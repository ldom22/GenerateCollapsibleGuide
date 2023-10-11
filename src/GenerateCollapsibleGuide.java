/****************************************************************************************************/
/*                                                                                                  */
/* File: GenerateCollapsibleGuide.java                                                              */
/* Description: Project main file                                                                   */
/* Created: 2023 in Mexico                                                                          */
/* License type: Apache                                                                             */
/*                                                                                                  */
/* Author: Luis Olea                                                                                */
/*                                                                                                  */
/****************************************************************************************************/

//libraries
import java.io.*;
import java.util.*;

//main class
public class GenerateCollapsibleGuide {
	
	//reads in file and template and creates html file
	public GenerateCollapsibleGuide(String in, String out) throws Exception {
		ArrayList<Element> elements = new ArrayList<>();
		BufferedReader br;
		
		//interpret input file
		try {
			Stack<Element> stack = new Stack<>();
			br = new BufferedReader(new FileReader(in));
			String input = br.readLine();
			int lastabs = 0;
			int line = 1;
			while(input != null){
				int cntabs = (int)input.chars().filter(c -> c == '\t').count();
				if(!input.contains("-") && cntabs==0){
					Element temp = new Element(input);
					elements.add(temp);
					stack.clear();
					stack.add(temp);
					lastabs = 0;
				} else {
					String[] split = input.split("-");
					String join = "";
					for(int i=1; i< split.length; i++){
						join += split[i] + "-";
					}
					join = join.substring(0,join.length()-1);
					Element temp = new Element(join);
					stack.add(temp);
					if(cntabs==lastabs){
						stack.pop();
						stack.pop();
						stack.peek().children.add(temp);
						stack.add(temp);
					} else if(cntabs==(lastabs+1)){
						stack.pop();
						stack.peek().children.add(temp);
						stack.add(temp);
					} else if(cntabs==(lastabs-1)){
						stack.pop();
						stack.pop();
						stack.pop();
						stack.peek().children.add(temp);
						stack.add(temp);
					} else {
						System.out.println("Invalid number of tabs ("+cntabs+") in line "+line+" of file " + in + ":");
						System.out.println(input);
						return;
					}
					lastabs = cntabs;
				}
				input = br.readLine();
				line++;
			}
			br.close();
		} catch(Exception e) {
			System.out.println("error reading "+in);
			e.printStackTrace();
			return;
		}
		
		//read template
		String html = Template.HTML;
		
		//replace text in template
		String result = "";
		for(Element e: elements){
			result += e.generateHTML();
		}
		html = html.replace("//replace", result);
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		bw.write(html);
		bw.flush();
		bw.close();
	}
	
	//check arguments and run
	public static void main(String args[]) throws Exception {
		if(args.length!=2){
			System.out.println("");
			System.out.println("GenerateCollapsibleGuide 1.0");
			System.out.println("");
			System.out.println("Generates an HTML guide with collapsible sections using template.html");
			System.out.println("Usage: java GenerateCollapsibleGuide input.txt output.html");
			System.out.println("");
			System.out.println("Made by Luis Olea in Mexico (2023)");
			System.out.println("");
			return;
		}
		new GenerateCollapsibleGuide(args[0], args[1]);
	}
}