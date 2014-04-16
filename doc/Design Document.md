# Student Verhuis Service App #

An aplication wich enables employees to easily calculate invoices for customers and thus minimizing the amount of mistakes made.

# List of classes and methods #

## MainActivity ##

controls the home page



- public void newFactuur(View view) : called when the user wants to calculate a new invoice
- public void terms (View view) : called when the user wants to view the Terms & Conditions

## factuurActivity ##

controls the page where a new invoice is calculated and user input is required.

- public class factuurActivity extends Activity implements OnClickListener :	
	
	- intializes layout screen
	- intializes edittext boxes for user input
	- initializes checkbox
	- initializes integer
	
	
- public void onCreate(Bundle savedInstanceState:
	
	- refers to the layout .xml file
	- finds the edittext boxes from the layout file
	- sets up an on click event with a submit button
	- sets up a checkbox with an on click event

-  public void onClick(View v):
	
	- processes on click events
	- checks if the checkbox is checked and acts accordingly
	- starts a new intent: Intent intent = new Intent(this, resultActivity.class)
	- parses userinput to the intent for further use
	- stars a new activity : result

## resultActivity ##
controls the page where the results of the invoice are viewed

- public class resultActivity extends ActionBarActivity:
	
	
	- initializes all field variables:
		- double verhuiswagen1;
    	- double verhuizers1;
    	- double verhuislift1;
    	- double aanhanger1;
    	- double kilometers1;
    	- double wagen;
    	- double verhuizer;
    	- double verhuislift;
    	- double aanhanger;
    	- double kilometers;
    	- double subtotaal;
    	- double toeslag;
    	- double btw;
    	- double totaal;
    	- int a; 
	
	
- public void onCreate(Bundle savedInstanceState):
	- initializes layout screen
	- refers to .xml file from the layout folder
	- starts a new intent: Intent intent = getIntent();
	- parses all the values from the factuur intent into variables:
		- verhuiswagen1 = intent.getDoubleExtra("verhuiswagen", 0.0);
		- verhuizers1 = intent.getDoubleExtra("verhuizer", 0.0);
		- verhuislift1 = intent.getDoubleExtra("verhuislift", 0.0);
        - aanhanger1 = intent.getDoubleExtra("aanhanger", 0.0);
        - kilometers1 = intent.getDoubleExtra("kilometers", 0.0);
        - a=intent.getIntExtra("checkbox", 0);
	- calculates invoice totals using these variables    
	- initializes textview boxes for viewing the result
	- parsing the results into the textview boxes
	- using decimalformat to make everything look smooth
	

## termsActivity 	

Controls the page where the user can view the Terms & conditions

- public class termsActivity extends Activity:
	- initializes a listview
	- initializes an arrayadapter
	- finds the listview resource and layout in the .xml layout files
	- populates the list with an array from strings.xml
	- views the list in a scrollable linear layout	   

