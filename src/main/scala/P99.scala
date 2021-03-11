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

    // tail recursive
    def reverse3[T](list: List[T]): List[T] = {
      def reverseTailRec(ret: List[T], curr: List[T]): List[T] = curr match {
          case Nil => ret
          case h :: tail => reverseTailRec(h :: ret, tail)
      }
      reverseTailRec(Nil, list)
    }

    /**
     * P06 (*) Find out whether a list is a palindrome.
     */
    def isPalindrome[T](list: List[T]): Boolean = {
        list.reverse == list
    }

    /**
     * P07 (**) Flatten a nested list structure.
     */
    def flatten(list: List[Any]): List[Any] =
        list.foldLeft(List.empty[Any])((l, elm) => elm match {
            case Nil => l
            case xs : List[Any] => l ++ flatten(xs)
            case v => l :+ v
        })

    def flatten2(list: List[Any]): List[Any] =
        list.flatMap {
            case ms: List[_] => flatten2(ms)
            case e => List(e)
        }


    /**
     * P08 (**) Eliminate consecutive duplicates of list elements.
     */
    def compress[T](list: List[T]): List[T] = {
        list.foldLeft(List.empty[T]) {
            (r, e) =>
                r match {
                    case r if r.isEmpty => List(e)
                    case r if r.head == e => r
                    case _ => e :: r
                }
        }.reverse
    }

    def compress2[T](list: List[T]): List[T] = {
      def compressR(result: List[T], curlList: List[T]): List[T] = curlList match {
          case h :: tail => compressR(h :: result, curlList = tail.dropWhile(_ == h))
          case Nil  =>  result.reverse
      }
      compressR(Nil, list)
    }

    /**
     * P09 (**) Pack consecutive duplicates of list elements into sublists.
     */
    def pack[T](list: List[T]): List[List[T]] = {
        def packR(result: List[List[T]], curlList: List[T]): List[List[T]] = curlList match {
            case h :: tail  =>   packR(addElementInPackingList(result, h), tail)
            case Nil    =>  result.reverse
        }

        def addElementInPackingList(result: List[List[T]], elm: T) : List[List[T]] = result match {
            case _ if !result.isEmpty && result.head.head == elm => (elm :: result.head) :: result.tail
            case _ => List(elm) :: result
        }

        packR(Nil, list)
    }

    def pack2[T](list: List[T]): List[List[T]] = {
        val (packed, next) = list span { _ == list.head }
        if(next == Nil) List(packed)
        else packed :: pack2(next)
    }

    /**
     * P10 (*) Run-length encoding of a list.
     */
    def encode[T](list: List[T]): List[(Int, T)] = {
      pack(list) map { l => (l.length, l.head) }
    }

    /**
     * P11 (*) Modified run-length encoding.
     */
    def encodeModified[T](list: List[T]) =
        encode(list) map { e => if (e._1 == 1) e._2 else e }

    /**
     * P12 (**) Decode a run-length encoded list.
     */
    def decode[T](list: List[(Int, T)]): List[T] = {
        list flatMap { e => Stream.fill(e._1)(e._2) }
    }

    /**
     * P13 (**) Run-length encoding of a list (direct solution).
     */
    def encodeDirect[T](list: List[T]): List[(Int, T)] =
        list.foldLeft(List.empty[(Int, T)]) { (r, e) =>
            r match {
                case Nil => (1,e) :: r
                case x :: xs => {
                  val (_, v) = x
                  if(v == e)
                      (x._1 + 1, x._2) :: xs
                  else
                      (1,e) :: (x :: xs)
                }
            }
        }.reverse

    /**
     * P14 (*) Duplicate the elements of a list.
     */
    def duplicate[T](list: List[T]): List[T] = list flatMap { v => List(v,v) }

    /**
     * P15 (**) Duplicate the elements of a list a given number of times.
     */
    def duplicateN[T](n: Int, list: List[T]): List[T] = list flatMap { List.fill(n)(_) }

    /**
     * P16 (**) Drop every Nth element from a list.
     */
    def drop[T](n: Int, list: List[T]): List[T] = list
      .zipWithIndex
      .filter{ case (_,idx) => (idx+1) % n != 0 }
      .map(_._1)

    def drop2[T](n: Int, list: List[T]): List[T] = {
      def dropR(c: Int, curr: List[T], ret: List[T]): List[T] = {
          (c,curr) match {
              case (_, Nil) => ret.reverse
              case (1, _ :: tail) => dropR(n, tail, ret)
              case (_, h :: tail) => dropR(c-1, tail, h :: ret)
          }
      }

      dropR(n, list, Nil)
    }

    /**
     * P17 (*) Split a list into two parts
     */
    def split[T](n: Int, list: List[T]): (List[T],List[T]) = list.splitAt(n)

    def split2[T](n: Int, list: List[T]): (List[T],List[T]) = {
      def splitR(n: Int, head: List[T], tail: List[T]): (List[T], List[T]) = {
            (n, tail) match {
                case (_, Nil) => (head.reverse, Nil)
                case (0, _) => (head.reverse, tail)
                case (c, h :: t) => splitR(c-1, h :: head, t)
            }
      }

      splitR(n, Nil, list)
    }

    def slice[T](from: Int, to: Int, list: List[T]): List[T] = {
        def sliceR[T](idx: Int, curr: List[T], ret: List[T]): List[T] = {
            (idx, curr) match {
                case (i, h :: tail) if from <= i && i < to => sliceR(i+1, tail, h :: ret)
                case (i, _) if i == to => ret.reverse
                case (i, _ :: tail) => sliceR(i+1, tail, ret)
            }
        }

        sliceR(0, list, Nil)
    }
}
