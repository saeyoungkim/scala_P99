import P99._
import org.scalatest.funspec.AnyFunSpec

class P99Spec extends AnyFunSpec {
    val testList: List[Int] = List(1,1,2,3,5,8)

    /**
     * P01
     * scala> last(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 8
     */
    describe("P01") {
        it("#last") {
            assert(Problems99.last(List(1,1,2,3,5,8)) == 8)
        }
        it("#last2") {
            assert(Problems99.last2(List(1,1,2,3,5,8)) == 8)
        }
    }

    /**
     * P02
     * scala> penultimate(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 5
     */
    describe("P02") {
        it("#penultimate") {
            assert(Problems99.penultimate(List(1,1,2,3,5,8)) == 5)
        }
    }

    /**
     * P03
     * scala> nth(2, List(1, 1, 2, 3, 5, 8))
     * res0: Int = 2
     */
    describe("P03") {
        it("#nth") {
            assert(Problems99.nth(2, testList) == 2)
        }
        it("#nth2") {
            assert(Problems99.nth2(2, testList) == 2)
        }
    }

    /**
     * P04
     * scala> length(List(1, 1, 2, 3, 5, 8))
     * res0: Int = 6
     */
    describe("P04") {
        it("#length") {
            assert(Problems99.length(testList) == 6)
        }
    }

    /**
     * P05
     * scala> reverse(List(1, 1, 2, 3, 5, 8))
     * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
     */
    describe("P05") {
        it("#reverse") {
            assert(Problems99.reverse(testList) == List(8,5,3,2,1,1))
        }
        it("#reverse2") {
            assert(Problems99.reverse2(testList) == List(8,5,3,2,1,1))
        }
        it("#reverse3") {
            assert(Problems99.reverse3(testList) == List(8,5,3,2,1,1))
        }
    }

    /**
     * P06
     * scala> isPalindrome(List(1, 2, 3, 2, 1))
     * res0: Boolean = true
     */
      describe("P06") {
            it("#isPalindrome") {
              assert(Problems99.isPalindrome(List(1,2,3,2,1)))
            }
      }

    /**
     * P07
     * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
     * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
     */
    describe("P07") {
        it("#flatten") {
            assert(Problems99.flatten(List(List(1,1),2,List(3,List(5,8)))) == testList)
        }
    }
}
