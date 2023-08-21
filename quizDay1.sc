import scala.collection.{LinearSeq, SortedMap, mutable}
import scala.io.StdIn

val wordList = List("apple", "basket", "candy")  //words count, letters count / output = 3, 16
val count = wordList.groupBy(identity).mapValues(_.size)
val numberOfWords = wordList.size
println(numberOfWords)
val letters = wordList.flatMap(_.sliding(1))
val letterCounts = letters.groupBy(identity).mapValues(_.size)
val numberOfLetters = letters.size
println(numberOfLetters)

def fibonacciArray(length: Int): Array[Int] = {
  val fibArray = new Array[Int](length)

  fibArray(0) = 0
  if (length > 1) {
    fibArray(1) = 1
    for (i <- 2 until length) {
      fibArray(i) = fibArray(i-1) + fibArray(i-2)
    }
  }

  fibArray
}

def main(args: Array[String]): Unit = {
  println("Enter the length of the Fibonacci array:")
  val length = StdIn.readInt()

  val fibArray = fibonacciArray(length)

  println("Fibonacci array:")
  fibArray.foreach(println)
}

main(Array())

type Row = Vector[Int]
type Matrix = Vector[Row]

def multiply(matrix1: Matrix, matrix2: Matrix): Matrix = {
  val numRows1 = matrix1.length
  val numCols1 = matrix1(0).length
  val numCols2 = matrix2(0).length

  val result = Array.ofDim[Int](numRows1, numCols2)

  for (i <- 0 until numRows1) {
    for (j <- 0 until numCols2) {
      var sum = 0
      for (k <- 0 until numCols1) {
        sum += matrix1(i)(k) * matrix2(k)(j)
      }
      result(i)(j) = sum
    }
  }

  result.map(_.toVector).toVector
}

val matrix1: Matrix = Vector(Vector(1, 2), Vector(3, 4))
val matrix2: Matrix = Vector(Vector(5, 6), Vector(7, 8))

val result: Matrix = multiply(matrix1, matrix2)

println(result)
