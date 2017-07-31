/*scala> "Hi"+50
res0: String = Hi50

scala> var a="oho"
a: String = oho

scala> var a=5.65
a: Double = 5.65

scala> val e = 99   :> val is constant
e: Int = 99

*/
/*
println("Hi"+55);

var a="oho";

println(a);

val e = 99;

println(e);*/

import scala.collection.mutable.ArrayBuffer

object ScalaTutorial{
	def main(args: Array[String])
	{
		var i = 0;

		while(i<=10)
		{
			println(i);
			i +=1;
		}

		val friend = Array("A","B");
		println(friend(0));

		val f2 = ArrayBuffer[String]();
		f2.insert(0,"E");
		println(f2(0));


		val empl = Map("manager" -> "abc", "worker" -> "pqr")

		println(empl("manager"));

		val col = collection.mutable.Map("cus" -> "abc");

		val rover = new Animal
		rover.setName("QWE");
		println(rover.getName);
	}

	class Animal(var name:String)
	{
		this.setName(name)

		val id = Animal.newIdNum

		def getName() : String  = name 

		def setName(name : String)
		{
			this.name = name
		}
	}
}