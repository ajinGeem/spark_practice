class Person(val name: String, val age: Int, var x: Int, var y: Int) {
  def walkTo(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"${name} is walking to (${x}, ${y})")
  }
}

class Child(name: String, age: Int, x: Int, y: Int) extends Person(name, age, x, y) {
  val speed: Int = 5

  def runTo(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"${name} is running to (${x}, ${y})")
  }

  def swimTo(x: Int, y: Int): Unit = {
    this.x = x
    this.y = y
    println(s"${name} is swimming to (${x}, ${y})")
  }
}

class Grandparent(name: String, age: Int, x: Int, y: Int) extends Person(name, age, x, y) {
  val speed: Int = 1
}

val person = new Person("Person", 30, 0, 0)
val child = new Child("Child", 10, 0, 0)
val grandparent = new Grandparent("Grandparent", 70, 0, 0)

println(s"Person: Name - ${person.name}, Age - ${person.age}, Speed - N/A, Current Position - (${person.x}, ${person.y})")
println(s"Child: Name - ${child.name}, Age - ${child.age}, Speed - ${child.speed}, Current Position - (${child.x}, ${child.y})")
println(s"Grandparent: Name - ${grandparent.name}, Age - ${grandparent.age}, Speed - ${grandparent.speed}, Current Position - (${grandparent.x}, ${grandparent.y})")

person.walkTo(1, 1)
child.runTo(2, 2)
child.swimTo(3, -1)