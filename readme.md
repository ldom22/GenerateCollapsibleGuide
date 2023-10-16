# GenerateCollapsibleGuide
### A command line tool for converting text files (in a specific format) into readable, organized HTML documents

GenerateCollapsibleGuide takes a formatted text file and turns it into a collapsible, formatted HTML document.
It currently supports:
- Links
- Copy to clipboard buttons
- Unlimited nesting of collapsible content

### Usage

For using GenerateCollapsibleGuide you will need java version "16.0.2" or newer installed in your system.

Run "java -version" on your local prompt to check if you have java installed, and check which version you have.

Download the latest compiled jar file from /jar or get a release from the release section.

Run from jar file:
```
java -jar GenerateCollapsibleGuide.jar input.txt output.html (jar file)
```

Run from class file:
```
java GenerateCollapsibleGuide input.txt output.html (class file)
```

To run the demo (Windows):

```
java -jar jar\GenerateCollapsibleGuide.jar demo\demo.txt demo\demo.html
```

To compile the project just run make.bat (Windows)

See the demo input file [here](https://ldom22.github.io/GenerateCollapsibleGuide/demo/demo.txt) and the demo output file [here](https://ldom22.github.io/GenerateCollapsibleGuide/demo/demo.html)

### Attributions

GGGUI is written in the [Java](http://www.java.com) programming language.
