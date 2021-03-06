package recfun

import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balanceCount(count: Int, chars: List[Char]): Boolean = {
      if (count < 0) false
      else if (chars.length == 0) count == 0
      else {
        var newCount = count
        if (chars.head == '(') newCount += 1
        else if (chars.head == ')') newCount -= 1
        balanceCount(newCount, chars.tail)
      }
    }

    balanceCount(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
   if(money==0) 1
   else if(coins.isEmpty || money < 0) 0
   else countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }
}
