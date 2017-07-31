package sample

object Launcher {
  def main(args: Array[String]) {

    println("Are you a friend of duke?[yes/no]:")
		val input = Console.readLine

		/**
		 * Declare the rule
		 */
		val helloWorldRule = new HelloWorldRule

		/**
		 * Set business data to operate on
		 */
		helloWorldRule.setInput(input.trim)

		/**
		 * Create a rules engine and register the business rule
		 */
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
		;
		rulesEngine.registerRule(helloWorldRule);

		/**
		 * Fire rules
		 */
		rulesEngine.fireRules();

	
    
    
  }
}