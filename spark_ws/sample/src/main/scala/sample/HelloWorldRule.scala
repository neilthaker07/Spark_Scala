package sample

class HelloWorldRule() 
{
	/**
	 * The user input which represents the data that the rule will operate on.
	 */
	private val input

	/*@Condition
	public boolean checkInput() {
		// The rule should be applied only if
		// the user's response is yes (duke friend)
		return input.equalsIgnoreCase("yes");
	}

	@Action
	public void sayHelloToDukeFriend() throws Exception {
		// When rule conditions are satisfied,
		// prints 'Hello duke's friend!' to the console
		System.out.println("Hello duke's friend!");
	}*/

	def setInput(input : String)
	{
		this.input = input
	}
	def name = this._name 
}