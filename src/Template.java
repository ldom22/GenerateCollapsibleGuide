/****************************************************************************************************/
/*                                                                                                  */
/* File: Template.java                                                                              */
/* Description: Contains the boilerplate HTML and Javascript code                                   */
/* Created: 2023 in Mexico                                                                          */
/* License type: Apache                                                                             */
/*                                                                                                  */
/* Author: Luis Olea                                                                                */
/*                                                                                                  */
/****************************************************************************************************/

public class Template {
	static String HTML = """
		<!DOCTYPE html>
		<html>
		<head>
		<meta name=\"viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
		<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
		<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
		</head>
		<body>

		<div data-role="page" id="pageone">
		//replace
		</div> 

		</body>

		<script>
		function clicked(name){
			var backup = document.getElementById(name).innerHTML
			document.getElementById(name).innerHTML = 'Copied to clipboard'
			navigator.clipboard.writeText(backup.substring(6,backup.length-1))
			setTimeout(() => {
				document.getElementById(name).innerHTML = backup
			}, 1000);
		}
		</script>

		</html>
	""";
}