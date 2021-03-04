package P99

object Problems99 extends App {
    /**
     * P01 (*) Find the last element of a list.
     */
    def last[T](list: List[T]): T = list.last

    def last2[T](list: List[T]): T = list match {
        case x :: Nil => x
        case _ :: xs => last2(xs)
        case _ => throw new RuntimeException("list cannot be empty.")
    }

    /**
     * P02 (*) Find the last but one element of a list.
     */
    def penultimate[T](list: List[T]): T = list match {
        case x1 :: _ :: Nil => x1
        case _ :: xs => penultimate(xs)
        case _ => throw new RuntimeException("list cannot be empty.")
    }

    /**
     * P03 (*) Find the Kth element of a list.
     */
    def nth[T](n: Int, list: List[T]): T = {
        require((0 <= n) && (n < list.length))
        list(n)
    }

    def nth2[T](n: Int, list: List[T]): T = {
        require((0 <= n) && (n < list.length))
        (n, list) match {
            case (0, h :: _) => h
            case (n, _ :: tail) => nth(n-1, tail)
            case (_, Nil)   => throw new NoSuchElementException
        }
    }

    /**
     * P04 (*) Find the number of elements of a list.
     */
    def length[T](list: List[T]): Int = list match {
        case Nil => 0
        case _ :: tail => length(tail) + 1
    }

    /**
     * P05 (*) Reverse a list.
     */
    def reverse[T](list: List[T]): List[T] = list match {
        case h :: Nil => List(h)
        case h :: tail => reverse(tail) :+ h
        case _ => Nil
    }

    def reverse2[T](list: List[T]): List[T] = list.foldLeft(List.empty[T])((r, h) => h :: r)

    /**
     * tail recursive
     */
    def reverse3[T](list: List[T]): List[T] = {
      def reverseTailRec(ret: List[T], curr: List[T]): List[T] = curr match {
          case Nil => ret
          case h :: tail => reverseTailRec(h :: ret, tail)
      }
      reverseTailRec(Nil, list)
    }
}
