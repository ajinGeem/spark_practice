// Trait for Person
trait Person {
  val name: String
  val age: Int
  val speed: Int
  var x: Int = 0
  var y: Int = 0

  // Method to walk to a location
  def walk(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"$name is walking to ($x, $y)")
  }

  // Method to run to a location
  def run(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"$name is running to ($x, $y)")
  }

  // Method to swim to a location
  def swim(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"$name is swimming to ($x, $y)")
  }

  // Method to display information
  def displayInfo(): Unit = {
    println(s"Name: $name")
    println(s"Age: $age")
    println(s"Speed: $speed")
    println(s"Current Location: ($x, $y)")
  }
}

// Class for Child
class Child(val name: String, val age: Int, val speed: Int) extends Person

// Class for Parent
class Parent(val name: String, val age: Int, val speed: Int) extends Person

// Class for Grandparent
class Grandparent(val name: String, val age: Int, val speed: Int) extends Person

// Main function
def main(args: Array[String]): Unit = {
  // Create instances of Person
  val child = new Child("Child", 10, 5)
  val parent = new Parent("Parent", 40, 3)
  val grandparent = new Grandparent("Grandparent", 70, 1)

  // Display information of all people
  child.displayInfo()
  parent.displayInfo()
  grandparent.displayInfo()

  // Walk to (1, 1)
  child.walk(1, 1)
  parent.walk(1, 1)
  grandparent.walk(1, 1)

  // Run to (2, 2)
  child.run(2, 2)
  parent.run(2, 2)

  // Swim to (3, -1)
  child.swim(3, -1)
}

// Execute the main function
main(Array())
